package Model;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

/**
 * Hole model object.
 *
 * The data for the games holes. This stores a number of korgools and also has a possible tuz state.
 */
public class KorgoolHole extends KorgoolContainer {
    private int id;

    private boolean tuz;
    private transient PublishSubject<Boolean> tuzSubject = PublishSubject.create();

    /**
     * Default constructor.
     *
     * Used for initialising holes in a new game.
     */
    public KorgoolHole(int id) {
        this(9, id, false);
    }

    /**
     * Auxiliary constructor.
     *
     * Used for initialising a hole from a load game, specifying its state.
     *
     * @param numberOfKorgools initial number of korgools in this hole
     * @param tuz true if this hole is in a tuz state
     */
    public KorgoolHole(int numberOfKorgools, int id, boolean tuz) {
        super(numberOfKorgools);
        this.id = id;
        this.tuz = tuz;
    }

    /**
     * Returns whether this hole is in a tuz state or not.
     *
     * @return true if this hole is in a tuz state
     */
    public boolean isTuz() {
        return tuz;
    }

    /**
     * Sets korgoolhole as tuz.
     */
    public void setTuz() {
        tuzSubject.onNext(tuz = true);
    }

    /**
     * @return int id of korgool hole.
     */
    public int getId() {
        return id;
    }

    /**
     * Increase the number of korgools in this container by one.
     */
    public void incrementNumberOfKorgools() {
        super.addKorgools(1);
    }

    /**
     * Sets the numbers of korgools to one.
     */
    public void setNumberOfKorgoolsToOne() {
        super.setNumberOfKorgools(1);
    }

    /**
     * Sets the numbers of korgools to zero.
     */
    public void clearKorgools() {
        super.setNumberOfKorgools(0);
    }

    /**
     * Allows subscription to the Tuz value.
     *
     * @param onNext lambda function to be executed on setting tuz.
     */
    public void subscribeToTuz(Consumer onNext) {
        tuzSubject.subscribe(onNext);
    }

    /**
     * Re-initialises the tuzSubject.
     */
    public void reInitTuzSubject() {
        tuzSubject = PublishSubject.create();
    }

    /**
     * @return String representation of korgool hole.
     */
    @Override
    public String toString() {
        return "[Korgool Hole " + id + ": " + getNumberOfKorgools() +  "]";
    }
}
