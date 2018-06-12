
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorOfIterators implements Iterator {

    Iterator<Integer> integerIterator;

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        Iterator<Integer> result = new Iterator<Integer>() {

            Iterator<Iterator<Integer>> main = it;
            Iterator<Integer> step = main.next();

            @Override
            public boolean hasNext() {
                if (!step.hasNext() && main.hasNext()) {
                    step = main.next();
                }
                return step.hasNext();
            }

            @Override
            public Integer next() {
                Integer value;
                if (step.hasNext()) {
                    value = step.next();
                } else if (main.hasNext()) {
                    step = main.next();
                    value = step.next();
                } else {
                    throw new NoSuchElementException();
                }
                return value;
            }

        };
        integerIterator = result;
        return result;
    }

    @Override
    public boolean hasNext() {
        return integerIterator.hasNext();
    }

    @Override
    public Object next() {
        return integerIterator.next();
    }
}
