package sk.xpress.tilegame.core.blocks;

import sk.xpress.tilegame.core.threads.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class BlockMaterial {

    public static final BlockMaterial WATER;
    public static final BlockMaterial STONE;
    public static final BlockMaterial GRASS_BLOCK;
    public static final BlockMaterial WOOD_PLANK;

    private int id;
    private String name;

    private BufferedImage bufferedImage;

    public BlockMaterial(int id, String name, String bufferedImagePath) {
        this.id = id;
        this.name = name;

        System.out.println("X:" +  BlockMaterial.class.getClassLoader().getResource("water.png"));
        try {
            bufferedImage = ImageIO.read(BlockMaterial.class.getClassLoader().getResource("" + bufferedImagePath + ".png"));

        } catch (IOException e) {
            bufferedImage = new BufferedImage(Game.DEFAULT_TILE_SIZE_PX, Game.DEFAULT_TILE_SIZE_PX, BufferedImage.TYPE_INT_ARGB);
            for(int x = 0; x < Game.DEFAULT_TILE_SIZE_PX; x++) {
                for(int y = 0; y < Game.DEFAULT_TILE_SIZE_PX; y++) {
                    bufferedImage.setRGB(x, y, Color.PINK.getRGB());
                }
            }
            e.printStackTrace();
        }
    }

    public BufferedImage getBufferedImage() { return bufferedImage; }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    static {
        System.out.println("Initializing block materials");
        WATER = (new BlockMaterial(0, "water", "water"));
        STONE = (new BlockMaterial(1, "stone", "stone"));
        GRASS_BLOCK = (new BlockMaterial(2, "grass_block", "grass_block"));
        WOOD_PLANK = (new BlockMaterial(3, "wood_plank", "wood_plank"));
    }


}
