package sk.xpress.tilegame.core.blocks.block;

import sk.xpress.tilegame.core.Collision;
import sk.xpress.tilegame.core.blocks.Block;
import sk.xpress.tilegame.core.blocks.BlockMaterial;
import sk.xpress.tilegame.core.blocks.wood.IWood;
import sk.xpress.tilegame.core.blocks.wood.WoodType;

public class Wood_Plank extends Block implements IWood {

    public Wood_Plank(int x, int y) {
        super(x, y);
    }

    @Override
    public BlockMaterial getBlockMaterial() {
        return BlockMaterial.WOOD_PLANK;
    }

    @Override
    public Collision getCollision() {
        return getWoodType().getCollision();
    }

    @Override
    public WoodType getWoodType() {
        return WoodType.OAK;
    }
}
