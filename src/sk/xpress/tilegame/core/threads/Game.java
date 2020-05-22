package sk.xpress.tilegame.core.threads;

import sk.xpress.tilegame.core.blocks.*;
import sk.xpress.tilegame.core.map.OpenSimplexNoise;
import sk.xpress.tilegame.core.tiles.worlds.Overworld;
import sk.xpress.tilegame.core.tiles.World;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Game extends GameThread {

    private String gameTitle;
    private JFrame jFrame;
    private Graphics graphics;

    private int width = 1280;
    private int height = 720;

    private static Game game;

    public static final int DEFAULT_TILE_SIZE_PX = 16;

    private static final Random random = new Random();

    private World overWorld;

    private OpenSimplexNoise openSimplexNoise;

    public Game(String title) {
        this.gameTitle = title;

        jFrame = new JFrame(title);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(width, height);

        graphics = jFrame.getGraphics();
        openSimplexNoise = new OpenSimplexNoise(random.nextLong());
    }

    @Override
    public void initialize() {
        overWorld = new Overworld();

        for(int x = 0; x < width; x+=DEFAULT_TILE_SIZE_PX) {
            for (int y = 0; y < height; y += DEFAULT_TILE_SIZE_PX) {
                double a = (openSimplexNoise.eval(x, y)*10);
                Block block;
                switch((int) a){
                    case 0:
                    case 1:
                    case 2:
                    case 3: {
                        block = new GrassBlock(x, y);
                        break;
                    }

                    case 4:
                    case 5:
                    case 6:
                    case 7: {
                        block = new Stone(x, y);
                        break;
                    }

                    case -1:
                    case -2:
                    case -3:
                    case -4: {
                        block = new Water(x, y);
                        break;
                    }
                    default:
                        block = new Water(x, y);
                }

                overWorld.addTile(block, x, y);
            }
        }
    }

    @Override
    public void update() {
        System.out.println("UPDATE");
    }


    @Override
    public void render() {
        for(int x = 0; x < width; x+=DEFAULT_TILE_SIZE_PX) {
            for(int y = 0; y < height; y+=DEFAULT_TILE_SIZE_PX) {

                graphics.setColor(overWorld.getTile()[x][y].getBlockMaterial().getColor());
                graphics.fill3DRect(x, y, x+DEFAULT_TILE_SIZE_PX, y+DEFAULT_TILE_SIZE_PX, false);
            }
        }
    }

    public OpenSimplexNoise getOpenSimplexNoise() {
        return openSimplexNoise;
    }

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        Game.game = game;
    }
}
