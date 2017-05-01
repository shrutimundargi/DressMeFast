package controller.tester;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import controller.Controller;
import controller.ControllerImpl;
import model.enumerations.Categories;
import model.enumerations.Status;

/**
 * 
 *
 */
public class Tester {
    private final Controller cont = ControllerImpl.getInstance();
    private final Date data = new Date();
    {
        cont.userController().signUp("carlo", "bello");
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

        assertEquals(Status.USER_FOUND, (cont.userController().checkLogin("carlo", "bello")));
        assertEquals(Status.USER_NOT_FOUND, (cont.userController().checkLogin("pollo", "palla")));
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
        assertEquals(Status.USER_REGISTERED, (cont.userController().signUp("fede", "bici")));
        assertEquals(Status.DRESS_ADDED, (cont.dress().addDress("name", "brand", 10, 10, data, "", Categories.BODY)));
        assertEquals(Status.DRESS_ADDED, (cont.dress().addDress("name", "brand", 10, 10, data, "", Categories.BODY)));
        assertEquals(Status.DRESS_ADDED, (cont.dress().addDress("name", "brand", 10, 10, data, "", Categories.BODY)));
        assertEquals(Status.LOGOUT_SUCCESFULL, (cont.userController().logout()));

    }

    /**
     * This test check modification of the dress properties.
     */
    @Test
    public void modifyDressProperties() {

    }

    // public static void main(String[] args) {
    // Date data = new Date();
    // Controller cont = ControllerImpl.getInstance();
    // System.out.println(cont.userController().signUp("pop", "palla"));
    // System.out.println(cont.userController().checkLogin("pop", "palla"));
    // // cont.authentication().logout();
    // System.out.println(cont.userController().checkLogin("pop", "palla"));
    // System.out.println(cont.userController().checkLogin("pop", "palla"));
    // //cont.authentication().logout();
    // cont.dress().addDress("name", "brand", 10, 10, data, "",
    // Categories.BODY);
    // cont.dress().addDress("name", "brand", 10, 10, data, "",
    // Categories.BODY);
    // }
}
