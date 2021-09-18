package net.kumc.lab.multiblockbreak;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Config {
    public static Set<UUID> enabledPlayers = new HashSet<>();
    public static boolean isEnabled = false;
    public static int minRadius = 4;
    public static int maxRadius = 8;
    public static int numberOfExecutionsPerSec = 25000;
    public static boolean shouldBlockTriggerEffect = true;
}
