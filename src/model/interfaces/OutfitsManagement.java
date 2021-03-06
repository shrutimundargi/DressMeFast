package model.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;

import model.enumerations.Outfit;
import model.enumerations.Status;

/**
 * This interface is used to manage different types of outfits.
 *
 */
public interface OutfitsManagement extends Serializable {

    /**
     * This method starts the initialization of the user and AI outfits.
     * 
     * @return the result of the initialization.
     */
    Status initializeAllOutfits();

    /**
     * @param outfitId
     *            the id of an outfit.
     *
     * @return the object outfit pointed by its id.
     */
    Outfits getOutfit(UUID outfitId);

    /**
     * @return the container of all the outfits.
     */
    Map<Outfit, List<Outfits>> getAllOutfits();

    /**
     * @param outfit
     *            an outfit object.
     *
     * @param type
     *            an outfit type in the enumeration "Outfit".
     *
     * @return the result of adding an outfit to the specified type.
     */
    Status addOutfit(Outfits outfit, Outfit type);

    /**
     * @param outfit
     *            an outfit object.
     * 
     * @param type
     *            an outfit type in the enumeration "Outfit".
     * 
     * @return the result of removing an outfit from the specified type.
     */
    Status removeOutfit(Outfits outfit, Outfit type);

    /**
     * @return a list with all the outfits (user created and AI created).
     */
    List<Outfits> getOutfitsList();

    /**
     * @param outfit
     *            an outfit object.
     * 
     * @return the result of adding an outfit.
     */
    Status addOutfitToQueue(Outfits outfit);

    /**
     * @param outfit
     *            an outfit object.
     * 
     * @return the result of removing an outfit.
     */
    Status removeOutfitFromQueue(Outfits outfit);

    /**
     * @return the last outfits added.
     */
    Queue<Outfits> getLastOutfitsAdded();

}
