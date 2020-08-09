package View;

import View.util.KazaanPanel;
import View.util.KorgoolHolePanel;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NewGame {
    private static final String NAME = "newGame";
    private static NewGame self;
    private JPanel newGamePanel;
    private JButton saveGameButton;
    private JButton quitButton;
    private JPanel korgoolHole_oh0;
    private JPanel korgoolHole_oh1;
    private JPanel korgoolHole_oh2;
    private JPanel korgoolHole_oh3;
    private JPanel korgoolHole_oh4;
    private JPanel korgoolHole_oh5;
    private JPanel korgoolHole_oh6;
    private JPanel korgoolHole_oh7;
    private JPanel korgoolHole_oh8;
    private JPanel korgoolHole_ph0;
    private JPanel korgoolHole_ph1;
    private JPanel korgoolHole_ph2;
    private JPanel korgoolHole_ph3;
    private JPanel korgoolHole_ph4;
    private JPanel korgoolHole_ph5;
    private JPanel korgoolHole_ph6;
    private JPanel korgoolHole_ph7;
    private JPanel korgoolHole_ph8;
    private JPanel kazaanOpponent;
    private JPanel kazaanPlayer;
    private JLabel statusLabel;
    private JButton performMoveButton;

    private List<JPanel> korgoolHoles;

    /**
     * Private constructor to ensure singleton integrity.
     */
    private NewGame() {
    }

    /**
     * Create new singleton instance of this class
     */
    public static NewGame newInstance() {
        self = new NewGame();
        return self;
    }

    /**
     * Gets singleton instance of this class
     */
    public static NewGame getInstance() {
        if (self == null) {
            System.err.println("NewGame.java: getInstance called before first newInstance call!");
            System.exit(-1);
        }
        return self;
    }

    /**
     * @return String name.
     */
    public String getName() {
        return NAME;
    }

    /**
     * @return JPanel root newGamePanel of view.
     */
    public JPanel getPanel() {
        return newGamePanel;
    }

    /**
     * @return List containing all the korgool hole panels,
     * player's are in 0-7. ai's are in 9-17.
     */
    public List<JPanel> getKorgoolHoles() {
        return korgoolHoles;
    }

    /**
     * @return List containing only the players korgools.
     */
    public List<JPanel> getPlayerKorgoolHoles() {
        return korgoolHoles.subList(0, 9);
    }

    /**
     * Get korgool hole are the specified index.
     *
     * @param holeNumber index of korgool hole.
     * @return JPanel indexed korgool hole.
     */
    public JPanel getKorgoolHole(int holeNumber) {
        return korgoolHoles.get(holeNumber);
    }

    /**
     * @return Opponent Kazaan
     */
    public JPanel getOpponentKazaan() {
        return kazaanOpponent;
    }

    /**
     * @return Player Kazaan
     */
    public JPanel getPlayerKazaan() {
        return kazaanPlayer;
    }

    /**
     * @return Perform move button
     */
    public JButton getPerformMoveButton() {
        return performMoveButton;
    }

    /**
     * @return Status label
     */
    public JLabel getStatusLabel() {
        return statusLabel;
    }

    /**
     * @return Save game button
     */
    public JButton getSaveGameButton() {
        return saveGameButton;
    }

    /**
     * @return Quit button
     */
    public JButton getQuitButton() {
        return quitButton;
    }

    /**
     * Instantiate components in thread safe way to be used with intellij forms.
     */
    private void createUIComponents() {
        korgoolHoles = new ArrayList<JPanel>() {{
            // ------- Player Korgool Holes --------
            add(korgoolHole_ph0 = new KorgoolHolePanel(true));
            add(korgoolHole_ph1 = new KorgoolHolePanel(true));
            add(korgoolHole_ph2 = new KorgoolHolePanel(true));
            add(korgoolHole_ph3 = new KorgoolHolePanel(true));
            add(korgoolHole_ph4 = new KorgoolHolePanel(true));
            add(korgoolHole_ph5 = new KorgoolHolePanel(true));
            add(korgoolHole_ph6 = new KorgoolHolePanel(true));
            add(korgoolHole_ph7 = new KorgoolHolePanel(true));
            add(korgoolHole_ph8 = new KorgoolHolePanel(true));
            // ------- Opponent Korgool Holes -------
            add(korgoolHole_oh0 = new KorgoolHolePanel(false));
            add(korgoolHole_oh1 = new KorgoolHolePanel(false));
            add(korgoolHole_oh2 = new KorgoolHolePanel(false));
            add(korgoolHole_oh3 = new KorgoolHolePanel(false));
            add(korgoolHole_oh4 = new KorgoolHolePanel(false));
            add(korgoolHole_oh5 = new KorgoolHolePanel(false));
            add(korgoolHole_oh6 = new KorgoolHolePanel(false));
            add(korgoolHole_oh7 = new KorgoolHolePanel(false));
            add(korgoolHole_oh8 = new KorgoolHolePanel(false));
        }};

        // ------- Player Kazaan --------
        kazaanPlayer = new KazaanPanel(true);

        // ------- Opponent Kazaan --------
        kazaanOpponent = new KazaanPanel(false);

        (performMoveButton = new JButton()).setEnabled(false);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        newGamePanel = new JPanel();
        newGamePanel.setLayout(new BorderLayout(0, 0));
        newGamePanel.setMinimumSize(new Dimension(1100, 320));
        newGamePanel.setName("newGamePanel");
        newGamePanel.setPreferredSize(new Dimension(1100, 320));
        newGamePanel.putClientProperty("html.disable", Boolean.FALSE);
        newGamePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(3, 9, new Insets(0, 5, 5, 2), -1, -1));
        panel1.setName("leftPanel");
        newGamePanel.add(panel1, BorderLayout.CENTER);
        korgoolHole_oh8.setBackground(new Color(-16777216));
        korgoolHole_oh8.setEnabled(true);
        korgoolHole_oh8.setName("korgoolHole_oh8");
        panel1.add(korgoolHole_oh8, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_oh0.setBackground(new Color(-16777216));
        korgoolHole_oh0.setEnabled(true);
        korgoolHole_oh0.setName("korgoolHole_oh0");
        panel1.add(korgoolHole_oh0, new GridConstraints(0, 8, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_oh7.setBackground(new Color(-16777216));
        korgoolHole_oh7.setEnabled(true);
        korgoolHole_oh7.setName("korgoolHole_oh7");
        panel1.add(korgoolHole_oh7, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_oh6.setBackground(new Color(-16777216));
        korgoolHole_oh6.setEnabled(true);
        korgoolHole_oh6.setName("korgoolHole_oh6");
        panel1.add(korgoolHole_oh6, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_oh5.setBackground(new Color(-16777216));
        korgoolHole_oh5.setEnabled(true);
        korgoolHole_oh5.setInheritsPopupMenu(false);
        korgoolHole_oh5.setName("korgoolHole_oh5");
        panel1.add(korgoolHole_oh5, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_oh4.setBackground(new Color(-16777216));
        korgoolHole_oh4.setEnabled(true);
        korgoolHole_oh4.setName("korgoolHole_oh4");
        panel1.add(korgoolHole_oh4, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_oh3.setBackground(new Color(-16777216));
        korgoolHole_oh3.setEnabled(true);
        korgoolHole_oh3.setName("korgoolHole_oh3");
        panel1.add(korgoolHole_oh3, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_oh2.setBackground(new Color(-16777216));
        korgoolHole_oh2.setEnabled(true);
        korgoolHole_oh2.setName("korgoolHole_oh2");
        panel1.add(korgoolHole_oh2, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_oh1.setBackground(new Color(-16777216));
        korgoolHole_oh1.setEnabled(true);
        korgoolHole_oh1.setName("korgoolHole_oh1");
        panel1.add(korgoolHole_oh1, new GridConstraints(0, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_ph8.setBackground(new Color(-1));
        korgoolHole_ph8.setEnabled(true);
        korgoolHole_ph8.setName("korgoolHole_ph8");
        panel1.add(korgoolHole_ph8, new GridConstraints(2, 8, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_ph7.setBackground(new Color(-1));
        korgoolHole_ph7.setEnabled(true);
        korgoolHole_ph7.setName("korgoolHole_ph7");
        panel1.add(korgoolHole_ph7, new GridConstraints(2, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_ph6.setBackground(new Color(-1));
        korgoolHole_ph6.setEnabled(true);
        korgoolHole_ph6.setName("korgoolHole_ph6");
        panel1.add(korgoolHole_ph6, new GridConstraints(2, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_ph5.setBackground(new Color(-1));
        korgoolHole_ph5.setEnabled(true);
        korgoolHole_ph5.setName("korgoolHole_ph5");
        panel1.add(korgoolHole_ph5, new GridConstraints(2, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_ph4.setBackground(new Color(-1));
        korgoolHole_ph4.setEnabled(true);
        korgoolHole_ph4.setName("korgoolHole_ph4");
        panel1.add(korgoolHole_ph4, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_ph3.setBackground(new Color(-1));
        korgoolHole_ph3.setEnabled(true);
        korgoolHole_ph3.setName("korgoolHole_ph3");
        panel1.add(korgoolHole_ph3, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_ph2.setBackground(new Color(-1));
        korgoolHole_ph2.setEnabled(true);
        korgoolHole_ph2.setName("korgoolHole_ph2");
        panel1.add(korgoolHole_ph2, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_ph1.setBackground(new Color(-1));
        korgoolHole_ph1.setEnabled(true);
        korgoolHole_ph1.setName("korgoolHole_ph1");
        panel1.add(korgoolHole_ph1, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        korgoolHole_ph0.setBackground(new Color(-1));
        korgoolHole_ph0.setEnabled(true);
        korgoolHole_ph0.setName("korgoolHole_ph0");
        panel1.add(korgoolHole_ph0, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(85, 230), new Dimension(85, 230), new Dimension(85, 230), 0, false));
        kazaanOpponent.setBackground(new Color(-16777216));
        kazaanOpponent.setName("kazaanOpponent");
        panel1.add(kazaanOpponent, new GridConstraints(1, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(121, 36), null, 0, false));
        kazaanPlayer.setBackground(new Color(-1));
        kazaanPlayer.setName("kazaanPlayer");
        panel1.add(kazaanPlayer, new GridConstraints(1, 5, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(121, 36), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout(0, 0));
        panel2.setMinimumSize(new Dimension(241, 106));
        panel2.setName("rightPanel");
        panel2.setPreferredSize(new Dimension(241, 106));
        newGamePanel.add(panel2, BorderLayout.EAST);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(3, 2, new Insets(5, 5, 5, 5), -1, -1));
        panel3.setName("containerPanel");
        panel2.add(panel3, BorderLayout.EAST);
        quitButton = new JButton();
        quitButton.setName("quitButton");
        quitButton.setText("Quit");
        panel3.add(quitButton, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 30), null, 0, false));
        saveGameButton = new JButton();
        saveGameButton.setName("saveGameButton");
        saveGameButton.setText("Save Game");
        panel3.add(saveGameButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(100, 30), null, 0, false));
        statusLabel = new JLabel();
        Font statusLabelFont = this.$$$getFont$$$("Monaco", -1, 24, statusLabel.getFont());
        if (statusLabelFont != null) statusLabel.setFont(statusLabelFont);
        statusLabel.setHorizontalAlignment(0);
        statusLabel.setHorizontalTextPosition(0);
        statusLabel.setName("statusLabel");
        statusLabel.setText("Your turn...");
        panel3.add(statusLabel, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        performMoveButton.setName("performMoveButton");
        performMoveButton.setText("Perform Move");
        panel3.add(performMoveButton, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return newGamePanel;
    }

}
