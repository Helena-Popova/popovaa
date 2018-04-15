package ru.job4j.chessboard.implementation;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chessboard.exception.ImposibleMoveException;
import ru.job4j.chessboard.implementation.Bishop;
import ru.job4j.chessboard.implementation.Cell;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopTest {

    /**
     * Тест на правильный путь ладьи
     */
    @Test
    public void wayIsRight() {
        Bishop bishop = new Bishop(new Cell(5, 5));
        Cell[] result = bishop.way(new Cell(5, 5), new Cell(5, 8));
        assertThat(result[0].getX(), is(new Cell(5, 6).getX()));
    }

    /**
     * тест на неправильный путь ладьи - выход за границы доски.
     * выкидавает исключение :
     * @throws ImposibleMoveException
     */
    @Test
    public void wayIsNotRight() throws ImposibleMoveException {
        Bishop  bishop = new Bishop(new Cell(5, 5));
        try {
            bishop.way(new Cell(5, 5), new Cell(5, -1));
        } catch (ImposibleMoveException ime) {
            Assert.assertNotEquals("", ime.getMessage());
        }
    }

    /**
     * Тест на переприсваивание ладье значения ячейки,на которой она стоит.
     */
    @Test
    public void copyC() {
        Bishop  bishop = new Bishop(new Cell(5, 5));
        assertThat(bishop.copyC(new Cell(1, 1)).position.getX(), is(new Cell(1, 1).getX()));
    }

}