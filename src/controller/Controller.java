package controller;

import controller.authentication.Authentication;
import controller.dress.DressController;
import controller.outfits.OutfitsController;
import view.NameOfScreens;
import view.UI;

/**
 * Interface for the controller.
 *
 */
public interface Controller {

    /**
     * @param name
     *            : nameOfScreens
     * @param uI
     *            : user Interface
     */
    void attachUI(NameOfScreens name, UI uI);

    /**
     * Allows access to authentication methods and user management.
     * 
     * @return An Authentication date that allows access to authentication
     *         methods and user management
     */
    Authentication authentication();

    /**
     * Allows access to all methods of dress.
     * 
     * @return An DressController date that allows access to all methods of
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
}
