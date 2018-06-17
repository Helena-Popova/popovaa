package array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private T[] objects;
    private int count = 0;

    public SimpleArray(int size) {
        objects = (T[]) new Object[size];
    }

    public boolean add(T... model) {
        if (model.length > objects.length - count) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        while (i < model.length) {
            objects[count++] = model[i];
            i++;
        }
        return true;
    }

    public boolean add(T model) {
        if (count > objects.length) {
            throw new IndexOutOfBoundsException();
        }
        objects[count++] = model;
        return true;
    }

    public boolean set(int index, T model) {
        if (index > objects.length) {
            throw new IndexOutOfBoundsException();
        }
        objects[index] = model;
        return true;
    }

    public boolean delete(int index) {
        int step = index;
        if (index > objects.length) {
            throw new IndexOutOfBoundsException();
        }
        while (step < count - 1) {
            objects[step] = objects[step + 1];
            step++;
        }
        objects[step - 1] = null;
        count--;
        return true;

    }

    public T get(int index) {
        if (index > objects.length) {
            throw new NullPointerException();
        }
        return objects[index];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;

                while (index < objects.length) {
                    if (objects[index] != null) {
                        result = true;
                        break;
                    } else if (index < objects.length - 1) {
                        index++;
                    }
                }
                return result;
            }

            @Override
            public T next() {
                if (index >= objects.length || count == 0) {
                    throw new NoSuchElementException();
                }
                return objects[index++];
            }
        };
        return iterator;
    }
}