package sk.xpress.tilegame.core.tiles;

import sk.xpress.tilegame.core.blocks.Block;
import sk.xpress.tilegame.core.blocks.BlockMaterial;


public abstract class World implements IWorld {

    protected Tile[][] tile = new Tile[2000][2000];

    public Tile[][] getTile() { return tile; }

    @Override
    public abstract void addTile(BlockMaterial blockMaterial, int x, int y);

    @Override
    public abstract void addTile(Block block, int x, int y);
}
