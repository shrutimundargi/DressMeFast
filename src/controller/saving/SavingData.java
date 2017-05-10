package controller.saving;

import model.enumerations.Status;
import model.interfaces.User;

/**
 * Interface used for saving Data.
 *
 */
public interface SavingData {

    /**
     * @param user
     *            : the User who will be saved
     * @return Return the status of the operation
     */
    Status save(User user);

    /**
     * @return Return the status of the operation
     */
    Status load();

}
