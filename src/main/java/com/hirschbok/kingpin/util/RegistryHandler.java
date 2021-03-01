
package com.hirschbok.kingpin.util;

import com.hirschbok.kingpin.crops.marijuanaCrop;
import com.hirschbok.kingpin.items.driedMarijuanaNugget;
import com.hirschbok.kingpin.items.marijuanaLeaf;
import com.hirschbok.kingpin.items.poppyResin;
import com.hirschbok.kingpin.items.syringe;
import com.hirschbok.kingpin.kingpin;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, kingpin.MOD_ID);
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, kingpin.MOD_ID);
    public static DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, kingpin.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // ITEMS
    public static final RegistryObject<Item> SYRINGE = ITEMS.register("syringe", syringe::new);
    public static final RegistryObject<Item> MARIJUANA_LEAF = ITEMS.register("marijuana_leaf", marijuanaLeaf::new);
    public static final RegistryObject<Item> DRIED_MARIJUANA_NUGGET = ITEMS.register("dried_marijuana_nugget", driedMarijuanaNugget::new);
    public static final RegistryObject<Item> POPPY_RESIN = ITEMS.register("poppy_resin", poppyResin::new);

    // SOUNDS
    public static final RegistryObject<SoundEvent> INJECT_SOUND = SOUNDS.register
            ("inject_sound", () -> new SoundEvent(new ResourceLocation(kingpin.MOD_ID, "inject_sound")));

    // CROPS
    public static final RegistryObject<Block> MARIJUANA_CROP = BLOCKS.register("marijuana", () -> new marijuanaCrop(Block.Properties.from(Blocks.FERN)));

    // CROP SEEDS
    public static final RegistryObject<Item> MARIJUANA_SEED = ITEMS.register("marijuana_seed",
            () -> new BlockItem(MARIJUANA_CROP.get(), new Item.Properties().group(ItemGroup.MISC)));
}