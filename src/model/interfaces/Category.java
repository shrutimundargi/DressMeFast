package model.interfaces;

import java.util.Map;
import java.util.UUID;

import model.Categories;
import model.Status;

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
     * @return the result of adding a dress.
     */
    Status addDress(Dress dress);

    /**
     * @return all the dresses of the category.
     */
    Map<UUID, Dress> getAllDresses();

}
