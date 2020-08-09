package Model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The test class Player.
 */
public class PlayerTest
{
    @Test
    public void playerNameSetToNaharulShouldReturnNaharul() {
        Player testPlayer = new Player("xyz", true);
        testPlayer.setName("Naharul");
        assertEquals("Naharul", testPlayer.getPlayerName());
    }

    @Test
    public void playerWhiteSideFlagSetToTrueShouldReturnTrue() {
        Player testPlayer = new Player("Naharul", false);
        testPlayer.setIsOnWhiteSide(true);
        assertEquals(true, testPlayer.getIsInWhiteSide());
    }

    @Test
    public void playerWhiteSideFlagSetToFalseShouldReturnFalse() {
        Player testPlayer = new Player("Naharul", true);
        testPlayer.setIsOnWhiteSide(false);
        assertEquals(false, testPlayer.getIsInWhiteSide());
    }

    @Test
    public void playerInstantiatedWithNameAsHayatShouldReturnHayat() {
        Player testPlayer = new Player("Hayat", false);
        assertEquals("Hayat", testPlayer.getPlayerName());
    }

    @Test
    public void playerInstantiatedWithWhiteSideFlagAsTrueShouldReturnTrue() {
        Player testPlayer = new Player("Hayat", true);
        assertEquals(true, testPlayer.getIsInWhiteSide());
    }

    @Test
    public void playerInstantiatedWithWhiteSideFlagAsFalseShouldReturnFalse() {
        Player testPlayer = new Player("Hayat", false);
        assertEquals(false, testPlayer.getIsInWhiteSide());
    }
}


