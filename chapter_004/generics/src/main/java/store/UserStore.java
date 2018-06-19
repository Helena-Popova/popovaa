package store;

import array.SimpleArray;
import base.*;

import java.util.NoSuchElementException;

public class UserStore<T extends Base> extends AbstractStore<User> {

    public UserStore(int size) {
        super(size);
    }

    @Override
    public void add(User model) {
        super.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return super.replace(id, model);
    }

}
