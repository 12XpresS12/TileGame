package sk.xpress.tilegame.core.blocks;

import java.awt.*;

public final class BlockMaterial {

    public static final BlockMaterial WATER;
    public static final BlockMaterial STONE;
    public static final BlockMaterial GRASS_BLOCK;

    private int id;
    private String name;
    private Color color;

    public BlockMaterial(int id, String name, Color color) {
        this.id = id;
        this.color = color;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    static {
        System.out.println("INITIALIZING MATERIALS");
        WATER = (new BlockMaterial(0, "water", new Color(35, 137, 218)));
        STONE = (new BlockMaterial(1, "stone", new Color(136,140,141)));
        GRASS_BLOCK = (new BlockMaterial(2, "grass_block", new Color(11,102,35)));
    }
}
