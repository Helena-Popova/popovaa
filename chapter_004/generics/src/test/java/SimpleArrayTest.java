import array.SimpleArray;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    private SimpleArray<Integer> simpleArray;

    @Before
    public void setUp(){
        simpleArray = new SimpleArray(12);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnFalseHasNextBecauseArrayIsEmpty () {
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void returnTrueWhenAddMassiveWithLengthLessArrayLength () {
        assertTrue(simpleArray.add(1, 2, 3, 4, 5, 6, 7));
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void shouldReturnChangedArray (){
        assertTrue(simpleArray.add(1, 1, 1, 1, 1, 1, 1));
        assertTrue(simpleArray.set(2, 3));
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));

    }

    @Test
    public void shouldReturnArrayLessThanOne(){
        assertTrue(simpleArray.add(1, 2, 3, 4, 5, 6, 7));
        assertTrue(simpleArray.delete(2));
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void shouldReturnSameValueInBothMethods (){
        assertTrue(simpleArray.add(1, 2, 3, 4, 5, 6, 7));
        assertTrue(simpleArray.delete(2));
        Iterator<Integer> it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(simpleArray.get(0)));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(simpleArray.get(1)));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(simpleArray.get(2)));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(simpleArray.get(3)));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(simpleArray.get(4)));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(simpleArray.get(5)));
        assertThat(it.hasNext(), is(false));
    }

}