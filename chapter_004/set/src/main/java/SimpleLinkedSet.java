import baseclasses.SimpleLinkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Helena
 * Реализовать коллекцию SimpleSet.
 * Коллекция должна обеспечивать void add(E e) и реализовывать Iterable<E>.
 * Коллекция не должна хранить дубликаты.
 * Set - внутри для хранения данных использует связный список.
 * Вы должны сделать свою реализацию связанного списка. Не используйте стандартные коллекции JDK.
 */
public class SimpleLinkedSet<E> extends SimpleLinkedList<E> {

    private boolean isRepeatInMySet(E value) {
        boolean result = false;
        for (int i = 0; i < super.getSize(); i++) {
            if (this.get(i).equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public void add(E value) {
        if (!isRepeatInMySet(value)) {
            super.add(value);
        }
    }
}