package ru.job4j.chessboard.implementation;
/**
 * Класс для реализации заполнение и получения информации о коорданитах
 * ячейки шахматной доски.
 *@author Helena
 *@sinse 1.0 20/03/18
 */
public class Cell {
    private int x;
    private int y;

    public Cell() {
        this.x = 0;
        this.y = 0;
    }
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
