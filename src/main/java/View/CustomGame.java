package View;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for the custom game panel
 * which allows the player to customise the initial conditions for a new game
 */
public class CustomGame {
    private static CustomGame self;
    private static final String NAME = "customGame";

    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JRadioButton radioButton6;
    private JRadioButton radioButton7;
    private JRadioButton radioButton8;
    private JRadioButton radioButton9;
    private JRadioButton radioButton10;
    private JRadioButton radioButton11;
    private JRadioButton radioButton12;
    private JRadioButton radioButton13;
    private JRadioButton radioButton14;
    private JRadioButton radioButton15;
    private JRadioButton radioButton16;
    private JRadioButton radioButton17;
    private JRadioButton radioButton18;
    private JRadioButton radioButton19;
    private JRadioButton radioButton20;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JSpinner spinner3;
    private JSpinner spinner4;
    private JSpinner spinner5;
    private JSpinner spinner6;
    private JSpinner spinner7;
    private JSpinner spinner8;
    private JSpinner spinner9;
    private JSpinner spinner10;
    private JSpinner spinner11;
    private JSpinner spinner12;
    private JSpinner spinner13;
    private JSpinner spinner14;
    private JSpinner spinner15;
    private JSpinner spinner16;
    private JSpinner spinner17;
    private JSpinner spinner18;
    private JSpinner spinner19;
    private JSpinner spinner20;
    private JButton submitButton;
    private JButton cancelButton;
    private JPanel customGamePanel;

    private List<JRadioButton> radioButtons; //List of all JRadioButtons in the Panel
    private List<JSpinner> spinners; // List of all JSpinners in the Panel
    
    /**
     * Private constructor to ensure singleton integrity.
     */
    private CustomGame() {
    }
    
    /**
     * Gets singleton instance of this class
     */
    public static CustomGame getInstance() {
        if (self == null) {
            self = new CustomGame();
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
     * This method returns the panel of the Custom game form
     *
     * @return the Custom game panel
     */
    public JPanel getPanel() {
        return customGamePanel;
    }

    /**
     * @return Submit button.
     */
    public JButton getSubmitButton() {
        return submitButton;
    }
    
    /**
     * @return Cancel button.
     */
    public JButton getCancelButton() {
        return cancelButton;
    }

    /**
     * @return List containing all the JRadioButtons in the custom game panel
     */
    public List<JRadioButton> getRadioButtons() {
        return radioButtons;
    }

    /**
     * @return List containing all the JSpinners in the custom game panel
     */
    public List<JSpinner> getSpinners() {
        return spinners;
    }
    
    /**
     * Instantiate components to be used with intellij forms.
     */
    private void createUIComponents() {
        //######## RADIO BUTTONS ########
        radioButtons = new ArrayList<JRadioButton>() {{
            add(radioButton1 = new JRadioButton());
            add(radioButton1 = new JRadioButton());
            add(radioButton2 = new JRadioButton());
            add(radioButton3 = new JRadioButton());
            add(radioButton4 = new JRadioButton());
            add(radioButton5 = new JRadioButton());
            add(radioButton6 = new JRadioButton());
            add(radioButton7 = new JRadioButton());
            add(radioButton8 = new JRadioButton());
            add(radioButton9 = new JRadioButton());
            add(radioButton10 = new JRadioButton());
            add(radioButton11 = new JRadioButton());
            add(radioButton12 = new JRadioButton());
            add(radioButton13 = new JRadioButton());
            add(radioButton14 = new JRadioButton());
            add(radioButton15 = new JRadioButton());
            add(radioButton16 = new JRadioButton());
            add(radioButton17 = new JRadioButton());
            add(radioButton18 = new JRadioButton());
            add(radioButton19 = new JRadioButton());
            add(radioButton20 = new JRadioButton());
        }};

        //######## SPINNERS ########
        spinners = new ArrayList<JSpinner>() {{
            add(spinner1 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner2 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner3 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner4 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner5 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner6 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner7 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner8 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner9 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner10 = new JSpinner(new SpinnerNumberModel(0, 0, 81, 1)));
            add(spinner11 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner12 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner13 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner14 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner15 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner16 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner17 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner18 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner19 = new JSpinner(new SpinnerNumberModel(9, 0, 164, 1)));
            add(spinner20 = new JSpinner(new SpinnerNumberModel(0, 0, 81, 1)));
        }};
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
        customGamePanel = new JPanel();
        customGamePanel.setLayout(new GridLayoutManager(15, 9, new Insets(0, 0, 0, 0), -1, -1));
        customGamePanel.setName("customGamePanel");
        final Spacer spacer1 = new Spacer();
        customGamePanel.add(spacer1, new GridConstraints(3, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setEnabled(true);
        label1.setText("Hole 1");
        customGamePanel.add(label1, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setEnabled(true);
        label2.setText("Hole 2");
        customGamePanel.add(label2, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setEnabled(true);
        label3.setText("Hole 3");
        customGamePanel.add(label3, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setEnabled(true);
        label4.setText("Hole 4");
        customGamePanel.add(label4, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setEnabled(true);
        label5.setText("Hole 5");
        customGamePanel.add(label5, new GridConstraints(7, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setEnabled(true);
        label6.setText("Hole 6");
        customGamePanel.add(label6, new GridConstraints(8, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setEnabled(true);
        label7.setText("Hole 7");
        customGamePanel.add(label7, new GridConstraints(9, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label8 = new JLabel();
        label8.setEnabled(true);
        label8.setText("Hole 8");
        customGamePanel.add(label8, new GridConstraints(10, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label9 = new JLabel();
        label9.setEnabled(true);
        label9.setText("Hole 9");
        customGamePanel.add(label9, new GridConstraints(11, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton1.setName("radioButton1");
        radioButton1.setText("");
        customGamePanel.add(radioButton1, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton2.setName("radioButton2");
        radioButton2.setText("");
        customGamePanel.add(radioButton2, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton3.setName("radioButton3");
        radioButton3.setText("");
        customGamePanel.add(radioButton3, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton4.setName("radioButton4");
        radioButton4.setText("");
        customGamePanel.add(radioButton4, new GridConstraints(6, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton5.setName("radioButton5");
        radioButton5.setText("");
        customGamePanel.add(radioButton5, new GridConstraints(7, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton6.setName("radioButton6");
        radioButton6.setText("");
        customGamePanel.add(radioButton6, new GridConstraints(8, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton7.setName("radioButton7");
        radioButton7.setText("");
        customGamePanel.add(radioButton7, new GridConstraints(9, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton8.setName("radioButton8");
        radioButton8.setText("");
        customGamePanel.add(radioButton8, new GridConstraints(10, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton9.setName("radioButton9");
        radioButton9.setText("");
        customGamePanel.add(radioButton9, new GridConstraints(11, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton11.setName("radioButton11");
        radioButton11.setText("");
        customGamePanel.add(radioButton11, new GridConstraints(4, 7, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton12.setName("radioButton12");
        radioButton12.setText("");
        customGamePanel.add(radioButton12, new GridConstraints(5, 7, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton13.setName("radioButton13");
        radioButton13.setText("");
        customGamePanel.add(radioButton13, new GridConstraints(6, 7, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton14.setName("radioButton14");
        radioButton14.setText("");
        customGamePanel.add(radioButton14, new GridConstraints(7, 7, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton15.setName("radioButton15");
        radioButton15.setText("");
        customGamePanel.add(radioButton15, new GridConstraints(8, 7, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton16.setName("radioButton16");
        radioButton16.setText("");
        customGamePanel.add(radioButton16, new GridConstraints(9, 7, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton17.setName("radioButton17");
        radioButton17.setText("");
        customGamePanel.add(radioButton17, new GridConstraints(10, 7, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton18.setName("radioButton18");
        radioButton18.setText("");
        customGamePanel.add(radioButton18, new GridConstraints(11, 7, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner1, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner2, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner3, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner4, new GridConstraints(6, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner5, new GridConstraints(7, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner6, new GridConstraints(8, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner7, new GridConstraints(9, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner8, new GridConstraints(10, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner9, new GridConstraints(11, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner10, new GridConstraints(12, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner11, new GridConstraints(3, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner12, new GridConstraints(4, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner13, new GridConstraints(5, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner14, new GridConstraints(6, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner15, new GridConstraints(7, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner16, new GridConstraints(8, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner17, new GridConstraints(9, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner18, new GridConstraints(10, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label10 = new JLabel();
        label10.setText("Kazan");
        customGamePanel.add(label10, new GridConstraints(12, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label11 = new JLabel();
        label11.setText("Hole 1");
        customGamePanel.add(label11, new GridConstraints(3, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label12 = new JLabel();
        label12.setText("Hole 2");
        customGamePanel.add(label12, new GridConstraints(4, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label13 = new JLabel();
        label13.setText("Hole 3");
        customGamePanel.add(label13, new GridConstraints(5, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label14 = new JLabel();
        label14.setText("Hole 4");
        customGamePanel.add(label14, new GridConstraints(6, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label15 = new JLabel();
        label15.setText("Hole 5");
        customGamePanel.add(label15, new GridConstraints(7, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label16 = new JLabel();
        label16.setText("Hole 6");
        customGamePanel.add(label16, new GridConstraints(8, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label17 = new JLabel();
        label17.setText("Hole 7");
        customGamePanel.add(label17, new GridConstraints(9, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label18 = new JLabel();
        label18.setText("Hole 8");
        customGamePanel.add(label18, new GridConstraints(10, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton10.setName("radioButton10");
        radioButton10.setText("");
        customGamePanel.add(radioButton10, new GridConstraints(3, 7, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner19, new GridConstraints(11, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        customGamePanel.add(spinner20, new GridConstraints(12, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label19 = new JLabel();
        label19.setText("Hole 9");
        customGamePanel.add(label19, new GridConstraints(11, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label20 = new JLabel();
        label20.setText("Kazan");
        customGamePanel.add(label20, new GridConstraints(12, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton19 = new JRadioButton();
        radioButton19.setSelected(true);
        radioButton19.setText("No Tuz");
        customGamePanel.add(radioButton19, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        radioButton20 = new JRadioButton();
        radioButton20.setSelected(true);
        radioButton20.setText("No Tuz");
        customGamePanel.add(radioButton20, new GridConstraints(2, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label21 = new JLabel();
        label21.setText("Player");
        customGamePanel.add(label21, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label22 = new JLabel();
        label22.setText("Opponent");
        customGamePanel.add(label22, new GridConstraints(1, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        submitButton = new JButton();
        submitButton.setName("submitButton");
        submitButton.setText("Submit");
        customGamePanel.add(submitButton, new GridConstraints(13, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cancelButton = new JButton();
        cancelButton.setName("cancelButton");
        cancelButton.setText("Cancel");
        customGamePanel.add(cancelButton, new GridConstraints(13, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label23 = new JLabel();
        label23.setText("Tuz");
        customGamePanel.add(label23, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label24 = new JLabel();
        label24.setText("Tuz");
        customGamePanel.add(label24, new GridConstraints(2, 7, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        customGamePanel.add(spacer2, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        customGamePanel.add(spacer3, new GridConstraints(3, 8, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        customGamePanel.add(spacer4, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        customGamePanel.add(spacer5, new GridConstraints(14, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton19);
        buttonGroup.add(radioButton19);
        buttonGroup.add(radioButton6);
        buttonGroup.add(radioButton8);
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton9);
        buttonGroup.add(radioButton3);
        buttonGroup.add(radioButton7);
        buttonGroup.add(radioButton5);
        buttonGroup.add(radioButton4);
        buttonGroup.add(radioButton2);
        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton12);
        buttonGroup.add(radioButton12);
        buttonGroup.add(radioButton18);
        buttonGroup.add(radioButton20);
        buttonGroup.add(radioButton13);
        buttonGroup.add(radioButton14);
        buttonGroup.add(radioButton11);
        buttonGroup.add(radioButton17);
        buttonGroup.add(radioButton10);
        buttonGroup.add(radioButton15);
        buttonGroup.add(radioButton16);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return customGamePanel;
    }

}
