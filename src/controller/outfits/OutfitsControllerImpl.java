package controller.outfits;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import model.classes.AIOutfit;
import model.classes.UserOutfit;
import model.enumerations.Outfit;
import model.enumerations.Status;
import model.interfaces.Outfits;
import model.interfaces.User;

/**
 * An implementation of the OutfitsController.
 *
 */
public final class OutfitsControllerImpl implements OutfitsController {
    private static final int AI_OUTFIT_OK = 0;
    private static final int CREATE_AI_ERROR = 1;
    private final User user;

    /**
     * @param user
     *            : user
     */
    public OutfitsControllerImpl(final User user) {
        this.user = user;
    }

    @Override
    public Status addOutfits(final List<UUID> dressesId, final String name) {
        final Outfits userOutfits = new UserOutfit().createOutfit(dressesId);
        userOutfits.setName(name);
        return user.getWardobe().getOutfits().addOutfit(userOutfits, Outfit.USER);
    }

    @Override
    public List<Outfits> getAllOutfits() {
        return user.getWardobe().getOutfits().getOutfitsList();
    }

    @Override
    public List<Outfits> getAIOutfits() {
        return user.getWardobe().getOutfits().getAllOutfits().get(Outfit.AI);

    }

    @Override
    public List<Outfits> getUserOutfits() {
        return user.getWardobe().getOutfits().getAllOutfits().get(Outfit.USER);
    }

    @Override
    public Outfits getOutfits(final UUID outfitsid) {
        return user.getWardobe().getOutfits().getOutfit(outfitsid);
    }

    @Override
    public Status modifyOutfits(final UUID outfitsid, final List<UUID> changeDresses) {
        if (user.getWardobe().getOutfits().getOutfit(outfitsid).getOutfitType().equals(Outfit.USER)) {
            user.getWardobe().getOutfits().getOutfit(outfitsid).createOutfit(changeDresses);
        } else if (user.getWardobe().getOutfits().getOutfit(outfitsid).getOutfitType().equals(Outfit.AI)) {
            user.getWardobe().getOutfits().getOutfit(outfitsid).setOutfit(changeDresses);
        }
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status modifyOutfitsName(final UUID outfitsid, final String newName) {
        return user.getWardobe().getOutfits().getOutfit(outfitsid).setName(newName);
    }

    @Override
    public void removeOutfit(final Outfits outfits) {
        user.getWardobe().getOutfits().removeOutfit(outfits, outfits.getOutfitType());
    }

    @Override
    public int createAIOutfit() {
        if (user.getWardobe().getCategories().getAllDresses().isEmpty()) {
            return CREATE_AI_ERROR;
        } else {
            final Outfits aIOutfits = new AIOutfit().createOutfit(user.getWardobe().getCategories().getAllCategories());
            user.getWardobe().getOutfits().addOutfit(aIOutfits, Outfit.AI);
            return AI_OUTFIT_OK;
        }
    }

    @Override
    public LocalDate getDate(final Outfits outfit) {
        return outfit.getDate();
    }

    @Override
    public void setDate(final Outfits outfit, final LocalDate date) {
        user.getWardobe().getOutfits().getOutfit(outfit.getId()).setDate(date);
    }

    @Override
    public Outfit getType(final Outfits outfit) {
        return outfit.getOutfitType();
    }

    @Override
    public void outfitWorn(final Outfits outfit) {
        outfit.setWornCount();
    }

    @Override
    public int numberTimeOutfitWorn(final Outfits outfit) {
        return outfit.getWornCount();
    }

}
