package model.classes;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

    /**
     * 
     */
    private static final long serialVersionUID = -6804650438287633952L;
    private final Map<Category, Categories> categoryMap;
    private final Queue<Dress> dressQueue;

    /**
     * Creates the container to store all the categories and the ids of all the
     * dresses.
     */

    public CategoriesManagementImpl() {
        this.categoryMap = new HashMap<>();
        this.dressQueue = new LinkedList<Dress>();
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
        this.addDressToQueue(dress, category);
        System.out.println(this.categoryMap.get(category));
        return Status.DRESS_ADDED;
    }

    @Override
    public Status removeDressFromCategory(final Dress dress, final Category category) {
        if (!this.categoryMap.containsKey(category)) {
            return Status.DRESS_NOT_FOUND;
        }
        this.categoryMap.get(category).removeDress(dress);
        this.removeDressFromQueue(dress);
        System.out.println(this.categoryMap.get(category));
        return Status.DRESS_REMOVED;
    }

    @Override
    public Status modifyCategoryOfDress(final Dress dress, final Category newCategory) {
        if (newCategory.equals(Category.EMPTY) || dress.getCategoryName().equals(newCategory)) {
            return Status.DRESS_NOT_MODIFIED;
        } else {
            this.removeDressFromCategory(dress, dress.getCategoryName());
            this.addDressToCategory(dress, newCategory);
            return Status.DRESS_MODIFIED;
        }
    }

    @Override
    public Map<Category, Categories> getAllCategories() {
        return this.categoryMap;
    }

    @Override
    public List<Dress> getAllDresses() {
        final List<Dress> tmpList = new LinkedList<Dress>();
        this.categoryMap.values().forEach(category -> {
            category.getAllDresses().values().forEach(dress -> {
                tmpList.add(dress);
            });
        });
        return Collections.unmodifiableList(tmpList);

    }

    @Override
    public Queue<Dress> getLastDressesAdded() {
        return this.dressQueue;
    }

    @Override
    public Status addDressToQueue(final Dress dress, final Category category) {
        if (this.dressQueue.size() < 4) {
            dress.setCategoryName(category);
            this.dressQueue.add(dress);
            return Status.DRESS_ADDED;
        } else {
            dress.setCategoryName(category);
            this.dressQueue.remove();
            this.dressQueue.add(dress);
            return Status.DRESS_ADDED;
        }
    }

    @Override
    public Status removeDressFromQueue(final Dress dress) {
        this.dressQueue.remove(dress);
        return Status.DRESS_REMOVED;
    }

    @Override
    public String toString() {
        return "CategoriesManagementImpl [categoryMap=" + categoryMap + ", dressQueue=" + dressQueue + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((categoryMap == null) ? 0 : categoryMap.hashCode());
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
        if (!(obj instanceof CategoriesManagementImpl)) {
            return false;
        }
        CategoriesManagementImpl other = (CategoriesManagementImpl) obj;
        if (categoryMap == null) {
            if (other.categoryMap != null) {
                return false;
            }
        } else if (!categoryMap.equals(other.categoryMap)) {
            return false;
        }
        return true;
    }

}
