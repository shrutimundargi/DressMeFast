package model.interfaces;

import java.util.Optional;

import model.AuthenticationStatus;

/**
 * The interface of an dress.
 *
 */

public interface Dress {

    /**
     * @return the name of the dress.
     */
    String getName();

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
    Optional<String> getPurchaseDate();

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
    AuthenticationStatus setName(String name);

    /**
     * @param brand
     *            the brand of the dress
     *
     * @return the result of the operation
     */
    AuthenticationStatus setBrand(String brand);

    /**
     * @param size
     *            the size of the dress
     *
     * @return the result of the operation
     */
    AuthenticationStatus setSize(int size);

    /**
     * @param price
     *            the price of the dress
     *
     * @return the result of the operation
     */
    AuthenticationStatus setPrice(int price);

    /**
     * @param purchaseDate
     *            the purchase date of the dress
     *
     * @return the result of the operation
     */
    AuthenticationStatus setPurchaseDate(String purchaseDate);

    /**
     * @param description
     *            the description of a dress
     *
     * @return the result of the operation
     */
    AuthenticationStatus setDescription(String description);

}
