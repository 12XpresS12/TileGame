package sk.xpress.tilegame.core;

import sk.xpress.tilegame.core.threads.Game;
import sk.xpress.tilegame.core.tiles.TileMap;

public class Main {

    private static final String gameThreadName = "Main";

    private static Main main;

    public static void main(String[] args) throws InterruptedException {
        main = new Main();

        Game game = new Game("Test");
        game.createThread(gameThreadName);
    }

    public static Main getMain() { return main; }
}
