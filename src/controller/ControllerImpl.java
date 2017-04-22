package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    private Authentication auth;
    private DressController dressC;
    private final Map<NameOfScreens, UI> map;

    private ControllerImpl() {
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
        auth = AuthenticationImpl.getInstance();
        return auth;
    }

    @Override
    public DressController dress() {
        if (Objects.isNull(auth.getUser())) {
            return null;
        } else {
            if (Objects.isNull(dressC)) {
                dressC = DressControllerImpl.getInstance();
                dressC.setUser(auth.getUser());
            }
            return dressC;
        }
    }
}
