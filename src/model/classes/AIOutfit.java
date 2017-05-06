package model.classes;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import model.enumerations.Status;
import model.interfaces.Outfits;

/**
 * This class allows the application to generate an outfit.
 *
 */
public class AIOutfit implements Outfits {

    private final UUID id;
    private Optional<String> name;
    private List<UUID> outfit;
    // private final Set<CategoryManagement> categoryM;

    /**
     * Creates a container of a single AI outfit.
     */
    public AIOutfit() {
        this.id = UUID.randomUUID();
        this.name = Optional.empty();
        this.outfit = new LinkedList<>();
    }
    @Override
    public UUID getId() {
        return this.id;
    }
    @Override
    public List<UUID> getOutfit() {
        return this.outfit;
    }
    @Override
    public Optional<String> getName() {
        return this.name;
    }

    @Override
    public Outfits createOutfit(final List<UUID> dressList) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Status setName(final String name) {
        this.name = Optional.ofNullable(name);
        return Status.CHANGE_SUCCESFULL;
    }

}
