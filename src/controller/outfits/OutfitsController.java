package controller.outfits;

import java.util.List;
import java.util.UUID;

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
     * @return Return OUTFIT_ADDED if Everything went well
     */
    Status addOutfits(List<UUID> dressesId);

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

}
