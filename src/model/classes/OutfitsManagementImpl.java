package model.classes;

import java.util.HashMap;
import java.util.Map;

import model.enumerations.Outfit;
import model.enumerations.Status;
import model.interfaces.Outfits;
import model.interfaces.OutfitsManagement;

/**
 * This class is used to manage different types of outfits.
 *
 */
public class OutfitsManagementImpl implements OutfitsManagement {

    private final Map<Outfit, Outfits> outfitsMap;

    /**
     * Creates a container for all the outfits.
     */
    public OutfitsManagementImpl() {
       this.outfitsMap = new HashMap<Outfit, Outfits>();
    }

    @Override
    public Status initializeAllOutfits() {
        if (!this.outfitsMap.isEmpty()) {
            return Status.OUTFITS_ALREADY_INITIALIZED;
        }
        this.outfitsMap.put(Outfit.USER, new UserOutfit());
        this.outfitsMap.put(Outfit.AI, new AIOutfit());
        System.out.println(this.outfitsMap.toString());
        return Status.OUTFITS_INITIALIZED;
    }

    @Override
    public Outfits getOutfit(final Outfit outfit) {
        return this.outfitsMap.get(outfit);
    }

    @Override
    public Status addOutfit(final Outfits outfit, final Outfit type) {
        if (!this.outfitsMap.containsKey(type)) {
            return Status.OUTFIT_NOT_ADDED;
        }
        //this.outfitsMap.get(type).addOutfit(outfit);
        return Status.OUTFIT_ADDED;
    }

    @Override
    public Map<Outfit, Outfits> getAllOutfits() {
        return this.outfitsMap;
    }
}
