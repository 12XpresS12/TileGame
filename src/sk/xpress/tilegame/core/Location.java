package sk.xpress.tilegame.core;

import sk.xpress.tilegame.core.tiles.Dimension;
import sk.xpress.tilegame.core.utils.Cord;

public class Location implements Cloneable {

    private Dimension world;
    private Cord.Double cord;

    public Location(Dimension world, double x, double y) {
        this.world = world;
        this.cord = new Cord.Double<>(x, y);
    }

    public Dimension getWorld() {
        System.out.println("Dimension: " + this.getWorld().toString());
        return this.getWorld();
    }

    public void setWorld(Dimension world) { this.world = world; }

    public double getX() {
        return this.cord.getX();
    }

    public double getY() {
        return this.cord.getY();
    }

    public void setX(double x) { this.cord.setX(x); }

    public void setY(double y) { this.cord.setY(y); }

    @Override
    public String toString() {
        return "Location{" +
                "world=" + world +
                ", x=" + cord.getX() +
                ", y=" + cord.getY() +
                '}';
    }

    public Location clone() {
        try {
            return (Location) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
