package net.kumc.lab.multiblockbreak.listener;

import net.kumc.lab.multiblockbreak.Config;
import net.kumc.lab.multiblockbreak.MultiBlockBreak;
import net.kumc.lab.multiblockbreak.Region;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (!Config.isEnabled) {
            return;
        }

        Player p = e.getPlayer();
        if (!Config.enabledPlayers.contains(p.getUniqueId())) {
            return;
        }

        List<Region> regionList = Arrays.asList(Region.values());
        Collections.shuffle(regionList);

        int radius = (int) (Math.random() * (Config.maxRadius - Config.minRadius) + Config.minRadius);
        if (Config.couldHappenAccident && Math.random() * 100 < Config.accidentProbability) {
            radius = Config.accidentRadius;
        }
       
        Set<Block> blocks = regionList.get(0).getBlocks.apply(e.getBlock().getLocation(), radius);
        blocks.forEach(x -> {
            if (x.getType().equals(Material.AIR) || x.getType().equals(Material.CAVE_AIR)) {
                return;
            }

            MultiBlockBreak.taskScheduler.offer(new BukkitRunnable() {
                @Override
                public void run() {
                    x.breakNaturally(p.getInventory().getItemInMainHand(), Config.shouldBlockTriggerEffect);
                }
            });
        });
    }
}