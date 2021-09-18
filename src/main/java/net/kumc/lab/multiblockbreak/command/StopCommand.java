package net.kumc.lab.multiblockbreak.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kumc.lab.multiblockbreak.Config;

public class StopCommand extends Command {
    public StopCommand() {
        super("stop");
    }

    @Override
    public void execute(CommandContext ctx) {
        if (!Config.isEnabled) {
            ctx.fail("MultiBlockBreakは既に無効です.");
            return;
        }
        Config.isEnabled = false;

        ctx.success("MultiBlockBreakを無効にしました.");
    }
}
