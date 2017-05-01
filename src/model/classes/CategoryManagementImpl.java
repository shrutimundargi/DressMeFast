package model.classes;

import java.util.HashMap;
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

    private final Map<Categories, Category> categoryMap;

    /**
     * Creates the container to store all the categories and the ids of all the
     * dresses.
     */
    public CategoryManagementImpl() {
        this.categoryMap = new HashMap<>();
    }

    @Override
    public Status initializeAllCategories() {
        if (!this.categoryMap.isEmpty()) {
            return Status.CATEGORIES_ALREADY_INITIALIZED;
        }
        Categories[] categoriesList = Categories.values();
        for (int i = 0; i < categoriesList.length; i++) {
            this.categoryMap.put(categoriesList[i], new CategoryImpl());
        }
        System.out.println(this.categoryMap.toString());
        return Status.CATEGORIES_INITIALIZED;
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
        System.out.println(this.categoryMap.get(category));
        return Status.DRESS_ADDED;
    }

    @Override
    public Set<UUID> getIdSet() {
        return ModelSingleton.getInstance().getIdSet();
    }

    @Override
    public Map<Categories, Category> getAllCategories() {
        return this.categoryMap;
    }

}
