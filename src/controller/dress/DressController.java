package controller.dress;

import java.util.Date;
import java.util.Set;

import model.CategoriesStatus;
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
    CategoriesStatus addDress(String name, String brand, int size, int price, Date purchaseDate, String description,
            CategoriesStatus categories);

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
    Set<Dress> getDressesOfCategory(CategoriesStatus categoryName);

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
    Set<CategoriesStatus> getAllCategory();

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

}
