package sk.xpress.tilegame.core.blocks.wood;

import sk.xpress.tilegame.core.Collision;

public enum WoodType {

    OAK(Collision.ALLOWED),
    BIRCH(Collision.ALLOWED);

    private Collision collision;

    WoodType(Collision collision) {
        this.collision = collision;
    }

    public Collision getCollision() {
        return collision;
    }
}
