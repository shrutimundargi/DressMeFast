package controller.user;

import java.time.LocalDate;

import model.enumerations.Status;
import model.interfaces.User;

/**
 * 
 * Interface used to allow a user to signUp and Login.
 *
 */

public interface UserController {

    /**
     * @param user
     *            : user's name
     * @param pass
     *            : user's password
     * @return the status of the Login operation.
     *         <p>
     *         Return USER_NOT_FOUND if the user's name doesn't exist, and
     *         WORONG_PASSWORD if the password is wrong, otherwise if everything
     *         goes well return USER_FOUND
     * 
     */
    Status checkLogin(String user, String pass);

    /**
     * @param user
     *            : user's name
     * @param pass
     *            : password
     * @return the status of the signUp operation.
     *         <P>
     *         Return USERNAME_ALREADY_TAKEN if the user's name already exist
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
     * @return the user's name
     */
    String getUsername();

    /**
     * @return Return the user
     */
    User getUser();

    /**
     * @return Return the registration date
     */
    LocalDate getSingUpDate();

}
