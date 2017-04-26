package model.classes;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import model.enumerations.Categories;
import model.enumerations.Status;
import model.interfaces.Category;
import model.interfaces.CategoryManagement;
import model.interfaces.Dress;

/**
 * The class used to manage a multitude of categories.
 *
 */
public class CategoryManagementImpl implements CategoryManagement {

    private Map<Categories, Category> categoryMap;
    private Set<UUID> idSet;

    /**
     * Creates the container to store all the categories and the ids of all the dresses.
     */
    public CategoryManagementImpl() {
        this.categoryMap = new EnumMap<>(Categories.class);
        this.idSet = new HashSet<>();
    }

    @Override
    public void initializeAllCategories() {
        for (Categories categoryName : Categories.values()) {
            this.categoryMap.put(categoryName, new CategoryImpl());
        }
        System.out.println(this.categoryMap.toString());
    }

    @Override
    public Category getCategory(final Categories category) {
        return this.categoryMap.get(category);
    }

    @Override
    public Status addDressToCategory(final Dress dress, final Categories category) {
        if (!this.categoryMap.containsKey(category)) {
            return Status.DRESS_NOT_ADDED;
        }
        this.categoryMap.get(category).addDress(dress);
        return Status.DRESS_ADDED;
    }

    @Override
    public Set<UUID> getIdSet() {
        return this.idSet;
    }

    @Override
    public Map<Categories, Category> getAllCategories() {
        return this.categoryMap;
    }

}
