package model.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

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
     * @param dressList
     *            a container with some dresses.
     *
     * @return a new outfit.
     */
    Outfits createOutfit(List<UUID> dressList);

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
}
