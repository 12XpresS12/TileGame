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
        WATER = (new BlockMaterial(0, "water", Color.getColor("2389da")));
        STONE = (new BlockMaterial(1, "stone", Color.getColor("888C8D")));
        GRASS_BLOCK = (new BlockMaterial(2, "grass_block", Color.getColor("0b6623")));
    }
}
