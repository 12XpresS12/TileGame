package sk.xpress.tilegame.core.application;

import sk.xpress.tilegame.core.application.services.CameraService;
import sk.xpress.tilegame.core.application.services.TestService;

public class Application {

    @Service
    public CameraService CameraService() {
        return new CameraService();
    }

    @Service
    public TestService TestService() {
        return new TestService();
    }
}
