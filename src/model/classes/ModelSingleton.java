package model.classes;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import model.interfaces.User;

/**
 * A singleton class.
 *
 */
public final class ModelSingleton {

    private final Set<UUID> idSet;
    private final Set<User> userSet;

    private static class SafeSingleton {
        private static final ModelSingleton SINGLETON = new ModelSingleton();
    }

    private ModelSingleton() {
        this.idSet = new HashSet<>();
        this.userSet = new HashSet<>();
    }

    /**
     * @return the singleton.
     */
    public static ModelSingleton getInstance() {
        return SafeSingleton.SINGLETON;
    }

    /**
     * @return the set containing all the ids of all the dresses.
     */
    public Set<UUID> getIdSet() {
        return this.idSet;
    }

    /**
     * @return the set containing all the users stored.
     */
    public Set<User> getUserSet() {
        return this.userSet;
    }

}
