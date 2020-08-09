package ViewModel;

import Model.AI;
import Model.Board;
import Model.Game;
import Model.KorgoolHole;
import View.GUI;
import View.MainMenu;
import View.NewGame;
import View.util.KazaanPanel;
import View.util.KorgoolHolePanel;
import ViewModel.util.GUIPanelController;
import org.pushingpixels.trident.Timeline;
import util.Constants;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.List;

public class NewGameViewModel implements GUIPanelController {
    private KorgoolHolePanel selectedKorgoolHole = null;
    private Board board;
    private Game game;

    /**
     * Default constructor.
     *
     * Used for starting a new game.
     */
    public NewGameViewModel() {
        this(new Board());
    }

    /**
     * Auxiliary constructor.
     *
     * Used to load the game from a previous state.
     * @param loadBoard the board state of the loaded game
     */
    public NewGameViewModel(Board loadBoard) {
        board = loadBoard;
        game = new Game(loadBoard);

        addPanelToGUI();
        setKorgoolHolesAction();
        setPerformMoveButton();
        setQuitButton();
        setSaveButton();

        connectModelToView();
    }

    /**
     * Adds the associated view to the main frame.
     */
    @Override
    public void addPanelToGUI() {
        NewGame newGame = NewGame.newInstance();
        GUI.getInstance().addPanel(newGame.getPanel(), newGame.getName());
    }


    /**
     * Add action listeners to only the players KorgoolHolePanel's
     * allow them to highlight on mouse enter etc.
     */
    private void setKorgoolHolesAction() {
        List<JPanel> korgoolHoles = NewGame.getInstance().getPlayerKorgoolHoles();
        for (int i=0; i < korgoolHoles.size(); i++) {
            KorgoolHolePanel korgoolHole = (KorgoolHolePanel) korgoolHoles.get(i);
            korgoolHole.setMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (korgoolHole.isSelected()) {
                        korgoolHole.deselect();
                        selectedKorgoolHole = null;

                        NewGame.getInstance().getPerformMoveButton().setEnabled(false);
                    } else {
                        if(selectedKorgoolHole != null) {
                            selectedKorgoolHole.deselect();
                        }
                        korgoolHole.select();
                        selectedKorgoolHole = korgoolHole;

                        NewGame.getInstance().getPerformMoveButton().setEnabled(true);
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    korgoolHole.mouseEntered();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    korgoolHole.mouseExited();
                }
            });
        }
    }

    /**
     * Add action listener to perform move button.
     */
    private void setPerformMoveButton() {
        JButton performMoveButton = NewGame.getInstance().getPerformMoveButton();
        performMoveButton.addActionListener(e -> {
            // Person Move
            selectedKorgoolHole.deselect();
            performMoveButton.setEnabled(false);

            int korgoolHoleIndex = NewGame.getInstance().getKorgoolHoles().indexOf(selectedKorgoolHole);
            game.personMove(korgoolHoleIndex);

            selectedKorgoolHole = null;


            if (game.getGameOver() != null)
            {
                return;
            }

            // AI Move
            NewGame.getInstance().getStatusLabel().setText("AI's turn ;)");
            Timer timer = new Timer(2000, e1 -> {
                game.aiMove(AI.mediumMove(board.getKorgoolHoles()));
            });
            timer.setRepeats(false);
            timer.start();

            Timer timer1 = new Timer(1000, e1 ->
                    NewGame.getInstance().getStatusLabel().setText("Your turn..."));
            timer1.setRepeats(false);
            timer1.start();
        });
    }

    /**
     * Add action listener to quit button.
     */
    private void setQuitButton() {
        NewGame.getInstance().getQuitButton().addActionListener(e -> {
            MainMenu mainMenu = MainMenu.getInstance();
            GUI.getInstance().showPanel(mainMenu.getName());
        });
    }

    /**
     * Sets the save button's functionality.
     */
    private void setSaveButton() {
        NewGame.getInstance().getSaveGameButton().addActionListener(e -> {
            final File FULL_DIRECTORY = Constants.FULL_DIRECTORY;
            final File SAVE_GAME_FILE = Constants.GAME_SAVE_FILE;

            if (!FULL_DIRECTORY.exists()) {
                FULL_DIRECTORY.mkdir();
            }

            try (ObjectOutputStream objectWrite = new ObjectOutputStream(
                    new FileOutputStream(SAVE_GAME_FILE))) {
                objectWrite.writeObject(board);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            MainMenu mainMenu = MainMenu.getInstance();
            GUI.getInstance().showPanel(mainMenu.getName());
        });
    }

    /**
     * Bind view to model, setting automatic updates as when the model changes.
     */
    private void connectModelToView() {
        for (int i=0; i<=17; i++) {

            KorgoolHolePanel korgoolHoleView = (KorgoolHolePanel) NewGame.getInstance().getKorgoolHole(i);
            KorgoolHole korgoolHoleModel = board.getKorgoolHole(i);

            korgoolHoleView.setValue(korgoolHoleModel.getNumberOfKorgools());
            if (korgoolHoleModel.isTuz()) {
                korgoolHoleView.setTuz();
            }

            korgoolHoleModel.subscribeToNumberOfKorgoolsSubject(numberOfKorgools -> {
                Timeline timeline = new Timeline(korgoolHoleView);
                timeline.addPropertyToInterpolate("value", korgoolHoleView.getValue(), numberOfKorgools);
                timeline.play();
            });

            korgoolHoleModel.subscribeToTuz(tuz -> {
                korgoolHoleView.setTuz();
            });
        }

        ((KazaanPanel) NewGame.getInstance().getOpponentKazaan()).setValue(board.getAiKazaan().getNumberOfKorgools());

        board.getAiKazaan().subscribeToNumberOfKorgoolsSubject(numberOfKorgools -> {
            ((KazaanPanel) NewGame.getInstance().getOpponentKazaan()).setValue((Integer) numberOfKorgools);
        });

        ((KazaanPanel) NewGame.getInstance().getPlayerKazaan()).setValue(board.getPersonKazaan().getNumberOfKorgools());

        board.getPersonKazaan().subscribeToNumberOfKorgoolsSubject(numberOfKorgools -> {
            ((KazaanPanel) NewGame.getInstance().getPlayerKazaan()).setValue((Integer) numberOfKorgools);
        });

        game.subscribeToGameOver(gameOver -> {
            NewGame newGame = NewGame.getInstance();

            switch (String.valueOf(gameOver)) {
                case "PERSON":
                    newGame.getStatusLabel().setText("You won!!");
                    break;
                case "AI":
                    newGame.getStatusLabel().setText("Sorry, you lost.");
                    break;
                case "DRAW":
                    newGame.getStatusLabel().setText("It's a draw.");
                    break;
            }
            NewGame.getInstance().getSaveGameButton().setEnabled(false);

            for (JPanel korgoolHolePanel: newGame.getPlayerKorgoolHoles()) {
                korgoolHolePanel.setEnabled(false);
            }
        });
    }
}
