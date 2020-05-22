package sk.xpress.tilegame.core;

import sk.xpress.tilegame.core.threads.Game;

public class Main {
    private static final String gameThreadName = "Main";

    public static void main(String[] args) {
        Game game = new Game("Test");
        Game.setGame(game); // Initialize Game instance
    }
}
