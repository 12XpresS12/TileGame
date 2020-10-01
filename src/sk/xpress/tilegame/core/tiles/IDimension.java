package sk.xpress.tilegame.core.tiles;

import sk.xpress.tilegame.core.blocks.Block;

public interface IDimension {

    String getWorldName();

    Chunk renderChunk(int chunkX, int chunkY);

    Tile addTile(Chunk chunk, Block block, int x, int y);

}
