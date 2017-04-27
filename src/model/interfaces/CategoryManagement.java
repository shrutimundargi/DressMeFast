package model.interfaces;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

import model.enumerations.Categories;
import model.enumerations.Status;

/**
 * This interface is used to manage a multitude of categories.
 *
 */
/**
 *
 */
public interface CategoryManagement {

    /**
     * This method starts the initialization of the default categories. 
     */
    Status initializeAllCategories();

    /**
     * @param category
     *        the name of the category in the enumeration "Categories".
     *
     * @return the object category pointed by its name. 
     */
    Category getCategory(Categories category);

    /**
     * @param dress
     *        a dress object.
     *
     * @param category
     *        a category name in the enumeration "Categories".
     *
     * @return the result of adding a dress object to the specified category.
     */
    Status addDressToCategory(Dress dress, Categories category);

    /**
     * @return the set with the ids of all the dresses inside all categories.
     */
    Set<UUID> getIdSet();

    /**
     * @return the map which contains the default categories.
     */
    Map<Categories, Category> getAllCategories();

}
