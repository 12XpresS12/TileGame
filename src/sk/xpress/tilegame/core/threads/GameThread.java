package sk.xpress.tilegame.core.threads;

import java.awt.*;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public abstract class GameThread implements Runnable {

    private static final double UPDATE_PER_SECOND = 60d;

    Thread gameThread;
    boolean isRunning = true;

    public GameThread() {
        System.out.println("Initializing Thread");
        gameThread = new Thread(this, "GameThread");
    }

    protected void preparedToStart() {
        gameThread.start();
    }

    protected abstract void initialize();

    protected abstract void update();
    protected abstract void render();

    protected abstract void stopThread();

    @Override
    public void run() {
        System.out.println("THREAD: " + Thread.currentThread().getName());

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / UPDATE_PER_SECOND;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        while(isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                update();
                updates++;
                delta--;
            }

            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " ups, " + frames + " fps");
                updates = 0;
                frames = 0;
            }
        }

        stopThread();
        System.out.println("Ending thread");
    }
}
