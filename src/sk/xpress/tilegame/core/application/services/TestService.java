package sk.xpress.tilegame.core.application.services;

import sk.xpress.tilegame.core.application.IApplication;
import sk.xpress.tilegame.core.logger.Log;

public class TestService implements IApplication {

    public void scanner() {
        Log.info("SCANNING");
    }

}
