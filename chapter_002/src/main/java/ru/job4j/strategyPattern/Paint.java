package ru.job4j.strategypattern;

/**
 * Class Paint
 * @author HelenaPopova
 * @since 1.0
 */
public class Paint {
    private Shape form;

    /**
     * в констуркторе сделала ввод нужной формы. потому что так удобнее,
     * мне кажется.
     * @param form
     */
    public Paint(Shape form) {
        this.form = form;
    }

    /**
     * Рисует фигуру
     */
    public void draw() {
        System.out.println(this.form.draw());
    }

    /**
     * Рисует квадрат и треугольничек
     * @param args
     */
    public static void main(String[] args) {

        Paint figure = new Paint(new Square());
        figure.draw();

        figure = new Paint(new Triangle());
        figure.draw();
    }
}