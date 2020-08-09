package View.util;

public class KazaanPanel extends KorgoolContainerPanel {
    /**
     * Default constructor sets the number of Korgools to 0.
     *
     * @param isWhite Boolean representing whether this panel is white.
     */
    public KazaanPanel(boolean isWhite) {
        this(0, isWhite);
    }

    /**
     * Auxiliary constructor setting isWhite and the number of Korgools to
     * the number specified.
     *
     * @param n int Number of initial Korgools.
     * @param isWhite Boolean representing whether this panel is white.
     */
    public KazaanPanel(int n, boolean isWhite) {
        super(n, isWhite);
    }


    /**
     * Sets the number of korgools on the panel.
     *
     * @param n int The number of korgools to display.
     */
    @Override
    public void setValue(int n) {
        if (isWhite) {
            super.setValue("Your score:", n);
        } else {
            super.setValue("AI's score:", n);
        }
    }
}
