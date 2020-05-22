package sk.xpress.tilegame.entity;

public final class EntityType {

    public static final EntityType TORCH;
    public static final EntityType PLAYER;
    public static final EntityType ZOMBIE;

    public EntityType() {

    }

    static {
        TORCH = new EntityType();
        PLAYER = new EntityType();
        ZOMBIE = new EntityType();
    }
}
