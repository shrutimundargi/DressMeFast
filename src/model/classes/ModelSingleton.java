package model.classes;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ModelSingleton {

    private static class SafeSingleton {
        private static final ModelSingleton SINGLETON = new ModelSingleton();
    }

    private Set<UUID> idSet;

    private ModelSingleton() {
        this.idSet = new HashSet<>();
    }

    public static ModelSingleton getInstance() {
        return SafeSingleton.SINGLETON;
    }

    public Set<UUID> getIdSet() {
        return this.idSet;
    }

}
