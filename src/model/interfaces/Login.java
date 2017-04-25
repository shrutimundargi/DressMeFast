package model.interfaces;

import java.util.Set;

import model.Status;

/**
 * This interface defines the methods to manage the login step.
 *
 */
public interface Login { 

    /**
     * @param name
     *        the name of the user to check.
     *
     * @param pass
     *        the password of the user to check.
     *
     * @param usersSet
     *        the set of all the user stored.
     *
     * @return if the user is able to login with the parameters.
     */
    Status checkLogin(String name, String pass, Set<User> usersSet);

    /**
     * @return the user in the login step.
     */
    User getUser();
}
