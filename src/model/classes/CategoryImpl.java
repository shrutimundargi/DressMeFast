package model.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import model.enumerations.Status;
import model.interfaces.Category;
import model.interfaces.Dress;

/**
 * Class used to manage a particular Category.
 *
 */
public class CategoryImpl extends CategoryManagementImpl implements Category {

    private final Map<UUID, Dress> map;

    /**
     * Creates a new category.
     */
    public CategoryImpl() {
        this.map = new HashMap<UUID, Dress>();
    }

    @Override
    public Dress getDress(final UUID dressId) {
        return this.map.get(dressId);
    }

    @Override
    public Status removeDress(final UUID dressId) {
        this.checkDressPresence(dressId);
        this.getIdSet().remove(dressId);
        this.map.remove(dressId);
        return Status.DRESS_REMOVED;
    }

    @Override
    public Status addDress(final Dress dress) {
        final UUID id = dress.getId();
        if (!this.map.containsKey(id)) {
            this.map.put(id, dress);
            this.getIdSet().add(id);
            System.out.println(Status.DRESS_ADDED.getText());
            return Status.DRESS_ADDED;
        }
        System.out.println(Status.DRESS_NOT_ADDED.getText());
        return Status.ID_ALREADY_EXISTS;

    }

    private void checkDressPresence(final UUID id) {
        if (!this.getIdSet().contains(id)) {
            throw new IllegalArgumentException("Dress not found");
        }
    }

    @Override
    public Map<UUID, Dress> getAllDresses() {
        return this.map;
    }
}
