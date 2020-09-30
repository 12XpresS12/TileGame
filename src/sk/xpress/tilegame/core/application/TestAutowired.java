package sk.xpress.tilegame.core.application;

import sk.xpress.tilegame.core.application.services.TestService;
import sk.xpress.tilegame.core.logger.Log;

@Component
public class TestAutowired {

    @Autowired
    private TestService test;

    public TestAutowired() {
        if(test == null)
            Log.error("TEST == null");
        else
        test.scanner();
    }

}
