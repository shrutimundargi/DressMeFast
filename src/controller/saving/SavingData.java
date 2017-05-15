package controller.saving;

import java.util.Set;

import model.enumerations.Status;
import model.interfaces.User;

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
    Status save(Set<User> userSet);

    /**
     * @return Return the status of the operation
     */
    Status load();

}
