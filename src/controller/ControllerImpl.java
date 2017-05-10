package controller;

import java.util.HashMap;
import java.util.Map;

import controller.dress.DressController;
import controller.dress.DressControllerImpl;
import controller.outfits.OutfitsController;
import controller.outfits.OutfitsControllerImpl;
import controller.saving.SavingData;
import controller.saving.SavingDataImpl;
import controller.user.UserController;
import controller.user.UserControllerImpl;
import model.enumerations.Status;
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
    private final SavingData save;
    private final Map<ScreensGraphic, UI> map;

    private ControllerImpl() {
        save = new SavingDataImpl();
        userCtr = new UserControllerImpl();
        map = new HashMap<>();
        loadData();
    }

    /**
     * @return SINGLETON
     */
    public static ControllerImpl getInstance() {
        return SINGLETON;
    }

    private void loadData() {
        save.load();
    }

    @Override
    public Status saveData() {
        return save.save(userCtr.getUser());
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
