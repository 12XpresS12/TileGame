package sk.xpress.tilegame.core.tiles;

import sk.xpress.tilegame.core.utils.Cord;

import java.util.Arrays;

public class Chunk {

    private Cord.Int chunkCoord;

    private Tile[][] tiles;
    public static final int CHUNK_SIZE = 10;

    public Chunk(int x, int y) {
        this.chunkCoord = new Cord.Int<>(x, y);
        tiles = new Tile[CHUNK_SIZE][CHUNK_SIZE];
    }

    public void setTiles(Tile[][] tile) {
        this.tiles = tile;
    }

    public Cord.Int getChunkCoord() {
        return chunkCoord;
    }

    public Tile[][] getTiles() {
        if(tiles == null)
            tiles = new Tile[CHUNK_SIZE][CHUNK_SIZE];
        return tiles;
    }

    public Tile getTile(int x, int y) {
        if(tiles == null)
            tiles = new Tile[CHUNK_SIZE][CHUNK_SIZE];

        return tiles[x][y];
    }

    public void setTile(int x, int y, Tile tile) {
        if(tiles == null)
            tiles = new Tile[CHUNK_SIZE][CHUNK_SIZE];

        tiles[x][y] = tile;
    }

    public int getX() {
        return chunkCoord.getX();
    }

    public int getY() {
        return chunkCoord.getY();
    }

    public int getMinX() {
        return (int) Cord.getLocationFromChunk(chunkCoord).getX();
    }

    public int getMinY() {
        return (int) Cord.getLocationFromChunk(chunkCoord).getY();
    }

    public int getMaxX() {
        return (int) Cord.getLocationFromChunk(chunkCoord).getX()+Chunk.CHUNK_SIZE;
    }

    public int getMaxY() {
        return (int) Cord.getLocationFromChunk(chunkCoord).getY()+Chunk.CHUNK_SIZE;
    }

    @Override
    public String toString() {
        return "Chunk{" +
                "chunkCoord=" + chunkCoord +
                ", tileLength=" + Arrays.toString(tiles).length() +
                '}';
    }
}
