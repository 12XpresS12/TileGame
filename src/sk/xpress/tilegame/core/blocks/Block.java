package sk.xpress.tilegame.core.blocks;

import sk.xpress.tilegame.core.Collision;

public abstract class Block {

    protected int x;
    protected int y;

    public Block(int x, int y){
        this.x = x;
        this.y = y;
    }

    public abstract BlockMaterial getBlockMaterial();
    public abstract Collision getCollision();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Block=[X:" + x + ", Y:" + y + "]";
    }
}
