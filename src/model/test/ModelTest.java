package model.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;

import model.classes.AIOutfit;
import model.classes.DressImpl;
import model.classes.UserManagementImpl;
import model.classes.UserOutfit;
import model.classes.WardobeImpl;
import model.enumerations.Category;
import model.enumerations.Outfit;
import model.enumerations.Status;
import model.interfaces.Dress;
import model.interfaces.Outfits;
import model.interfaces.UserManagement;
import model.interfaces.Wardrobe;

/**
 * This class is used to test the features of the model package.
 *
 */
public final class ModelTest {

    private static final int NUMBER_OF_DRESSES = 5;
    private final Wardrobe wardrobe = new WardobeImpl();
    private final LocalDate date = LocalDate.now();
    private final UserManagement userManagement = new UserManagementImpl();
    private final List<UUID> someDresses = new LinkedList<>();
    private Outfits firstOutfit;
    private Outfits secondOutfit;
    private static final int SIZE = 44;
    private static final int PRICE = 80;

    /**
     * Tests the creation of a user.
     */
    @Test
    public void testUser() {
        assertEquals(Status.USER_REGISTERED, (userManagement.addUser("pop", "palla")));
        assertEquals(Status.DUPLICATED_USER, (userManagement.addUser("pop", "palla")));
        assertEquals(Status.USERNAME_ALREADY_TAKEN, (userManagement.addUser("pop", "prova")));
    }

    /**
     * Tests the creation of a dress, its insertion in a category, the creation
     * of an outfit and the essentials methods.
     */
    @Test
    public void testCategoryAndOutfit() {

        wardrobe.getCategories().initializeAllCategories();
        wardrobe.getOutfits().initializeAllOutfits();

        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Category.HEAD));
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Category.BODY));
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Category.FOOT));
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Category.HANDS));
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Category.LEGS));
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Category.NECK));
        assertTrue(wardrobe.getOutfits().getAllOutfits().keySet().contains(Outfit.AI));
        assertTrue(wardrobe.getOutfits().getAllOutfits().keySet().contains(Outfit.USER));

        final Dress dress = new DressImpl.DressBuilder().buildBrand("Lee").buildDescription("Ruined Jeans")
                .buildName("Fav Jeans").buildPrice(PRICE).buildPurchaseDate(date).buildSize(SIZE).build();

        assertTrue(dress.getBrand().equals("Lee"));
        assertTrue(dress.getDescription().equals("Ruined Jeans"));
        assertTrue(dress.getName().equals("Fav Jeans"));
        assertTrue(dress.getPrice().equals(PRICE));
        assertTrue(dress.getPurchaseDate().equals(date));
        assertTrue(dress.getSize().equals(SIZE));

        final Dress dress2 = new DressImpl.DressBuilder().buildBrand("Denny Rose").buildDescription("Cool Jeans")
                .buildName("Jeans").buildPrice(PRICE).buildPurchaseDate(date).buildSize(SIZE).build();

        assertTrue(dress2.getBrand().equals("Denny Rose"));
        assertTrue(dress2.getDescription().equals("Cool Jeans"));
        assertTrue(dress2.getName().equals("Jeans"));
        assertTrue(dress2.getPrice().equals(PRICE));
        assertTrue(dress2.getPurchaseDate().equals(date));
        assertTrue(dress2.getSize().equals(SIZE));

        final Dress dress1 = new DressImpl.DressBuilder().buildBrand("On Spirit")
                .buildDescription("Violet Cool T-Shirt").buildName("Fav T-Shirt").buildPrice(PRICE)
                .buildPurchaseDate(date).buildSize(SIZE).build();

        assertTrue(dress1.getBrand().equals("On Spirit"));
        assertTrue(dress1.getDescription().equals("Violet Cool T-Shirt"));
        assertTrue(dress1.getName().equals("Fav T-Shirt"));
        assertTrue(dress1.getPrice().equals(PRICE));
        assertTrue(dress1.getPurchaseDate().equals(date));
        assertTrue(dress1.getSize().equals(SIZE));

        final Dress dress3 = new DressImpl.DressBuilder().buildBrand("Levis").buildDescription("prova")
                .buildName("prova").buildPrice(PRICE).buildPurchaseDate(date).buildSize(SIZE).build();

        final Dress dress4 = new DressImpl.DressBuilder().buildBrand("Denny Rose").buildDescription("nice jeans")
                .buildName("White Jeans").buildPrice(PRICE).buildPurchaseDate(date).buildSize(SIZE).build();

        wardrobe.getCategories().addDressToCategory(dress, Category.LEGS);
        System.out.println(dress.getCategoryName().getCategoryName());
        wardrobe.getCategories().addDressToCategory(dress2, Category.LEGS);
        System.out.println(dress2.getCategoryName().getCategoryName());
        wardrobe.getCategories().addDressToCategory(dress1, Category.BODY);
        System.out.println(dress1.getCategoryName().getCategoryName());
        wardrobe.getCategories().addDressToCategory(dress3, Category.HEAD);
        System.out.println(dress3.getCategoryName().getCategoryName());
        wardrobe.getCategories().addDressToCategory(dress4, Category.LEGS);

        assertNotNull((wardrobe.getCategories().getAllCategories().get(Category.LEGS).getDress(dress.getId())));
        assertTrue(
                wardrobe.getCategories().getAllCategories().get(Category.LEGS).getDress(dress.getId()).equals(dress));
        assertNotNull((wardrobe.getCategories().getAllCategories().get(Category.LEGS).getDress(dress2.getId())));
        assertTrue(
                wardrobe.getCategories().getAllCategories().get(Category.LEGS).getDress(dress2.getId()).equals(dress2));
        assertNotNull((wardrobe.getCategories().getAllCategories().get(Category.BODY).getDress(dress1.getId())));
        assertTrue(
                wardrobe.getCategories().getAllCategories().get(Category.BODY).getDress(dress1.getId()).equals(dress1));

        assertEquals(NUMBER_OF_DRESSES, wardrobe.getCategories().getAllDresses().size());
        assertEquals(NUMBER_OF_DRESSES, wardrobe.countDresses());

        wardrobe.getCategories().getCategory(Category.LEGS).getDress(dress.getId()).setName("new name");
        assertTrue(wardrobe.getCategories().getCategory(Category.LEGS).getDress(dress.getId()).getName()
                .equals("new name"));

        wardrobe.getCategories().modifyCategoryOfDress(dress, Category.HEAD);
        assertTrue(wardrobe.getCategories().getAllCategories().get(Category.HEAD).getAllDresses()
                .containsKey(dress.getId()));
        assertFalse(wardrobe.getCategories().getAllCategories().get(Category.LEGS).getAllDresses()
                .containsKey(dress.getId()));

        wardrobe.getCategories().removeDressFromCategory(dress, dress.getCategoryName());
        assertNull((wardrobe.getCategories().getAllCategories().get(Category.HEAD).getDress(dress.getId())));
        assertEquals(4, wardrobe.countDresses());

        final Set<String> brands = wardrobe.getAllBrands();
        System.out.println(brands.toString());
        final Set<Dress> dressesOfBrand = wardrobe.getDressesOfBrand("Levis");
        System.out.println(dressesOfBrand.toString());
        assertTrue(wardrobe.getMostPopularBrand().equals("Denny Rose"));

        someDresses.add(dress1.getId());
        someDresses.add(dress2.getId());
        dress3.setFavourited(true);
        firstOutfit = new UserOutfit().createOutfit(someDresses);
        wardrobe.getOutfits().addOutfit(firstOutfit, Outfit.USER);
        assertEquals(1, wardrobe.countOutfits());
        secondOutfit = new AIOutfit().createOutfit(wardrobe.getCategories().getAllCategories());
        wardrobe.getOutfits().addOutfit(secondOutfit, Outfit.AI);
        assertEquals(2, wardrobe.countOutfits());
        System.out.println(secondOutfit.getOutfit().toString());
        assertTrue(secondOutfit.getOutfit().contains(dress3.getId()));
        wardrobe.getOutfits().removeOutfit(firstOutfit, Outfit.USER);
        assertEquals(1, wardrobe.countOutfits());

    }
}
