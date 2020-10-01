package sk.xpress.tilegame.entity.entity;

import sk.xpress.tilegame.core.Location;
import sk.xpress.tilegame.core.camera.ICamera;
import sk.xpress.tilegame.core.logger.Log;
import sk.xpress.tilegame.entity.EntityType;
import sk.xpress.tilegame.entity.LivingEntity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerEntity extends LivingEntity implements KeyListener {

    private ICamera camera;

    public PlayerEntity(Location location, ICamera iCamera) {
        super(location);
        this.camera = iCamera;
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

    public ICamera getCamera() {
        return camera;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        Log.info("CHAR: " + event.getKeyChar());
        switch (event.getKeyChar()) {
            case 'w': {
                camera.moveCamera(0, 1);
                break;
            }
            case 'a': {
                camera.moveCamera(-1, 0);
                break;
            }
            case 's': {
                camera.moveCamera(0, -1);
                break;
            }
            case 'd': {
                camera.moveCamera(+1, 0);
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
