package controller.outfits;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import model.enumerations.Outfit;
import model.enumerations.Status;
import model.interfaces.Outfits;

/**
 * Interface Used for Outfits.
 *
 */
public interface OutfitsController {

    /**
     * @param dressesId
     *            : A list containing all the id of the dresses
     * @param name
     *            : the name of the outfits
     * @return Return OUTFIT_ADDED if Everything went well
     */
    Status addOutfits(List<UUID> dressesId, String name);

    /**
     * @return ReturnA list containing all the Outfits
     */
    List<Outfits> getAllOutfits();

    /**
     * @return Return A list containing all the ai outfits
     */
    List<Outfits> getAIOutfits();

    /**
     * @return Return A list containing all the user outfits
     */
    List<Outfits> getUserOutfits();

    /**
     * @param outfitsid
     *            : the id of the specific outfits
     * @return Return the specific outfits
     */
    Outfits getOutfits(UUID outfitsid);

    /**
     * @return return 1 if there aren't dresses, otherwise return 0.
     */
    int createAIOutfit();

    /**
     * @param outfitsid
     *            : the id of the specific outfits
     * @param changeDresses
     *            : A list containing the new dresses's id
     * @return Return CHANGE_SUCCESFULL if Everything went well
     */
    Status modifyOutfits(UUID outfitsid, List<UUID> changeDresses);

    /**
     * @param outfitsid
     *            : the id of the specific outfits
     * @param newName
     *            : The new name for the outfits
     * @return Return CHANGE_SUCCESFULL if Everything went well
     */
    Status modifyOutfitsName(UUID outfitsid, String newName);

    /**
     * @param outfit
     *            : the outfit that you wont delete
     */
    void removeOutfit(Outfits outfit);

    /**
     * @param outfit
     *            : a specific outfit
     * @return Return the creation date of an outfit
     */
    LocalDate getDate(Outfits outfit);

    /**
     * @param outfit
     *            : a specific outfit
     * 
     * @param date
     *            : the new date
     */
    void setDate(Outfits outfit, LocalDate date);

    /**
     * @param outfit
     *            : a specific outfit
     * @return Return the type of the specific outfit, this can be AI or USER
     */
    Outfit getType(Outfits outfit);

    /**
     * @param outfit
     *            : a specific outfit
     */
    void outfitWorn(Outfits outfit);

    /**
     * @param outfit
     *            : a specific outfit
     * @return Return the number of time that the outfit was worn
     */
    int numberTimeOutfitWorn(Outfits outfit);
}
