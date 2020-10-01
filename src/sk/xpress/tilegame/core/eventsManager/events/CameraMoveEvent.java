package sk.xpress.tilegame.core.eventsManager.events;

import sk.xpress.tilegame.core.camera.ICamera;
import sk.xpress.tilegame.core.utils.Cord;

public class CameraMoveEvent extends Event {

    private ICamera camera;
    private Cord.Double oldCord;
    private Cord.Double newCord;

    public CameraMoveEvent(ICamera camera, Cord.Double oldCord, Cord.Double newCord) {
        this.camera = camera;
        this.oldCord = oldCord;
        this.newCord = newCord;
    }

    public ICamera getCamera() {
        return camera;
    }

    public Cord.Double getOldCord() {
        return oldCord;
    }

    public Cord.Double getNewCord() {
        return newCord;
    }
}
