package sk.xpress.tilegame.core.blocks;

import sk.xpress.tilegame.core.threads.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public final class BlockMaterial {

    public static final BlockMaterial WATER;
    public static final BlockMaterial STONE;
    public static final BlockMaterial GRASS_BLOCK;
    public static final BlockMaterial WOOD_PLANK;

    private int id;
    private String name;
    private Color color;

    private BufferedImage bufferedImage;

    public BlockMaterial(int id, String name, Color color) {
        this.id = id;
        this.color = color;
        this.name = name;

        bufferedImage = new BufferedImage(Game.DEFAULT_TILE_SIZE_PX, Game.DEFAULT_TILE_SIZE_PX, BufferedImage.TYPE_INT_ARGB);

        if(bufferedImage == null)
            return;

        for(int x = 0; x < Game.DEFAULT_TILE_SIZE_PX; x++) {
            for(int y = 0; y < Game.DEFAULT_TILE_SIZE_PX; y++) {
                bufferedImage.setRGB(x, y, color.getRGB());
            }
        }
    }

    public BufferedImage getBufferedImage() { return bufferedImage; }

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
        System.out.println("Initializing block materials");
        WATER = (new BlockMaterial(0, "water", new Color(35, 137, 218)));
        STONE = (new BlockMaterial(1, "stone", new Color(136,140,141)));
        GRASS_BLOCK = (new BlockMaterial(2, "grass_block", new Color(11,102,35)));
        WOOD_PLANK = (new BlockMaterial(2, "wood_plank", new Color(100,100,100)));
    }
}
