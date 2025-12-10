package net.ethan.cheese.item;

import net.ethan.cheese.Cheese;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent MOLDY_MUSIC = registerSoundEvent("moldy_music");

    private static SoundEvent registerSoundEvent(String name){
        Identifier identifier = Identifier.of(Cheese.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    public static void registerModSounds(){
        Cheese.LOGGER.info("Registering mod sounds for " + Cheese.MOD_ID);
    }
}

