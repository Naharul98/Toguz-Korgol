package Model;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BoardTest {
    /*
    Default constructor tests.
     */
    @Test
    public void testDefaultConstructorPersonKazaan() {
        Board board = new Board();
        assertEquals(0, board.getPersonKazaan().getNumberOfKorgools());
    }

    @Test
    public void testDefaultConstructorAiKazaan() {
        Board board = new Board();
        assertEquals(0, board.getAiKazaan().getNumberOfKorgools());
    }

    @Test
    public void testConstructorWithMinusOneKorgool() {
        Board board = new Board();
        assertArrayEquals(IntStream.range(0, 18).map(i -> 9).toArray(), board.getKorgoolHoles().stream().mapToInt(korgoolHole -> korgoolHole.getNumberOfKorgools()).toArray());
    }
}
