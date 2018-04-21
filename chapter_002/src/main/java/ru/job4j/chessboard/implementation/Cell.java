package ru.job4j.chessboard.implementation;

import ru.job4j.chessboard.exception.ImposibleMoveException;

/**
 * Класс для реализации заполнение и получения информации о коорданитах
 * ячейки шахматной доски.
 *@author Helena
 *@sinse 1.0 20/03/18
 */
public class Cell {
    private int x = 0;
    private int y = 0;

    public Cell() {
        this(0, 0);
    }
    public Cell(int x, int y) {
        if (x < 0 || y < 0 || x > 8 || y > 8) {
            throw new ImposibleMoveException("Выход за границу доски");
        }
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


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            Cell temp = (Cell) obj;
            return (temp.getY() == this.getY() && temp.getX() == this.getX());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return String.format(" X : %d , Y : %d ", this.getX(), this.getY());
    }

}
