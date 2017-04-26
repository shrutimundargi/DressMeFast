package controller.dress;

import java.util.Date;
import java.util.Set;

import model.enumerations.Categories;
import model.enumerations.Status;
import model.interfaces.Dress;
import model.interfaces.User;

/**
 * Interface Used for Dress.
 *
 */
public interface DressController {

    /**
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
     */
    Categories addDress(String name, String brand, int size, int price, Date purchaseDate, String description,
            Categories categories);

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
    Set<Dress> getDressesOfCategory(Categories categoryName);

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
    Set<Categories> getAllCategory();

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
     * @param name
     *            : dress name
     * @return the status of the modify dress name operation
     */
    Status modifyDressName(Dress dress, String name);

    /**
     * @param dress
     *            : dress
     * @param brand
     *            : brand
     * @return the status of the modify dress brand operation
     */
    Status modifyDressBrand(Dress dress, String brand);

    /**
     * @param dress
     *            : dress
     * @param size
     *            : new size
     * @return the status of the modify dress size operation
     */
    Status modifyDressSize(Dress dress, int size);

    /**
     * @param dress
     *            : dress
     * @param data
     *            : new data
     * @return the status of the modify dress purchase date operation
     */
    Status modifyDressPurchaseDate(Dress dress, Date data);

    /**
     * @param dress
     *            : dress
     * @param description
     *            : new description
     * @return the status of the modify dress description operation
     */
    Status modifyDressDescription(Dress dress, String description);

    /**
     * @param dress
     *            : dress
     * @return the description dress
     */
    String getDressDescription(Dress dress);

    /**
     * @param dress
     *            : dress
     * @param category
     *            : new category
     * @return the status of the modify dress category operation
     */
    Status modifyDressCategory(Dress dress, Categories category);

    /**
     * @param dress
     *            : dress
     * @param favorite
     *            : new favorite
     * @return the status of the modify favorite tag operation
     */
    Status modifyFavoriteTag(Dress dress, Boolean favorite);

}
