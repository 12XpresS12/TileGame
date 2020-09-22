package sk.xpress.tilegame.core.logger;

public enum LogType {
    ERROR("[ERROR] "),
    INFO("[INFO] "),
    WARN("[WARN] ");

    private String prefix;

    LogType(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
