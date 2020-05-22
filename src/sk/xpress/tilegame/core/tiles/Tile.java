package sk.xpress.tilegame.core.tiles;

import sk.xpress.tilegame.core.blocks.BlockMaterial;
import sk.xpress.tilegame.core.blocks.Block;

public class Tile {

    private int width;
    private int height;

    private BlockMaterial blockMaterial;
    private Block block;

    public Tile(int width, int height, Block block) {
        this.height = height;
        this.width = width;
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
}
