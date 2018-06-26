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
    private int hashCAPACITY = 12;
    private int countInsert = 0;

    Object[] objects = new Object[hashCAPACITY];

    /**
     * Чтобы найти место объекта в таблице, вычисляется
     * его хеш-код и уменьшается его модуль до общего количества групп.
     * @param e
     * @return
     */
    public boolean add(E e) {
        checkCapacity();
        objects[Math.abs(e.hashCode() % hashCAPACITY)] = e;
        countInsert++;
        return true;
    }

    /**
     * быстрый доступ благодаря прямому обращению к ячейке
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return objects[Math.abs(e.hashCode() % hashCAPACITY)] != null && objects[Math.abs(e.hashCode() % hashCAPACITY)].equals(e);
    }

    /**
     * @param e
     * @return
     */
    public boolean remove(E e) {
        boolean result = false;
        if (contains(e)) {
            objects[Math.abs(e.hashCode() % hashCAPACITY)] = null;
            result = true;
        }
        return result;
    }

    /**
     * Предусматриваем возможность роста хэш-таблицы при нехватке места для нового элемента.
     */
    private void checkCapacity() {
        if (countInsert >= hashCAPACITY * 0.75) {
            hashCAPACITY *= 2;
            Object[] second = new Object[hashCAPACITY];
            Iterator iterator = iterator();
            //перехеширование элементов
            while (iterator.hasNext()) {
                E value = (E) iterator.next();
                second[Math.abs(value.hashCode() % hashCAPACITY)] = value;
            }
            objects = Arrays.copyOf(second, hashCAPACITY);
        }
    }


    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {

            int expectedModCount = modCount;
            private int count = 0;

            public boolean hasNext() {
                checkConcurrent();
                boolean result = false;
                int i = count;
                while (i < hashCAPACITY) {
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
                if (count > hashCAPACITY || count < 0) {
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
