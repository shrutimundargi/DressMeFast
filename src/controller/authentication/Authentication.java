package controller.authentication;

import model.AuthenticationStatus;
import model.interfaces.User;

/**
 * 
 * Interface Used for Login/singUp a User.
 *
 *
 */

public interface Authentication {

    /**
     * @param user user
     * @param pass password
     * @return AuthenticationStatus
     */
    AuthenticationStatus addUser(String user, String pass);

    /**
     * @param user user
     * @param pass password
     * @return AuthenticationStatus
     */
    AuthenticationStatus checkAuthentication(String user, String pass);

    /**
     * @return User
     */
    User getUser();

}
