package model.interfaces;

import java.util.Set;

import model.enumerations.Status;

/**
 * This interface defines the methods to manage a multitude of users.
 *
 */
public interface UserManagement {

    /**
     * @param signUpName
     *            the name specified at signup.
     * 
     * @param signUpPassword
     *            the password specified at signup.
     * 
     * @return the result of adding an user.
     */
    Status addUser(String signUpName, String signUpPassword);

    /**
     * @param name
     *        the name of the user to get.
     *
     * @param password
     *        the password of the user to get.
     *
     * @return the user specified by the parameters.
     */
    Status getSpecifiedUser(String name, String password);

    /**
     * @return the user object in the login step.
     */
    User getLoginUser();

    /**
     * @return the user object in the signup step.
     */
    User getSignUpUser();

    /**
     * @return all the users stored.
     */
    Set<User> getUsersSet();
}
