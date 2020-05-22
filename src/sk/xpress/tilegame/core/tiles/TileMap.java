package sk.xpress.tilegame.core.tiles;

public class TileMap {

    private Tile[][] tile;

    public Tile[][] getTile() {
        return tile;
    }

    public void test(){
        tile[0][1] = new Tile(10 , 20);
    }
}
