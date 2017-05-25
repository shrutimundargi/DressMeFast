package model.classes;

import java.util.Collections;
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

    /**
     * 
     */
    private static final long serialVersionUID = -4635854653312351505L;
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
    public Status removeDress(final Dress dress) {
        if (this.map.containsKey(dress.getId())) {
            this.map.remove(dress.getId());
            System.out.println(Status.DRESS_REMOVED.getText());
            return Status.DRESS_REMOVED;
        }
        return Status.DRESS_NOT_FOUND;
    }

    @Override
    public Status addDress(final Dress dress, final Category categoryName) {
        final UUID id = dress.getId();
        if (!this.map.containsKey(id)) {
            dress.setCategoryName(categoryName);
            this.map.put(id, dress);
            System.out.println(Status.DRESS_ADDED.getText());
            return Status.DRESS_ADDED;
        }
        System.out.println(Status.DRESS_NOT_ADDED.getText());
        return Status.DRESS_NOT_ADDED;

    }

    @Override
    public Map<UUID, Dress> getAllDresses() {
        return Collections.unmodifiableMap(this.map);
    }

    @Override
    public String toString() {
        return "CategoryImpl [map=" + map + ", toString()=" + super.toString() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((map == null) ? 0 : map.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CategoriesImpl)) {
            return false;
        }
        final CategoriesImpl other = (CategoriesImpl) obj;
        if (map == null) {
            if (other.map != null) {
                return false;
            }
        } else if (!map.equals(other.map)) {
            return false;
        }
        return true;
    }

}
