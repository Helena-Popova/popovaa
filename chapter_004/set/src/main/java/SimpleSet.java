import baseclasses.SimpleList;

import java.util.Iterator;

public class SimpleSet<E> extends SimpleList<E> {


    private boolean isRepeatInMySet(E value) {
        boolean result = false;
        Iterator<E> iterator = super.iterator();
        while (iterator.hasNext()) {
            E step = iterator.next();
            if (step != null && ((E) step).equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean add(E value) {
        boolean result = false;
        if (!isRepeatInMySet(value)) {
            result = super.add(value);
        }
        return result;
    }
}
