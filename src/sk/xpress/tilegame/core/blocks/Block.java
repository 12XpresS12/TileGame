package sk.xpress.tilegame.core.blocks;

import sk.xpress.tilegame.core.Collision;

public abstract class Block {

    private Collision collision;

    public abstract Collision getCollision();

    @Override
    public String toString() {
        return super.toString();
    }
}
