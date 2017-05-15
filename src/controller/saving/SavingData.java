package controller.saving;

import java.util.Set;

import model.interfaces.User;
import model.interfaces.UserManagement;

/**
 * Interface used for saving Data.
 *
 */
public interface SavingData {

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
