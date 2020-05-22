package sk.xpress.tilegame.entity;

import sk.xpress.tilegame.core.Location;

public abstract class LivingEntity extends Entity {

    protected double hp;

    public LivingEntity(Location location) {
        super(location);
    }

    @Override
    public Location getLocation() {
        return null;
    }

    public void teleport(Location location) {
        System.out.println("Teleporting to new location!");
        this.location = location;
    }

    public abstract double getMaxHealthPoint();
    public abstract double getHealthPoint();
    public abstract EntityType getEntityType();
}
