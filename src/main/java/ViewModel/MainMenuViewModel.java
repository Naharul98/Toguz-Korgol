package ViewModel;

import Model.Board;
import View.*;
import ViewModel.util.GUIPanelController;
import util.Constants;

import javax.swing.*;
import java.io.*;

public class MainMenuViewModel implements GUIPanelController {
    /**
     * Default constructor setting up the actions for the main menu.
     */
    public MainMenuViewModel() {
        setNewGameButton();
        setCustomGameButton();
        setInstructionsButton();
        setLoadGameButton();
    }

    /**
     * Adds the associated view to the main frame.
     */
    @Override
    public void addPanelToGUI() {
        MainMenu mainMenu = MainMenu.getInstance();
        GUI.getInstance().addPanel(mainMenu.getPanel(), mainMenu.getName());
    }

    /**
     * Adds action listener to new game button.
     */
    private void setNewGameButton() {
        MainMenu.getInstance().getNewGameButton().addActionListener(e -> {
            GUI gui = GUI.getInstance();
            new NewGameViewModel();
            NewGame newGame = NewGame.getInstance();
            gui.showPanel(newGame.getName());
        });
    }

    /**
     * Adds action listener to custom game button.
     */
    private void setCustomGameButton() {
        MainMenu.getInstance().getCustomGameButton().addActionListener(e -> {
            GUI gui = GUI.getInstance();
            CustomGame customGame = CustomGame.getInstance();
            gui.showPanel(customGame.getName());
        });
    }

    /**
     * Adds action listener to instructions button.
     */
    private void setInstructionsButton() {
        MainMenu.getInstance().getInstructionsButton().addActionListener(e -> {
            GUI gui = GUI.getInstance();
            Instructions instructions = Instructions.getInstance();
            gui.showPanel(instructions.getName());
        });
    }

    /**
     * Loads from a saved state. If none exists it will show an error message.
     */
    private void setLoadGameButton() {
        MainMenu.getInstance().getLoadGameButton().addActionListener(e -> {
            File FULL_DIRECTORY = Constants.FULL_DIRECTORY;
            File GAME_SAVE_FILE = Constants.GAME_SAVE_FILE;

            if (!FULL_DIRECTORY.exists()) {
                JOptionPane.showMessageDialog(MainMenu.getInstance().getPanel(), "No save game found!",
                        "Load Game Error!", JOptionPane.ERROR_MESSAGE);
            } else {
                try (ObjectInputStream objectRead = new ObjectInputStream(new FileInputStream(GAME_SAVE_FILE))) {
                    Board loadBoard = (Board) objectRead.readObject();
                    loadBoard.reInit();

                    GUI gui = GUI.getInstance();
                    new NewGameViewModel(loadBoard);
                    NewGame newGame = NewGame.getInstance();
                    gui.showPanel(newGame.getName());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
