package controller;



import controller.authentication.Authentication;
import controller.dress.DressController;
import view.NameOfScreens;
import view.UI;

/**
 *  Interface for the controller.
 *
 */
public interface Controller {

    /**
     * Permette di accedere ai metodi riguardanti la gestione dell'Autenticazione di un utente.
     * @return Authentication
     */
    Authentication authentication();

    /**
     * permette di accedere ai metodi riguardanti la gestione dei vestiti.
     * @return DressController
     */
    DressController dress();

    /**
     * @param name name
     * @param uI user Interface
     */
    void attachUI(NameOfScreens name, UI uI);
}
 