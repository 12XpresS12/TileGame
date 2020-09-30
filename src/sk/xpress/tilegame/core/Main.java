package sk.xpress.tilegame.core;

import sk.xpress.tilegame.core.application.*;
import sk.xpress.tilegame.core.logger.Log;
import sk.xpress.tilegame.core.threads.Game;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String gameThreadName = "Main";
    public static List<IApplication> services;
    public static TestAutowired testAutowired;

    public static void main(String[] args) {
       // testAutowired = new TestAutowired();

        Thread thread = new Thread("Testing") {
            @Override
            public void run() {
                services = new ArrayList<IApplication>();
                registerApplication(Application.class, new Application());

                Log.info("Registirng services: " + services.size());
                Log.info("Wiring services");
                new Wiring();
            }
        };
        //thread.start();




        Game game = new Game("TileGame");
        Game.setGame(game); // Initialize Game instance
    }

    public static void registerApplication(Class clazz, Application application) {
        for(Method method : clazz.getDeclaredMethods()) {
            if(method.getAnnotations() == null)
                continue;

            for(Annotation annotation : method.getAnnotations()) {
                if(annotation instanceof Service) {
                    IApplication object = null;
                    try {
                        object =
                                (IApplication) method.invoke(application);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    if(object == null)
                        return;

                    services.add(object);
                }

            }
        }
    }

}
