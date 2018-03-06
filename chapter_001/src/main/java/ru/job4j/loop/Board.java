package ru.job4j.loop;

/**
 * It is class for paint some board
 * @author HelenaPopova
 * @version 1.0
 * @since 06.03.18
 */
public class Board {
    /**
     * Method for paint strings
     * @param width
     * @param height
     * @return
     */
    public String paint(int width, int height){
        StringBuilder screen = new StringBuilder();
        String lineNew = System.lineSeparator();
        for(int i = 0; i< height; i++){
            for(int a = 0; a< width; a++){
                if (((i+a)%2) == 0 ){
                    screen.append("x");
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
