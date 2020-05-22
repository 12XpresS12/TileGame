package sk.xpress.tilegame.core.blocks.block;

import sk.xpress.tilegame.core.Collision;
import sk.xpress.tilegame.core.Location;
import sk.xpress.tilegame.core.blocks.Block;
import sk.xpress.tilegame.core.blocks.BlockMaterial;

public class Stone extends Block {

    public Stone(Location location) {
        super(location);
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
