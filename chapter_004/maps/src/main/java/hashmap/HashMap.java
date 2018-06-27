package hashmap;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashMap<K, V> implements Iterable<HashMap.Entry<K, V>>  {

    private int hashCAPACITY = 16;
    private Entry[] container = new Entry[hashCAPACITY];
    private int index  = 0;
    private int modCount = 0;

    /**
     * Simple class for save pair of key-value in the map
     * @param <K>
     * @param <V>
     */
    public static class Entry<K, V> {
        public K key;
        public V value;

        public Entry(K k, V v) {
            key = k;
            value = v;
        }
    }

    /**
     * Associates the specified value with the specified key in this map.
     * and insert pair if key is not exist
     * @param key
     * @param value
     * @return
     */
    public boolean insert(K key, V value) {
        boolean result = container[Math.abs(key.hashCode() % hashCAPACITY)] == null;
        if (result) {
            container[Math.abs(key.hashCode() % hashCAPACITY)] = new Entry(key, value);
            index++;
            modCount++;
        }
        return result;
    }


    /**
     * Returns the value to which the specified key is mapped,
     *or null if this map contains no mapping for the key.
     * @param key
     * @return
     */
    public V get(K key) {
        V result = null;
        Entry<K, V> ref = container[Math.abs(key.hashCode() % hashCAPACITY)];
        if (ref != null && ref.key.equals(key)) {
            result = (V) container[Math.abs(key.hashCode() % hashCAPACITY)].value;
        }
        return result;
    }


    /**
     * Deletes the specified value with the specified key in this map.
     * @param key
     * @return
     */
    public boolean delete(K key) {
        boolean result = false;
        Entry<K, V> ref = container[Math.abs(key.hashCode() % hashCAPACITY)];
        if (ref != null) {
            container[Math.abs(key.hashCode() % hashCAPACITY)] = null;
            result = true;
            index--;
            modCount++;
        }
        return result;
    }

    public void checkHashCAPACITY() {
        if (index >= hashCAPACITY * 0.75) {
            hashCAPACITY *= 2;
            Entry[] second = new Entry[hashCAPACITY];
            Iterator iterator = iterator();
            //перехеширование элементов
            while (iterator.hasNext()) {
                Entry value = (Entry) iterator.next();
                second[Math.abs(value.hashCode() % hashCAPACITY)] = value;
            }
            container = Arrays.copyOf(second, hashCAPACITY);
        }
    }

    /**
     * Returns the number of key-value mappings in this map.
     * @return
     */
    public int getSize() {
        return index;
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {

        Iterator<Entry<K, V>> iterator = new Iterator<Entry<K, V>>() {

            int expectedModCount = modCount;
            int count = 0;

            @Override
            public boolean hasNext() {
                checkConcurrent();

                boolean result = false;
                int i = count;
                while (i < hashCAPACITY) {
                    if (container[i] != null) {
                        result = true;
                        break;
                    }
                    i++;
                }
                count = i;
                return result;
            }

            @Override
            public Entry<K, V> next() {
                if (count >= hashCAPACITY) {
                    throw new NoSuchElementException();
                }
                checkConcurrent();
                return container[count++];
            }

            public void remove() {
                checkConcurrent();
                if (count > hashCAPACITY || count < 0) {
                    throw new IndexOutOfBoundsException();
                }
                container[count] = null;
                count--;
                expectedModCount++;
                modCount++;
            }

            private void checkConcurrent() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
        return iterator;
    }
}