package sk.xpress.tilegame.core.listeners;

import sk.xpress.tilegame.core.threads.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener {

    private static KeyListener keyListener;

    public KeyboardListener() {
        System.out.println("LISTNER");

        keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyChar()) {
                    case 'w': {
                        System.out.println("DOPREDU");
                        break;
                    }
                    case 'a': {
                        System.out.println("DOLAVA");
                        break;
                    }
                    case 's': {
                        System.out.println("DOZADU");
                        break;
                    }
                    case 'd': {
                        System.out.println("DOPRAVA");
                        break;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        };
    }

    public static KeyListener getKeyListener() {
        return keyListener;
    }
}
