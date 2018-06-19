package lists;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinamicList<E> implements Iterable<E> {
    private Object[] container = new Object[10];
    int index  = 0;
    int modCount = 0;

    public boolean add(E value) {
        if (container.length != 0 && container.length % 10 == 0) {
            container = Arrays.copyOf(container, container.length + 10);
        }
        container[index++] = value;
        modCount++;
        return true;
    }

    public E get(int index) {
        return (E) container[index];
    }

    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {

            int expectedModCount = modCount;
            private int count = 0;


            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean result = false;
                int i = count;
                if (count < container.length) {
                    while (i < container.length) {
                        if (container[count] != null) {
                            result = true;
                            break;
                        }
                        i++;
                    }
                }
                return result;
            }

            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (count >= container.length) {
                    throw new NoSuchElementException();
                }
                return (E) container[count++];
            }

            public void remove() {
                if (count > container.length || count < 0) {
                    throw new IndexOutOfBoundsException();
                }
                container[count] = null;
                count--;
                expectedModCount++;
                modCount++;
                index--;
            }
        };
        return iterator;
    }
}
