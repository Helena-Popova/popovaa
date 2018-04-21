package ru.job4j.chessboard.implementation;
import ru.job4j.chessboard.exception.FigureNotFoundException;
import ru.job4j.chessboard.exception.ImposibleMoveException;
import ru.job4j.chessboard.exception.OccupiedWayException;
import ru.job4j.chessboard.exception.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Описание модели шахматной доски
 * List<Figure> figureList - сохраняет введненные фигуны на шахматной доске и их расположение
 * @author Helena
 *@sinse 1.0
 */

public class Board {
    private List<Figure> figureList = new ArrayList<>(32);

    /**
     * Добавляет фигуру в figureList, если в указанной ячейке уже стоит фигура, то
     * вылетает исключение OccupiedWayException.
     * @param figure
     * @throws OccupiedWayException
     */
    public void add(Figure figure) throws  OccupiedWayException {
        if (!containsOtherOnSame(figure)) {
            figureList.add(figure);
        }
    }


    /**
     * Метод проверяет, на пустая ли ячейка, с которой мы работаем, если пуста ,то FigureNotFoundException.
     * Проверяет. может ли фигура в ячейке двигаться к Cell dest, если нет то ImposibleMoveException.
     * Проверяет, не занят ли путь фигурами другими, если занят, то OccupiedWayException.
     * Если не выбросило ни одного исключения,то return true.
     * @param source начальная ячейка
     * @param dest ячейка куда нужно перейти
     * @return true or false
     * @throws ImposibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
    public  boolean move(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        Cell[] allWay = figureList.get(this.figureList.indexOf(containsFigureOnCell(source))).way(source, dest);
        for (Cell step : allWay) {
            if (!containsOtherOnSame(step)) {
                return false;
            }
        }
        return true;
    }




    /**
     * Нельзя добавить фигуру, если в нашем списке на этом месте уже стоит другая.
     * Если такие фигуры есть,то создаеём OccupiedWayException.
     * Если таких фигур нет, то возвращаем false - фигур на пути следования нет.
     * @param figure фигура, которую добавляют
     * @return ( true or false) стоит там другая фигура или нет
     */
    public boolean containsOtherOnSame(Figure figure) {
        for (Figure f : figureList) {
            if (f.position.equals(figure.position)) {
                throw new OccupiedWayException(" На пути уже стоит другая фигура ");
            }
        }
        return false;
    }

    /**
     * Перегрузка
     * Метод проверяет,что на пути следования фигуры не стоят еще фигуры.
     * @param cell ячейка, в которой стоит фигура, которую добавляют
     * @return На пути уже стоит другая фигура
     */
    public boolean containsOtherOnSame(Cell cell) {
        for (Figure f : figureList) {
            if (f.position.equals(cell)) {
                throw new OccupiedWayException(" На пути уже стоит другая фигура ");
            }
        }
        return true;
    }

    /**
     * Проверяет есть ли фигура в переданной ячейке
     * @param offer
     * @return true or false
     */
    public Figure containsFigureOnCell(Cell offer) throws FigureNotFoundException {
        for (Figure f : figureList) {
            if (f.position.equals(offer)) {
                return f;
            }
        }
        throw new FigureNotFoundException(" В ячейке нет фигуры ");
    }

    /**
     * Показывает все добавленные фигуры
     */
    public void showAllFigure() {
        for (Figure f : figureList) {
            System.out.println(String.format("Figure: %s, coordinates %d , %d", f.getClass(), f.position.getX(), f.position.getY()));
        }
    }

    /**
     * Изменение позиции фигуры
     * @param f - фигура
     * @param cell - клетка, на которую прыгает фигура
     */
    public void rearrange(Figure f, Cell cell) {
        if (move(f.position, cell)) {
            this.figureList.set(this.figureList.indexOf(f), f.copyC(cell));
        }
    }
}
