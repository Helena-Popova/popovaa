package lists;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinamicList<E> implements Iterable<E> {
    private int capacity = 10;
    private Object[] container = new Object[capacity];
    int index  = 0;
    int modCount = 0;

    public boolean add(E value) {
        if (index >= capacity) {
            capacity = (capacity * 3) / 2 + 1;
            container = Arrays.copyOf(container, capacity);
        }
        container[index++] = value;
        modCount++;
        return true;
    }

    public E get(int sIndex) {
        return (E) container[sIndex];
    }

    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {

            int expectedModCount = modCount;
            private int count = 0;


            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < capacity;
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
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
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
