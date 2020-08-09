package Model;

import Model.util.PlayerType;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/**
 * The controller for the game data.
 *
 * This class will call methods upon the board and manipulate the game state. These methods represents the actions
 * the player can make within the game.
 */
public class Game {
    private int position;
    private Board board;
    private String gameOver = null;
    private PublishSubject<String> gameOverSubject = PublishSubject.create();

    /**
     * Default constructor.
     *
     * @param board the object representing the game state
     */
    public Game(Board board) {
        this.board = board;
    }

    /**
     * Performs a move for the player collecting korgools into their kazaan
     * as necessary.
     */
    public void personMove(int index) {
        position = index;
        move();

        if (isOnAiPosition()) {
            int korgoolsInHole = board.getKorgoolHole(position).getNumberOfKorgools();
            if (korgoolsInHole % 2 == 0) {
                board.getKorgoolHole(position).clearKorgools();
                board.getPersonKazaan().addKorgools(korgoolsInHole);
            } else if (korgoolsInHole == 3) {
                if(canCaptureTuz(PlayerType.PERSON)) {
                    board.setPersonTuz(position);
                    board.getKorgoolHole(position).clearKorgools();
                    board.getPersonKazaan().addKorgools(korgoolsInHole);
                }
            }
        }

        checkGameEnd();
    }

    /**
     * Performs a move for the ai collecting korgools into its kazaan
     * as necessary.
     */
    public void aiMove(int index) {
        position = index;
        move();

        if (isOnPersonPosition()) {
            int korgoolsInHole = board.getKorgoolHole(position).getNumberOfKorgools();

            if (korgoolsInHole % 2 == 0) {
                board.getKorgoolHole(position).clearKorgools();
                board.getAiKazaan().addKorgools(korgoolsInHole);
            } else if (korgoolsInHole == 3) {
                if(canCaptureTuz(PlayerType.AI)) {
                    board.setAiTuz(position);
                    board.getKorgoolHole(position).clearKorgools();
                    board.getAiKazaan().addKorgools(korgoolsInHole);
                }
            }
        }

        checkGameEnd();
    }

    /**
     * Makes a move in the game, redistributing korgools to other holes.
     */
    private void move() {
        if (position < 0 || position > 17) {
            return;
        }

        int korgoolsInHole = board.getKorgoolHole(position).getNumberOfKorgools();

        if(korgoolsInHole == 1) {
            board.getKorgoolHole(position).clearKorgools();
            KorgoolHole korgoolHole = board.getKorgoolHole(incrementPosition());
            if (korgoolHole.isTuz()) {
                if (position >= 0 && position <= 7) {
                    board.getAiKazaan().addKorgools(1);
                } else {
                    board.getPersonKazaan().addKorgools(1);
                }
            } else {
                korgoolHole.incrementNumberOfKorgools();
            }
        } else {
            board.getKorgoolHole(position).setNumberOfKorgoolsToOne();
            while(korgoolsInHole > 1) {
                KorgoolHole korgoolHole = board.getKorgoolHole(incrementPosition());
                if (korgoolHole.isTuz()) {
                    if (position >= 0 && position <= 7) {
                        board.getAiKazaan().addKorgools(1);
                    } else {
                        board.getPersonKazaan().addKorgools(1);
                    }
                    korgoolHole.clearKorgools();
                } else {
                    korgoolHole.incrementNumberOfKorgools();
                }
                korgoolsInHole--;
            }
        }
    }

    /**
     * @return Boolean whether the current position belongs to person.
     */
    private boolean isOnPersonPosition() {
        return (position >= 0 && position <= 8);
    }

    /**
     * @return Boolean whether the current position belongs to ai.
     */
    private boolean isOnAiPosition() {
        return (position >= 9 && position <= 17);
    }

    /**
     * Performs all conditional checks to see if the playerType can capture
     * the current position of tuz.
     *
     * @param playerType Enum player
     * @return Boolean representing if the tuz can be captured.
     */
    private boolean canCaptureTuz(PlayerType playerType) {
        if (board.hasTuz(playerType)) {
            return false;
        }

        if (position == 8 || position == 17) {
            return false;
        }

        if (board.getOppositionTuz(playerType) % 9 == position % 9) {
            return false;
        }

        return true;
    }

    /**
     * Check if the game has ended, pushing the status of the game
     * if has ended to the view.
     */
    private void checkGameEnd() {
        if (checkPersonWin()) {
            gameOverSubject.onNext(gameOver ="PERSON");
        } else if (checkAiWin()) {
            gameOverSubject.onNext(gameOver = "AI");
        } else if (checkDraw()) {
            gameOverSubject.onNext(gameOver = "DRAW");
        }
    }

    /**
     * Checks if the player has won.
     *
     * @return if the player has one or not
     */
    private boolean checkPersonWin() {
        return board.getPersonKazaan().getNumberOfKorgools() >= 82;
    }

    /**
     * Checks if the opponent has won.
     *
     * @return if the opponent has one or not
     */
    private boolean checkAiWin() {
        return board.getAiKazaan().getNumberOfKorgools() >= 82;
    }

    /**
     * Checks whether the game has reached a draw state
     *
     * @return if the game is a draw
     */
    private boolean checkDraw() {
        int playerKorgools = board.getPersonKazaan().getNumberOfKorgools(),
            opponentKorgools = board.getAiKazaan().getNumberOfKorgools();
        return (playerKorgools == 81 && opponentKorgools == 81);
    }

    /**
     * Auxiliary function to ensure when the position is incremeted
     * it is always within the board limits.
     *
     * @return KorgoleHole index.
     */
    private int incrementPosition() {
        return position = ++position % 18;
    }

    /**
     * @return String representing the winner of the game.
     */
    public String getGameOver() {
        return gameOver;
    }

    /**
     * Allows subscription to gameOver value.
     *
     * @param onNext lambda function to be executed on change of gameOver.
     */
    public void subscribeToGameOver(Consumer onNext) {
        gameOverSubject.subscribe(onNext);
    }
}
