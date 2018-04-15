package ru.job4j.chessboard.exception;

/**
 * Исключение типа - фигура не может пройти по заданному вами пути.
 * потому что либо пуь выходит за границы доски, либо путь не предназначен
 * для данного типа фигуры.
 *@author Helena
 *@sinse 1.0 20/03/18
 */
public class ImposibleMoveException extends RuntimeException {
    public ImposibleMoveException(String ime) {
        super(ime);
    }
}
