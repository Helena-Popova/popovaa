package ru.job4j.chessboard.implementation;
import ru.job4j.chessboard.exception.ImposibleMoveException;
import ru.job4j.chessboard.exception.*;

public class Bishop extends Figure  {

    public Bishop(Cell cell) {
        super(cell);
    }

    /**
     * У ладьи существует два типа джижения :
     * когда она двигается по ВЕРТИКАЛИ, то координата по x сохраняется,
     * по у  имеет границы вверх: 8 - source.getY() и вниз: source.getY() - 1,
     * по ГОРИЗОНТАЛИ соответсвено, y не менятеся, x - по аналогии.
     * то есть dest координаты не должны выходить за массив доски
     * @param source откуда должна пойти фигура
     * @param dest куда должна прийти фигура
     * @return возвращает массив клеток, которые прошла фигура
     * @throws ImposibleMoveException - такой путь не может сущетсвовать для данной фигуры
     */
    public Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        int index = 0;
        int horizontal = dest.getX() - source.getX(); // горизонтальная составляющая
        int vertical = dest.getY() - source.getY(); //вертикальная

        Cell[] result = new Cell[horizontal != 0 ? Math.abs(horizontal) : Math.abs(vertical)];
        if (vertical == 0 || horizontal == 0) {
            for (int step = horizontal != 0 ? source.getX() : source.getY(); step != (horizontal != 0 ? dest.getX() : dest.getY());) {
                step = horizontal >= 0 && vertical >= 0 ? ++step :  --step;
                result[index++] = horizontal != 0 ? new Cell(step, source.getY()) : new Cell(source.getX(), step);
            }
            return result;
        } else {
            throw  new ImposibleMoveException("Такой путь невозможен.");
        }
    }

    public Figure copyC(Cell dest) {
        return new Bishop(dest);
    }

}
