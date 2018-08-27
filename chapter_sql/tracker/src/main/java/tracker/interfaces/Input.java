package tracker.interfaces;

import java.util.ArrayList;

public interface Input {
    String ask(String question);

    int ask(String quesion, ArrayList<Integer> range);
}