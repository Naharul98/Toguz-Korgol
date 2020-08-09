package View;

import javax.swing.*;
import java.awt.*;

/**
 * This class is responsible for all aspects of the View
 */
public class GUI {
    private static GUI self;

    private JFrame mainFrame = new JFrame("Toguz Korgool");
    private JPanel mainPanel = new JPanel();
    private CardLayout mainPanelLayout = new CardLayout();

     /**
     * Create and show the View
     */
    private GUI(JPanel initialPanel, String panelName, JPanel... panels) {
        initComponents(initialPanel, panelName);
    }

    /**
     * Create new singleton instance of this class
     */
    public static GUI newInstance(JPanel initialPanel, String panelName) {
        self = new GUI(initialPanel, panelName);
        return self;
    }

    /**
     * Gets singleton instance of this class
     */
    public static GUI getInstance() {
        if(self == null) {
            System.err.println("GUI.java: getInstance called before first newInstance call!\nAn initial panel must be set!");
            System.exit(-1);
        }
        return self;
    }

    /**
     * Instantiate components in thread safe way to be used with intellij forms.
     */
    private void initComponents(JPanel initialPanel, String panelName) {
        mainPanel.setLayout(mainPanelLayout);
        mainPanel.add(initialPanel, panelName);
        mainPanel.setBorder(BorderFactory.createMatteBorder(
                20, 20, 20, 20, new JPanel().getBackground()));

        mainFrame.add(mainPanel);
        mainFrame.setResizable(false);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Adds panel to the main frame card layout.
     *
     * @param panel JPanel to be displayed.
     * @param panelName String name of panel.
     */
    public void addPanel(JPanel panel, String panelName) {
        mainPanel.add(panel, panelName);
        mainFrame.pack();
    }

    /**
     * Displays the JPanel associated with the name passed in.
     * @param panelName
     */
    public void showPanel(String panelName) {
        mainPanelLayout.show(mainPanel, panelName);
    }

    /**
     * Sets the main frame visible.
     */
    public void setVisible() {
        mainFrame.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2);
    }
}
