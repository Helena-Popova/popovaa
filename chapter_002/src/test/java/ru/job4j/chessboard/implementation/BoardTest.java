package ru.job4j.chessboard.implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ru.job4j.chessboard.exception.FigureNotFoundException;
import ru.job4j.chessboard.exception.ImposibleMoveException;
import ru.job4j.chessboard.exception.OccupiedWayException;
import ru.job4j.chessboard.implementation.Bishop;
import ru.job4j.chessboard.implementation.Board;
import ru.job4j.chessboard.implementation.Cell;
import ru.job4j.chessboard.implementation.King;

public class BoardTest {

    Board chessTable = new Board();

    /**
     * на доске имеются изначально две фигуры
     */
    @Before
    public void loadMem() {
        chessTable.add(new King(new Cell(1, 1)));
        chessTable.add(new Bishop(new Cell(1, 2)));
    }

    /**
     * Если попробует поставить новыю фигуру в занятую ячейку,то выкинет OccupiedWayException
     * @throws OccupiedWayException
     */
    @Test
    public void addExceprionTest() throws OccupiedWayException {
        try {
            chessTable.add(new Bishop(new Cell(1, 1)));
        } catch (OccupiedWayException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    /**
     * Если попытается работать с ячейкой, в которой нет фигуры,то выкинет FigureNotFoundException
     * @throws FigureNotFoundException
     */
    @Test
    public void moveExceptionTestNoFigureInTheCell() throws FigureNotFoundException {
        try {
            chessTable.move(new Cell(3, 4), new Cell(4, 5));
        } catch (FigureNotFoundException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    /**
     * Если реализаци пути для фигуру в ячейке не совпадает с указанным в методе move значением конечной ячейки,
     * то выкинет исключение
     * @throws ImposibleMoveException
     */
    @Test
    public void moveExceptionTestImposibleWayForFigure() throws ImposibleMoveException {
        try {
            chessTable.move(new Cell(1, 1), new Cell(4, 5));
        } catch (ImposibleMoveException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    /**
     * если какие=то фигуру уже стоят на пути, то выкинет исключение, что нельзя пройти по данному пути
     * @throws OccupiedWayException
     */
    @Test
    public void moveExceptionTestSomeElseFigureStayOnWay() throws OccupiedWayException {
        try {
            chessTable.move(new Cell(1, 1), new Cell(1, 2));
        } catch (OccupiedWayException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

}