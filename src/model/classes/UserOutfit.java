package model.classes;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import model.enumerations.Category;
import model.enumerations.Status;
import model.interfaces.Categories;
import model.interfaces.Outfits;

/**
 * This class allows the user to create its own outfit.
 *
 */
public class UserOutfit implements Outfits {

    /**
     * 
     */
    private static final long serialVersionUID = 1955061646165533928L;
    private final UUID id;
    private String name;
    private Integer wornCount;
    private List<UUID> outfit;

    /**
     * Creates a container of a single user outfit.
     */
    public UserOutfit() {
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
        if (dressList.isEmpty()) {
            return null;
        }
        this.outfit = dressList;
        return this;
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
        throw new UnsupportedOperationException();
    }

    @Override
    public Status setOutfit(final List<UUID> dressList) {
        this.outfit = dressList;
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public String toString() {
        return "UserOutfit [id=" + id + ", name=" + name + ", wornCount=" + wornCount + ", outfit=" + outfit + "]";
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
        if (!(obj instanceof UserOutfit)) {
            return false;
        }
        final UserOutfit other = (UserOutfit) obj;
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
