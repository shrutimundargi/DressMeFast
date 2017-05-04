package model.classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import model.enumerations.Category;
import model.enumerations.Status;
import model.interfaces.Categories;
import model.interfaces.CategoriesManagement;
import model.interfaces.Dress;

/**
 * The class used to manage a multitude of categories.
 *
 */
public class CategoriesManagementImpl implements CategoriesManagement {

    private final Map<Category, Categories> categoryMap;

    /**
     * Creates the container to store all the categories and the ids of all the
     * dresses.
     */
    public CategoriesManagementImpl() {
        this.categoryMap = new HashMap<>();
    }

    @Override
    public Status initializeAllCategories() {
        if (!this.categoryMap.isEmpty()) {
            return Status.CATEGORIES_ALREADY_INITIALIZED;
        }
        this.categoryMap.put(Category.HEAD, new CategoriesImpl());
        this.categoryMap.put(Category.NECK, new CategoriesImpl());
        this.categoryMap.put(Category.HANDS, new CategoriesImpl());
        this.categoryMap.put(Category.BODY, new CategoriesImpl());
        this.categoryMap.put(Category.LEGS, new CategoriesImpl());
        this.categoryMap.put(Category.FOOT, new CategoriesImpl());
        System.out.println(this.categoryMap.toString());
        return Status.CATEGORIES_INITIALIZED;
    }

    @Override
    public Categories getCategory(final Category category) {
        return this.categoryMap.get(category);
    }

    @Override
    public Status addDressToCategory(final Dress dress, final Category category) {
        if (!this.categoryMap.containsKey(category)) {
            return Status.DRESS_NOT_ADDED;
        }
        this.categoryMap.get(category).addDress(dress, category);
        System.out.println(this.categoryMap.get(category));
        return Status.DRESS_ADDED;
    }

    @Override
    public Set<Dress> getDressSet() {
        return ModelSingleton.getInstance().getDressSet();
    }

    @Override
    public Map<Category, Categories> getAllCategories() {
        return this.categoryMap;
    }

}
