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
        System.out.println("THREAD: " + Thread.currentThread().getName());

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
        }
        System.out.println("Ending thread");
    }
}
