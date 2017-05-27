package model.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;

import model.enumerations.Category;

/**
 * This interface is used to manage a user's wardrobe.
 *
 */

public interface Wardrobe extends Serializable {

    /**
     * @return all the categories objects.
     */
    CategoriesManagement getCategories();

    /**
     * @return all the outfits objects.
     */
    OutfitsManagement getOutfits();

    /**
     * @return the number of the dresses stored.
     */
    int countDresses();

    /**
     * @return the number of the outfits stored.
     */
    int countOutfits();

    /**
     * @return the brand name with the most occurrences.
     */
    String getMostPopularBrand();

    /**
     * @return all the brands of all the dresses.
     */
    Set<String> getAllBrands();

    /**
     * @param brand
     *            the brand of a dress.
     *
     * @return all the dresses with the specified brand (if present).
     */
    Set<Dress> getDressesOfBrand(String brand);

    /**
     * @return all the sizes of all the dresses.
     */
    Set<Integer> getAllSizes();

    /**
     * @return all the preferred dresses.
     */
    Set<Dress> getFavouritedDresses();

    /**
     * @param size
     *            the size of the dresses to find.
     * 
     * @return all the dresses with the specified size.
     */
    Set<Dress> getDressesOfSize(int size);

    /**
     * @return the last added dresses.
     */
    Queue<Dress> getLastAddedDresses();

    /**
     * @param category
     *            a particular category.
     * 
     * @return a container with all the brands of the dresses inside the
     *         specified category.
     */
    List<String> getBrandsOfCategory(Category category);

    /**
     * @param category
     *            a particular category.
     * 
     * @param brand
     *            a particular brand.
     * 
     * @return a container with all the dresses of the specified category and
     *         brand.
     */
    List<Dress> getDressesOfBrandAndCategory(Category category, String brand);

    /**
     * @param category
     *            a particular category.
     * 
     * @return a container with all the sizes of the dresses inside the
     *         specified category.
     */
    List<Integer> getSizesOfCategory(Category category);

    /**
     * @param category
     *            a particular category.
     * 
     * @param size
     *            a particular size.
     * 
     * @return a container with all the dresses of the specified category and
     *         size.
     */
    List<Dress> getDressesOfSizeAndCategory(Category category, int size);

    /**
     * @param category
     *            a particular category.
     * 
     * @return a container with all the dresses of a particular category.
     */
    List<Dress> getDressesOfCategory(Category category);

    /**
     * @param dressId
     *            the id of a dress.
     * 
     * @return the dress associated with the specified id.
     */
    Dress getDressOfId(UUID dressId);
}
