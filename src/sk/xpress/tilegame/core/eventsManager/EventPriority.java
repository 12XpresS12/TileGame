package sk.xpress.tilegame.core.eventsManager;

public enum EventPriority {

    LOWEST(-2),
    LOW(-1),
    NORMAL(0),
    HIGH(1),
    HIGHER(2);

    private int priority;

    EventPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
