package model;

import java.util.Objects;
import java.util.Optional;

import model.interfaces.Dress;

public class DressImpl implements Dress {

    private String name;
    private Optional<String> brand;
    private int size;
    private Optional<Integer> price;
    private Optional<String> purchaseDate;
    private Optional<String> description;

    private DressImpl(String name, Optional<String> brand, int size, Optional<Integer> price,
            Optional<String> purchaseDate, Optional<String> description) {
        super();
        this.name = name;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.purchaseDate = purchaseDate;
        this.description = description;
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
    public int getSize() {
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

    public static class DressBuilder {

        private String name;
        private Optional<String> brand;
        private int size;
        private Optional<Integer> price;
        private Optional<String> purchaseDate;
        private Optional<String> description;

        public DressBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DressBuilder brand(String brand) {
            this.brand = Optional.of(brand);
            return this;
        }

        public DressBuilder size(int size) {
            this.size = size;
            return this;
        }

        public DressBuilder price(int price) {
            this.price = Optional.of(price);
            return this;
        }

        public DressBuilder purchaseDate(String purchaseDate) {
            this.purchaseDate = Optional.of(purchaseDate);
            return this;
        }

        public DressBuilder description(String description) {
            this.description = Optional.of(description);
            return this;
        }

        public Dress build() {
            Objects.requireNonNull(this.name);
            Objects.requireNonNull(this.size);
            return new DressImpl(this.name, this.brand, this.size, this.price, this.purchaseDate, this.description);
        }
    }
}
