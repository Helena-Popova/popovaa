import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Lock {
    @GuardedBy("this")
    private boolean isLocked = false;

    /**
     * проверяет свободен ли лок? Если да - захватывает, иначе блокируется.
     */
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        this.isLocked = true;
    }

    /**
     * проверяет владеет ли поток локом? Если да то - освобождает.
     */
    public void unlock() throws InterruptedException {
        while (!isLocked) {
            wait();
        }
        this.isLocked = false;
        notifyAll();
    }
}
