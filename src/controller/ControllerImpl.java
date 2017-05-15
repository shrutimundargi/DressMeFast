package controller;

import java.util.HashMap;
import java.util.Map;

import controller.dress.DressController;
import controller.dress.DressControllerImpl;
import controller.outfits.OutfitsController;
import controller.outfits.OutfitsControllerImpl;
import controller.saving.Information;
import controller.saving.SavingData;
import controller.saving.SavingDataImpl;
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
    public static final ControllerImpl SINGLETON = new ControllerImpl();

    private final UserController userCtr;
    private final UserManagement userM;
    private final SavingData save;
    private final Map<ScreensGraphic, UI> map;

    private ControllerImpl() {
        save = new SavingDataImpl();
        userCtr = new UserControllerImpl();
        map = new HashMap<>();
        userM = new UserManagementImpl();
        loadData();
    }

    /**
     * @return SINGLETON
     */
    public static ControllerImpl getInstance() {
        return SINGLETON;
    }

    private void loadData() {
        save.load(userM);
    }

    @Override
    public Information saveData() {
        return save.save(userM.getUsersSet());
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
