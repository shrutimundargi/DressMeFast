package controller.authentication;

import model.enumerations.Status;

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
    Status checkLogin(String user, String pass);

    /**
     * @param user
     *            username
     * @param pass
     *            password
     * @return the status of the signUp operation
     */
    Status signUp(String user, String pass);

    /**
     * @return the status of the logout operation
     */
    Status logout();

    /**
     * @return the username of the User
     */
    String getUsername();

}
