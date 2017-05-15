package model.classes;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import model.enumerations.Category;
import model.enumerations.Status;
import model.interfaces.Categories;
import model.interfaces.Dress;
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
        return Collections.unmodifiableList(this.outfit);
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
        throw new UnsupportedOperationException();
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

    @Override
    public Outfits createOutfit(final Map<Category, Categories> categoryMap) {
        List<Dress> dressList = new LinkedList<Dress>();
        categoryMap.values().forEach(category -> {
            category.getAllDresses().values().forEach(dress -> {
                dressList.add(dress);
            });
        });
        dressList.forEach(dress -> {
            if (dress.getFavourited().booleanValue()) {
                this.outfit.add(dress.getId());
            }
        });
        return this;
    }

    @Override
    public String toString() {
        return "AIOutfit [id=" + id + ", name=" + name + ", wornCount=" + wornCount + ", outfit=" + outfit + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((outfit == null) ? 0 : outfit.hashCode());
        result = prime * result + ((wornCount == null) ? 0 : wornCount.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AIOutfit)) {
            return false;
        }
        AIOutfit other = (AIOutfit) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (outfit == null) {
            if (other.outfit != null) {
                return false;
            }
        } else if (!outfit.equals(other.outfit)) {
            return false;
        }
        if (wornCount == null) {
            if (other.wornCount != null) {
                return false;
            }
        } else if (!wornCount.equals(other.wornCount)) {
            return false;
        }
        return true;
    }

}
