package net.ethan.cheese.sound;

import net.ethan.cheese.Cheese;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModJukeboxSongs {

    public static final RegistryKey<JukeboxSong> MOLDY_MUSIC = of("moldy_music");

    private static RegistryKey<JukeboxSong> of(String name) {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Cheese.MOD_ID, name));
    }

    public static void registerModJukeboxSongs() {
        Cheese.LOGGER.info("Registering mod jukebox songs for " + Cheese.MOD_ID);
    }
}