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
import net.minecraft.item.*;
import net.minecraft.util.Rarity;
import net.ethan.cheese.sound.ModJukeboxSongs;

public class ModItems {


    public static final Item MOLDY_MUSIC_DISC = registerItem("moldy_music_disc",
            new Item(new Item.Settings()
                    .maxCount(1)
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(ModJukeboxSongs.MOLDY_MUSIC)));

    // Cheddar Tools
    public static final Item CHEDDAR_SWORD = registerItem("cheddar_sword",
            new SwordItem(ModToolMaterial.CHEDDAR, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.CHEDDAR, 3, -2.4f))));

    public static final Item CHEDDAR_PICKAXE = registerItem("cheddar_pickaxe",
            new PickaxeItem(ModToolMaterial.CHEDDAR, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterial.CHEDDAR, 1, -2.8f))));

    public static final Item CHEDDAR_AXE = registerItem("cheddar_axe",
            new AxeItem(ModToolMaterial.CHEDDAR, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterial.CHEDDAR, 6, -3.0f))));

    public static final Item CHEDDAR_SHOVEL = registerItem("cheddar_shovel",
            new ShovelItem(ModToolMaterial.CHEDDAR, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterial.CHEDDAR, 1.5f, -3.0f))));

    public static final Item CHEDDAR_HOE = registerItem("cheddar_hoe",
            new HoeItem(ModToolMaterial.CHEDDAR, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterial.CHEDDAR, 0, -3.0f))));

    // Moldy Tools
    public static final Item MOLDY_SWORD = registerItem("moldy_sword",
            new SwordItem(ModToolMaterial.MOLDY, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterial.MOLDY, 3, -2.4f))));

    public static final Item MOLDY_PICKAXE = registerItem("moldy_pickaxe",
            new PickaxeItem(ModToolMaterial.MOLDY, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterial.MOLDY, 1, -2.8f))));

    public static final Item MOLDY_AXE = registerItem("moldy_axe",
            new AxeItem(ModToolMaterial.MOLDY, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterial.MOLDY, 6, -3.0f))));

    public static final Item MOLDY_SHOVEL = registerItem("moldy_shovel",
            new ShovelItem(ModToolMaterial.MOLDY, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterial.MOLDY, 1.5f, -3.0f))));

    public static final Item MOLDY_HOE = registerItem("moldy_hoe",
            new HoeItem(ModToolMaterial.MOLDY, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterial.MOLDY, 0, -3.0f))));

    public static final Item MOLDY_CHEESE_APPLE = registerItem("moldy_cheese_apple", new Item(new Item.Settings()
            .food(new FoodComponent.Builder()
                    .nutrition(2)
                    .saturationModifier(0.2f)
                    .snack()
                    .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA,200), 1.0f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON,200), 1.0f)
                    .build())));

    public static final Item CHEESE_APPLE = registerItem("cheese_apple", new Item(new Item.Settings()
            .food(new FoodComponent.Builder()
                    .nutrition(5)
                    .saturationModifier(0.4f)
                    .snack()
                    .build())));

    public static final Item CHEESE_ON_A_STICK = registerItem("cheese_on_a_stick", new Item(new Item.Settings()
            .food(new FoodComponent.Builder()
                    .nutrition(4)
                    .saturationModifier(0.3f)
                    .snack()
                    .build())));

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
                    .statusEffect(new StatusEffectInstance(StatusEffects.POISON,200), 1.0f)
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
            entries.add(CHEESE_ON_A_STICK);
            entries.add(CHEESE_APPLE);
            entries.add(MOLDY_CHEESE_APPLE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(CHEDDAR_SWORD);
            entries.add(CHEDDAR_PICKAXE);
            entries.add(CHEDDAR_AXE);
            entries.add(CHEDDAR_SHOVEL);
            entries.add(CHEDDAR_HOE);
            entries.add(MOLDY_SWORD);
            entries.add(MOLDY_PICKAXE);
            entries.add(MOLDY_AXE);
            entries.add(MOLDY_SHOVEL);
            entries.add(MOLDY_HOE);
            entries.add(MOLDY_MUSIC_DISC);
        });

    }
}
