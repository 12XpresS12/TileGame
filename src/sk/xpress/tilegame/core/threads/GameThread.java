package sk.xpress.tilegame.core.threads;

import java.util.concurrent.TimeUnit;

public abstract class GameThread implements Runnable {

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
        initialize();


        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
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


        System.out.println("THREAD: " + Thread.currentThread().getName());
/*
        int x = 0;
        while(isRunning) {
            try {
                System.out.println("Operation: " + x);
                x++;

                update();
                render();

                if(x > 600000) {
                    stopThread();
                    isRunning = false;
                }
                TimeUnit.MILLISECONDS.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        System.out.println("Ending thread");
    }
}
