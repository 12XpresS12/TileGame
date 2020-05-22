package sk.xpress.tilegame.core.threads;

public abstract class GameThread implements Runnable {

    Thread gameThread;
    boolean isRunning = true;

    private static final int MAX_FPS = 250;

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
        System.out.println("Thread: " + Thread.currentThread().getName());

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;

        while(isRunning) {
            long now = System.nanoTime();
            if(frames < MAX_FPS) {
                delta += (now - lastTime) / ns;
                lastTime = now;
                while (delta >= 1) {
                    update();
                    updates++;
                    delta--;
                }
            }

            if(frames < MAX_FPS) {
                render();
                frames++;
            }

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " ups, " + frames + " fps");
                if(frames <= 10)
                    throw new RuntimeException("Frames are under 10 FPS!");

                updates = 0;
                frames = 0;
            }
        }

        stopThread();
        System.out.println("Ending thread");
    }
}
