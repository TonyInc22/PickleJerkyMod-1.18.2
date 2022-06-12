package com.inc.picklejerkymod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.checkerframework.checker.units.qual.C;

public class ModCreativeModeTab {
    public static final CreativeModeTab PICKLEJERKY_TAB = new CreativeModeTab("picklejerkytab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.PICKLE.get());
        }
    };
}
