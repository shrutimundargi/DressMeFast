package controller;

import controller.data_management.DataManagementImpl;
import controller.dress.DressController;
import controller.dress.DressControllerImpl;
import controller.outfits.OutfitsController;
import controller.outfits.OutfitsControllerImpl;
import controller.user.UserController;
import controller.user.UserControllerImpl;
import model.classes.UserManagementImpl;
import model.interfaces.UserManagement;

/**
 * An implementation of the Controller.
 *
 */
public final class ControllerImpl implements Controller {

    /**
     * Singleton.
     */
    private final UserController userCtr;
    private final UserManagement userM;

    private static class SafeSingleton {
        private static final ControllerImpl SINGLETON = new ControllerImpl();
    }

    /**
     * 
     */
    protected ControllerImpl() {
        userM = new UserManagementImpl();
        userCtr = new UserControllerImpl(userM);
        loadData();
    }

    /**
     * @return SINGLETON
     */
    public static ControllerImpl getInstance() {
        return SafeSingleton.SINGLETON;
    }

    /**
     * This method loads all the informations of a user if exists otherwise create the container to store data
     */
    private void loadData() {
        new DataManagementImpl().load(userM);
    }

    @Override
    public void saveData() {
        new DataManagementImpl().save(userM.getUsersSet());
    }

    @Override
    public UserController userController() {
        return userCtr;
    }

    @Override
    public DressController dress() {
        return new DressControllerImpl(userCtr.getUser());
    }

    @Override
    public OutfitsController outfits() {
        return new OutfitsControllerImpl(userCtr.getUser());
    }

}
