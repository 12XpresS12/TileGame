package sk.xpress.tilegame.core.blocks.block;

import sk.xpress.tilegame.core.Collision;
import sk.xpress.tilegame.core.Location;
import sk.xpress.tilegame.core.blocks.Block;
import sk.xpress.tilegame.core.blocks.BlockMaterial;

public class Water extends Block {

    public Water(Location location) {
        super(location);
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
