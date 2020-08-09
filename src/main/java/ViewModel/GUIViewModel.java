package ViewModel;

import View.GUI;
import View.MainMenu;

import javax.swing.*;

public class GUIViewModel {
    /**
     * Default constructor instantiating the man GUI, and calling all the
     * relevant ViewModel constructors setting up the view's behaviours
     * and actions. All with a thread safe method as we are using separate
     * threads between the Model and View & ViewModel
     */
    public GUIViewModel() {
        SwingUtilities.invokeLater(() -> {
            MainMenu mainMenu = MainMenu.getInstance();
            GUI gui = GUI.newInstance(mainMenu.getPanel(), mainMenu.getName());

            // ----- INSTANTIATE VIEW-MODEL's -----
            new MainMenuViewModel();
            new InstructionsViewModel();
            new NewGameViewModel();
            new CustomGameViewModel();
            // -----------------------------------

            gui.setVisible();
        });
    }
}
