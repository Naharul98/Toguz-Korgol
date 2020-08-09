package ViewModel;

import Model.Board;
import Model.KorgoolHole;
import View.CustomGame;
import View.GUI;
import View.MainMenu;
import View.NewGame;
import ViewModel.util.GUIPanelController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CustomGameViewModel implements GUIPanelController {
    /**
     * Default constructor setting up the actions for the custom game page.
     */
    public CustomGameViewModel() {
        addPanelToGUI();
        setSubmitButton();
        setCancelButton();
    }

    /**
     * adds the associated view to the main frame.
     */
    @Override
    public void addPanelToGUI() {
        CustomGame customGame = CustomGame.getInstance();
        GUI.getInstance().addPanel(customGame.getPanel(), customGame.getName());
    }

    /**
     * Sets the submit button functionality.
     *
     * Tests whether the given game state is valid and if so creates a new game from this state,
     * if not then an error message is given depending on the problem.
     */
    private void setSubmitButton() {
        CustomGame.getInstance().getSubmitButton().addActionListener(e -> {
            CustomGame customGame = CustomGame.getInstance();

            Integer personKazaan = (Integer) customGame.getSpinners().get(9).getValue();
            Integer aiKazaan = (Integer) customGame.getSpinners().get(19).getValue();
            int personTuz = getPlayerTuz();
            int aiTuz = getAITuz();

            Board newBoard = new Board.Builder()
                    .setPersonKazaanScore(personKazaan)
                    .setPersonTuz(personTuz)
                    .setAiKazaanScore(aiKazaan)
                    .setAiTuz(aiTuz)
                    .build(getKorgoolCount());

            if(checkKorgoolCount(newBoard) && checkTuzPositions(personTuz, aiTuz)
                    && checkPlayerTuzCount(newBoard) && checkAITuzCount(newBoard)) {
                GUI gui = GUI.getInstance();
                new NewGameViewModel(newBoard);
                NewGame newGame = NewGame.getInstance();
                gui.showPanel(newGame.getName());
            }
        });
    }

    /**
     * Add action listener to cancel button.
     */
    private void setCancelButton() {
        CustomGame.getInstance().getCancelButton().addActionListener(e -> {
            GUI gui = GUI.getInstance();
            MainMenu mainMenu = MainMenu.getInstance();
            gui.showPanel(mainMenu.getName());
        });
    }

    /**
     * Gets a collection containing the number of korgools in each hole
     *
     * @return the collection of korgools for each hole
     */
    private List<Integer> getKorgoolCount() {
        List<Integer> korgoolCountArray = new ArrayList<>(18);
        List<JSpinner> spinners = CustomGame.getInstance().getSpinners();

        for(int i = 0; i < 9; ++i) {
            korgoolCountArray.add((Integer) spinners.get(i).getValue());
        }

        for(int i = 10; i < 19; ++i) {
            korgoolCountArray.add((Integer) spinners.get(i).getValue());
        }

        return korgoolCountArray;
    }

    /**
     * Gets the player tuz hole index (-1 if none)
     *
     * @return the player tuz hole index
     */
    private int getPlayerTuz() {
        List<JRadioButton> buttons = CustomGame.getInstance().getRadioButtons();

        if(buttons.get(0).isSelected()) {
            return -1;
        } else {
            for(int i = 1; i < 10; ++i) {
                if(buttons.get(i).isSelected()){
                    return i - 1;
                }
            }
        }
        return -1;
    }

    /**
     * Gets the ai tuz hole index (-1 if none)
     *
     * @return the ai tuz hole index
     */
    private int getAITuz() {
        List<JRadioButton> buttons = CustomGame.getInstance().getRadioButtons();

        if(buttons.get(10).isSelected()) {
            return -1;
        } else {
            for(int i = 11; i < 20; ++i) {
                if(buttons.get(i).isSelected()){
                    return i - 1;
                }
            }
        }
        return -1;
    }

    /**
     * Checks whether the player only has one or zero tuz holes
     * @param customBoard the board object being checked
     * @return if the player only has one or zero tuz holes
     */
    private boolean checkPlayerTuzCount(Board customBoard) {
        if(customBoard.getKorgoolHoles().subList(9, 9).stream()
                .filter(KorgoolHole::isTuz)
                .count() > 2) {
            JOptionPane.showMessageDialog(MainMenu.getInstance().getPanel(), "Incorrect number of player tuz holes!",
                    "Custom Game Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Checks whether the ai only has one or zero tuz holes
     *
     * @param customBoard the board object being checked
     * @return if the ai only has one or zero tuz holes
     */
    private boolean checkAITuzCount(Board customBoard) {
        if(customBoard.getKorgoolHoles().subList(9, 9).stream()
                .filter(KorgoolHole::isTuz)
                .count() > 2) {
            JOptionPane.showMessageDialog(MainMenu.getInstance().getPanel(), "Incorrect number of AI tuz holes!",
                    "Custom Game Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Checks whether the tuz positions of the given board are in the same position
     * @param playerTuz the position of the players tuz hole (-1 if doesnt exist)
     * @param aiTuz the position of the ai tuz hole (-1 if doesnt exist)
     * @return if the tuz positions are valid
     */
    private boolean checkTuzPositions(int playerTuz, int aiTuz) {
        if(playerTuz == aiTuz % 9 && playerTuz != -1) {
            JOptionPane.showMessageDialog(MainMenu.getInstance().getPanel(), "Incorrect tuz positions!",
                    "Custom Game Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Checks whether the board parameter has the correct number of korgools (162)
     *
     * @param customBoard the board that is being checked
     * @return if there is a valid number of korgools
     */
    private boolean checkKorgoolCount(Board customBoard) {
        int count = 0;
        for(KorgoolHole hole : customBoard.getKorgoolHoles()) {
            int add = hole.getNumberOfKorgools();
            if(add < 0) {
                return false;
            } else {
                count += hole.getNumberOfKorgools();
            }
        }

        count += customBoard.getPersonKazaan().getNumberOfKorgools();
        count += customBoard.getAiKazaan().getNumberOfKorgools();

        if(count < 162) {
            JOptionPane.showMessageDialog(MainMenu.getInstance().getPanel(), "Incorrect amount of Korgools! Only "
                            + count + ". Need " + (162 - count) + " more!", "Custom Game Error!", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if(count > 162) {
            JOptionPane.showMessageDialog(MainMenu.getInstance().getPanel(), "Incorrect amount of Korgools! You have "
                    + count + ". Remove " + (count - 162) + "!", "Custom Game Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            return true;
        }
        return false;
    }
}
