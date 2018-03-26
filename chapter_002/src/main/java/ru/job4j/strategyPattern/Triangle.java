package ru.job4j.strategypattern;

/**
 * Class Triangle
 * @author HelenaPopova
 * @since 1.0
 */
public class Triangle implements Shape {
    /**
     *  Метод составляет треугольник.
     * @return Triangle
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   \n");
        pic.append("  +++  \n");
        pic.append(" +++++ \n");
        pic.append("+++++++\n");
        return pic.toString();
    }
}