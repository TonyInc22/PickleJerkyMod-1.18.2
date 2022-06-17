package com.inc.picklejerkymod.item;

import com.inc.picklejerkymod.PickleJerkyMod;
import com.inc.picklejerkymod.item.custom.DillItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PickleJerkyMod.MOD_ID);

    public static final RegistryObject<Item> PICKLE = ITEMS.register("pickle",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB).food(ModFoods.PICKLE)));

    public static final RegistryObject<Item> PICKLE_SPICE = ITEMS.register("picklespice",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> SPICE = ITEMS.register("spice",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> JAR = ITEMS.register("jar",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> DILL = ITEMS.register("dill",
            () -> new DillItem(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> DILL_SEED = ITEMS.register("dill_seed",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> BEEF_JERKY = ITEMS.register("beef_jerky",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB).food(ModFoods.BEEF_JERKY)));

    public static final RegistryObject<Item> MUTTON_JERKY = ITEMS.register("mutton_jerky",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB).food(ModFoods.MUTTON_JERKY)));

    public static final RegistryObject<Item> CHICKEN_JERKY = ITEMS.register("chicken_jerky",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB).food(ModFoods.CHICKEN_JERKY)));

    public static final RegistryObject<Item> PORK_JERKY = ITEMS.register("pork_jerky",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB).food(ModFoods.PORK_JERKY)));

    public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB).food(ModFoods.CUCUMBER)));

    public static final RegistryObject<Item> POT = ITEMS.register("pot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> JAR_OF_EGGS = ITEMS.register("jar_of_eggs",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> JAR_OF_CUCUMBERS = ITEMS.register("jar_of_cucumbers",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> JAR_OF_APPLES = ITEMS.register("jar_of_apples",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> JAR_OF_CARROTS = ITEMS.register("jar_of_carrots",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> JAR_OF_POTATOES = ITEMS.register("jar_of_potatoes",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));

    public static final RegistryObject<Item> JAR_OF_BEETS = ITEMS.register("jar_of_beets",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PICKLEJERKY_TAB)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
