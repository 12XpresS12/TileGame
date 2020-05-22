package sk.xpress.tilegame.core;

import sk.xpress.tilegame.core.tiles.World;

public class Location {

    private World world;
    private double x;
    private double y;

    public Location(World world, double x, double y) {
        this.world = world;
        this.x = x;
        this.y = y;
    }

    public World getWorld() { return this.getWorld(); }

    public void setWorld(World world) { this.world = world; }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) { this.x = x; }

    public void setY(double y) { this.y = y; }
}
