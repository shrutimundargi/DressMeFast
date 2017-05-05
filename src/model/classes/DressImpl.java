package model.classes;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import model.enumerations.Category;
import model.enumerations.Status;
import model.interfaces.Dress;

/**
 * This class implements the Dress features.
 * 
 *
 */
public final class DressImpl implements Dress {

    private final UUID id;
    private Optional<String> name;
    private Optional<String> brand;
    private Optional<Integer> size;
    private Optional<Integer> price;
    private Optional<Date> purchaseDate;
    private Optional<String> description;
    private Boolean favourited;
    private Category category;

    /**
     * This constructor is used to build a dress.
     * 
     * @param dressName
     *            the name of the dress.
     * @param dressBrand
     *            the brand of the dress.
     * @param dressSize
     *            the size of the dress.
     * @param dressPrice
     *            the price of the dress.
     * @param dressPurchaseDate
     *            the purchase date of a dress.
     * @param dressDescription
     *            the description of a dress.
     */
    protected DressImpl(final Optional<String> dressName, final Optional<String> dressBrand,
            final Optional<Integer> dressSize, final Optional<Integer> dressPrice,
            final Optional<Date> dressPurchaseDate, final Optional<String> dressDescription) {
        super();
        this.name = dressName;
        this.brand = dressBrand;
        this.size = dressSize;
        this.price = dressPrice;
        this.purchaseDate = dressPurchaseDate;
        this.description = dressDescription;
        this.id = UUID.randomUUID();
        this.favourited = false;
        this.category = Category.EMPTY;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public Optional<String> getName() {
        return this.name;
    }

    @Override
    public Optional<String> getBrand() {
        return this.brand;
    }

    @Override
    public Optional<Integer> getSize() {
        return this.size;
    }

    @Override
    public Optional<Integer> getPrice() {
        return this.price;
    }

    @Override
    public Optional<Date> getPurchaseDate() {
        return this.purchaseDate;
    }

    @Override
    public Optional<String> getDescription() {
        return this.description;
    }
    @Override
    public Boolean getFavourited() {
        return this.favourited;
    }

    @Override
    public Category getCategoryName() {
        return this.category;
    }

    @Override
    public Status setName(final String dressName) {
        this.name = Optional.of(dressName);
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status setBrand(final String dressBrand) {
        this.brand = Optional.of(dressBrand);
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status setSize(final int dressSize) {
        this.size = Optional.of(dressSize);
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status setPrice(final int dressPrice) {
        this.price = Optional.of(dressPrice);
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status setPurchaseDate(final Date dressPurchaseDate) {
        this.purchaseDate = Optional.of(dressPurchaseDate);
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status setDescription(final String dressDescription) {
        this.description = Optional.of(dressDescription);
        return Status.CHANGE_SUCCESFULL;
    }
    @Override
    public Status setFavourited(final Boolean favourited) {
        this.favourited = favourited;
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status setCategoryName(final Category category) {
        this.category = category;
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((favourited == null) ? 0 : favourited.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
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
        if (!(obj instanceof DressImpl)) {
            return false;
        }
        final DressImpl other = (DressImpl) obj;
        if (brand == null) {
            if (other.brand != null) {
                return false;
            }
        } else if (!brand.equals(other.brand)) {
            return false;
        }
        if (category != other.category) {
            return false;
        }
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (favourited == null) {
            if (other.favourited != null) {
                return false;
            }
        } else if (!favourited.equals(other.favourited)) {
            return false;
        }
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
        if (price == null) {
            if (other.price != null) {
                return false;
            }
        } else if (!price.equals(other.price)) {
            return false;
        }
        if (purchaseDate == null) {
            if (other.purchaseDate != null) {
                return false;
            }
        } else if (!purchaseDate.equals(other.purchaseDate)) {
            return false;
        }
        if (size == null) {
            if (other.size != null) {
                return false;
            }
        } else if (!size.equals(other.size)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DressImpl [id=" + id + ", name=" + name + ", brand=" + brand + ", size=" + size + ", price=" + price
                + ", purchaseDate=" + purchaseDate + ", description=" + description + "]";
    }

    /**
     * The builder class for a dress.
     *
     */
    public static class DressBuilder {

        private Optional<String> name = Optional.empty();
        private Optional<String> brand = Optional.empty();
        private Optional<Integer> size = Optional.empty();
        private Optional<Integer> price = Optional.empty();
        private Optional<Date> purchaseDate = Optional.empty();
        private Optional<String> description = Optional.empty();

        /**
         * @param dressName
         *            the name of the dress
         *
         * @return a dress
         */
        public DressBuilder buildName(final String dressName) {
            this.name = Optional.ofNullable(dressName);
            return this;
        }

        /**
         * @param dressBrand
         *            the brand of the dress
         * 
         * @return a dress
         */
        public DressBuilder buildBrand(final String dressBrand) {
            this.brand = Optional.ofNullable(dressBrand);
            return this;
        }

        /**
         * @param dressSize
         *            the size of the dress
         *
         * @return a dress
         */
        public DressBuilder buildSize(final int dressSize) {
            this.size = Optional.ofNullable(dressSize);
            return this;
        }

        /**
         * @param dressPrice
         *            the price of the dress
         *
         * @return a dress
         */
        public DressBuilder buildPrice(final int dressPrice) {
            this.price = Optional.ofNullable(dressPrice);
            return this;
        }

        /**
         * @param dressPurchaseDate
         *            the purchase date of the dress
         *
         * @return a dress
         */
        public DressBuilder buildPurchaseDate(final Date dressPurchaseDate) {
            this.purchaseDate = Optional.ofNullable(dressPurchaseDate);
            return this;
        }

        /**
         * @param dressDescription
         *            the description of a dress
         *
         * @return a dress
         */
        public DressBuilder buildDescription(final String dressDescription) {
            this.description = Optional.ofNullable(dressDescription);
            return this;
        }

        /**
         * @return a new dress object
         */
        public Dress build() {
            return new DressImpl(this.name, this.brand, this.size, this.price, this.purchaseDate, this.description);
        }
    }

}
