package model.interfaces;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

import model.enumerations.Category;
import model.enumerations.Status;

/**
 * The interface of a single Category.
 *
 */
public interface Categories extends Serializable {

    /**
     * @param dressId
     *        the id of a dress
     *
     * @return the dress if present.
     */
    Dress getDress(UUID dressId);

    /**
     * @param dress
     *        a particular dress.
     *
     * @return the result of removing a dress.
     */
    Status removeDress(Dress dress);

    /**
     * @param dress
     *        the dress Object
     * 
     * @param categoryName
     *        the name of the category in which store the dress.
     *
     * @return the result of adding a dress.
     */
    Status addDress(Dress dress, Category categoryName);

    /**
     * @return all the dresses of the category.
     */
    Map<UUID, Dress> getAllDresses();

}
