package model.interfaces;

import java.util.Map;
import java.util.UUID;

import model.enumerations.Categories;
import model.enumerations.Status;

/**
 * The interface of a single Category.
 *
 */
public interface Category {

    /**
     * @param dressId
     *        the id of a dress
     *
     * @return the dress if present.
     */
    Dress getDress(UUID dressId);

    /**
     * @param dressId
     *        the id of a dress
     *
     * @return the result of removing a dress. Throws IllegalArgumentException if dress is not present.
     */
    Status removeDress(UUID dressId);

    /**
     * @param dress
     *        the dress Object
     * 
     * @param categoryName
     *        the name of the category in which store the dress.
     *
     * @return the result of adding a dress.
     */
    Status addDress(Dress dress, Categories categoryName);

    /**
     * @return all the dresses of the category.
     */
    Map<UUID, Dress> getAllDresses();

}
