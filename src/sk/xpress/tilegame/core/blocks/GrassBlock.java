package sk.xpress.tilegame.core.blocks;

import sk.xpress.tilegame.core.Collision;

public class GrassBlock extends Block {

    public GrassBlock(int x, int y) {
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
