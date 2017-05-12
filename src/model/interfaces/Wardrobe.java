package model.interfaces;

import java.io.Serializable;
import java.util.Queue;
import java.util.Set;

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
     *        the brand of a dress.
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

    /**@param size
     *        the size of the dresses to find. 
     * 
     * @return all the dresses with the specified size.
     */
    Set<Dress> getDressesOfSize(int size);

    /**
     * @return the last added dresses.
     */
    Queue<Dress> getLastAddedDresses();
}
