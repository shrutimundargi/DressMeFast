package model.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import model.enumerations.Category;
import model.enumerations.Outfit;
import model.enumerations.Status;

/**
 * The interface of a single outfit. In this case, an outfit is represented by a
 * multitude of dresses and it's divided in two types: user created and AI
 * created.
 *
 */
public interface Outfits extends Serializable {

    /**
     * @return the id of an outfit.
     */
    UUID getId();

    /**
     * @return an outfit.
     */
    List<UUID> getOutfit();

    /**
     * @return the name of an outfit.
     */
    String getName();

    /**
     * @return how many times an outfit was worn.
     */
    Integer getWornCount();

    /**
     * @return the outfit's type.
     */
    Outfit getOutfitType();

    /**
     * @param dressList
     *            a container with some dresses.
     *
     * @return a new outfit.
     */
    Outfits createOutfit(List<UUID> dressList);

    /**
     * @param categoryMap
     *            a container with all the dresses.
     *
     * @return a new outfit (generated).
     */
    Outfits createOutfit(Map<Category, Categories> categoryMap);

    /**
     * @param name
     *            the name of the outfit to assign.
     * @return the result of the operation.
     */
    Status setName(String name);

    /**
     * This method increments by one the worn count of a particular outfit.
     * 
     * @return the result of the operation.
     */
    Status setWornCount();

    /**
     * @param dressList
     *            a list with some dresses ids.
     * 
     * @return the result of the operation.
     */
    Status setOutfit(List<UUID> dressList);
}
