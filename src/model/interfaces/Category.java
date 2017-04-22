package model.interfaces;

import java.util.UUID;

import model.CategoriesStatus;

/**
 * The interface of a single Category.
 *
 */
public interface Category {

    /**
     * @param dressId
     *        the id of a dress
     *
     * @return the dress if present
     */
    Dress getDress(UUID dressId);

    /**
     * @param dressId
     *        the id of a dress
     *
     * @return the result of removing a dress. Throws IllegalArgumentException if dress is not present.
     */
    CategoriesStatus removeDress(UUID dressId);

    /**
     * @param dress
     *        the dress Object
     *
     * @return the result of adding a dress.
     */
    CategoriesStatus addDress(Dress dress);

}
