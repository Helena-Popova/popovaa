package lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefineCircleTest {

    DefineCircle defineCircle = new DefineCircle();
    DinamicLinkedList.Node first = new DinamicLinkedList.Node(1);
    DinamicLinkedList.Node two = new DinamicLinkedList.Node(2);
    DinamicLinkedList.Node third = new DinamicLinkedList.Node(3);
    DinamicLinkedList.Node four = new DinamicLinkedList.Node(4);
    @Before
    public void loadSomeCircleAndNonCircleList() {

        first.next = two;
        two.next = third;
        third.next = four;
    }
    @Test
    public void hasCycleReturnYes() {
        four.next = first;
        assertTrue(defineCircle.hasCycle(first));
    }
    @Test
    public void hasCycleReturnNo() {
        four.next = null;
        assertFalse(defineCircle.hasCycle(first));
    }
}