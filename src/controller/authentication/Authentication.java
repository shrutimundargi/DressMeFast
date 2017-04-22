package controller.authentication;

import model.AuthenticationStatus;
import model.interfaces.User;

/**
 * 
 * Interface Used for Login/singUp a User.
 *
 */

public interface Authentication {

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
     * @return AuthenticationStatus
     */
    AuthenticationStatus logout();

    /**
     * @return User
     */
    User getUser();

    /**
     * @return String
     */
    String getUsername();

}
