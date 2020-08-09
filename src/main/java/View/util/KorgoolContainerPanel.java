package View.util;

import javax.swing.*;
import java.awt.*;

public abstract class KorgoolContainerPanel extends JPanel {
    private int value;
    protected boolean isWhite;

    /**
     * Auxiliary constructor setting isWhite and the number of Korgools to
     * the number specified.
     *
     * @param n int Number of initial Korgools.
     * @param isWhite Boolean representing whether this panel is white.
     */
    public KorgoolContainerPanel(int n, boolean isWhite) {
        setEnabled(true);
        value = n;
        this.isWhite = isWhite;

        JLabel jLabel = new JLabel(String.valueOf(n), SwingConstants.CENTER);
        if (!isWhite) {
            setBackground(Color.BLACK);
            jLabel.setForeground(Color.WHITE);
        }
        jLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        setLayout(new BorderLayout());
        add(jLabel, BorderLayout.CENTER);
    }

    /**
     * Sets the number of korgools on the panel.
     *
     * @param n int The number of korgools to display.
     */
    public void setValue(int n) {
        setValue("", n);
    }

    /**
     * Sets the number of korgools on the panel.
     *
     * @param prefix String to display in front the display number of korgools.
     * @param n int The number of korgools to display.
     */
    public void setValue(String prefix, int n) {
        setLabelAndUpdateValue((prefix + " " + n).trim(), n);
    }

    /**
     * Manually set the display to the passed in string 'label', and set value to n.
     *
     * @param label String to be displayed.
     * @param n int The number to set value to.
     */
    protected void setLabelAndUpdateValue(String label, int n) {
        value = n;
        ((JLabel) getComponent(0)).setText(label);
    }

    /**
     * @return The current value representing the number of korgools being displayed.
     */
    public int getValue() {
        return value;
    }
}
