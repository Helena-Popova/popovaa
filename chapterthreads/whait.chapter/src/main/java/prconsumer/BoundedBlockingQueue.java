package prconsumer;

import lombok.Getter;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * Для этого вам необходимо реализовать собственную версию bounded blocking queue.
 * Это блокирующая очередь, ограниченная по размеру.
 * В данном шаблоне Producer помещает данные в очередь,
 * а Consumer извлекает данные из очереди.
 * Если очередь заполнена полностью,
 * то при попытке добавления поток Producer блокируется,
 * до тех пор пока Consumer не извлечет очередные данные,
 * т.е. в очереди появится свободное место.
 * И наоборот если очередь пуста поток Consumer блокируется,
 * до тех пор пока Producer не поместит в очередь данные.
 * В задании нельзя использовать потокобезопасные коллекции реализованные в JDK.
 * Ваша задача используя, wait/notify реализовать блокирующую очередь.
 * @author Helen
 * @param <T>
 */
@ThreadSafe
public class BoundedBlockingQueue<T> {

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    @GuardedBy("this")
    @Getter
    private int size;

    public BoundedBlockingQueue(int sizeUser) {
        this.size = sizeUser;
    }

    public void offer(T value) throws InterruptedException {
        synchronized (queue) {
            while (this.queue.size() == this.size) {
                this.queue.wait();
            }

            this.queue.offer(value);
            this.queue.notify();
        }
    }

    public void offer(T value, long timeout) throws InterruptedException {
        synchronized (queue) {
            if (this.queue.size() == this.size) {
                this.queue.wait(timeout);
            }
            this.queue.offer(value);
            this.queue.notify();
        }
    }

    public T poll() throws InterruptedException {
        T result;
        synchronized (queue) {
            while (this.queue.size() == 0) {
                this.queue.wait();
            }
            result = queue.poll();
            this.queue.notify();
        }
        return result;
    }

    public int getRealSize() {
        return this.queue.size();
    }
}
