package model.interfaces;

import java.util.List;
import java.util.Map;

import model.enumerations.Category;
import model.enumerations.Status;

/**
 * This interface is used to manage a multitude of categories.
 *
 */
/**
 *
 */
public interface CategoriesManagement {

    /**
     * This method starts the initialization of the default categories.
     * 
     *  @return the result of the initialization.
     */
    Status initializeAllCategories();

    /**
     * @param category
     *        the name of the category in the enumeration "Categories".
     *
     * @return the object category pointed by its name. 
     */
    Categories getCategory(Category category);

    /**
     * @param dress
     *        a dress object.
     *
     * @param category
     *        a category name in the enumeration "Categories".
     *
     * @return the result of adding a dress object to the specified category.
     */
    Status addDressToCategory(Dress dress, Category category);

    /**
     * @return the list with all the dresses stored.
     */
    List<Dress> getDressList();

    /**
     * @return the map which contains the default categories.
     */
    Map<Category, Categories> getAllCategories();

}
