package model.interfaces;


import model.enumerations.Status;

/**
 * This interface defines the methods to manage the sign up step.
 *
 */
public interface SignUp {

    /**
     * @param signUpName
     *        the chosen at sign up.
     *
     * @param signUpPassword
     *        the password chosen at sign up.
     *
     * @return if the user can sign up with the parameters.
     */
    Status storeUser(String signUpName, String signUpPassword);

    /**
     * @return the user at sign up step.
     */
    User getUser();
}
