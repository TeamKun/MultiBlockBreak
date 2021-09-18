package net.kumc.lab.multiblockbreak;

import dev.kotx.flylib.FlyLib;
import net.kumc.lab.multiblockbreak.command.MainCommand;
import net.kumc.lab.multiblockbreak.listener.BlockBreakListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MultiBlockBreak extends JavaPlugin {
    public static MultiBlockBreak instance;
    public static TaskScheduler taskScheduler;

    @Override
    public void onEnable() {
        instance = this;
        taskScheduler = new TaskScheduler(this);

        FlyLib.create(this, builder -> {
            builder.command(new MainCommand());
        });
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
    }

    @Override
    public void onDisable() {
    }
}
