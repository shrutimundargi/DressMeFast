package model.classes;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import model.enumerations.Status;
import model.interfaces.Outfits;

/**
 * This class allows the application to generate an outfit.
 *
 */
public class AIOutfit implements Outfits {

    /**
     * 
     */
    private static final long serialVersionUID = 7498876564149704140L;
    private final UUID id;
    private String name;
    private Integer wornCount;
    private List<UUID> outfit;

    /**
     * Creates a container of a single AI outfit.
     */
    public AIOutfit() {
        this.id = UUID.randomUUID();
        this.name = null;
        this.wornCount = 0;
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
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getWornCount() {
        return this.wornCount;
    }

    @Override
    public Outfits createOutfit(final List<UUID> dressList) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Status setName(final String name) {
        this.name = name;
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status setWornCount() {
        this.wornCount++;
        return Status.CHANGE_SUCCESFULL;
    }

}
