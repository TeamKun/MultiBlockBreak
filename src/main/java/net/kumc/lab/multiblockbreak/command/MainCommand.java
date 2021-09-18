package net.kumc.lab.multiblockbreak.command;

import dev.kotx.flylib.command.Command;

public class MainCommand extends Command {
    public MainCommand() {
        super("multiblockbreak");
        children(new StartCommand(), new StopCommand(), new ConfigCommand(), new AddPlayerCommand(), new RemovePlayerCommand());
    }
}
