package sk.xpress.tilegame.core.tiles;

import sk.xpress.tilegame.core.blocks.Block;
import sk.xpress.tilegame.core.blocks.BlockMaterial;

public class Tile {

    private int width;
    private int height;

    private BlockMaterial blockMaterial;
    private Block block;

    public static final int TILE_WIDTH_HEIGHT = 64;

    public Tile(Block block) {
        this.height = TILE_WIDTH_HEIGHT-1;
        this.width = TILE_WIDTH_HEIGHT-1;
        this.blockMaterial = block.getBlockMaterial();
        this.block = block;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public BlockMaterial getBlockMaterial() { return blockMaterial; }

    public Block getBlock() {
        return block;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "width=" + width +
                ", height=" + height +
                ", blockMaterial=" + blockMaterial +
                ", block=" + block +
                '}';
    }
}
