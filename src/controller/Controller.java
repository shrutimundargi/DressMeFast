package controller;

import java.util.Set;

import model.interfaces.Dress;
import view.NameOfScreens;
import view.UI;
import model.AuthenticationStatus;
import model.CategoriesStatus;

/**
 *  Interface for the controller.
 *
 */
public interface Controller {

    /**
     * @param user user
     * @param pass password
     * @return AuthenticationStatus
     */
    AuthenticationStatus checkLogin(String user, String pass);

    /**
     * @param user user
     * @param pass password
     * @return AuthenticationStatus
     */
    AuthenticationStatus signUp(String user, String pass);

    /**
     * @return Set<Dress>.
     */
    Set<Dress> getThreeLastDresses();

    /**
     * @return Set<String>.
     */
    Set<String> getAllBrand();

    /**
     * @param brandName brandName
     * @return Set<Dress>
     */
    Set<Dress> getDressesOfBrand(String brandName);

    /**
     * @return Set<Dress>.
     */
    Set<Dress> getFavoriteDresses();

    /**
     * @return Set<Integer>.
     */
    Set<Integer> getAllSize();

    /**
     * @param size size
     * @return Set<Dress>
     */
    Set<Dress> getDressesOfSize(int size);

    /**
     * @return Set<String>
     */
    Set<String> getAllCategory();

    /**
     * @param categoryName categoryName
     * @return Set<Dress>
     */
    Set<Dress> getDressesOfCategory(String categoryName);

    /**
     * @param name name
     * @param uI user Interface
     */
    void attachUI(NameOfScreens name, UI uI);

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

    /**
     * @return String Username
     */
    String getUsername();

    /**
     * @return AuthenticationStatus Logout
     */
    AuthenticationStatus logout();

}
 