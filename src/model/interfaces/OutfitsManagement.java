package model.interfaces;

import java.util.Map;

import model.enumerations.Outfit;
import model.enumerations.Status;

/**
 * This interface is used to manage different types of outfits.
 *
 */
public interface OutfitsManagement {

    /**
     * This method starts the initialization of the user and AI outfits.
     * 
     *  @return the result of the initialization.
     */
    Status initializeAllOutfits();

    /**
     * @param outfit
     *        the type of outfit in the enumeration "Outfits".
     *
     * @return the object outfit pointed by its type. 
     */
    Outfits getOutfit(Outfit outfit);

    /**
     * @param outfit
     *        an outfit object.
     *
     * @param type
     *        an outfit type in the enumeration "Outfits".
     *
     * @return the result of adding an outfit object to the specified type.
     */
    Status addOutfit(Outfits outfit, Outfit type);

    /**
     * @return the map which contains the default types of outfit.
     */
    Map<Outfit, Outfits> getAllOutfits();
}
