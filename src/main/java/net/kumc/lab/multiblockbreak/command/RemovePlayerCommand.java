package net.kumc.lab.multiblockbreak.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kumc.lab.multiblockbreak.Config;
import org.bukkit.entity.Player;

import java.util.List;

public class RemovePlayerCommand extends Command {
    public RemovePlayerCommand() {
        super("removePlayer");

        usage(builder -> {
            builder.entityArgument("selector");
        });
    }

    @Override
    public void execute(CommandContext ctx) {
        int count = 0;
        for (Object arg : ((List) ctx.getTypedArgs())) {
            if (arg instanceof Player) {
                if (Config.enabledPlayers.remove(((Player) arg).getUniqueId())) {
                    count++;
                }
            }
        }

        ctx.success(count + "人のプレイヤーを無効化しました.");
    }
}
