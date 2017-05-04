package controller.dress;

import java.util.Date;
import java.util.Set;

import model.enumerations.Category;
import model.enumerations.Status;
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
     * @return the status of adding a dress operation
     *         <P>
     *         Return DRESS_NOT_ADDED if there is a problem with the adding
     *         otherwise return DRESS_ADDED
     */
    Status addDress(String name, String brand, int size, int price, Date purchaseDate, String description,
            Category categories);

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
     * @return A set of all dresses research
     */
    Set<Dress> getDressesResearch();

    /**
     * @return All categories
     */
    Set<Category> getAllCategory();

    /**
     * @return All brands
     */
    Set<String> getAllBrand();

    /**
     * @return All sizes of dresses
     */
    Set<Integer> getAllSize();

    /**
     * @return User favorite dresses
     */
    Set<Dress> getFavoriteDresses();

    /**
     * @return the last three dresses added
     */
    Set<Dress> getThreeLastDresses();

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
    Date getDressPurchaseDate(Dress dress);

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
    Status modifyDressPurchaseDate(Dress dress, Date data);

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
     *         If everything goes well return CHANGE_SUCCESFULL
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

}
