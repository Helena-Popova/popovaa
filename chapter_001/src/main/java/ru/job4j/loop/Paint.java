package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * Class for drawing pyramids
 * @author Helena
 * @version 1.0
 * @since 09.03.18
 */

public class Paint {

    /**
     * method for drawing pyramids
     * @param height
     * @return pyramid
     */

    public String pyramid(int height) {
        return this.loopBy(height, 2 * height - 1, (row, column)-> row >= height - column - 1 && row + height - 1 >= column);
    }
    /**
     * method for drawing pyramids
     * @param height
     * @return pyramid
     */
    public String simplePiramid(int height) {
        int width = height > 0 ? (2 * height - 1) : 0;
        return this.loopBy(height, width, (row, column)-> column >= (width / 2 - row) && column <= (width / 2 + row));
    }

    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        String lineNew = System.lineSeparator();
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                    }
                }
                screen.append(lineNew);
            }
            return screen.toString();
    }
}
