package model.classes;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import model.interfaces.Dress;
import model.interfaces.User;

/**
 * A singleton class.
 *
 */

public final class ModelSingleton {

    private Set<User> userSet;
    private final Queue<Dress> dressQueue;

    private static class SafeSingleton {
        private static final ModelSingleton SINGLETON = new ModelSingleton();
    }

    private ModelSingleton() {
        this.userSet = new HashSet<>();
        this.dressQueue = new LinkedList<Dress>();
    }

    /**
     * @return the singleton.
     */
    public static ModelSingleton getInstance() {
        return SafeSingleton.SINGLETON;
    }


    /**
     * @return the set containing all the users stored.
     */
    public Set<User> getUserSet() {
        return this.userSet;
    }

    /**
     * @return the queue containing the last dresses stored.
     */
    public Queue<Dress> getDressQueue() {
        return this.dressQueue;
    }

    /**
     * @param userSet
     *            a container with all the users.
     * 
     */
    public void setUsers(final Set<User> userSet) {
        this.userSet = userSet;
    }
}
