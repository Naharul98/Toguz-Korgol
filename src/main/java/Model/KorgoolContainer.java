package Model;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

import java.io.Serializable;

/**
 * A basic container of korgools.
 *
 * This provides the data functionality of all elements of the game that may contain a korgool.
 */
public abstract class KorgoolContainer implements Serializable {
    private int numberOfKorgools;
    private transient PublishSubject<Integer> numberOfKorgoolsSubject = PublishSubject.create();

    /**
     * Default constructor.
     *
     * @param n The number of Korgools to initialiase the Korgool hole with.
     */
    public KorgoolContainer(int n) {
        numberOfKorgools = n;
    }

    /**
     * Get the number of korgools in this container.
     *
     * @return the number of korgools in the container
     */
    public int getNumberOfKorgools() {
        return numberOfKorgools;
    }

    /**
     * Increase the number of korgools in this container by n.
     *
     * @param n int Number of korgools to add.
     */
    protected void addKorgools(int n) {
        numberOfKorgoolsSubject.onNext(numberOfKorgools += n);
    }

    /**
     * Changes to the number of korgools to n.
     *
     * @param n int Number of korgool to set this to.
     */
    protected void setNumberOfKorgools(int n) {
        numberOfKorgoolsSubject.onNext(numberOfKorgools = n);
    }

    /**
     * Allows subscription to the number of korgools.
     *
     * @param onNext lambda function to be executed on changing the number of korgools.
     */
    public void subscribeToNumberOfKorgoolsSubject(Consumer onNext) {
        numberOfKorgoolsSubject.subscribe(onNext);
    }

    /**
     * Re-initialises the numberOfKorgoolsSubject.
     */
    public void reInitKorgoolsSubject() {
        numberOfKorgoolsSubject = PublishSubject.create();
    }
}
