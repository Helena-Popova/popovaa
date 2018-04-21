package ru.job4j.chessboard.implementation;
import ru.job4j.chessboard.exception.ImposibleMoveException;
import ru.job4j.chessboard.exception.*;

/**
 * Класс описывающий фигуру  - Король.
 * король может двигаться в любую сторону от изначальной клетки на 1 клетку.
 */
public class King extends Figure {

    public King(Cell cell) {
        super(cell);
    }
    public  Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        if (Math.abs(dest.getY() - source.getY()) <= 1 && Math.abs(dest.getX() - source.getX()) <= 1) {
            return new Cell[]{dest};
        } else {
            throw  new ImposibleMoveException("Фигура не может двигаться по такому пути.");
        }
    }

    public  Figure copyC(Cell dest) {
        return new King(dest);
    }
}
