package lists;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@ThreadSafe
public class DinamicList<E> implements Iterable<E> {

    private int capacity = 10;
    @GuardedBy("monitor")
    private Object[] container = new Object[capacity];
    @GuardedBy("monitor")
    int index = 0;
    @GuardedBy("monitor")
    int modCount = 0;


    public synchronized boolean add(E value) {
        if (index >= capacity) {
            capacity = (capacity * 3) / 2 + 1;
            container = Arrays.copyOf(container, capacity);
        }
        container[index++] = value;
        modCount++;
        return true;
    }

    public synchronized E get(int sIndex) {
        return (E) container[sIndex];
    }

    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {

            private int expectedModCount = modCount;
            private int count = 0;


            public synchronized boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < capacity;
            }

            public synchronized E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                synchronized (container) {
                    if (count >= container.length) {
                        throw new NoSuchElementException();
                    }
                }
                return (E) container[count++];
            }

            public void remove() {
                synchronized (container) {
                    if (count > container.length || count < 0) {
                        throw new IndexOutOfBoundsException();
                    }
                    if (expectedModCount != modCount) {
                        throw new ConcurrentModificationException();
                    }
                    container[count] = null;
                    count--;
                    expectedModCount++;
                    modCount++;
                    index--;
                }
            }
        };
        return iterator;
    }

}
