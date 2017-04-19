package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import controller.authentication.Authentication;
import controller.authentication.AuthenticationImpl;
import model.AuthenticationStatus;
import model.CategoriesStatus;
import model.DressImpl;
import model.interfaces.Dress;
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
    private Authentication auth;
    private AuthenticationStatus status;
    private User user;
    private Map<NameOfScreens, UI> map;

    private ControllerImpl() {
        auth = AuthenticationImpl.getInstance();
        map = new HashMap<>();
    }

    /**
     * @return SINGLETON
     */
    public static ControllerImpl getInstance() {
        return SINGLETON;
    }

    /**
     * Questo metodo permette all'utente di loggarsi restituendo il risultato
     * dell'operazione.
     */
    @Override
    public AuthenticationStatus checkLogin(final String username, final String pass) {
        status = auth.checkAuthentication(username, pass);
        if (this.status != AuthenticationStatus.USER_NOT_FOUND || this.status != AuthenticationStatus.WRONG_PASSWORD) {
            this.user = auth.getUser();
        }
        return status;
    }

    /**
     * Questo metodo permette all'utente di Registrarsi restituendo il risultato
     * dell'operazione.
     */
    @Override
    public AuthenticationStatus signUp(final String username, final String pass) {
        status = auth.addUser(username, pass);
        if (this.status != AuthenticationStatus.USERNAME_ALREADY_TAKEN
                && this.status != AuthenticationStatus.DUPLICATED_USER) {
            this.user = auth.getUser();
        }
        return status;
    }

    @Override
    public Set<String> getAllBrand() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Integer> getAllSize() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<String> getAllCategory() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Dress> getThreeLastDresses() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Dress> getDressesOfBrand(final String brandName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Dress> getFavoriteDresses(final String brandName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Dress> getDressesOfSize(final int size) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Dress> getDressesOfCategory() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void attachUI(final NameOfScreens name, final UI uI) {
        map.put(name, uI);
    }

    @Override
    public CategoriesStatus addDress(final String name, final String brand, final int size, final int price,
            final String purchaseDate, final String description, final CategoriesStatus categories) {

        Dress dress;

        try {
            Objects.requireNonNull(categories);
        } catch (NullPointerException e) {
            return null;
        }

        dress = new DressImpl.DressBuilder().name(name).brand(brand).size(size).purchaseDate(purchaseDate)
                .description(description).build();

        return user.getWardobe().getAllCategories().addDressToCategory(categories);
    }

}
