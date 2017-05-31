package controller;

import controller.dress.DressController;
import controller.outfits.OutfitsController;
import controller.user.UserController;

/**
 * Interface for the controller.
 *
 */
public interface Controller {
    /**
     * Allows access to authentication methods and user management.
     * 
     * @return An Authentication date that allows access to authentication
     *         methods and user management
     */
    UserController userController();

    /**
     * Allows access to all methods of dress.
     * 
     * @return A DressController date that allows access to all methods of
     *         dress
     */
    DressController dress();

    /**
     * Allows access to all methods of outfits.
     * 
     * @return OutfitsController date that allows access to all methods of
     *         outfits
     */
    OutfitsController outfits();

    /**
     * 
     */
    void saveData();
}
