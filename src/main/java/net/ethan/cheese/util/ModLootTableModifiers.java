package net.ethan.cheese.util;

import com.mojang.datafixers.kinds.Const;
import net.ethan.cheese.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier ZOMBIE_ID
            = Identifier.of("minecraft", "entities/zombie");

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((key, tablebuilder, source, registry) -> {
            if (ZOMBIE_ID.equals((key.getValue()))) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.MOLDY_CHEESE_WEDGE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());

            tablebuilder.pool(poolBuilder.build());
            }
        });
    }
}
