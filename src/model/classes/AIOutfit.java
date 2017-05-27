package model.classes;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
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
        final List<Dress> dressHead = new LinkedList<>();
        final List<Dress> dressNeck = new LinkedList<>();
        final List<Dress> dressBody = new LinkedList<>();
        final List<Dress> dressHands = new LinkedList<>();
        final List<Dress> dressLegs = new LinkedList<>();
        final List<Dress> dressFoot = new LinkedList<>();
        final Random randomizer = new Random();

        categoryMap.get(Category.HEAD).getAllDresses().values().forEach(dress -> {
            dressHead.add(dress);
        });

        categoryMap.get(Category.NECK).getAllDresses().values().forEach(dress -> {
            dressNeck.add(dress);
        });

        categoryMap.get(Category.BODY).getAllDresses().values().forEach(dress -> {
            dressBody.add(dress);
        });

        categoryMap.get(Category.HANDS).getAllDresses().values().forEach(dress -> {
            dressHands.add(dress);
        });

        categoryMap.get(Category.LEGS).getAllDresses().values().forEach(dress -> {
            dressLegs.add(dress);
        });

        categoryMap.get(Category.FOOT).getAllDresses().values().forEach(dress -> {
            dressFoot.add(dress);
        });

        Dress randomBodyDress = null;
        if (!dressBody.isEmpty()) {
            randomBodyDress = dressBody.get(randomizer.nextInt(dressBody.size()));
            if (randomBodyDress.getFavourited().booleanValue() || randomBodyDress.getWornCount() == 0) {
                this.outfit.add(randomBodyDress.getId());
            }
        }
        Dress randomLegsDress = null;
        if (!dressLegs.isEmpty() && randomBodyDress != null) {
            randomLegsDress = dressLegs.get(randomizer.nextInt(dressLegs.size()));
            if (randomLegsDress.getFavourited().booleanValue() || randomLegsDress.getWornCount() == 0
                    || randomLegsDress.getBrand().equals(randomBodyDress.getBrand())
                    || randomLegsDress.getSize().equals(randomBodyDress.getSize())) {
                this.outfit.add(randomLegsDress.getId());
            }
        }

        Dress randomHeadDress = null;
        if (!dressHead.isEmpty()) {
            randomHeadDress = dressHead.get(randomizer.nextInt(dressHead.size()));
            if (randomHeadDress.getFavourited().booleanValue() || randomHeadDress.getWornCount() == 0) {
                this.outfit.add(randomHeadDress.getId());
            }
        }

        if (!dressNeck.isEmpty() && randomHeadDress != null) {
            final Dress randomNeckDress = dressNeck.get(randomizer.nextInt(dressNeck.size()));
            if (randomNeckDress.getFavourited().booleanValue() || randomHeadDress.getWornCount() == 0
                    || randomNeckDress.getBrand().equals(randomHeadDress.getBrand())
                    || randomNeckDress.getSize().equals(randomHeadDress.getSize())) {
                this.outfit.add(randomNeckDress.getId());
            }
        }

        if (!dressHands.isEmpty()) {
            final Dress randomHandsDress = dressHands.get(randomizer.nextInt(dressHands.size()));
            if (randomHandsDress.getFavourited().booleanValue() || randomHeadDress.getWornCount() == 0
                    || randomHandsDress.getBrand().equals(randomHeadDress.getBrand())
                    || randomHandsDress.getSize().equals(randomHeadDress.getSize())) {
                this.outfit.add(randomHandsDress.getId());
            }
        }

        if (!dressFoot.isEmpty()) {
            final Dress randomFootDress = dressFoot.get(randomizer.nextInt(dressFoot.size()));
            if (randomFootDress.getFavourited().booleanValue() || randomFootDress.getWornCount() == 0
                    || randomFootDress.getBrand().equals(randomBodyDress.getBrand())
                    || randomFootDress.getBrand().equals(randomLegsDress.getBrand())) {
                this.outfit.add(randomFootDress.getId());
            }
        }
        return this;
    }

    @Override
    public Status setOutfit(final List<UUID> dressList) {
        this.outfit = dressList;
        return Status.CHANGE_SUCCESFULL;
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
        final AIOutfit other = (AIOutfit) obj;
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
