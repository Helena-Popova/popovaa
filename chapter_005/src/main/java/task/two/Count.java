package task.two;

import lombok.Getter;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class Count {
    @GuardedBy("this")
    @Getter
    private int value;

    public synchronized void increment() {
        this.value++;
    }

}
