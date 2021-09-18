package net.kumc.lab.multiblockbreak;

import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;

public enum Region {
    CUBOID((origin, radius) -> {
        Set<Block> blocks = new HashSet<>();

        for (int x = -radius; x < radius; x++) {
            for (int y = -radius; y < radius; y++) {
                for (int z = -radius; z < radius; z++) {
                    blocks.add(origin.getBlock().getRelative(x, y, z));
                }
            }
        }

        return blocks;
    }),
    SPHERE((origin, radius) -> {
        Set<Block> blocks = new HashSet<>();

        int height = radius;
        for (int y = 0; y < height; y++) {
            for (int x = -radius; x < radius; x++) {
                for (int z = -radius; z < radius; z++) {
                    Block b1 = origin.getBlock().getRelative(x, y, z);
                    if (b1.getLocation().distance(origin.clone().add(0, y, 0)) < radius) {
                        blocks.add(b1);
                    }

                    Block b2 = origin.getBlock().getRelative(x, -y, z);
                    if (b2.getLocation().distance(origin.clone().add(0, -y, 0)) < radius) {
                        blocks.add(b2);
                    }
                }
            }
            radius--;
        }

        return blocks;
    }),
    CIRCLE((origin, radius) -> {
        Set<Block> blocks = new HashSet<>();

        for (int x = -radius; x < radius; x++) {
            for (int z = -radius; z < radius; z++) {
                Block b = origin.getBlock().getRelative(x, 0, z);
                if (b.getLocation().distance(origin) < radius) {
                    blocks.add(b);
                }
            }
        }

        return blocks;
    }),
    CYL((origin, radius) -> {
        Set<Block> blocks = new HashSet<>();

        for (int y = -radius; y < radius; y++) {
            for (int x = -radius; x < radius; x++) {
                for (int z = -radius; z < radius; z++) {
                    Block b = origin.getBlock().getRelative(x, y, z);
                    if (b.getLocation().distance(origin.clone().add(0, y, 0)) < radius) {
                        blocks.add(b);
                    }
                }
            }
        }

        return blocks;
    }),
    PYRAMID((origin, radius) -> {
        Set<Block> blocks = new HashSet<>();

        int height = radius;
        for (int y = -height / 2; y < height / 2; y++) {
            for (int x = -radius; x < radius; x++) {
                for (int z = -radius; z < radius; z++) {
                    blocks.add(origin.getBlock().getRelative(x, y, z));
                }
            }
            radius--;
        }

        return blocks;
    }),
    INVPYRAMID((origin, radius) -> {
        Set<Block> blocks = new HashSet<>();

        int height = radius;
        for (int y = height / 2; y > -height / 2; y--) {
            for (int x = -radius; x < radius; x++) {
                for (int z = -radius; z < radius; z++) {
                    blocks.add(origin.getBlock().getRelative(x, y, z));
                }
            }
            radius--;
        }

        return blocks;
    });

    public BiFunction<Location, Integer, Set<Block>> getBlocks;

    Region(BiFunction<Location, Integer, Set<Block>> func) {
        this.getBlocks = func;
    }
}
