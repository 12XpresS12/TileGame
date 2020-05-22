package sk.xpress.tilegame.core;

import javafx.application.Application;
import javafx.stage.Stage;
import sk.xpress.tilegame.core.threads.Game;

public class Main extends Application {

    private static final String gameThreadName = "Main";

    public static void main(String[] args) {
        Game game = new Game("Test");
        Game.setGame(game); // Initialize Game instance
    }

    public void start(Stage stage) throws Exception {
        Game game = new Game("Test");
        Game.setGame(game); // Initialize Game instance
    }
}
