package model.classes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import model.enumerations.Outfit;
import model.enumerations.Status;
import model.interfaces.Outfits;
import model.interfaces.OutfitsManagement;

/**
 * This class is used to manage different types of outfits.
 *
 */
public class OutfitsManagementImpl implements OutfitsManagement {

    private final Map<Outfit, List<UUID>> outfitsMap;

    /**
     * Creates a container for all the outfits.
     */
    public OutfitsManagementImpl() {
        this.outfitsMap = new HashMap<>();
    }

    @Override
    public Status initializeAllOutfits() {
        if (!this.outfitsMap.isEmpty()) {
            return Status.OUTFITS_ALREADY_INITIALIZED;
        }
        this.outfitsMap.put(Outfit.USER, new LinkedList<>());
        this.outfitsMap.put(Outfit.AI, new LinkedList<>());
        System.out.println(this.outfitsMap.toString());
        return Status.OUTFITS_INITIALIZED;
    }

    @Override
    public Outfits getOutfit(final UUID outfitId) {
        for (final Outfits outfit : ModelSingleton.getInstance().getOutfitsList()) {
            if (outfit.getId().equals(outfitId)) {
                return outfit;
            }
        }
        return null;
    }

    @Override
    public Status addOutfit(final Outfits outfit, final Outfit type) {
        if (!this.outfitsMap.containsKey(type)) {
            return Status.OUTFIT_NOT_ADDED;
        }
        ModelSingleton.getInstance().getOutfitsList().add(outfit);
        this.outfitsMap.get(type).add(outfit.getId());
        return Status.OUTFIT_ADDED;
    }
    @Override
    public Status removeOutfit(final Outfits outfit, final Outfit type) {
        this.checkOutfitPresence(outfit);
        ModelSingleton.getInstance().getOutfitsList().remove(outfit);
        this.outfitsMap.get(type).remove(outfit);
        return Status.OUTFIT_REMOVED;
    }

    @Override
    public Map<Outfit, List<UUID>> getAllOutfits() {
        return this.outfitsMap;
    }

    private Status checkOutfitPresence(final Outfits outfitToCheck) {
        for (final Outfits outfit : ModelSingleton.getInstance().getOutfitsList()) {
            if ((outfit.getId().equals(outfitToCheck.getId()))) {
                return Status.OUTFIT_FOUND;
            }
        }
        throw new IllegalArgumentException("Outfit not found");
    }
}
