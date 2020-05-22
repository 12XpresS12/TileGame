package sk.xpress.tilegame.core.threads;

import java.util.HashMap;
import java.util.Map;

public abstract class Threaded implements Runnable {

    private String threadName;
    public static Map<String, ThreadClass> threadMap = new HashMap<>();

    public abstract void startThread();

    public abstract void stopThread();

    protected synchronized void createThread(String threadName, Threaded threaded) {
        this.threadName = threadName;

        Thread thread = new Thread();
        //threadMap.putIfAbsent(threaded, thread);
        threadMap.putIfAbsent(threadName, new ThreadClass(threaded,thread));

        thread.start();
        this.startThread();

    }


    class ThreadClass {
        private Threaded threaded;
        private Thread thread;

        public ThreadClass(Threaded threaded, Thread thread) {
            this.thread = thread;
            this.threaded = threaded;
        }

        public Threaded getThreaded() {
            return threaded;
        }

        public Thread getThread() {
            return thread;
        }
    }

    public String getThreadName() {
        return threadName;
    }
}
