import lombok.Getter;
import lombok.Setter;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

@Getter
@Setter
@ThreadSafe
public class Pool implements ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    @GuardedBy("this")
    private final Queue<Runnable> tasks = new LinkedBlockingQueue<>();
    private volatile boolean isRunning = true;

    public Pool() {
        super();
        int sizePool = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < sizePool; i++) {
            this.threads.add(new Thread(new TaskWorker()));
            this.threads.get(i).start();
        }
    }


    @Override
    public void work(Runnable job) {
        synchronized (tasks) {
            if (isRunning) {
                tasks.offer(job);
                tasks.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        isRunning = false;
        for (Thread thread : this.threads) {
            thread.interrupt();
        }
    }

    private final class TaskWorker implements Runnable {

        @Override
        public void run() {
            while (isRunning) {
                synchronized (tasks) {
                    while (tasks.isEmpty()) {
                        try {
                            tasks.wait();
                        } catch (InterruptedException ie) {
                            ie.printStackTrace();
                        }
                    }
                    Runnable nextTask = tasks.poll();
                    if (nextTask != null) {
                        nextTask.run();
                    }
                }
            }
        }
    }


}
