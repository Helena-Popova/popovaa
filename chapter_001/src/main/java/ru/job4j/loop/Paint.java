package ru.job4j.loop;

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
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
    /**
     * method for drawing pyramids
     * @param height
     * @return pyramid
     */
    public String simplePiramid(int height){
        StringBuilder screen = new StringBuilder();
        String lineNew = System.lineSeparator();

        int width = height>0 ? (2*height -1) : 0;

        for(int row = 0; row< height; row++){
            for(int column = 0; column< width; column++){
                if ( column >= (width/2 - row) && column <= (width/2 + row)) {
                    screen.append("^");
                }
                else{
                    screen.append(" ");
                }
            }
            screen.append(lineNew);
        }
        return screen.toString();

    }
}
