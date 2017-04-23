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
     * @param user
     *            username
     * @param pass
     *            password
     * @return the status of the Login operation
     */
    AuthenticationStatus checkLogin(String user, String pass);

    /**
     * @param user
     *            username
     * @param pass
     *            password
     * @return the status of the signUp operation
     */
    AuthenticationStatus signUp(String user, String pass);

    /**
     * @return the status of the logout operation
     */
    AuthenticationStatus logout();

    /**
     * @return User
     */
    User getUser();

    /**
     * @return the username of the User
     */
    String getUsername();

}
