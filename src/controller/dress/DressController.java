package controller.dress;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import model.enumerations.Category;
import model.enumerations.Status;
import model.interfaces.Categories;
import model.interfaces.Dress;
import model.interfaces.User;

/**
 * Interface Used for Dress.
 *
 */
public interface DressController {

    /**
     *
     *
     * @param name
     *            : dress name
     * @param brand
     *            : brand
     * @param size
     *            : size
     * @param price
     *            : price
     * @param purchaseDate
     *            : purchase date
     * @param description
     *            : description
     * @param categories
     *            : categories
     * @param image
     *            : the image
     * @return the status of adding a dress operation
     *         <P>
     *         Return DRESS_NOT_ADDED if there is a problem with the adding
     *         otherwise return DRESS_ADDED
     */
    Status addDress(String name, String brand, Integer size, double price, LocalDate purchaseDate, String description,
            Category categories, File image);

    /**
     * @param brandName
     *            : the name of the brand
     * @return all dresses of one specific brand
     */
    Set<Dress> getDressesOfBrand(String brandName);

    /**
     * @param categoryName
     *            : the name of category
     * @return All dresses of the specified category
     */
    Set<Dress> getDressesOfCategory(Category categoryName);

    /**
     * @param size
     *            : sizes of dress
     * @return All dresses of the specified size
     */
    Set<Dress> getDressesOfSize(int size);

    /**
     * @return All categories
     */
    Set<Categories> getAllCategory();

    /**
     * @param id
     *            : id of the dress
     * @return the dress associated at the id specified
     */
    Dress getDressFromUUID(UUID id);

    /**
     * @return All brands
     */
    Set<String> getAllBrand();

    /**
     * @return All sizes of dresses
     */
    Set<Integer> getAllSize();

    /**
     * @return Return all Dresses
     */
    List<Dress> getAllDresses();

    /**
     * @param categoryName
     *            : the name of the category
     * @return Return all Brand into a Category
     */
    List<String> getAllBrandName(Category categoryName);

    /**
     * @param categoryName
     *            : the name of the category
     * @param brand
     *            : the name of dress
     * @return Return all Dress with the category and brand specified
     */
    List<Dress> getAllBrandDress(Category categoryName, String brand);

    /**
     * @param categoryName
     *            : the name of category
     * @return Return all size of the specified category
     */
    List<Integer> getAllSizeName(Category categoryName);

    /**
     * @param categoryName
     *            : the name of the category
     * @param size
     *            : the name of brand
     * @return Return all dress with the category and size specified
     */
    List<Dress> getAllSizeDress(Category categoryName, int size);

    /**
     * @return Return the number of dresses added
     */
    int getNumberOfDresses();

    /**
     * @return User favorite dresses
     */
    Set<Dress> getFavoriteDresses();

    /**
     * @return the last three dresses added
     */
    Set<Dress> getLastAddedDresses();

    /**
     * @param user
     *            : User
     */
    void setUser(User user);

    /**
     * @param dress
     *            : dress
     * @return Return the name of dress
     */
    String getDressName(Dress dress);

    /**
     * @param dress
     *            : dress
     * @return Return the brand of dress
     */
    String getDressBrand(Dress dress);

    /**
     * @param dress
     *            : dress
     * @return Return the dress size
     */
    int getDressSize(Dress dress);

    /**
     * @param dress
     *            : dress
     * @return Return the purchase date of the dress
     */
    LocalDate getDressPurchaseDate(Dress dress);

    /**
     * @param dress
     *            : dress
     * @return the description dress
     */
    String getDressDescription(Dress dress);

    /**
     * @param dress
     *            : dress
     * @return Return true if the favorite tag is true, otherwise false
     */
    Boolean getFavoriteTag(Dress dress);

    /**
     * @param dress
     *            : dress
     * @param name
     *            : dress name
     * @return the status of the modify dress name operation
     *         <P>
     *         If everything goes well return CHANGE_SUCCESFULL
     */
    Status modifyDressName(Dress dress, String name);

    /**
     * @param dress
     *            : dress
     * @param brand
     *            : brand
     * @return the status of the modify dress brand operation
     *         <P>
     *         If everything goes well return CHANGE_SUCCESFULL
     */
    Status modifyDressBrand(Dress dress, String brand);

    /**
     * @param dress
     *            : dress
     * @param size
     *            : new size
     * @return the status of the modify dress size operation
     *         <P>
     *         If everything goes well return CHANGE_SUCCESFULL
     */
    Status modifyDressSize(Dress dress, int size);

    /**
     * @param dress
     *            : dress
     * @param data
     *            : new data
     * @return the status of the modify dress purchase date operation
     *         <P>
     *         If everything goes well return CHANGE_SUCCESFULL
     */
    Status modifyDressPurchaseDate(Dress dress, LocalDate data);

    /**
     * @param dress
     *            : dress
     * @param description
     *            : new description
     * @return the status of the modify dress description operation
     *         <P>
     *         If everything goes well return CHANGE_SUCCESFULL
     */
    Status modifyDressDescription(Dress dress, String description);

    /**
     * @param dress
     *            : dress
     * @param category
     *            : new category
     * @return the status of the modify dress category operation
     *         <P>
     *         If everything goes well return DRESS_MODIFIED otherwise
     *         DRESS_NOT_MODIFIED
     */
    Status modifyDressCategory(Dress dress, Category category);

    /**
     * @param dress
     *            : dress
     * @param favorite
     *            : new favorite
     * @return the status of the modify favorite tag operation
     *         <P>
     *         If everything goes well return CHANGE_SUCCESFULL
     */
    Status modifyFavoriteTag(Dress dress, Boolean favorite);

    /**
     * @param dress
     *            : the dress that you want delete
     * @return the status of the delete dress operation
     */
    Status deleteDress(Dress dress);

    /**
     * @param dress
     *            : the dress that you wore
     */
    void dressWorn(Dress dress);

    /**
     * @param dress
     *            : the dress that you wont the information
     * @return Return the number of time that the dress was worn
     */
    int numberTimeDressWorn(Dress dress);

    /**
     * @return Return all popular brand
     */
    String getPopularBrand();

    /**
     * @param category
     *            : the category name
     * @return Return all dress into a specific category
     */
    List<Dress> getDressIntoCategory(Category category);

    /**
     * @param dress
     *            : the dress that you wont change price
     * @param price
     *            : the price that you wont change
     * @return the status of the modify price operation
     *         <P>
     *         If everything goes well return CHANGE_SUCCESFULL
     */
    Status modifyDressPrice(Dress dress, double price);

}
