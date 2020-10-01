package sk.xpress.tilegame.core.eventsManager;

import sk.xpress.tilegame.core.eventsManager.listeners.CameraListener;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ListenerHandler {

    private List<EventHandler> events = new ArrayList<>();

    public void registerMethod(){
        events.add(new EventHandler(new CameraListener(), new ArrayList<Method>()));
    }

    class EventHandler<event> {

        private event event;
        private List<Method> methodList;

        public EventHandler(event event, List<Method> methodList) {
            this.event = event;
            this.methodList = methodList;
        }

        public event getEvent() {
            return event;
        }

        public void setEvent(event event) {
            this.event = event;
        }

        public List<Method> getMethodList() {
            return methodList;
        }

        public void setMethodList(List<Method> methodList) {
            this.methodList = methodList;
        }
    }
}

