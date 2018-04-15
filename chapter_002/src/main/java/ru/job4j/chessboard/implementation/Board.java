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
 * indexWorkFigure - сохраняет индекс фигуры в figureList , с которой мы работаем.
 * @author Helena
 *@sinse 1.0
 */

public class Board {
    private List<Figure> figureList = new ArrayList<>(32);
    private int indexWorkFigure;

    /**
     * Добавляет фигуру в figureList, если в указанной ячейке уже стоит фигура, то
     * вылетает исключение OccupiedWayException.
     * @param figure
     * @throws OccupiedWayException
     */
    public void add(Figure figure) throws OccupiedWayException {
        try {
            if (!containsOtherOnSame(figure)) {
                figureList.add(figure);
            }
        } catch (OccupiedWayException owe) {
            System.out.println(" На этом месте уже стоит фигура ");
        }
    }


    /**
     * Метод проверяет, на пустая ли ячейка, с которой мы работаем, если пуста ,то FigureNotFoundException.
     * Проверяет. может ли фигура в ячейке двигаться к Cell dest, если нет то ImposibleMoveException.
     * Проверяет, не занят ли путь фигурами другими, если занят, то OccupiedWayException.
     * Если не выбросило ни одного исключения,то return true.
     * @param source
     * @param dest
     * @return true or false
     * @throws ImposibleMoveException
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
    public  boolean move(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        int indexObjectWork;
        try {
            containsFigureOnCell(source);
            indexObjectWork = this.indexWorkFigure;
            Cell[] allWay = figureList.get(indexObjectWork).way(source, dest);
            for (Cell step : allWay) {
                System.out.println(String.format("%s step: %d, %d", figureList.get(indexObjectWork).getClass().toString(), step.getX(), step.getY()));
                containsOtherOnSame(step);
            }
            return true;
        } catch (FigureNotFoundException fnfe) {
            System.out.println(" В ячейке нет фигуры ");
        } catch (ImposibleMoveException ime) {
            System.out.println(" Фигура не может двигаться по такому пути ");
        } catch (OccupiedWayException owe) {
            System.out.println(" На пути уже стоит фигура ");
        }
        return false;
    }




    /**
     * Нельзя добавить фигуру, если в нашем списке на этом месте уже стоит другая.
     * Если такие фигуры есть,то создаеём OccupiedWayException.
     * Если таких фигур нет, то возвращаем false - фигур на пути следования нет.
     * @param figure фигура, которую добавляют
     * @return можно довабить или нет ( true or false)
     */
    public boolean containsOtherOnSame(Figure figure) {
        for (Figure f : figureList) {
            if (f.position.getX() == figure.position.getX() && f.position.getY() == figure.position.getY()) {
                throw new OccupiedWayException(" На пути уже стоит фигура ");
            }
        }
        return false;
    }

    /**
     * Перегрузка
     * Метод проверяет,что на пути следования фигуры не стоят еще фигуры.
     * @param figure фигура, которую добавляют
     * @return ( true or false)
     */
    public boolean containsOtherOnSame(Cell figure) {
        for (Figure f : figureList) {
            if (f.position.getX() == figure.getX() && f.position.getY() == figure.getY()) {
                throw new OccupiedWayException(String.format(" Исключение в  %d, %d ", f.position.getX(), f.position.getY()));
            }
        }
        return true;
    }

    /**
     * Проверяет есть ли фигура в переданной ячейке
     * @param offer
     * @return true or false
     */
    public void containsFigureOnCell(Cell offer) throws FigureNotFoundException {
        for (Figure f : figureList) {
            if (f.position.getX() == offer.getX() && f.position.getY() == offer.getY()) {
                this.indexWorkFigure = figureList.indexOf(f);
                return;
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
        this.indexWorkFigure = 0;
        containsFigureOnCell(f.position);
        if (move(f.position, cell)) {
            this.figureList.set(this.indexWorkFigure, f.copyC(cell));
        }
    }
}
