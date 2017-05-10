package controller.tester;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;

import controller.Controller;
import controller.ControllerImpl;
import model.enumerations.Category;
import model.enumerations.Status;
import model.interfaces.Dress;

/**
 * 
 *
 */
public class Tester {
    private static final int PRICE_OCCHIALE = 500;
    private static final int PRICE_COSTUME = 150;
    private static final int SIZE_COSTUME = 44;
    private static final int PRICE_FELPA = 1000000;
    private static final int PRICE_MAGLIETTA = 10000;
    private static final int SIZE = 38;
    private static final String ARMANI = "armani";
    private static final int NUMBER_OF_DRESSES_ADDED = 5;
    private final Controller cont = ControllerImpl.getInstance();
    private final Date data = new Date();
    private UUID id;

    /**
     * 
     */
    @Test
    public void dressTest() {

        userTest();

        addDress();

        checkGetDressesOf(ARMANI);

        checkModifyDressName();

        checkGetLastAddedDresses();

        removeDress();

        checkGetAll();

        checkOutfits();

    }

    private UUID addtIdDess(final Category categories) {
        return cont.dress().getDressesOfCategory(categories).iterator().next().getId();

    }

    private UUID getIdOutfits() {
        return cont.outfits().getUserOutfits().get(0).getId();
    }

    private Dress getDress(final Category categories, final UUID id) {
        for (final Dress dress : cont.dress().getDressesOfCategory(categories)) {
            if (dress.getId().equals(id)) {
                return dress;
            }
        }
        return null;
    }

    private void userTest() {
        assertEquals(Status.USER_REGISTERED, (cont.userController().signUp("pop", "palla")));
        assertEquals(Status.USERNAME_ALREADY_TAKEN, (cont.userController().signUp("pop", "palla")));
        assertEquals(Status.USER_REGISTERED, (cont.userController().signUp("pippo", "pollo")));
        assertEquals(Status.LOGOUT_SUCCESFULL, (cont.userController().logout()));
        assertEquals(Status.USER_FOUND, (cont.userController().checkLogin("pop", "palla")));
        assertEquals(Status.USER_NOT_FOUND, (cont.userController().checkLogin("pollo", "fifa")));
        assertEquals(Status.WRONG_PASSWORD, (cont.userController().checkLogin("pippo", "pippo")));
    }

    private void addDress() {
        assertEquals(Status.DRESS_ADDED, (cont.dress().addDress("maglietta", ARMANI, SIZE, PRICE_MAGLIETTA, data,
                "ho speso troppo", Category.BODY)));

        assertEquals(Status.DRESS_ADDED, (cont.dress().addDress("felpa", ARMANI, SIZE, PRICE_FELPA, data,
                "ho venduto la casa per una felpa", Category.BODY)));

        assertEquals(Status.DRESS_ADDED,
                (cont.dress().addDress("pantaloni", "Lee", SIZE, 0, data, "li ho rubati", Category.LEGS)));

        assertEquals(Status.DRESS_ADDED, (cont.dress().addDress("costume", "nike", SIZE_COSTUME, PRICE_COSTUME, data,
                "sono ingrassato ho dovuto cambiare taglia", Category.LEGS)));

        assertEquals(Status.DRESS_ADDED, (cont.dress().addDress("occhiali", "rayban", 0, PRICE_OCCHIALE, data,
                "ho speso troppo", Category.HEAD)));

        assertEquals(NUMBER_OF_DRESSES_ADDED, cont.dress().getNumberOfDresses());
    }

    private void checkGetDressesOf(final String brandName) {

        final Set<UUID> dress1 = new HashSet<>();
        final Set<UUID> dress2 = new HashSet<>();

        for (final Dress dress : cont.dress().getAllDresses()) {
            if (dress.getBrand().equals(brandName)) {
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
        System.out.println("\n\t vestito eliminiato --> " + getDress(Category.BODY, id) + "\n");
        cont.dress().deleteDress(getDress(Category.BODY, id));
        assertEquals(NUMBER_OF_DRESSES_ADDED - 1, cont.dress().getNumberOfDresses());
    }

    private void checkGetAll() {
        final Set<String> brandSet = new HashSet<>();
        brandSet.add(ARMANI);
        brandSet.add("Lee");
        brandSet.add("rayban");
        brandSet.add("nike");

        assertEquals(brandSet, cont.dress().getAllBrand());
    }

    private void checkOutfits() {
        UUID idOutfits;
        final List<UUID> idDress = new LinkedList<>();
        for (final Dress dress : cont.dress().getAllDresses()) {
            idDress.add(dress.getId());
        }
        assertEquals(Status.OUTFIT_ADDED, cont.outfits().addOutfits(idDress));
        assertEquals(1, cont.outfits().getAllOutfits().size());
        assertEquals(0, cont.outfits().getAIOutfits().size());
        assertEquals(1, cont.outfits().getUserOutfits().size());
        idOutfits = getIdOutfits();
        assertEquals(idOutfits, cont.outfits().getOutfits(idOutfits).getId());

        cont.outfits().modifyOutfitsName(idOutfits, "Outfits new name");
        assertEquals("Outfits new name", cont.outfits().getOutfits(idOutfits).getName());
        assertEquals(4, cont.outfits().getOutfits(idOutfits).getOutfit().size());
    }

}
