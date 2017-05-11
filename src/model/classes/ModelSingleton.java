package model.classes;

import java.util.HashSet;
import java.util.Set;

import model.interfaces.User;

/**
 * A singleton class.
 *
 */

public final class ModelSingleton {

    private Set<User> userSet;

    private static class SafeSingleton {
        private static final ModelSingleton SINGLETON = new ModelSingleton();
    }

    private ModelSingleton() {
        this.userSet = new HashSet<>();
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
     * @param userSet
     *            a container with all the users.
     * 
     */
    public void setUsers(final Set<User> userSet) {
        this.userSet = userSet;
    }
}
