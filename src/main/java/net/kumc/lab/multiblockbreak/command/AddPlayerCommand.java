package net.kumc.lab.multiblockbreak.command;

import dev.kotx.flylib.command.Command;
import dev.kotx.flylib.command.CommandContext;
import net.kumc.lab.multiblockbreak.Config;
import org.bukkit.entity.Player;

import java.util.List;

public class AddPlayerCommand extends Command {
    public AddPlayerCommand() {
        super("addPlayer");

        usage(builder -> {
            builder.entityArgument("selector");
        });
    }

    @Override
    public void execute(CommandContext ctx) {
        int count = 0;
        for (Object arg : ((List) ctx.getTypedArgs().get(0))) {
            if (arg instanceof Player) {
                if (Config.enabledPlayers.add(((Player) arg).getUniqueId())) {
                    count++;
                }
            }
        }

        ctx.success(count + "人のプレイヤーを有効化しました.");
    }
}
