package sk.xpress.tilegame.core.threads;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Game extends Threaded {

    private String gameTitle;
    private JFrame jFrame;

    private int width = 1280;
    private int height = 720;

    boolean isRunning = true;

    public synchronized void createThread(String threadName) {
        super.createThread(threadName, this);
    }

    public Game(String title) {
        this.gameTitle = title;

        jFrame = new JFrame(title);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setSize(width, height);
    }


    @Override
    public void startThread() {
        System.out.println("INIT THREAD");
        this.run();
    }

    @Override
    public void stopThread() {

    }

    @Override
    public void run() {
        int x = 0;
        while(isRunning) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Operation: " + x);
                x++;

                if(x > 60) {
                    stopThread();
                    isRunning = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ending thread");
    }
}
