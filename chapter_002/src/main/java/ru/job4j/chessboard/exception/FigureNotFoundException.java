package ru.job4j.chessboard.exception;

/**
 * Исключение типа - в данной ячейке не содержится фигура
 *@author Helena
 *@sinse 1.0 20/03/18
 */
public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String fnfe) {
        super(fnfe);
    }
}
