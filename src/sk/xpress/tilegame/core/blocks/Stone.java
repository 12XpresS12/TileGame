package sk.xpress.tilegame.core.blocks;

import sk.xpress.tilegame.core.Collision;

public class Stone extends Block {

    public Stone(int x, int y) {
        super(x, y);
    }

    @Override
    public BlockMaterial getBlockMaterial() {
        return BlockMaterial.STONE;
    }

    @Override
    public Collision getCollision() {
        return Collision.ALLOWED;
    }
}
