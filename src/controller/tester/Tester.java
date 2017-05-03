package controller.tester;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;

import controller.Controller;
import controller.ControllerImpl;
import model.classes.UserManagementImpl;
import model.enumerations.Categories;
import model.enumerations.Status;
import model.interfaces.Dress;
import model.interfaces.User;
import model.interfaces.UserManagement;

/**
 * 
 *
 */
public class Tester {
    private final Controller cont = ControllerImpl.getInstance();
    private final Date data = new Date();
    private User usr;

    /**
     * 
     */
    public Tester() {
        cont.userController().signUp("ale", "view");
        cont.userController().signUp("carlo", "bello");
    }

    private void user() {
        final UserManagement userM = new UserManagementImpl();
        userM.addUser("michi", "carne");
        usr = userM.getSignUpUser();
        usr.getWardobe().getCategories().initializeAllCategories().getText();
        cont.setUser(usr);
    }

    private UUID getIdDess() {
        return usr.getWardobe().getCategories().getCategory(Categories.BODY).getAllDresses().keySet().iterator().next();
    }

    private Dress getDress(final Categories categories, final UUID id) {
        return usr.getWardobe().getCategories().getCategory(categories).getDress(id);
    }

    /**
     * This test check the correct sing up of the User.
     */
    @Test
    public void singUpTest() {
        assertEquals(Status.USER_REGISTERED, (cont.userController().signUp("pop", "palla")));
        assertEquals(Status.USERNAME_ALREADY_TAKEN, (cont.userController().signUp("pop", "palla")));
        assertEquals(Status.USER_REGISTERED, (cont.userController().signUp("pippo", "pollo")));
    }

    /**
     * This test check the correct login of the User.
     */
    @Test
    public void loginTest() {
        assertEquals(Status.USER_FOUND, (cont.userController().checkLogin("ale", "view")));
        assertEquals(Status.USER_NOT_FOUND, (cont.userController().checkLogin("pollo", "fifa")));
        assertEquals(Status.WRONG_PASSWORD, (cont.userController().checkLogin("carlo", "pippo")));

    }

    /**
     * This test check the correct logout of the User.
     */
    @Test
    public void logoutTest() {
        assertEquals(Status.LOGOUT_SUCCESFULL, (cont.userController().logout()));
    }

    /**
     * This test check the correct adding of a dress.
     */
    @Test
    public void addDress() {
        assertEquals(Status.DRESS_ADDED, (cont.dress().addDress("dress", "brand", 10, 10, data, "", Categories.BODY)));
        assertEquals(Status.DRESS_ADDED, (cont.dress().addDress("dress2", "brand", 10, 10, data, "", Categories.BODY)));
        assertEquals(Status.DRESS_ADDED, (cont.dress().addDress("dress3", "brand", 10, 10, data, "", Categories.BODY)));
        assertEquals(Status.LOGOUT_SUCCESFULL, (cont.userController().logout()));

    }

    /**
     * This test check modification of the dress properties.
     */
    @Test
    public void modifyDressProperties() {
        UUID idDress;
        user();

        assertEquals(Status.DRESS_ADDED,
                (cont.dress().addDress("dress4", "armani", 10, 10, data, "", Categories.BODY)));

        idDress = getIdDess();

        assertEquals(Status.CHANGE_SUCCESFULL,
                (cont.dress().modifyDressName(getDress(Categories.BODY, idDress), "new name")));
        assertEquals("new name", cont.dress().getDressName(getDress(Categories.BODY, idDress)));
    }
}
