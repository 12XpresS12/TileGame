package sk.xpress.tilegame.core.tiles;

import java.util.HashMap;
import java.util.Map;

public class WorldManager {

    private static Map<String, World> worlds = new HashMap<>();

    public static void addWorld(String worldName, World world) {
        if(worlds.containsKey(worldName))
            throw new IllegalArgumentException("World already exist!");

        worlds.put(worldName, world);
    }

    public static World getDefaultWorld(){
        return worlds.get("world");
    }

    public static World getWorld(String worldName) {
        if(!worlds.containsKey(worldName))
            throw new NullPointerException("World doesnt exist!");

        return worlds.get(worldName);
    }

    public static Map<String, World> getWorlds() {
        return worlds;
    }
}
