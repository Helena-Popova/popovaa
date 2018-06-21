package lists;

import java.util.Iterator;

public class DefineCircle {
    public boolean hasCycle(DinamicLinkedList.Node first) {
        boolean result = false;
        DinamicLinkedList.Node storeV = first;
        DinamicLinkedList.Node circleV = first;
        LabelRound: while (storeV != null) {
            while (circleV.next != storeV.next) {
                if (storeV.next == circleV) {
                    result = true;
                    break LabelRound;
                }
                circleV = circleV.next;
            }
            storeV = storeV.next;
            circleV = first;
        }
        return result;
    }
}
