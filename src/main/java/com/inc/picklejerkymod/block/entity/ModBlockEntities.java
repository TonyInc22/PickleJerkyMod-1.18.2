package com.inc.picklejerkymod.block.entity;

import com.inc.picklejerkymod.PickleJerkyMod;
import com.inc.picklejerkymod.block.ModBlocks;
import com.inc.picklejerkymod.block.entity.custom.DehydraterBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, PickleJerkyMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<DehydraterBlockEntity>> DEHYDRATER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("dehydrater_block_entity", () ->
                    BlockEntityType.Builder.of(DehydraterBlockEntity::new,
                            ModBlocks.DEHYDRATER_BLOCK.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}