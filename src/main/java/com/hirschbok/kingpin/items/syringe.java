
package com.hirschbok.kingpin.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class syringe extends Item {

    public syringe() {
        super(new Item.Properties().group(ItemGroup.FOOD));
    }
}