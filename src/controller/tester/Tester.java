package controller.tester;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;

import controller.Controller;
import controller.ControllerImpl;
import model.classes.ModelSingleton;
import model.classes.UserManagementImpl;
import model.enumerations.Category;
import model.enumerations.Status;
import model.interfaces.Dress;
import model.interfaces.User;
import model.interfaces.UserManagement;

/**
 * 
 *
 */
public class Tester {
    private static final int NUMBER_OF_DRESSES_ADDED = 5;
    private final Controller cont = ControllerImpl.getInstance();
    private final Date data = new Date();
    private ModelSingleton model = ModelSingleton.getInstance();
    private UUID id = null;
    private User usr;

    /**
     * 
     */
    @Test
    public void dressTest() {

        userTest();

        addDress();

        checkGetDressesOf("armani");

        checkModifyDressName();

        checkGetLastAddedDresses();
        
        removeDress();

        checkGetAll();

    }

    private void user(final String name, final String pass) {
        final UserManagement userM = new UserManagementImpl();
        userM.addUser(name, pass);
        usr = userM.getSignUpUser();
        usr.getWardobe().getCategories().initializeAllCategories().getText();
        cont.setUser(usr);
    }

    private UUID addtIdDess(final Category categories) {
        return usr.getWardobe().getCategories().getCategory(categories).getAllDresses().keySet().iterator().next();

    }

    private Dress getDress(final Category categories, final UUID id) {
        return usr.getWardobe().getCategories().getCategory(categories).getDress(id);
    }

    private void userTest() {
        assertEquals(Status.USER_REGISTERED, (cont.userController().signUp("pop", "palla")));
        assertEquals(Status.USERNAME_ALREADY_TAKEN, (cont.userController().signUp("pop", "palla")));
        assertEquals(Status.USER_REGISTERED, (cont.userController().signUp("pippo", "pollo")));

        assertEquals(Status.USER_FOUND, (cont.userController().checkLogin("pop", "palla")));
        assertEquals(Status.USER_NOT_FOUND, (cont.userController().checkLogin("pollo", "fifa")));
        assertEquals(Status.WRONG_PASSWORD, (cont.userController().checkLogin("pippo", "pippo")));

        assertEquals(Status.LOGOUT_SUCCESFULL, (cont.userController().logout()));
        user("carlo", "bello");
    }

    private void addDress() {
        assertEquals(Status.DRESS_ADDED,
                (cont.dress().addDress("maglietta", "armani", 38, 10000, data, "ho speso troppo", Category.BODY)));

        assertEquals(Status.DRESS_ADDED, (cont.dress().addDress("felpa", "armani", 38, 1000000, data,
                "ho venduto la casa per una felpa", Category.BODY)));

        assertEquals(Status.DRESS_ADDED,
                (cont.dress().addDress("pantaloni", "Lee", 38, 0, data, "li ho rubati", Category.LEGS)));

        assertEquals(Status.DRESS_ADDED, (cont.dress().addDress("costume", "nike", 44, 150, data,
                "sono ingrassato ho dovuto cambiare taglia", Category.LEGS)));

        assertEquals(Status.DRESS_ADDED,
                (cont.dress().addDress("occhiali", "rayban", 0, 500, data, "ho speso troppo", Category.HEAD)));

        assertEquals(NUMBER_OF_DRESSES_ADDED, model.getDressList().size());
    }

    private void checkGetDressesOf(final String brandName) {

        final Set<UUID> dress1 = new HashSet<>();
        final Set<UUID> dress2 = new HashSet<>();

        for (final Dress dress : model.getDressList()) {
            if (dress.getBrand().get().equals(brandName)) {
                dress1.add(dress.getId());
            }
        }
        for (final Dress dress : cont.dress().getDressesOfBrand(brandName)) {
            dress2.add(dress.getId());
        }

        assertEquals(2, (cont.dress().getDressesOfBrand(brandName).size()));

        assertEquals(dress1, dress2);
    }

    private void checkModifyDressName() {

        id = addtIdDess(Category.BODY);

        assertEquals(Status.CHANGE_SUCCESFULL, (cont.dress().modifyDressName(getDress(Category.BODY, id), "new name")));
        assertEquals("new name", cont.dress().getDressName(getDress(Category.BODY, id)));
    }

    private void checkGetLastAddedDresses() {
        Set<Dress> lastAddedDresses = new HashSet<>();
        lastAddedDresses = cont.dress().getLastAddedDresses();
        assertEquals(4, lastAddedDresses.size());

    }

    private void removeDress() {
        id = addtIdDess(Category.BODY);

        cont.dress().deleteDress(getDress(Category.BODY, id));
        assertEquals(NUMBER_OF_DRESSES_ADDED - 1, model.getDressList().size());
    }

    private void checkGetAll() {
        final Set<String> brandSet = new HashSet<>();
        brandSet.add("armani");
        brandSet.add("Lee");
        brandSet.add("rayban");
        brandSet.add("nike");

        assertEquals(brandSet, cont.dress().getAllBrand());
    }

}
