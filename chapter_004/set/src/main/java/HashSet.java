import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Helena
 * Напишите свою реализацию Set на базе хэш-таблицы. Реализуйте следующие методы:
 * 1) boolean add (E e)
 * 2) boolean contains (E e)
 * 3) boolean remove (E e)
 * Ваша хэш-таблица должна базироваться на массиве. Не используйте стандартные коллекции JDK.
 * Разрешение коллизий реализовывать не надо. Предусмотрите возможность роста хэш-таблицы при нехватке места для нового элемента.
 */
public class HashSet<E> implements Iterable<E> {

    private int modCount = 0;
    private int capacity = 12;
    private int countInsert = 0;

    private Object[] objects = new Object[capacity];

    /**
     * Чтобы найти место объекта в таблице, вычисляется
     * его хеш-код и уменьшается его модуль до общего количества групп.
     * @param e
     * @return
     */
    public boolean add(E e) {
        checkCapacity();
        this.objects[Math.abs(e.hashCode() % capacity)] = e;
        this.countInsert++;
        return true;
    }

    /**
     * быстрый доступ благодаря прямому обращению к ячейке
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return this.objects[Math.abs(e.hashCode() % this.capacity)] != null && this.objects[Math.abs(e.hashCode() % this.capacity)].equals(e);
    }

    /**
     * @param e
     * @return
     */
    public boolean remove(E e) {
        boolean result = false;
        if (contains(e)) {
            this.objects[Math.abs(e.hashCode() % this.capacity)] = null;
            result = true;
        }
        return result;
    }

    /**
     * Предусматриваем возможность роста хэш-таблицы при нехватке места для нового элемента.
     */
    private void checkCapacity() {
        if (this.countInsert >= this.capacity * 0.75) {
            this.capacity *= 2;
            Object[] second = new Object[capacity];
            Iterator iterator = iterator();
            //перехеширование элементов
            while (iterator.hasNext()) {
                E value = (E) iterator.next();
                second[Math.abs(value.hashCode() % this.capacity)] = value;
            }
            this.objects = Arrays.copyOf(second, this.capacity);
        }
    }


    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {

            private int expectedModCount = modCount;
            private int count = 0;

            public boolean hasNext() {
                checkConcurrent();
                boolean result = false;
                int i = this.count;
                while (i < capacity) {
                    if (objects[i] != null) {
                        result = true;
                        break;
                    }
                    i++;
                }
                count = i;
                return result;
            }

            public E next() {
                checkConcurrent();
                if (count >= objects.length) {
                    throw new NoSuchElementException();
                }
                return (E) objects[count++];
            }

            public void remove() {
                checkConcurrent();
                if (count > capacity || count < 0) {
                    throw new IndexOutOfBoundsException();
                }
                objects[count] = null;
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
