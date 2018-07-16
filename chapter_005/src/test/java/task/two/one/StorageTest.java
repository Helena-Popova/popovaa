package task.two.one;

import lombok.Getter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StorageTest {

    private Storage storage = new Storage();
    DoSomething threadAdd;

    /**
     * делаем поток, потоп переопределяя метод run с той функцией,что нужна
     */
    public static class DoSomething extends Thread {
        @Getter
        private List<User> usersThread;
        public DoSomething() { }

        public DoSomething(User ... insertUsers) {
            usersThread = Arrays.stream(insertUsers).collect(Collectors.toList());
        }
    }

    @Before
    public void loadBefore() throws InterruptedException {
        threadAdd = new DoSomething(
                new User(1, 3000),
                new User(2, 55000),
                new User(3, 900),
                new User(4, 8000)) {

            @Override
            public void run() {
                storage.add(this.getUsersThread().get(0));
                storage.add(this.getUsersThread().get(1));
                storage.add(this.getUsersThread().get(2));
                storage.add(this.getUsersThread().get(3));
            }
        };
        threadAdd.start();
        threadAdd.join();
    }
    @Test
    public void add() throws InterruptedException {
        DoSomething threadAdd = new DoSomething(new User(5, 200), new User(6, 100)) {
            @Override
            public void run() {
                storage.add(this.getUsersThread().get(0));
                storage.add(this.getUsersThread().get(1));
            }
        };
        threadAdd.start();
        threadAdd.join();
        assertTrue(storage.getUsers().containsKey(1));
        assertTrue(storage.getUsers().containsKey(2));
        assertTrue(storage.getUsers().containsKey(3));
        assertTrue(storage.getUsers().containsKey(4));
        assertTrue(storage.getUsers().containsKey(5));
        assertTrue(storage.getUsers().containsKey(6));
        assertThat(storage.getUsers().get(5), is(new User(5, 200)));
        assertThat(storage.getUsers().get(6), is(new User(6, 100)));

    }

    @Test
    public void update() throws InterruptedException {
        DoSomething threadUp = new DoSomething(new User(4, 1000)) {
            @Override
            public void run() {
                storage.update(this.getUsersThread().get(0));
            }
        };
        threadUp.start();
        threadUp.join();
        assertTrue(storage.getUsers().containsKey(4));
        assertThat(storage.getUsers().get(4), is(new User(4, 1000)));
    }

    @Test
    public void delete() throws InterruptedException {
        DoSomething delete = new DoSomething() {
            @Override
            public void run() {
                storage.delete(new User(4, 8000));
                storage.delete(new User(3, 900));
                storage.delete(new User(2, 55000));
                storage.delete(new User(1, 3000));
            }
        };
        delete.start();
        delete.join();
        assertFalse(storage.getUsers().containsKey(4));
        assertFalse(storage.getUsers().containsKey(3));
        assertFalse(storage.getUsers().containsKey(2));
        assertFalse(storage.getUsers().containsKey(1));
        assertTrue(storage.getUsers().isEmpty());
    }

    @Test
    public void transfer() throws InterruptedException {
        DoSomething transfer = new DoSomething() {
            @Override
            public void run() {
                assertTrue(storage.transfer(4, 1, 4000));
                assertThat(storage.getUsers().get(4), is(new User(4, 4000)));
                assertTrue(storage.transfer(4, 2, 4000));
                assertFalse(storage.transfer(4, 3, 100));
            }
        };
        transfer.start();
        transfer.join();
        assertThat(storage.getUsers().get(1), is(new User(1, 7000)));
        assertThat(storage.getUsers().get(2), is(new User(2, 59000)));
        assertThat(storage.getUsers().get(4), is(new User(4, 0)));

    }

}