package sk.xpress.tilegame.core.blocks.block;

import sk.xpress.tilegame.core.Collision;
import sk.xpress.tilegame.core.blocks.Block;
import sk.xpress.tilegame.core.blocks.BlockMaterial;

public class Grass_Block extends Block {

    public Grass_Block(int x, int y) {
        super(x, y);
    }

    @Override
    public BlockMaterial getBlockMaterial() {
        return BlockMaterial.GRASS_BLOCK;
    }

    @Override
    public Collision getCollision() {
        return Collision.ALLOWED;
    }
}
