package controller;

import controller.dress.DressController;
import controller.outfits.OutfitsController;
import controller.saving.Information;
import controller.user.UserController;
import view.ScreensGraphic;
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
    void attachUI(ScreensGraphic name, UI uI);

    /**
     * @param name
     *            : name of Screen Graphic
     * @return UI
     */
    UI getUI(ScreensGraphic name);

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

    /**
     * @return Return the status of the saving data
     */
    Information saveData();
}
