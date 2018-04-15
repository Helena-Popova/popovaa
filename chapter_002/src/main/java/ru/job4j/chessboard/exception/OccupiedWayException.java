package ru.job4j.chessboard.exception;
/**
 * Исключение типа - в какой-то клетке на данном мути уже стоит фигура.
 *@author Helena
 *@sinse 1.0 20/03/18
 */
public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String owe) {
        super(owe);
    }
}
