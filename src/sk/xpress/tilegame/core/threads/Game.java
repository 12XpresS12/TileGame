package sk.xpress.tilegame.core.threads;

import sk.xpress.tilegame.core.Location;
import sk.xpress.tilegame.core.blocks.Block;
import sk.xpress.tilegame.core.blocks.block.Grass_Block;
import sk.xpress.tilegame.core.blocks.block.Stone;
import sk.xpress.tilegame.core.blocks.block.Water;
import sk.xpress.tilegame.core.blocks.block.Wood_Plank;
import sk.xpress.tilegame.core.camera.Camera;
import sk.xpress.tilegame.core.camera.ICamera;
import sk.xpress.tilegame.core.logger.Log;
import sk.xpress.tilegame.core.tiles.Chunk;
import sk.xpress.tilegame.core.tiles.Dimension;
import sk.xpress.tilegame.core.tiles.DimensionManager;
import sk.xpress.tilegame.core.tiles.Tile;
import sk.xpress.tilegame.core.tiles.worlds.World;
import sk.xpress.tilegame.core.utils.Cord;
import sk.xpress.tilegame.entity.entity.PlayerEntity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Game extends GameThread {

    private String gameTitle;
    private Graphics graphics;

    private int width = 1280;
    private int height = 720;
    private static Game game;
    public static final int DEFAULT_TILE_SIZE_PX = 25;

    private static final Random random = new Random();

    private Dimension overWorld;
    private ICamera camera;
    private PlayerEntity playerEntity;

    private static final int VIEW_DISTANCE = 5;

    private static ArrayList<Chunk> renderedChunks;

    public Game(String title) {
        super();
        this.gameTitle = title;
        jFrame = new JFrame(title);
        graphics = jFrame.getGraphics();

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setSize(width, height);
        jFrame.setResizable(false);

        preinitialize();
        initialize();
        postinitialize();

        renderedChunks = new ArrayList<>();

        this.preparedToStart(); // Must be last, because this will start the Game Thread
    }


    @Override
    protected void preinitialize() {
        /* Setup World */
        overWorld = new World();
        DimensionManager.addWorld("world", overWorld);

        /* Setup Camera */
        camera = new Camera();
        camera.setCameraPosition(new Cord.Double(100, 100));

        Log.info("Pre-Inititialize complete!");
    }

    @Override
    protected void initialize() {
        int renderedChunks = cameraMove();
        Log.info("Rendered chunks: " + renderedChunks);

        Log.info("Inititialize complete!");

    }

    public int cameraMove() {
        int renderedChunks = 0;
        int camPosX = (int) camera.getCameraPositionX();
        int camPosY = (int) camera.getCameraPositionY();

        for(int chunkX = camPosX-VIEW_DISTANCE; chunkX < camPosX+VIEW_DISTANCE; chunkX++) {
            for(int chunkY = camPosY-VIEW_DISTANCE; chunkY < camPosY+VIEW_DISTANCE; chunkY++) {
                Chunk chunk = overWorld.renderChunk(chunkX, chunkY);
                for(int x = chunk.getMinX(); x < chunk.getMaxX(); x++) {
                    for(int y = chunk.getMinY(); y < chunk.getMaxY(); y++) {
                        overWorld.addTile(chunk,
                                getTypeOfBlockFromCord(new Cord.Double<>(x,y)),
                                x-(int)Cord.getLocationFromChunk(chunk.getChunkCoord()).getX(),
                                y-(int)Cord.getLocationFromChunk(chunk.getChunkCoord()).getY());
                    }
                }
                renderedChunks++;
            }
        }
        return renderedChunks;
    }

    private Block getTypeOfBlockFromCord(Cord.Double cord) {
        double a = (overWorld.getOpenSimplexNoise().eval(cord.getX(), cord.getY())*10);
        Block block;
        Location location = new Location(overWorld, cord.getX(), cord.getY());
        //Log.error(location.toString());
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

        return block;
    }

    @Override
    public void postinitialize() {
       playerEntity = new PlayerEntity(new Location(overWorld, 100, 100), camera);
       jFrame.addKeyListener(playerEntity);
        Log.info("Post-Inititialize complete!");
    }

    @Override
    public void update() {
    }


    @Override
    public synchronized void render() {
        if(graphics == null)
            graphics = jFrame.getGraphics();
        /*VER 5*/

        int camPosX = (int) camera.getCameraPositionX();
        int camPosY = (int) camera.getCameraPositionY();

        int x = 0,y = 0;
        for(int chunkX = camPosX-VIEW_DISTANCE; chunkX < camPosX+VIEW_DISTANCE; chunkX++) {
            for (int chunkY = camPosY - VIEW_DISTANCE; chunkY < camPosY + VIEW_DISTANCE; chunkY++) {
                Chunk chunk = overWorld.getChunk(chunkX, chunkY);
                for(Tile[] tile1 : chunk.getTiles()) {
                    for(Tile tile : tile1) {
                        graphics.drawImage(
                                tile.getBlockMaterial().getBufferedImage(),
                                (int) tile.getBlock().getX()*DEFAULT_TILE_SIZE_PX%width,
                                (int) tile.getBlock().getY()*DEFAULT_TILE_SIZE_PX%height, null);
                    }
                }
                Cord.Double pos = Cord.getLocationFromChunk(chunk.getChunkCoord());

            }
        }


        /*
        * VER 4
        */
        /*
        int chunks = 0;
        for(int chunkX =
            (int)(camera.getCameraPositionX() - VIEW_DISTANCE);
            chunkX < camera.getCameraPositionX()+VIEW_DISTANCE;
            chunkX++) {

            for(int chunkY =
                (int)(camera.getCameraPositionY() - (VIEW_DISTANCE/2));
                chunkY < camera.getCameraPositionX()+VIEW_DISTANCE;
                chunkY++) {

                chunks++;
                Chunk chunk = overWorld.getChunk(chunkX, chunkY);
                Cord.Double pos = Cord.getLocationFromChunk(chunk.getChunkCoord());

                for (int i = 0; i < chunk.getTiles().length; i++) {
                            graphics.drawImage(
                                    chunk.getTile((int) pos.getX()%Chunk.CHUNK_SIZE, (int) (pos.getY()%Chunk.CHUNK_SIZE + (pos.getX()%Chunk.CHUNK_SIZE)))
                                            .getBlockMaterial()
                                            .getBufferedImage(),
                                    (int) pos.getX()%height, (int) pos.getY()%width, null);

                }
            }
        }
        Log.info("Rendered chunks: " + chunks);
*/
        /*VER 3


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
