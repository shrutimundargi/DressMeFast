package controller.data_management;

import java.util.Set;

import model.interfaces.User;
import model.interfaces.UserManagement;

/**
 * Interface used for saving and loading Data.
 *
 */
public interface DataManagement {

    /**
     * @param userSet
     *            : the Users that will be saved
     * @return Return the status of the operation
     */
    Information save(Set<User> userSet);

    /**
     * @param userM
     *            : An instance of UserManagement
     * @return Return the status of the operation
     */
    Information load(UserManagement userM);

}
