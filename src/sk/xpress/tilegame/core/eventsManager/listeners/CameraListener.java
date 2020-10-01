package sk.xpress.tilegame.core.eventsManager.listeners;

import sk.xpress.tilegame.core.eventsManager.EHandler;
import sk.xpress.tilegame.core.eventsManager.EventPriority;
import sk.xpress.tilegame.core.eventsManager.Listener;
import sk.xpress.tilegame.core.eventsManager.events.CameraMoveEvent;

public class CameraListener implements Listener {

    @EHandler(eventPriority = EventPriority.HIGH)
    public void onCameraEvent(CameraMoveEvent cameraMoveEvent) {

    }
}
