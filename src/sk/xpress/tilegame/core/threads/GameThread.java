package sk.xpress.tilegame.core.threads;

import java.util.concurrent.TimeUnit;

public abstract class GameThread extends Threaded {

    boolean isRunning = true;

    public synchronized void createThread(String threadName) {
        super.createThread(threadName, this);
    }


    @Override
    public void startThread() {
        System.out.println("INIT THREAD");
        this.run();
    }

    @Override
    public void stopThread() {

    }

    public abstract void initialize();

    public abstract void update();
    public abstract void render();

    @Override
    public void run() {
        initialize();

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
