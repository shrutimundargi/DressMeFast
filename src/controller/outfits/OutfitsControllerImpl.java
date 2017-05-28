package controller.outfits;

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
        user.getWardobe().getOutfits().getOutfit(outfitsid).createOutfit(changeDresses);
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status modifyOutfitsName(final UUID outfitsid, final String newName) {
        return user.getWardobe().getOutfits().getOutfit(outfitsid).setName(newName);
    }

    @Override
    public void removeOutfit(final Outfits outfits) {
        user.getWardobe().getOutfits().removeOutfit(outfits, Outfit.USER);
    }

    @Override
    public void removeAIOutfit(final Outfits outfits) {
        user.getWardobe().getOutfits().removeOutfit(outfits, Outfit.AI);
    }

    @Override
    public int createAIOutfit() {
        if (user.getWardobe().getCategories().getAllDresses().size() == 0) {
            return 1;
        } else {
            final Outfits aIOutfits = new AIOutfit().createOutfit(user.getWardobe().getCategories().getAllCategories());
            user.getWardobe().getOutfits().addOutfit(aIOutfits, Outfit.AI);
            return 0;
        }
    }
}
