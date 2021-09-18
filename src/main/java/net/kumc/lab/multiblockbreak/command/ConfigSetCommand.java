package net.kumc.lab.multiblockbreak.command;

import dev.kotx.flylib.command.Command;
import net.kumc.lab.multiblockbreak.Config;

import java.lang.reflect.Field;

public class ConfigSetCommand extends Command {
    public ConfigSetCommand() {
        super("set");

        try {
            for (Field field : Config.class.getDeclaredFields()) {
                if (!field.getName().equals("enabledPlayers") && !field.getName().equals("isEnabled")) {
                    field.setAccessible(true);
                    children(new ConfigItem(field));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
