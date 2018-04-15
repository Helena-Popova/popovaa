package ru.job4j.chessboard.implementation;

import ru.job4j.chessboard.exception.ImposibleMoveException;
import ru.job4j.chessboard.exception.*;
/**
 * Абстрактный класс для описания фигуры .
 * Есть позиция  - final Cell position
 * Cell[] way - классы, которые будут расширять, описывают возможный путь
 * фигуры. Если он неправильный - вылетает ImposibleMoveException.
 * Figure copyC -  перезаписывает фигуру в новую ячейку.
 *@author Helena
 *@sinse 1.0 20/03/18
 */
public abstract class Figure {
    final Cell position;

    private int[] moveDirection = new int[4];

    public Figure(Cell position) {
        this.position = position;
    }

    public abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

    public abstract Figure copyC(Cell dest);
}
