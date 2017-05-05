package model.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import model.enumerations.Category;
import model.enumerations.Status;
import model.interfaces.Categories;
import model.interfaces.Dress;

/**
 * Class used to manage a particular category.
 *
 */
public class CategoriesImpl implements Categories {

    private final Map<UUID, Dress> map;

    /**
     * Creates a new category.
     */
    public CategoriesImpl() {
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
        this.removeDressFromQueue(this.map.get(dressId));
        this.map.remove(dressId);
        System.out.println(Status.DRESS_REMOVED.getText());
        return Status.DRESS_REMOVED;
    }

    @Override
    public Status addDress(final Dress dress, final Category categoryName) {
        final UUID id = dress.getId();
        if (!this.map.containsKey(id)) {
            dress.setCategoryName(categoryName);
            this.map.put(id, dress);
            // this.getIdSet().add(id);
            this.addDressToSet(dress);
            this.addDressToQueue(dress);
            // System.out.println(this.getIdSet().size());
            System.out.println(ModelSingleton.getInstance().getDressList().size());
            System.out.println(Status.DRESS_ADDED.getText());
            return Status.DRESS_ADDED;
        }
        System.out.println(Status.DRESS_NOT_ADDED.getText());
        return Status.ID_ALREADY_EXISTS;

    }

    private Status checkDressPresence(final UUID id) {
        for (final Dress dress : ModelSingleton.getInstance().getDressList()) {
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
        ModelSingleton.getInstance().getDressList().add(dress);
    }

    private void removeDressFromSet(final Dress dress) {
        ModelSingleton.getInstance().getDressList().remove(dress);
    }

    private void addDressToQueue(final Dress dress) {
        if (ModelSingleton.getInstance().getDressQueue().size() < 4) {
            ModelSingleton.getInstance().getDressQueue().add(dress);
        } else {
            ModelSingleton.getInstance().getDressQueue().remove();
            ModelSingleton.getInstance().getDressQueue().add(dress);
        }
    }

    private void removeDressFromQueue(final Dress dress) {
        ModelSingleton.getInstance().getDressQueue().remove(dress);
    }
}
