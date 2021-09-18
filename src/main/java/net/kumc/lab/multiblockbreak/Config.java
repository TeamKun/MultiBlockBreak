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
    public static boolean shouldBlockTriggerEffect = false;
    public static boolean couldHappenAccident = true;
    public static double accidentProbability = 1.0;
    public static int accidentRadius = 16;
    public static boolean exceptCreativePlayer = false;
    public static boolean shouldItemDrop = false;
}
