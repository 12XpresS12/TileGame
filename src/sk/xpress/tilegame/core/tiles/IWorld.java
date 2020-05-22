package sk.xpress.tilegame.core.tiles;

import sk.xpress.tilegame.core.blocks.Block;
import sk.xpress.tilegame.core.blocks.BlockMaterial;

public interface IWorld {

    String getWorldName();

    Tile[][] getTile();

    @Deprecated
    void addTile(BlockMaterial blockMaterial, int x, int y);

    void addTile(Block block, int x, int y);
}
