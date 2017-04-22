package controller.dress;

import java.util.Set;

import model.CategoriesStatus;



/**
 *  Interface Used for Dress.
 *
 */
public interface DressController {
    /**
     * @return Set<Dress>.
     */
    Set<DressController> getThreeLastDresses();

    /**
     * @return Set<String>.
     */
    Set<String> getAllBrand();

    /**
     * @param brandName brandName
     * @return Set<Dress>
     */
    Set<DressController> getDressesOfBrand(String brandName);

    /**
     * @return Set<Dress>.
     */
    Set<DressController> getFavoriteDresses();

    /**
     * @return Set<Integer>.
     */
    Set<Integer> getAllSize();

    /**
     * @param size size
     * @return Set<Dress>
     */
    Set<DressController> getDressesOfSize(int size);

    /**
     * @return Set<String>
     */
    Set<String> getAllCategory();

    /**
     * @param categoryName categoryName
     * @return Set<Dress>
     */
    Set<DressController> getDressesOfCategory(String categoryName);

    /**
     * @param name name
     * @param brand brand
     * @param size size
     * @param price price
     * @param purchaseDate purchase date
     * @param description description
     * @param categories categories
     * @return CategoriesStatus
     */
    CategoriesStatus addDress(String name, String brand, int size, int price, String purchaseDate,
            String description, CategoriesStatus categories);
}
