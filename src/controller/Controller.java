package controller;


import controller.authentication.Authentication;
import controller.dress.DressController;
import controller.outfits.OutfitsController;
import view.NameOfScreens;
import view.UI;

/**
 *  Interface for the controller.
 *
 */
public interface Controller {

    /**
     * Allows access to all methods for authentication.
     * 
     * @return An Authentication date that allows access to all methods for
     *         authentication
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
     * @param name
     *            nameOfScreens
     * @param uI
     *            : user Interface
     */
    void attachUI(NameOfScreens name, UI uI);

    /**
     * Allows access to all methods of outfits.
     * 
     * @return OutfitsController date that allows access to all methods of
     *           outfits
     */
    OutfitsController outfits();
}
