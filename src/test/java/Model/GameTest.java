package Model;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static junit.framework.TestCase.assertEquals;

public class GameTest {
    Game game;

    @Before
    public void setup() {
        game = new Game(new Board());
    }
    @Test
    public void testGameInitiallyNotOver() {
        game.subscribeToGameOver(gameOver -> {
            assertEquals(null, gameOver);
        });
    }

    @Test
    public void testPersonFirstMove() {
        game.subscribeToGameOver(gameOver -> {
            assertEquals(null, gameOver);
        });

        game.personMove(ThreadLocalRandom.current().nextInt(0, 8));
    }

    @Test
    public void testLastMove() {
        Board board = new Board.Builder().setPersonKazaanScore(82).build();
        game = new Game(board);

        game.subscribeToGameOver(gameOver -> {
            assertEquals("PERSON", gameOver);
        });
        game.personMove(ThreadLocalRandom.current().nextInt(0, 8));
    }
}