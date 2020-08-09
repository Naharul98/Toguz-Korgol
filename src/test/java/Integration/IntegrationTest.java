package Integration;

import View.util.KorgoolHolePanel;
import ViewModel.GUIViewModel;
import com.athaydes.automaton.Swinger;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class IntegrationTest {
    private Swinger swinger;

    @Before
    public void setup() {
        new GUIViewModel();
        swinger = Swinger.forSwingWindow();
    }

    @Test
    public void run() {
        swinger.pause(500);
        ((JButton) swinger.getAt("name:newGameButton")).doClick();
        swinger.pause(500);

        testNewGameButton();

        // save game for testing loading later
        ((JButton) swinger.getAt("name:saveGameButton")).doClick();
        swinger.pause(500);

        testSaveGameButton();

        ((JButton) swinger.getAt("name:quitButton")).doClick();
        swinger.pause(500);
        ((JButton) swinger.getAt("name:customGameButton")).doClick();
        swinger.pause(500);

        testCustomGameButton();

        ((JButton) swinger.getAt("name:cancelButton")).doClick();
        swinger.pause(500);
        ((JButton) swinger.getAt("name:loadGameButton")).doClick();
        swinger.pause(500);

        testLoadGameButton();

        ((JButton) swinger.getAt("name:quitButton")).doClick();
        swinger.pause(500);
        ((JButton) swinger.getAt("name:instructionsButton")).doClick();
        swinger.pause(500);

        testInstructionsButton();

        ((JButton) swinger.getAt("name:backButton")).doClick();
        swinger.pause(500);

        ((JButton) swinger.getAt("name:customGameButton")).doClick();
        swinger.pause(500);

        int playerTuz = ThreadLocalRandom.current().nextInt(1,9);
        ((JRadioButton) swinger.getAt("name:radioButton" +playerTuz)).doClick();
        int aiTuz = ((playerTuz+1) % 9) + 9;
        ((JRadioButton) swinger.getAt("name:radioButton" + aiTuz)).doClick();

        ((JButton) swinger.getAt("name:submitButton")).doClick();
        swinger.pause(500);

        testCustomGameFeature(playerTuz, aiTuz);
    }

    private void testCustomGameFeature(int playerTuz, int aiTuz) {
        KorgoolHolePanel playerPanel = (KorgoolHolePanel) swinger.getAt("name:korgoolHole_ph" + playerTuz);
        System.out.println(playerPanel);
        KorgoolHolePanel aiPanel = (KorgoolHolePanel) swinger.getAt("name:korgoolHole_oh" + (aiTuz%9));

        assertTrue(playerPanel.isTuz());
        assertTrue(aiPanel.isTuz());
    }

    /**
     * Check current panel in the new game panel
     */
    private void testOnNewGamePanel() {
        JPanel newGamePanel = (JPanel) swinger.getAt("name:newGamePanel");
        assertNotEquals(null, newGamePanel);
    }

    /**
     * Test new game button
     */
    private void testNewGameButton() {
        testOnNewGamePanel();
    }

    /**
     * Test save game button
     */
    private void testSaveGameButton() {
        testOnNewGamePanel();
    }

    /**
     * Test custom game button
     */
    private void testCustomGameButton() {
        JPanel customGamePanel = (JPanel) swinger.getAt("name:customGamePanel");
        assertNotEquals(null, customGamePanel);
    }

    /**
     * Test load game button
     */
    private void testLoadGameButton() {
        testOnNewGamePanel();
    }

    /**
     * Test instructions button.
     */
    private void testInstructionsButton() {
        JPanel instructionsPanel = (JPanel) swinger.getAt("name:instructionsPanel");
        assertNotEquals(null, instructionsPanel);

        JButton backButton = (JButton) swinger.getAt("name:backButton");
        assertEquals("Back", backButton.getText());
    }
}