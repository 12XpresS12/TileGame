package sk.xpress.tilegame.core.tiles.worlds;

import sk.xpress.tilegame.core.blocks.Block;
import sk.xpress.tilegame.core.tiles.Chunk;
import sk.xpress.tilegame.core.tiles.Dimension;
import sk.xpress.tilegame.core.tiles.Tile;

public class World extends Dimension {

    public String getWorldName() {
        return "World";
    }

    public Chunk renderChunk(int chunkX, int chunkY) {
        Chunk chunk = new Chunk(chunkX , chunkY);
        getChunk()[chunkX][chunkY] = chunk;
        return chunk;
    }

    public Tile addTile(Chunk chunk, Block block, int x, int y) {
        Tile tile = new Tile(block);
        getChunk()[chunk.getX()][chunk.getY()].setTile(x, y, tile);
        return tile;
    }


    /*
    @Override
    public void addTile(BlockMaterial blockMaterial, int x, int y) {
        new Chunk();
    }

    @Override
    public void addTile(Block block, int x, int y) {
        getTile()[x][y] = new Tile(Game.DEFAULT_TILE_SIZE_PX-1 , Game.DEFAULT_TILE_SIZE_PX-1, block);
    }

     */
}
