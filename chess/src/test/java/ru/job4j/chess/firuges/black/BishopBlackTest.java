package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BishopBlackTest {

    @Test
    public void whenTestPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position()).isEqualTo(Cell.C1);
    }

    @Test
    public void whenTestCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        Figure a = bishopBlack.copy(Cell.G5);
        assertThat(a.position()).isEqualTo(Cell.G5);
    }

    @Test
    public void whenTestWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlack.way(Cell.G5);
        assertThat(cells).isEqualTo(new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5});
    }

    @Test
    public void whenInvalidWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishopBlack.way(Cell.G6);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from C1 to G6");
    }
}