package ViewModel;

import View.GUI;
import View.Instructions;
import View.MainMenu;
import ViewModel.util.GUIPanelController;

public class InstructionsViewModel implements GUIPanelController {
    /**
     * Default constructor setting up the actions for the instruction page.
     */
    public InstructionsViewModel() {
        setBackButton();
        addPanelToGUI();
    }

    /**
     * Adds the associated view to the main frame.
     */
    @Override
    public void addPanelToGUI() {
        Instructions instructions = Instructions.getInstance();
        GUI.getInstance().addPanel(instructions.getPanel(), instructions.getName());
    }

    /**
     * Add action listener to back button.
     */
    private void setBackButton() {
        Instructions.getInstance().getBackButton().addActionListener(e -> {
            GUI gui = GUI.getInstance();
            MainMenu mainMenu = MainMenu.getInstance();
            gui.showPanel(mainMenu.getName());
        });
    }
}
