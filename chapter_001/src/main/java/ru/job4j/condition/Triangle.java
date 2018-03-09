package ru.job4j.condition;

/**
 *Class for calculate area of a trinagle.
 *@author Popova A
 *@version 1.0
 *@since 1.0
 */
public class Triangle {

    /**
     *Private objects
     */
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /**
     * Half period
     *
     * @param ab distanse between a and b
     * @param ac distanse between a and c
     * @param bc distanse between b and c
     * @return Перимент.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc)/2;
    }


    /**
     * Calculate area of trinagle.
     *
     * @return area or -1
     */
    public double area() {
        double rsl = -1;
        double ab = this.a.distanseTo(this.b);
        double ac = this.a.distanseTo(this.c);
        double bc = this.b.distanseTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            rsl = Math.sqrt(p*(p-ab)*(p-ac)*(p-bc));
        }
        return rsl;
    }

    /**
     * Method check -  May triangle exist or not.
     *
     * @param ab distanse between a and b
     * @param ac distanse between a and c
     * @param bc distanse between b and c
     * @return Triangle may exist or not
     */
    private boolean exist(double ab, double ac, double bc) {
        return ((ab+ac > bc) && (ac+ bc > ab) && (bc+ab > ac));
    }
}
