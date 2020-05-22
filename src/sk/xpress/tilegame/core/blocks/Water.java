package sk.xpress.tilegame.core.blocks;

import sk.xpress.tilegame.core.Collision;

public class Water extends Block {

    private int width;
    private int height;

    private Collision collision;

    public Water(int width, int height) {
        this.width = width;
        this.height = height;

        collision = Collision.DISABLED;
    }

    @Override
    public Collision getCollision() {
        return null;
    }
}
