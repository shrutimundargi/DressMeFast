package model.interfaces;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import model.Status;

/**
 * The interface of an dress.
 *
 */

public interface Dress {

    /**
     * @return the id of the dress
     */
    UUID getId();

    /**
     * @return the name of the dress.
     */
    Optional<String> getName();

    /**
     * @return the brand of the dress.
     */
    Optional<String> getBrand();

    /**
     * @return the size of the dress.
     */
    Optional<Integer> getSize();

    /**
     * @return the price of the dress.
     */
    Optional<Integer> getPrice();

    /**
     * @return the price of the dress.
     */
    Optional<Date> getPurchaseDate();

    /**
     * @return the purchase date of the dress.
     */
    Optional<String> getDescription();

    /**
     * @param name
     *            the name of the dress
     *
     * @return the result of the operation
     */
    Status setName(String name);

    /**
     * @param brand
     *            the brand of the dress
     *
     * @return the result of the operation
     */
    Status setBrand(String brand);

    /**
     * @param size
     *            the size of the dress
     *
     * @return the result of the operation
     */
    Status setSize(int size);

    /**
     * @param price
     *            the price of the dress
     *
     * @return the result of the operation
     */
    Status setPrice(int price);

    /**
     * @param purchaseDate
     *            the purchase date of the dress
     *
     * @return the result of the operation
     */
    Status setPurchaseDate(Date purchaseDate);

    /**
     * @param description
     *            the description of a dress
     *
     * @return the result of the operation
     */
    Status setDescription(String description);

}
