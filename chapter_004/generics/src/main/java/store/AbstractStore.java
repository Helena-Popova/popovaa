package store;
import array.SimpleArray;
import base.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractStore<T extends Base> implements Store<T>  {

    private SimpleArray<T> dataArray;

    public AbstractStore(int size) {
        dataArray = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        dataArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = findIndexInStore(id);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        dataArray.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int index = findIndexInStore(id);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        dataArray.delete(index);
        return true;
    }

    @Override
    public T findById(String id) {
        int index = findIndexInStore(id);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        return dataArray.get(index);
    }

    private int findIndexInStore(String id) {
        int result = -1;
        Iterator<T> iterator = dataArray.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                result = index;
                break;
            }
            index++;
        }
        return result;
    }
}