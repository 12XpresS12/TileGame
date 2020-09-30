package sk.xpress.tilegame.core.blocks;

import sk.xpress.tilegame.core.Collision;
import sk.xpress.tilegame.core.Location;

public abstract class Block {

    protected Location location;

    public Block(Location location){
        this.location = location;
    }

    public abstract BlockMaterial getBlockMaterial();
    public abstract Collision getCollision();

    public Location getBlockLocation() { return location; }

    public double getX() { return location.getX(); }
    public double getY() { return location.getY(); }

    @Override
    public String toString() {
        return "Block{" +
                "location=" + location +
                '}';
    }
}
