package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Data structure for storing all the holes of the board.
 *
 * This class will act as a cyclical array where the first half corresponds to the players holes
 * and the second half corresponds to the opponents holes (chosen arbitrarily).
 */
public class KorgoolHoleArray extends ArrayList<KorgoolHole> implements Serializable {
    /**
     * Builder to enable easy construction of custom objects.
     */
    public static class Builder {
        private int personTuz = -1;
        private int aiTuz = -1;

        public Builder setPersonTuz(int playerTuzIndex) {
            this.personTuz = playerTuzIndex;
            return this;
        }

        public Builder setAiTuz(int opponentTuzIndex) {
            this.aiTuz = opponentTuzIndex;
            return this;
        }

        public KorgoolHoleArray build() {
            KorgoolHoleArray korgoolHoleArray = new KorgoolHoleArray();
            try {
                korgoolHoleArray.get(personTuz).setTuz();
            } catch (Exception e) {}
            try {
                korgoolHoleArray.get(aiTuz).setTuz();
            } catch (Exception e) {}
            return korgoolHoleArray;
        }

        public KorgoolHoleArray build(List<Integer> korgoolCount) {
            if (korgoolCount.size() != 18) {
                throw new IllegalArgumentException("korgool Count array size must be 18!");
            }
            return new KorgoolHoleArray(korgoolCount, personTuz, aiTuz);
        }
    }

    /*
    The number of holes per player
     */
    private static final int NUMBER_OF_HOLES = 9;

    /*
    The size of the hole array is the combined number of holes on the board.
     */
    private static final int LENGTH = NUMBER_OF_HOLES * 2;

    /**
     * Default constructor.
     *
     * Calls the default constructor of KorgoolHole.
     */
    public KorgoolHoleArray() {
        super(LENGTH);
        for(int i = 0; i < LENGTH; ++i) {
            this.add(new KorgoolHole(i));
        }
    }

    /**
     * Auxiliary constructor.
     *
     * Used to load a saved game state.
     *
     * @param korgoolCount an array containing the number of korgools for each hole
     * @param playerTuz integer representing the location of the players tuz or -1 if no tuz.
     * @param opponentTuz integer representing the location of the opponents tuz or -1 if no tuz.
     */
    private KorgoolHoleArray(List<Integer> korgoolCount, int playerTuz, int opponentTuz) {
        super(LENGTH);
        for(int i = 0; i < LENGTH; i++) {
            if(i == playerTuz || i == opponentTuz) {
                this.add(new KorgoolHole(korgoolCount.get(i), i, true));
            } else {
                this.add(new KorgoolHole(korgoolCount.get(i), i, false));
            }
        }
    }
}
