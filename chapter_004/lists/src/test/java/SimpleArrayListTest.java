import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayListTest {
    SimpleArrayList<Integer> simpleArrayList = new SimpleArrayList();

    @Before
    public void setUp() {
        simpleArrayList.add(1);
        simpleArrayList.add(2);
        simpleArrayList.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(simpleArrayList.get(1), is(2));
    }

    @Test
    public void whenDeleteElementsThanGetNewFirstElement() {
        simpleArrayList.delete();
        assertThat(Integer.valueOf(2), is(simpleArrayList.get(0)));
        assertThat(simpleArrayList.getSize(), is(2));
    }
}