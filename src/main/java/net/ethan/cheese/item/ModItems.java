package net.ethan.cheese.item;

import net.ethan.cheese.Cheese;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item CHEESE = registerItem("cheese", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Cheese.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Cheese.LOGGER.info("Registering mod items for " + Cheese.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries ->{
            entries.add(CHEESE);
        });
    }
}
