package sk.xpress.tilegame.core.tiles;

import sk.xpress.tilegame.core.logger.Log;

import java.util.HashMap;
import java.util.Map;

public class DimensionManager {

    private static Map<String, Dimension> worlds = new HashMap<>();

    public static void addWorld(String worldName, Dimension world) {
        if(worlds.containsKey(worldName))
            throw new IllegalArgumentException("World already exist!");

        Log.info("World initializing - World: " + worldName);
        worlds.put(worldName, world);
    }

    public static Dimension getDefaultWorld(){
        return worlds.get("world");
    }

    public static Dimension getWorld(String worldName) {
        if(!worlds.containsKey(worldName))
            throw new NullPointerException("World doesnt exist!");

        return worlds.get(worldName);
    }

    public static Map<String, Dimension> getWorlds() {
        return worlds;
    }
}
