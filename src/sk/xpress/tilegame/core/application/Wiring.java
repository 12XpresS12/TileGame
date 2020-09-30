package sk.xpress.tilegame.core.application;


import org.reflections.scanners.Scanner;
import sk.xpress.tilegame.core.Main;
import sk.xpress.tilegame.core.application.services.TestService;
import sk.xpress.tilegame.core.logger.Log;

import org.reflections.Reflections;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;



public class Wiring {

    public Wiring() {
    }

    public Wiring(String test) {
        try {
            scanningPackages();
        } catch (NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public void scanningPackages() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Reflections reflection = new Reflections("sk.xpress.tilegame");
        for(Class clazz : reflection.getTypesAnnotatedWith(Component.class)) {
            //Log.info("clazz: " + clazz.getName(), " FIELDS: " + clazz.getFields().length);
            if(clazz.getDeclaredFields().length > 0) {
                Field fields = clazz.getDeclaredField("test");
                if (fields == null)
                    continue;
                else {
                    Object obj = Main.testAutowired;
                    fields.setAccessible(true);
                    fields.set(obj, new TestService());
                    ((TestService) fields.get(obj)).scanner();

                }
            }
            for(Field field : clazz.getDeclaredFields()) {
                Log.info("FIELD: " + field.getGenericType());
                for(Annotation annotation : field.getAnnotations()) {
                    if(!(annotation instanceof Autowired))
                        return;
                    Log.info("X: " + field.getName() + ", " + field.getType());
                    //field.set();
                }
            }
        }
    }

}
