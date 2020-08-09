package Model;

import Model.util.PlayerType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Board model object.
 * <p>
 * Contains all the information of the game board. This class is acted upon by the ViewModel.
 */
public class Board implements Serializable {
    /**
     * Builder to enable easy construction of custom objects.
     */
    public static class Builder {
        private int personTuz = -1,
                aiTuz = -1,
                personKazaanScore = 0,
                aiKazaanScore = 0;

        public Builder setPersonTuz(int playerTuzIndex) {
            this.personTuz = playerTuzIndex;
            return this;
        }

        public Builder setAiTuz(int opponentTuzIndex) {
            this.aiTuz = opponentTuzIndex;
            return this;
        }

        public Builder setPersonKazaanScore(int kazaanScore) {
            this.personKazaanScore = kazaanScore;
            return this;
        }

        public Builder setAiKazaanScore(int kazaanScore) {
            this.aiKazaanScore = kazaanScore;
            return this;
        }

        public Board build() {
            List<Integer> korgoolCount = new ArrayList<>(18);
            for (int i=0; i <= 17; i++) {
                korgoolCount.add(9);
            }
            return build(korgoolCount);
        }

        public Board build(List<Integer> korgoolCount) {
            Board board = new Board();
            board.personKazaan = new Kazaan(personKazaanScore);
            board.aiKazaan = new Kazaan(aiKazaanScore);
            board.korgoolHoles = new KorgoolHoleArray.Builder()
                    .setPersonTuz(personTuz)
                    .setAiTuz(aiTuz)
                    .build(korgoolCount);

            return board;
        }
    }

    private Kazaan personKazaan, aiKazaan;
    private KorgoolHoleArray korgoolHoles;

    /**
     * Default constructor.
     * <p>
     * Initialises the board for a new game. Kazaans and holes are initially empty.
     */
    public Board() {
        personKazaan = new Kazaan();
        aiKazaan = new Kazaan();
        korgoolHoles = new KorgoolHoleArray();
    }

    /**
     * Get the players kazaan.
     *
     * @return the players kazaan object
     */
    public Kazaan getPersonKazaan() {
        return personKazaan;
    }

    /**
     * Get the opponents kazaan.
     *
     * @return the opponents kazaan object
     */
    public Kazaan getAiKazaan() {
        return aiKazaan;
    }

    /**
     * Checks if the playerType owns a tuz.
     *
     * @param playerType Enum PlayerType
     * @return Boolean representing if the playerType has tuz.
     */
    public boolean hasTuz(PlayerType playerType) {
        switch (playerType) {
            case PERSON:
                return korgoolHoles.stream()
                        .filter(korgoolHole -> korgoolHole.getId() >= 9)
                        .anyMatch(korgoolHole -> korgoolHole.isTuz());
            case AI:
                return korgoolHoles.stream()
                        .filter(korgoolHole -> korgoolHole.getId() <= 8)
                        .anyMatch(korgoolHole -> korgoolHole.isTuz());
            default:
                return false;
        }
    }

    /**
     * Sets tuz for person.
     * @param index of tuz.
     */
    public void setPersonTuz(int index) {
        korgoolHoles.get(index).setTuz();
    }

    /**
     * Sets tuz for ai.
     * @param index of tuz.
     */
    public void setAiTuz(int index) {
        korgoolHoles.get(index).setTuz();
    }

    /**
     * Finds the posisition of the opposite playerType's
     * tuz, or -1 if none.
     * @param playerType Enum
     * @return int position of Tuz.
     */
    public int getOppositionTuz(PlayerType playerType) {
        switch (playerType) {
            case PERSON:
                return korgoolHoles.stream()
                        .filter(korgoolHole -> korgoolHole.getId() <= 8)
                        .mapToInt(korgoolHole -> korgoolHole.getId())
                        .findFirst()
                        .getAsInt();
            case AI:
                return korgoolHoles.stream()
                        .filter(korgoolHole -> korgoolHole.getId() >= 9)
                        .mapToInt(korgoolHole -> korgoolHole.getId())
                        .findFirst()
                        .getAsInt();
            default:
                return -1;
        }
    }

    /**
     * Get the board KorgoolHoleArray.
     *
     * @return the array of holes in the board
     */
    public List<KorgoolHole> getKorgoolHoles() {
        return korgoolHoles;
    }

    /**
     *
     * @param holeIndex
     * @return
     */
    public KorgoolHole getKorgoolHole(int holeIndex) {
        return korgoolHoles.get(holeIndex);
    }

    /**
     * Re-initialises the unserializable variables.
     */
    public void reInit() {
        personKazaan.reInitKorgoolsSubject();
        aiKazaan.reInitKorgoolsSubject();
        korgoolHoles.forEach(e -> {
            e.reInitKorgoolsSubject();
            e.reInitTuzSubject();
        });
    }
}
