package ru.job4j.chessboard.implementation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.job4j.chessboard.exception.ImposibleMoveException;
import ru.job4j.chessboard.implementation.Cell;
import ru.job4j.chessboard.implementation.Figure;
import ru.job4j.chessboard.implementation.King;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class KingTest {
    /**
     * Тест на прохождение фигурой Король правильного пути
     */
    @Test
    public void wayRight() {
        King figureFing = new King(new Cell(1, 1));
        Cell[] result = figureFing.way(new Cell(1, 1), new Cell(2, 2));
        assertThat(result[0], is(new Cell(2, 2)));
    }

    /**
     * тест на переприсваивание значения ячейки,на которой стоит фигура.
     */
    @Test
    public void copyCRight() {
        Figure figureFing = new King(new Cell(1, 1)).copyC(new  Cell(2, 2));
        Figure result = new King(new Cell(2, 2));
        assertThat(result.position, is(figureFing.position));
    }

    /**
     * если задано неправильное знавение пути - в данном случае путь больше,чем одна клетка, то
     * выкидывается исключение ImposibleMoveException
     */
    @Test(expected = ImposibleMoveException.class)
    public void testImposibleMoveException() {
        King figureFing = new King(new Cell(1, 1));
        figureFing.way(new Cell(1, 1), new Cell(3, 2));
    }

    /**
     * Выход за границы доски - выкинет исключение
     */
    @Test(expected = ImposibleMoveException.class)
    public void testOutOfBoard() {
       King figureFing = new King(new Cell(1, 1));
       Cell[] result = figureFing.way(new Cell(8, 1), new Cell(9, 1));
    }


}