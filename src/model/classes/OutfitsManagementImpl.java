package model.classes;

import java.util.Collections;
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

    private final Map<Outfit, List<Outfits>> outfitsMap;

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
        for (final Outfit type : this.outfitsMap.keySet()) {
            for (final Outfits outfit : this.outfitsMap.get(type)) {
                if (outfit.getId().equals(outfitId)) {
                    return outfit;
                }
            }
        }
        return null;
    }

    @Override
    public Status addOutfit(final Outfits outfit, final Outfit type) {
        if (!this.outfitsMap.containsKey(type)) {
            return Status.OUTFIT_NOT_ADDED;
        }
        this.outfitsMap.get(type).add(outfit);
        return Status.OUTFIT_ADDED;
    }

    @Override
    public Status removeOutfit(final Outfits outfit, final Outfit type) {
        if (!this.outfitsMap.containsKey(type)) {
            return Status.OUTFIT_NOT_FOUND;
        }
        this.outfitsMap.get(type).remove(outfit);
        return Status.OUTFIT_REMOVED;
    }

    @Override
    public Map<Outfit, List<Outfits>> getAllOutfits() {
        return this.outfitsMap;
    }

    @Override
    public List<Outfits> getOutfitsList() {
        final List<Outfits> tmpOutfits = new LinkedList<>();
        this.getAllOutfits().values().forEach(outfits -> {
            outfits.forEach(outfit -> {
                tmpOutfits.add(outfit);
            });
        });
        return Collections.unmodifiableList(tmpOutfits);
    }

}
