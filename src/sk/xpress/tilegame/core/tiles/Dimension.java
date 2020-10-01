package sk.xpress.tilegame.core.tiles;

import sk.xpress.tilegame.core.map.IWorldGenrator;
import sk.xpress.tilegame.core.map.OpenSimplexNoise;


public abstract class Dimension implements IDimension {

    protected Chunk[][] chunks = new Chunk[10000][10000];

    OpenSimplexNoise openSimplexNoise;

    public Dimension(){
        openSimplexNoise = new OpenSimplexNoise();
    }

    public OpenSimplexNoise getOpenSimplexNoise() {
        return openSimplexNoise;
    }

    public IWorldGenrator getWorldGenerator() {
        return (IWorldGenrator) openSimplexNoise;
    }

    public Chunk[][] getChunk() {
        if(chunks == null)
            chunks = new Chunk[10000][10000];
        return chunks; }

    public Chunk getChunk(int x, int y) {
        if(chunks[x][y] == null)
            renderChunk(x, y);

        return chunks[x][y];
    }


    @Override
    public String toString() {
        return "Dimension{Name=" + this.getWorldName() + ", Chunks=" + getChunk().length*getChunk().length + "}";
    }
}

