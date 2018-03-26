package ru.job4j.strategypattern;

/**
 * Class Square.
 * @author HelenaPopova
 * @since 1.0
 */
public class Square implements Shape {
    /**
     * Метод составляет квадрат.
     * @return Square
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append(" +++++\n");
        pic.append("+     +\n");
        pic.append("+     +\n");
        pic.append(" +++++\n");
        return pic.toString();
    }

}
