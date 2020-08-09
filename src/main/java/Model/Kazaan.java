package Model;

/**
 * Kazaan model object.
 *
 * The data of the games kazaans. This can only store korgools.
 */
public class Kazaan extends KorgoolContainer {

    /**
     * Default constructor.
     *
     * Initialises kazaan with zero korgools (for example, for the beginning of a game).
     */
    public Kazaan() {
        this(0);
    }

    /**
     * Constructor for initialising a kazaan with a non-zero amount of korgools.
     *
     * Used, for example, when loading a game.
     *
     * @param numberOfKorgools the number of korgools to initialise the kazaan with
     */
    public Kazaan(int numberOfKorgools) {
        super(numberOfKorgools);
    }
}
