package sk.xpress.tilegame.core.threads;

import sk.xpress.tilegame.core.Location;
import sk.xpress.tilegame.core.blocks.*;
import sk.xpress.tilegame.core.blocks.block.Grass_Block;
import sk.xpress.tilegame.core.blocks.block.Stone;
import sk.xpress.tilegame.core.blocks.block.Water;
import sk.xpress.tilegame.core.blocks.block.Wood_Plank;
import sk.xpress.tilegame.core.listeners.KeyboardListener;
import sk.xpress.tilegame.core.map.OpenSimplexNoise;
import sk.xpress.tilegame.core.tiles.Tile;
import sk.xpress.tilegame.core.tiles.WorldManager;
import sk.xpress.tilegame.core.tiles.worlds.Overworld;
import sk.xpress.tilegame.core.tiles.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Game extends GameThread {

    private String gameTitle;
    private JFrame jFrame;
    private Graphics graphics;

    private int width = 1920;
    private int height = 1270;
    private static Game game;
    public static final int DEFAULT_TILE_SIZE_PX = 32;

    private static final Random random = new Random();

    private World overWorld;

    public Game(String title) {
        super();
        this.gameTitle = title;
        jFrame = new JFrame(title);
        graphics = jFrame.getGraphics();

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(width, height);

        new KeyboardListener();

        jFrame.addKeyListener(KeyboardListener.getKeyListener());

        initialize();
        this.preparedToStart(); // Must be last, because this will start the Game Thread
    }

    @Override
    public void initialize() {
        overWorld = new Overworld();
        WorldManager.addWorld("world", overWorld);

        for(int x = 0; x < width*8; x+=DEFAULT_TILE_SIZE_PX) {
            for (int y = 0; y < height*8; y += DEFAULT_TILE_SIZE_PX) {
                double a = (overWorld.getOpenSimplexNoise().eval(x, y)*10);
                Block block;
                Location location = new Location(WorldManager.getDefaultWorld(), x, y);
                switch((int) a){
                    case 0:
                    case 1:
                    case 2:
                    case 3: {
                        block = new Grass_Block(location.clone());
                        break;
                    }

                    case 4:
                    case 5:
                    case 6:
                    case 7: {
                        block = new Stone(location.clone());
                        break;
                    }

                    case -1:
                    case -2:
                    case -3:
                    case -4: {
                        block = new Water(location.clone());
                        break;
                    }
                    default:
                        block = new Wood_Plank(location.clone());
                }

                overWorld.addTile(block, x, y);
            }
        }
    }

    @Override
    public void update() {
    }


    @Override
    public void render() {
        if(graphics == null)
            graphics = jFrame.getGraphics();
        /*VER 3
         */

        for (int x = 0; x < width; x += DEFAULT_TILE_SIZE_PX) {
            for(int y = 0; y < height; y+=DEFAULT_TILE_SIZE_PX) {
                graphics.drawImage(overWorld.getTile()[x][y].getBlockMaterial().getBufferedImage(), x, y, null);
            }
        }
      /* VER 2
      if(this.overWorld.convertToList() != null && this.overWorld.convertToList().size() > 1)

        for (Tile tile : this.overWorld.convertToList()) {
            if(tile == null)
                continue;

            graphics.setColor(tile.getBlockMaterial().getColor());
            graphics.fillRect(tile.getBlock().getX(), tile.getBlock().getY(),
                    tile.getBlock().getX()*tile.getWidth(), tile.getBlock().getY()*tile.getHeight());

            graphics.setColor(Color.magenta);
            graphics.drawString("" + tile.getBlock().getX(),
                    tile.getBlock().getX()-((int) (this.DEFAULT_TILE_SIZE_PX/1.5)),
                    tile.getBlock().getY()-((int)  (this.DEFAULT_TILE_SIZE_PX/1.5)));
        }*ú

        /*VER 1

        for(int y = 0; y < height; y+=DEFAULT_TILE_SIZE_PX) {
            for(int x = 0; x < width; x+=DEFAULT_TILE_SIZE_PX) {

                graphics.setColor(
                        overWorld
                        .getTile()[x][y]
                        .getBlockMaterial()
                        .getColor());

                graphics.fill3DRect(x-32, y-32, x+DEFAULT_TILE_SIZE_PX, y+DEFAULT_TILE_SIZE_PX, false);
                //graphics.drawString("X",  x-((int) (DEFAULT_TILE_SIZE_PX/1.55)), y-((int) (DEFAULT_TILE_SIZE_PX/2.75)));
            }
        }*/
    }

    @Override
    public void stopThread() { }

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        Game.game = game;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public JFrame getJFrame() { return jFrame; }
}
