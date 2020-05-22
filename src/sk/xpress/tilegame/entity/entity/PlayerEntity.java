package sk.xpress.tilegame.entity.entity;

import sk.xpress.tilegame.core.Location;
import sk.xpress.tilegame.entity.EntityType;
import sk.xpress.tilegame.entity.LivingEntity;

public class PlayerEntity extends LivingEntity {

    public PlayerEntity(Location location) {
        super(location);
    }

    @Override
    public double getMaxHealthPoint() {
        return 20;
    }

    @Override
    public double getHealthPoint() {
        return 20;
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.PLAYER;
    }

}
