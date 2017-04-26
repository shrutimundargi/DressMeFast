package model.interfaces;

import java.util.Set;

import model.Status;

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
     * @param usersSet
     *        the set of the current users stored.
     *
     * @return if the user can sign up with the parameters.
     */
    Status storeUser(String signUpName, String signUpPassword, Set<User> usersSet);

    /**
     * @return the set of the users stored.
     */
    Set<User> getSet();

    /**
     * @return the user at sign up step.
     */
    User getUser();
}
