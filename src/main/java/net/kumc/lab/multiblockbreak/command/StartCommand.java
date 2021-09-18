package net.kumc.lab.multiblockbreak.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kumc.lab.multiblockbreak.Config;

public class StartCommand extends Command {
    public StartCommand() {
        super("start");
    }

    @Override
    public void execute(CommandContext ctx) {
        if (Config.isEnabled) {
            ctx.fail("MultiBlockBreakは既に有効です.");
            return;
        }
        Config.isEnabled = true;

        ctx.success("MultiBlockBreakを有効にしました.");
    }
}
