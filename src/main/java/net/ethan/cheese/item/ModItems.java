package net.ethan.cheese.item;

import net.ethan.cheese.Cheese;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item GRILLED_CHEESE_SANDWICH = registerItem("grilled_cheese_sandwich", new Item(new Item.Settings()
            .food(new FoodComponent.Builder()
                    .nutrition(8)
                    .saturationModifier(0.8f)
                    .build())));

    public static final Item COLD_CHEESE_SANDWICH = registerItem("cold_cheese_sandwich", new Item(new Item.Settings()
            .food(new FoodComponent.Builder()
                    .nutrition(6)
                    .saturationModifier(0.5f)
                    .build())));

    public static final Item MOLDY_CHEESE_WEDGE = registerItem("moldy_cheese_wedge", new Item(new Item.Settings()
            .food(new FoodComponent.Builder()
                    .nutrition(1)
                    .saturationModifier(0.1f)
                    .snack()
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,200), 1.0f)
                    .build())));

    public static final Item CHEDDAR_CHEESE_WEDGE = registerItem("cheddar_cheese_wedge", new Item(new Item.Settings()
            .food(new FoodComponent.Builder()
                    .nutrition(4)
                    .saturationModifier(0.3f)
                    .snack()
                    .build())));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Cheese.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Cheese.LOGGER.info("Registering mod items for " + Cheese.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries ->{
            entries.add(CHEDDAR_CHEESE_WEDGE);
            entries.add(MOLDY_CHEESE_WEDGE);
            entries.add(COLD_CHEESE_SANDWICH);
            entries.add(GRILLED_CHEESE_SANDWICH);
        });
    }
}
