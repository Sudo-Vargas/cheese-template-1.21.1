package net.ethan.cheese.block;

import net.ethan.cheese.Cheese;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BLOCK_OF_CHEESE = registerBlock("block_of_cheese",
            new Block(AbstractBlock.Settings.create().strength(0.7F).sounds(BlockSoundGroup.SLIME)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItems(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Cheese.MOD_ID, name), block);
    }

    private static void registerBlockItems(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Cheese.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Cheese.LOGGER.info("Registering mod blocks for " + Cheese.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.BLOCK_OF_CHEESE);
        });
    }

}
