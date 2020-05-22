package sk.xpress.tilegame.core.tiles;

public class Tile {

    private int width;
    private int height;

    public Tile(int width, int height){
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
