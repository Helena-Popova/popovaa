package store;

import array.SimpleArray;
import base.*;

import java.util.NoSuchElementException;

public class RoleStore<T extends Base>  extends AbstractStore<Role> {

    public RoleStore(int size) {
        super(size);
    }

    @Override
    public void add(Role model) {
        super.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return super.replace(id, model);
    }
}