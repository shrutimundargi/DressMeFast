package model;

import java.util.Objects;
import java.util.Optional;

import model.interfaces.Dress;

/**
 * This class implements the Dress features.
 * 
 *
 */
public final class DressImpl implements Dress {

    private String name;
    private Optional<String> brand;
    private Optional<Integer> size;
    private Optional<Integer> price;
    private Optional<String> purchaseDate;
    private Optional<String> description;

    private DressImpl(final String dressName, final Optional<String> dressBrand, final Optional<Integer> dressSize,
            final Optional<Integer> dressPrice, final Optional<String> dressPurchaseDate,
            final Optional<String> dressDescription) {
        super();
        this.name = dressName;
        this.brand = dressBrand;
        this.size = dressSize;
        this.price = dressPrice;
        this.purchaseDate = dressPurchaseDate;
        this.description = dressDescription;
    }

    @Override
    public String getName() {
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
    public Optional<String> getPurchaseDate() {
        return this.purchaseDate;
    }

    @Override
    public Optional<String> getDescription() {
        return this.description;
    }

    @Override
    public AuthenticationStatus setName(final String dressName) {
        this.name = dressName;
        return AuthenticationStatus.CHANGE_SUCCESFULL;
    }

    @Override
    public AuthenticationStatus setBrand(final String dressBrand) {
        this.brand = Optional.of(dressBrand);
        return AuthenticationStatus.CHANGE_SUCCESFULL;
    }

    @Override
    public AuthenticationStatus setSize(final int dressSize) {
        this.size = Optional.of(dressSize);
        return AuthenticationStatus.CHANGE_SUCCESFULL;
    }

    @Override
    public AuthenticationStatus setPrice(final int dressPrice) {
        this.price = Optional.of(dressPrice);
        return AuthenticationStatus.CHANGE_SUCCESFULL;
    }

    @Override
    public AuthenticationStatus setPurchaseDate(final String dressPurchaseDate) {
        this.purchaseDate = Optional.of(dressPurchaseDate);
        return AuthenticationStatus.CHANGE_SUCCESFULL;
    }

    @Override
    public AuthenticationStatus setDescription(final String dressDescription) {
        this.description = Optional.of(dressDescription);
        return AuthenticationStatus.CHANGE_SUCCESFULL;
    }

    /**
     * The builder class for a dress.
     *
     */
    public static class DressBuilder {

        private String name;
        private Optional<String> brand;
        private Optional<Integer> size;
        private Optional<Integer> price;
        private Optional<String> purchaseDate;
        private Optional<String> description;

        /**
         * @param dressName
         *            the name of the dress
         *
         * @return a dress
         */
        public DressBuilder buildName(final String dressName) {
            this.name = dressName;
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
        public DressBuilder buildPurchaseDate(final String dressPurchaseDate) {
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
