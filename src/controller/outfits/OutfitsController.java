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
     *            : A list containing all the ids of the dresses
     * @param name
     *            : the name of the outfit
     * @return Returns OUTFIT_ADDED if Everything went well
     */
    Status addOutfits(List<UUID> dressesId, String name);

    /**
     * @return Returns a list containing all the Outfits
     */
    List<Outfits> getAllOutfits();

    /**
     * @return Returns a list containing all the AI outfits
     */
    List<Outfits> getAIOutfits();

    /**
     * @return Returns a list containing all the user outfits
     */
    List<Outfits> getUserOutfits();

    /**
     * @param outfitsid
     *            : the id of the specific outfits
     * @return Returns the specific outfits
     */
    Outfits getOutfits(UUID outfitsid);

    /**
     * @return Returns 1 if there aren't dresses, otherwise returns 0.
     */
    int createAIOutfit();

    /**
     * @param outfitsid
     *            : the id of the specific outfit
     * @param changeDresses
     *            : A list containing the new dresses id
     * @return Returns CHANGE_SUCCESFULL if Everything went well
     */
    Status modifyOutfits(UUID outfitsid, List<UUID> changeDresses);

    /**
     * @param outfitsid
     *            : the id of the specific outfit
     * @param newName
     *            : The new name for the outfit
     * @return Returns CHANGE_SUCCESFULL if Everything went well
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
     * @return Returns the creation date of an outfit
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
     * @return Returns the type of the specific outfit, this can be AI or USER
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
     * @return Returns the number of time that the outfit was worn
     */
    int numberTimeOutfitWorn(Outfits outfit);
}
