package store;

import array.SimpleArray;
import base.*;

import java.util.NoSuchElementException;

public class RoleStore<T extends Base>  extends AbstractStore<T> {

    public RoleStore(int size) {
        super(size);
    }

    @Override
    public void add(T model) {
        if (!(model instanceof Role)) {
            throw new ClassCastException();
        }
        super.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (!(model instanceof Role)) {
            throw new ClassCastException();
        }
        return super.replace(id, model);
    }
}