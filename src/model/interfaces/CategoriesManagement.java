package model.interfaces;

import java.util.List;
import java.util.Map;
import java.util.Queue;

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
     * @return the result of the initialization.
     */
    Status initializeAllCategories();

    /**
     * @param category
     *            the name of the category in the enumeration "Categories".
     *
     * @return the object category pointed by its name.
     */
    Categories getCategory(Category category);

    /**
     * @param dress
     *            a dress object.
     *
     * @param category
     *            a category name.
     *
     * @return the result of adding a dress object to the specified category.
     */
    Status addDressToCategory(Dress dress, Category category);

    /**
     * @param dress
     *            a dress object.
     * 
     * @param category
     *            a category name.
     * 
     * @return the result of removing a dress object from the specified
     *         category.
     */
    Status removeDressFromCategory(Dress dress, Category category);

    /**
     * @param dress
     *            a dress object.
     * 
     * @param newCategory
     *            the name of the new category.
     * 
     * @return the result of modifying a category of a dress.
     */
    Status modifyCategoryOfDress(Dress dress, Category newCategory);

    /**
     * @return the map which contains the default categories.
     */
    Map<Category, Categories> getAllCategories();

    /**
     * @return a container with all the dresses.
     */
    List<Dress> getAllDresses();

    /**
     * @return the container with the last dresses added.
     */
    Queue<Dress> getLastDressesAdded();

    /**
     * @param dress
     *            a dress object.
     * 
     * @param category
     *            a category name.
     * 
     * @return the result of the operation.
     */
    Status addDressToQueue(Dress dress, Category category);

    /**
     * @param dress
     *            a dress object.
     * 
     * @return the result of the operation.
     */
    Status removeDressFromQueue(Dress dress);

}
