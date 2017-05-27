package controller;

import java.util.HashMap;
import java.util.Map;

import controller.data_management.DataManagementImpl;
import controller.dress.DressController;
import controller.dress.DressControllerImpl;
import controller.outfits.OutfitsController;
import controller.outfits.OutfitsControllerImpl;
import controller.user.UserController;
import controller.user.UserControllerImpl;
import model.classes.UserManagementImpl;
import model.interfaces.UserManagement;
import view.ScreensGraphic;
import view.UI;

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
    private final Map<ScreensGraphic, UI> map;

    private static class SafeSingleton {
        private static final ControllerImpl SINGLETON = new ControllerImpl();
    }

    /**
     * 
     */
    protected ControllerImpl() {
        userM = new UserManagementImpl();
        userCtr = new UserControllerImpl(userM);
        map = new HashMap<>();
        loadData();
    }

    /**
     * @return SINGLETON
     */
    public static ControllerImpl getInstance() {
        return SafeSingleton.SINGLETON;
    }

    private void loadData() {
        new DataManagementImpl().load(userM);
    }

    @Override
    public void saveData() {
        new DataManagementImpl().save(userM.getUsersSet());
    }

    @Override
    public void attachUI(final ScreensGraphic name, final UI uI) {
        map.put(name, uI);
    }

    @Override
    public UI getUI(final ScreensGraphic name) {
        return map.get(name);
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
