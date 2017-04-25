package model;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import model.interfaces.Dress;

/**
 * This class implements the Dress features.
 * 
 *
 */
public final class DressImpl implements Dress {

    private UUID id;
    private Optional<String> name;
    private Optional<String> brand;
    private Optional<Integer> size;
    private Optional<Integer> price;
    private Optional<Date> purchaseDate;
    private Optional<String> description;

    private DressImpl(final Optional<String> dressName, final Optional<String> dressBrand, final Optional<Integer> dressSize,
            final Optional<Integer> dressPrice, final Optional<Date> dressPurchaseDate,
            final Optional<String> dressDescription) {
        super();
        this.name = dressName;
        this.brand = dressBrand;
        this.size = dressSize;
        this.price = dressPrice;
        this.purchaseDate = dressPurchaseDate;
        this.description = dressDescription;
        this.id = UUID.randomUUID();
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

    /**
     * The builder class for a dress.
     *
     */
    public static class DressBuilder {

        private Optional<String> name;
        private Optional<String> brand;
        private Optional<Integer> size;
        private Optional<Integer> price;
        private Optional<Date> purchaseDate;
        private Optional<String> description;

        /**
         * @param dressName
         *            the name of the dress
         *
         * @return a dress
         */
        public DressBuilder buildName(final String dressName) {
            this.name = Optional.of(dressName);
            return this;
        }

        /**
         * @param dressBrand
         *            the brand of the dress
         * 
         * @return a dress
         */
        public DressBuilder buildBrand(final String dressBrand) {
            this.brand = Optional.of(dressBrand);
            return this;
        }

        /**
         * @param dressSize
         *            the size of the dress
         *
         * @return a dress
         */
        public DressBuilder buildSize(final int dressSize) {
            this.size = Optional.of(dressSize);
            return this;
        }

        /**
         * @param dressPrice
         *            the price of the dress
         *
         * @return a dress
         */
        public DressBuilder buildPrice(final int dressPrice) {
            this.price = Optional.of(dressPrice);
            return this;
        }

        /**
         * @param dressPurchaseDate
         *            the purchase date of the dress
         *
         * @return a dress
         */
        public DressBuilder buildPurchaseDate(final Date dressPurchaseDate) {
            this.purchaseDate = Optional.of(dressPurchaseDate);
            return this;
        }

        /**
         * @param dressDescription
         *            the description of a dress
         *
         * @return a dress
         */
        public DressBuilder buildDescription(final String dressDescription) {
            this.description = Optional.of(dressDescription);
            return this;
        }

        /**
         * @return a new dress object
         */
        public Dress build() {
            Objects.requireNonNull(this.name);
            return new DressImpl(this.name, this.brand, this.size, this.price, this.purchaseDate, this.description);
        }
    }

}
