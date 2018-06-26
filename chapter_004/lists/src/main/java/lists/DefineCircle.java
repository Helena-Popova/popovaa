package lists;

import java.util.Iterator;

public class DefineCircle {
    public boolean hasCycle(DinamicLinkedList.Node first) {
        boolean result = false;
        if (first != null) {
            DinamicLinkedList.Node step = first;
            DinamicLinkedList.Node stepNext = first;
            while (step != null && stepNext != null && stepNext.next != null) {
                step = step.next;
                stepNext = stepNext.next.next;
                if (step == stepNext) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
