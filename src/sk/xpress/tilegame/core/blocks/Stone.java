package sk.xpress.tilegame.core.blocks;

import sk.xpress.tilegame.core.Collision;

public class Stone extends Block {

    private int width;
    private int height;

    private Collision collision;

    public Stone(int width, int height) {
        this.width = width;
        this.height = height;

        collision = Collision.ALLOWED;
    }


    @Override
    public Collision getCollision() {
        return collision;
    }
}
