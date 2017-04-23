package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import controller.authentication.Authentication;
import controller.authentication.AuthenticationImpl;
import controller.dress.DressController;
import controller.dress.DressControllerImpl;
import controller.exception.MyException;
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
    private static final String ACESS_ERROR_DRESS = "User not found, you can't acess to Dress without a user";

    private Authentication auth;
    private DressController dressCtr;
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

        try {
            Objects.requireNonNull(auth.getUser());
        } catch (Exception e) {
            final RuntimeException e2 = new MyException(ACESS_ERROR_DRESS);
            throw e2;
        }

        if (Objects.isNull(dressCtr)) {
            dressCtr = DressControllerImpl.getInstance();
            dressCtr.setUser(auth.getUser());
        }
        return dressCtr;

    }
}
