package model.interfaces;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import model.enumerations.Category;
import model.enumerations.Status;

/**
 * The interface of an dress.
 *
 */

public interface Dress extends Serializable {

    /**
     * @return the id of the dress
     */
    UUID getId();

    /**
     * @return the image of the dress.
     */
    File getImage();

    /**
     * @return the name of the dress.
     */
    String getName();

    /**
     * @return the brand of the dress.
     */
    String getBrand();

    /**
     * @return the size of the dress.
     */
    Integer getSize();

    /**
     * @return the price of the dress.
     */
    double getPrice();

    /**
     * @return the price of the dress.
     */
    LocalDate getPurchaseDate();

    /**
     * @return the purchase date of the dress.
     */
    String getDescription();

    /**
     * @return true if the dress is set to preferred, false otherwise.
     */
    Boolean getFavourited();

    /**
     * @return how many times a dress was worn.
     */
    Integer getWornCount();

    /**
     * @return the category name in which the dress is stored.
     */
    Category getCategoryName();

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
    Status setPrice(double price);

    /**
     * @param purchaseDate
     *            the purchase date of the dress
     *
     * @return the result of the operation
     */
    Status setPurchaseDate(LocalDate purchaseDate);

    /**
     * @param description
     *            the description of a dress
     *
     * @return the result of the operation
     */
    Status setDescription(String description);

    /**
     * @param favourited
     *            true if the dress is set to preferred, false otherwise.
     *
     * @return the result of the operation
     */
    Status setFavourited(Boolean favourited);

    /**
     * This method increments by one the worn count of a particular dress.
     * 
     * @return the result of the operation.
     */
    Status setWornCount();

    /**
     * @param category
     *            the name of the category in which save the dress.
     *
     * @return the result of the operation.
     */
    Status setCategoryName(Category category);

}
