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
     *            : username
     * @param pass
     *            : password
     * @return the status of the Login operation.
     *         <p>
     *         Return USER_NOT_FOUND if the username don't exist, and
     *         WORONG_PASSWORD if the password is wrong, otherwise if everything
     *         goes well return USER_FOUND
     * 
     */
    Status checkLogin(String user, String pass);

    /**
     * @param user
     *            : username
     * @param pass
     *            : password
     * @return the status of the signUp operation.
     *         <P>
     *         Return USERNAME_ALREADY_TAKEN if the username already exist
     *         otherwise if everything goes well return USER_REGISTERED
     */
    Status signUp(String user, String pass);

    /**
     * @return the status of the logout operation
     *         <P>
     *         Return LOGOUT_SUCCESFULL
     */
    Status logout();

    /**
     * @return the username of the User
     */
    String getUsername();

}
