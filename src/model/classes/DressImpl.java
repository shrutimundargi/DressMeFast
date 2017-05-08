package model.classes;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;
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

    /**
     * 
     */
    private static final long serialVersionUID = -8127816404845045598L;
    private final UUID id;
    private final File image;
    private String name;
    private String brand;
    private Integer size;
    private Integer price;
    private Date purchaseDate;
    private String description;
    private Boolean favourited;
    private Integer wornCount;
    private Category category;

    /**
     * This constructor is used to build a dress.
     * 
     * @param dressImage
     *            the image of the dress.
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
    protected DressImpl(final File dressImage, final String dressName, final String dressBrand, final Integer dressSize,
            final Integer dressPrice, final Date dressPurchaseDate, final String dressDescription) {
        super();
        this.image = dressImage;
        this.name = dressName;
        this.brand = dressBrand;
        this.size = dressSize;
        this.price = dressPrice;
        this.purchaseDate = dressPurchaseDate;
        this.description = dressDescription;
        this.id = UUID.randomUUID();
        this.favourited = false;
        this.wornCount = 0;
        this.category = Category.EMPTY;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public File getImage() {
        return this.image;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    @Override
    public Integer getSize() {
        return this.size;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }

    @Override
    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public Boolean getFavourited() {
        return this.favourited;
    }

    @Override
    public Integer getWornCount() {
        return this.wornCount;
    }

    @Override
    public Category getCategoryName() {
        return this.category;
    }

    @Override
    public Status setName(final String dressName) {
        this.name = dressName;
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status setBrand(final String dressBrand) {
        this.brand = dressBrand;
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status setSize(final int dressSize) {
        this.size = dressSize;
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status setPrice(final int dressPrice) {
        this.price = dressPrice;
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status setPurchaseDate(final Date dressPurchaseDate) {
        this.purchaseDate = dressPurchaseDate;
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status setDescription(final String dressDescription) {
        this.description = dressDescription;
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status setFavourited(final Boolean favourited) {
        this.favourited = favourited;
        return Status.CHANGE_SUCCESFULL;
    }

    @Override
    public Status setWornCount() {
        this.wornCount++;
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
        result = prime * result + ((image == null) ? 0 : image.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((purchaseDate == null) ? 0 : purchaseDate.hashCode());
        result = prime * result + ((size == null) ? 0 : size.hashCode());
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
        if (image == null) {
            if (other.image != null) {
                return false;
            }
        } else if (!image.equals(other.image)) {
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
        if (wornCount == null) {
            if (other.wornCount != null) {
                return false;
            }
        } else if (!wornCount.equals(other.wornCount)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DressImpl [id=" + id + ", name=" + name + ", brand=" + brand + ", size=" + size + ", price=" + price
                + ", purchaseDate=" + purchaseDate + ", description=" + description + "]";
    }

    private void writeObject(final ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
    }

    /**
     * The builder class for a dress.
     *
     */
    public static class DressBuilder {

        private File builderImage;
        private String builderName;
        private String builderBrand;
        private Integer builderSize;
        private Integer builderPrice;
        private Date builderPurchaseDate;
        private String builderDescription;

        /**
         * @param imagePath
         *            the image path of the dress.
         *
         * @return a dress.
         */
        public DressBuilder buildImage(final String imagePath) {
            this.builderImage = new File(imagePath);
            return this;
        }

        /**
         * @param dressName
         *            the name of the dress
         *
         * @return a dress
         */
        public DressBuilder buildName(final String dressName) {
            this.builderName = dressName;
            return this;
        }

        /**
         * @param dressBrand
         *            the brand of the dress
         * 
         * @return a dress
         */
        public DressBuilder buildBrand(final String dressBrand) {
            this.builderBrand = dressBrand;
            return this;
        }

        /**
         * @param dressSize
         *            the size of the dress
         *
         * @return a dress
         */
        public DressBuilder buildSize(final int dressSize) {
            this.builderSize = dressSize;
            return this;
        }

        /**
         * @param dressPrice
         *            the price of the dress
         *
         * @return a dress
         */
        public DressBuilder buildPrice(final int dressPrice) {
            this.builderPrice = dressPrice;
            return this;
        }

        /**
         * @param dressPurchaseDate
         *            the purchase date of the dress
         *
         * @return a dress
         */
        public DressBuilder buildPurchaseDate(final Date dressPurchaseDate) {
            this.builderPurchaseDate = dressPurchaseDate;
            return this;
        }

        /**
         * @param dressDescription
         *            the description of a dress
         *
         * @return a dress
         */
        public DressBuilder buildDescription(final String dressDescription) {
            this.builderDescription = dressDescription;
            return this;
        }

        /**
         * @return a new dress object
         */
        public Dress build() {
            return new DressImpl(this.builderImage, this.builderName, this.builderBrand, this.builderSize,
                    this.builderPrice, this.builderPurchaseDate, this.builderDescription);
        }
    }

}
