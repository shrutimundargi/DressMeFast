package controller;

import java.util.HashMap;
import java.util.Map;

import controller.authentication.Authentication;
import controller.authentication.AuthenticationImpl;
import controller.dress.DressController;
import controller.dress.DressControllerImpl;
import controller.outfits.OutfitsController;
import controller.outfits.OutfitsControllerImpl;
import model.interfaces.User;
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
    private final Map<NameOfScreens, UI> map;
    private User user;

    private ControllerImpl() {
        auth = new AuthenticationImpl();
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
    
    public UI getUI(NameOfScreens name){
    	return map.get(name);
    }

    @Override
    public Authentication authentication() {
        return auth;
    }

    @Override
    public DressController dress() {
       return new DressControllerImpl(user);

    }

    @Override
    public OutfitsController outfits() {
        return new OutfitsControllerImpl();
    }

    @Override
    public void setUser(final User user) {
        this.user = user;
    }
}
