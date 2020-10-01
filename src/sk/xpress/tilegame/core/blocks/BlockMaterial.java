package sk.xpress.tilegame.core.blocks;

import sk.xpress.tilegame.core.logger.Log;
import sk.xpress.tilegame.core.threads.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public final class BlockMaterial {

    public static BlockMaterial WATER;
    public static BlockMaterial STONE;
    public static BlockMaterial GRASS_BLOCK;
    public static BlockMaterial WOOD_PLANK;

    private int id;
    private String name;

    private BufferedImage bufferedImage;

    public BlockMaterial(int id, String name, String bufferedImagePath) {
        this.id = id;
        this.name = name;

        //System.out.println("X:" +  BlockMaterial.class.getClassLoader().getResource("water.png"));
        try {
            //System.out.println("Path" + bufferedImagePath + "," +"getClassLoader" + getClass().getClassLoader().getResource(bufferedImagePath + ".png"));
            URL url = getClass().getClassLoader().getResource("" + bufferedImagePath + ".png");
            if(url != null)
                bufferedImage = ImageIO.read(url);
            else {
                bufferedImage = new BufferedImage(Game.DEFAULT_TILE_SIZE_PX, Game.DEFAULT_TILE_SIZE_PX, BufferedImage.TYPE_INT_ARGB);
                for(int x = 0; x < Game.DEFAULT_TILE_SIZE_PX; x++) {
                    for(int y = 0; y < Game.DEFAULT_TILE_SIZE_PX; y++) {
                        //Log.error("Texture of " + bufferedImagePath.toLowerCase() + " cannot be found!");
                        switch(bufferedImagePath.toLowerCase()) {
                            case "water": {
                                bufferedImage.setRGB(x, y, Color.BLUE.getRGB());
                                break;
                            }
                            case "stone": {
                                bufferedImage.setRGB(x, y, Color.GRAY.getRGB());
                                break;
                            }
                            case "grass_block": {
                                bufferedImage.setRGB(x, y, Color.GREEN.getRGB());
                                break;
                            }
                            case "wood_plank": {
                                bufferedImage.setRGB(x, y, Color.MAGENTA.getRGB());
                                break;
                            }
                        }

                    }
                }
            }
        } catch (IOException e) {

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
        Log.info("Initializing block materials");
        WATER = (new BlockMaterial(0, "water", "water"));
        STONE = (new BlockMaterial(1, "stone", "stone"));
        GRASS_BLOCK = (new BlockMaterial(2, "grass_block", "grass_block"));
        WOOD_PLANK = (new BlockMaterial(3, "wood_plank", "wood_plank"));
        Log.info("Initialized block materials (SUCCESS)");
    }

    @Override
    public String toString() {
        return "BlockMaterial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bufferedImageMinX='" + bufferedImage.getMinX() + '\'' +
                ", bufferedImageMinY='" + bufferedImage.getMinY() +
                '}';
    }
}
