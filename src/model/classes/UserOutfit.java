package model.classes;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import model.enumerations.Status;
import model.interfaces.Outfits;

/**
 * This class allows the user to create its own outfit.
 *
 */
public class UserOutfit implements Outfits {

    private final UUID id;
    private Optional<String> name;
    private List<UUID> userOutfits;
    // private final Set<CategoryManagement> categoryM;

    public UserOutfit() {
        this.id = UUID.randomUUID();
        this.name = Optional.empty();
        this.userOutfits = new LinkedList<>();
    }
    @Override
    public UUID getId() {
        return this.id;
    }

    public List<UUID> getOutfits() {
        return this.userOutfits;
    }

    public Optional<String> getName() {
        return this.name;
    }

    public UserOutfit createOutfit(final List<UUID> dressList) {
        if (dressList.isEmpty()) {
            return null;
        }
        this.userOutfits = dressList;
        return this;
    }

    public Status setName(final String name) {
        this.name = Optional.ofNullable(name);
        return Status.CHANGE_SUCCESFULL;
    }

}
