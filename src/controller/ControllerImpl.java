package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import controller.authentication.Authentication;
import controller.authentication.AuthenticationImpl;
import controller.dress.DressController;
import controller.dress.DressControllerImpl;
import controller.outfits.OutfitsController;
import controller.outfits.OutfitsControllerImpl;
import view.NameOfScreens;
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

    private final Authentication auth;
    private final DressController dressCtr;
    private final OutfitsController outfistCtr;
    private final Map<NameOfScreens, UI> map;

    private ControllerImpl() {
        auth = AuthenticationImpl.getInstance();
        dressCtr = DressControllerImpl.getInstance();
        outfistCtr = OutfitsControllerImpl.getInstance();
        map = new HashMap<>();
    }

    /**
     * @return SINGLETON
     */
    public static ControllerImpl getInstance() {
        return SINGLETON;
    }

    @Override
    public void attachUI(final NameOfScreens name, final UI uI) {
        map.put(name, uI);
    }

    @Override
    public Authentication authentication() {
        dressCtr.setUser(null);
        return auth;
    }

    @Override
    public DressController dress() {
        if (Objects.isNull(dressCtr.getUser())) {
            dressCtr.setUser(auth.getUser());
        }
        return dressCtr;

    }

    @Override
    public OutfitsController outfits() {
        return outfistCtr;

    }
}
