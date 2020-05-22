package sk.xpress.tilegame.entity;

import sk.xpress.tilegame.core.Location;

public abstract class Entity {

    protected Location location;


    public Entity(Location location) {
        this.location = location;
    }

    public abstract Location getLocation();

}
