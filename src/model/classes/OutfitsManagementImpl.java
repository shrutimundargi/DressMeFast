package model.classes;

import java.util.HashMap;
import java.util.Map;

import model.enumerations.Outfits;
import model.enumerations.Status;
import model.interfaces.Outfit;
import model.interfaces.OutfitsManagement;

/**
 * This class is used to manage different types of outfits.
 *
 */
public class OutfitsManagementImpl implements OutfitsManagement {

    private final Map<Outfits, Outfit> outfitsMap;

    /**
     * Creates a container for all the outfits.
     */
    public OutfitsManagementImpl() {
       this.outfitsMap = new HashMap<Outfits, Outfit>();
    }

    @Override
    public Status initializeAllOutfits() {
        if (!this.outfitsMap.isEmpty()) {
            return Status.OUTFITS_ALREADY_INITIALIZED;
        }
        this.outfitsMap.put(Outfits.USER, new UserOutfit());
        this.outfitsMap.put(Outfits.AI, new AIOutfit());
        System.out.println(this.outfitsMap.toString());
        return Status.OUTFITS_INITIALIZED;
    }

    @Override
    public Outfit getOutfit(final Outfits outfit) {
        return this.outfitsMap.get(outfit);
    }

    @Override
    public Status addOutfit(final Outfit outfit, final Outfits type) {
        if (!this.outfitsMap.containsKey(type)) {
            return Status.OUTFIT_NOT_ADDED;
        }
        //this.outfitsMap.get(type).addOutfit(outfit);
        return Status.OUTFIT_ADDED;
    }

    @Override
    public Map<Outfits, Outfit> getAllOutfits() {
        return this.outfitsMap;
    }
}
