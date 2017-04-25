package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import model.interfaces.Category;
import model.interfaces.Dress;

/**
 * Class used to add or remove dresses to/from a particular Category.
 *
 */
public class CategoryImpl implements Category {

    private Map<UUID, Dress> map;
    private List<UUID> idList;

    /**
     * Creates a new category.
     */
    public CategoryImpl() {
        this.map = new HashMap<UUID, Dress>();
        this.idList = new LinkedList<>();
    }

    @Override
    public Dress getDress(final UUID dressId) {
        return this.map.get(dressId);
    }

    @Override
    public Status removeDress(final UUID dressId) {
        this.checkDressPresence(dressId);
        this.idList.remove(dressId);
        this.map.remove(dressId);
        return Status.DRESS_REMOVED;
    }

    @Override
    public Status addDress(final Dress dress) {
        final UUID id = dress.getId();
        if (!this.map.containsKey(id)) {
            this.map.put(id, dress);
            this.idList.add(id);
            return Status.DRESS_ADDED;
        }
        return Status.ID_ALREADY_EXISTS;

    }

    private void checkDressPresence(final UUID id) {
        if (!this.idList.contains(id)) {
            throw new IllegalArgumentException("Dress not found");
        }
    }

    @Override
    public Map<UUID, Dress> getAllDresses() {
        return this.map;
    }
}
