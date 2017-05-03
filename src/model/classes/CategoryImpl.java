package model.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import model.enumerations.Categories;
import model.enumerations.Status;
import model.interfaces.Category;
import model.interfaces.Dress;

/**
 * Class used to manage a particular Category.
 *
 */
public class CategoryImpl implements Category {

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
        // this.getIdSet().remove(dressId);
        this.removeDressFromSet(this.map.get(dressId));
        this.map.remove(dressId);
        System.out.println(Status.DRESS_REMOVED.getText());
        return Status.DRESS_REMOVED;
    }

    @Override
    public Status addDress(final Dress dress, final Categories categoryName) {
        final UUID id = dress.getId();
        if (!this.map.containsKey(id)) {
            dress.setCategoryName(categoryName);
            this.map.put(id, dress);
            // this.getIdSet().add(id);
            this.addDressToSet(dress);
            // System.out.println(this.getIdSet().size());
            System.out.println(ModelSingleton.getInstance().getDressSet().size());
            System.out.println(Status.DRESS_ADDED.getText());
            return Status.DRESS_ADDED;
        }
        System.out.println(Status.DRESS_NOT_ADDED.getText());
        return Status.ID_ALREADY_EXISTS;

    }

    private Status checkDressPresence(final UUID id) {
        for (final Dress dress : ModelSingleton.getInstance().getDressSet()) {
            if ((dress.getId().equals(id))) {
                return Status.DRESS_FOUND;
            }
        }
        throw new IllegalArgumentException("Dress not found");
    }

    @Override
    public Map<UUID, Dress> getAllDresses() {
        return this.map;
    }

    @Override
    public String toString() {
        return "CategoryImpl [map=" + map + ", toString()=" + super.toString() + "]";
    }

    private void addDressToSet(final Dress dress) {
        ModelSingleton.getInstance().getDressSet().add(dress);
    }

    private void removeDressFromSet(final Dress dress) {
        ModelSingleton.getInstance().getDressSet().remove(dress);
    }
}
