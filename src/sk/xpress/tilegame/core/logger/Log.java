package sk.xpress.tilegame.core.logger;

import org.jetbrains.annotations.NotNull;

public class Log {

    public static void info(@NotNull String...texts) {
        text(LogType.INFO, texts);
    }

    public static void error(@NotNull String...texts) {
        text(LogType.ERROR, texts);
    }

    public static void warn(@NotNull String...texts) {
        text(LogType.WARN, texts);
    }

    public static void text(LogType logType, @NotNull String...texts) {
        for(String text: texts) {
            System.out.println(logType.getPrefix() + text);
        }
    }

}
