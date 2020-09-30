package sk.xpress.tilegame.core.logger;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;

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
        String time = new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis());
        for(String text: texts) {
            System.out.println(time + " >> " + logType.getPrefix() + text);
        }
    }

}
