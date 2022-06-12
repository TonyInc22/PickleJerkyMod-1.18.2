package com.inc.picklejerkymod.item;

import com.inc.picklejerkymod.PickleJerkyMod;
import com.mojang.brigadier.LiteralMessage;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PickleJerkyMod.MOD_ID);

    public static final RegistryObject<Item> PICKLE = ITEMS.register("pickle",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> PICKLE_SPICE = ITEMS.register("picklespice",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> SPICE = ITEMS.register("spice",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> JAR = ITEMS.register("jar",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> DILL = ITEMS.register("dill",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> BEEF_JERKY = ITEMS.register("beef_jerky",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> MUTTON_JERKY = ITEMS.register("mutton_jerky",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> CHICKEN_JERKY = ITEMS.register("chicken_jerky",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> PORK_JERKY = ITEMS.register("pork_jerky",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
