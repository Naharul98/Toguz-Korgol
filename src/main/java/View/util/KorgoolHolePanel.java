package View.util;

import util.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KorgoolHolePanel extends KorgoolContainerPanel {
    private boolean isSelected = false, isTuz = true;

    private MouseListener enabledActions = null,
            disabledActions = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.RED));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    setBorder(BorderFactory.createEmptyBorder());
                }
            };

    /*
     * loads korgool hole labels.
     */
    private Map<Integer, String> labels = new HashMap<Integer, String>() {{
        try (Scanner scanner = new Scanner(Constants.LABELS_FILE)) {
            scanner.useDelimiter("-------");
            while(scanner.hasNext()){
                int number = Integer.valueOf(scanner.next().trim());
                String label = "<html>" + scanner.next().substring(1).replaceAll("\n", "<br/>").replaceAll(" ", "&nbsp;") + "</html>";
                put(number, label);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }};

    /**
     * Default constructor sets the number of Korgools to 9.
     *
     * @param isWhite Boolean representing whether this panel is white.
     */
    public KorgoolHolePanel(boolean isWhite) {
        this(9, isWhite);
    }

    /**
     * Auxiliary constructor setting isWhite and the number of Korgools to
     * the number specified.
     *
     * @param n int Number of initial Korgools.
     * @param isWhite Boolean representing whether this panel is white.
     */
    public KorgoolHolePanel(int n, boolean isWhite) {
        super(n, isWhite);
    }

    /**
     * Performs visual changes to be applied when selected.
     */
    public void select() {
        setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLUE));
        isSelected = true;
    }

    /**
     * Performs visual changes to be applied when deselected.
     */
    public void deselect() {
        setBorder(BorderFactory.createEmptyBorder());
        isSelected = false;
    }

    /**
     * @return Boolean thatss true if this panel has been selected false
     * otherwise.
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     * Behaviour for when the mouse enters.
     */
    public void mouseEntered() {
        if (!isSelected) {
            setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.GREEN));
        }
    }

    /**
     * Behaviour for when the mouse exits.
     */
    public void mouseExited() {
        if (!isSelected) {
            setBorder(BorderFactory.createEmptyBorder());
        }
    }

    /**
     * Override default setEnabled add extra functionality
     * to handle add and removing action listeners.
     * @param enable Boolean true to enable
     */
    @Override
    public void setEnabled(boolean enable) {
        if (enabledActions == null) {
            return;
        }

        // disabling panel
        if (!enable) {
            removeMouseListener(enabledActions);
            addMouseListener(disabledActions);
        }

        // enabling panel (if not already enabled)
        else if (!isEnabled()) {
            removeMouseListener(disabledActions);
            addMouseListener(enabledActions);
        }

        super.setEnabled(enable);
    }

    /**
     * Sets the panel as tuz, handling visual changes also.
     */
    public void setTuz() {
        isTuz = true;

        JLabel label = new JLabel("Tuz");
        label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        label.setBorder(new EmptyBorder(5,0,0,5));
        label.setAlignmentX(Component.RIGHT_ALIGNMENT);

        if (isWhite) {
            setBackground(Color.PINK);
        } else {
            setBackground(new Color(100, 0, 0));
            label.setForeground(Color.WHITE);
        }

        Box box = Box.createVerticalBox();
        box.add(label);

        add(box, BorderLayout.NORTH);
    }

    /**
     * @return boolean representing it the panel is Tuz.
     */
    public boolean isTuz() {
        return isTuz;
    }

    /**
     * Sets the mouse listener for the panel.
     *
     * @param l MouseListener to be set.
     */
    public void setMouseListener(MouseListener l) {
        removeMouseListener(enabledActions);
        addMouseListener(l);
        enabledActions = l;
    }

    /**
     * Sets the number of korgools on the panel, handling any visual changes
     * also by called the relevant class methods.
     *
     * @param n int The number of korgools to display.
     */
    @Override
    public void setValue(int n) {
        if (n == 0) setEnabled(false);
        else setEnabled(true);

        if (n > 10) {
            super.setValue(n);
        } else {
            super.setLabelAndUpdateValue(labels.get(n), n);
        }
    }
}
