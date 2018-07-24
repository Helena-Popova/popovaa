import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public interface ThreadPool {
    public  void work(Runnable job);

    public void shutdown();
}
