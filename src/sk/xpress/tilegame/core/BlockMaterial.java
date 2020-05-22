package sk.xpress.tilegame.core;

import sk.xpress.tilegame.core.blocks.Block;

public enum BlockMaterial {

    Stone(sk.xpress.tilegame.core.blocks.Stone.class),
    Water(sk.xpress.tilegame.core.blocks.Water.class);

    private Class<? extends Block> aClass;

    BlockMaterial(Class<? extends Block> classType) {
        this.aClass = classType;
    }

    public Class<? extends Block> getAClass() {
        return aClass;
    }
}
