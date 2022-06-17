package com.inc.picklejerkymod.block.entity.custom;

import com.inc.picklejerkymod.block.entity.ModBlockEntities;
import com.inc.picklejerkymod.item.ModItems;

import com.inc.picklejerkymod.screen.DehydraterMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Random;

public class DehydraterBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public DehydraterBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.DEHYDRATER_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Dehydrater");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new DehydraterMenu(pContainerId, pInventory, this);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }


    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, DehydraterBlockEntity pBlockEntity) {
        if(hasRecipe(pBlockEntity) && hasNotReachedStackLimit(pBlockEntity)) {
            craftItem(pBlockEntity);
        }
    }

    private static void craftItem(DehydraterBlockEntity entity) {
        int meat = 0;
        if (entity.itemHandler.getStackInSlot(0).getItem() == Items.CHICKEN.asItem()) meat = 1;
        if (entity.itemHandler.getStackInSlot(0).getItem() == Items.BEEF.asItem()) meat = 2;
        if (entity.itemHandler.getStackInSlot(0).getItem() == Items.PORKCHOP.asItem()) meat = 3;
        if (entity.itemHandler.getStackInSlot(0).getItem() == Items.MUTTON.asItem()) meat = 4;

        entity.itemHandler.extractItem(0, 1, false);
        entity.itemHandler.extractItem(1, 1, false);

        switch (meat) {
            case 1:
                entity.itemHandler.setStackInSlot(2, new ItemStack(ModItems.CHICKEN_JERKY.get(),
                    entity.itemHandler.getStackInSlot(2).getCount() + 1));
            case 2:
                entity.itemHandler.setStackInSlot(2, new ItemStack(ModItems.BEEF_JERKY.get(),
                        entity.itemHandler.getStackInSlot(2).getCount() + 1));
            case 3:
                entity.itemHandler.setStackInSlot(2, new ItemStack(ModItems.PORK_JERKY.get(),
                        entity.itemHandler.getStackInSlot(2).getCount() + 1));
            case 4:
                entity.itemHandler.setStackInSlot(2, new ItemStack(ModItems.MUTTON_JERKY.get(),
                        entity.itemHandler.getStackInSlot(2).getCount() + 1));
            default:
                entity.itemHandler.setStackInSlot(2, new ItemStack(ModItems.PICKLE.get(),
                        entity.itemHandler.getStackInSlot(2).getCount() + 1));
        }
    }

    private static boolean hasRecipe(DehydraterBlockEntity entity) {
        boolean hasItemInMeatSlot =
                ((entity.itemHandler.getStackInSlot(0).getItem() == Items.CHICKEN)
                || (entity.itemHandler.getStackInSlot(0).getItem() == Items.BEEF)
                || (entity.itemHandler.getStackInSlot(0).getItem() == Items.PORKCHOP)
                || (entity.itemHandler.getStackInSlot(0).getItem() == Items.MUTTON));
        boolean hasItemInSpiceSlot = entity.itemHandler.getStackInSlot(1).getItem() == ModItems.SPICE.get();

        return hasItemInMeatSlot && hasItemInSpiceSlot;
    }

    private static boolean hasNotReachedStackLimit(DehydraterBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(2).getCount() < entity.itemHandler.getStackInSlot(2).getMaxStackSize();
    }

}