package sk.xpress.tilegame.core;

import sk.xpress.tilegame.core.threads.Game;

public class Main {

    private static final String running = "Main-Thread";

    private static Main main;

    public static void main(String[] args) throws InterruptedException {
        main = new Main();

        Game game = new Game("Test");
        game.createThread(running);
    }

    public static Main getMain() { return main; }
}
