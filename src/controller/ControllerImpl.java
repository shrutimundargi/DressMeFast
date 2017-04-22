package controller;

import java.util.HashMap;
import java.util.Map;


import controller.authentication.Authentication;
import controller.authentication.AuthenticationImpl;
import controller.dress.DressController;
import controller.dress.DressControllerImpl;
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
    private final DressController dress;
    private Map<NameOfScreens, UI> map;

    private ControllerImpl() {
        auth = AuthenticationImpl.getInstance();
        dress = DressControllerImpl.getInstance();
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
        return this.auth;
    }

    @Override
    public DressController dress() {
        return this.dress;
    }

}
