package sk.xpress.tilegame.core.tiles;

import sk.xpress.tilegame.core.blocks.Block;
import sk.xpress.tilegame.core.blocks.BlockMaterial;
import sk.xpress.tilegame.core.map.OpenSimplexNoise;


public abstract class World implements IWorld {

    OpenSimplexNoise openSimplexNoise;

    public World(){
        openSimplexNoise = new OpenSimplexNoise();
    }

    public OpenSimplexNoise getOpenSimplexNoise() {
        return openSimplexNoise;
    }

    protected Tile[][] tile = new Tile[10000][10000];

    public synchronized Tile[][] getTile() { return tile; }

    @Override
    public abstract void addTile(BlockMaterial blockMaterial, int x, int y);

    @Override
    public abstract void addTile(Block block, int x, int y);
}
