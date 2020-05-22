package sk.xpress.tilegame.core.blocks.block;

import sk.xpress.tilegame.core.Collision;
import sk.xpress.tilegame.core.blocks.Block;
import sk.xpress.tilegame.core.blocks.BlockMaterial;

public class Water extends Block {

    public Water(int x, int y) {
        super(x, y);
    }

    @Override
    public BlockMaterial getBlockMaterial() {
        return BlockMaterial.WATER;
    }

    @Override
    public Collision getCollision() {
        return Collision.DISABLED;
    }
}
