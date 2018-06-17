package store;

import array.SimpleArray;
import base.*;

import java.util.NoSuchElementException;

public class UserStore<T extends Base> extends AbstractStore<T> {

    public UserStore(int size) {
        super(size);
    }

    @Override
    public void add(T model) {
        if (!(model instanceof User)) {
            throw new ClassCastException();
        }
        super.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (!(model instanceof User)) {
            throw new ClassCastException();
        }
        return super.replace(id, model);
    }

}
