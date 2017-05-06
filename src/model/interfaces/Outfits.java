package model.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import model.enumerations.Status;

/**
 * The interface of a single outfit. In this case, an outfit is represented by a
 * multitude of dresses and it's divided in two types: user created and AI
 * created.
 *
 */
public interface Outfits {

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
    Optional<String> getName();

    /**
     * @param dressList
     *        a container with some dresses.
     *
     * @return a new outfit.
     */
    Outfits createOutfit(List<UUID> dressList);

    /**
     * @param name
     *        the name of the outfit to assign.
     * @return the result of the operation.
     */
    Status setName(String name);
}
