package model.test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import model.classes.DressImpl;
import model.classes.ModelSingleton;
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

    private static final int SIZE = 44;
    private static final int PRICE = 80;

    /**
     * Test the creation of a dress and its insertion in a category.
     */
    @Test
    public void testCategory() {

        final Wardrobe wardrobe = new WardobeImpl();
        final Date date = new Date();
        final UserManagement userManagement = new UserManagementImpl();
        final List<UUID> someDresses = new LinkedList<>();
        Outfits firstOutfit;
        assertEquals(Status.USER_REGISTERED, (userManagement.addUser("pop", "palla")));
        assertEquals(Status.DUPLICATED_USER, (userManagement.addUser("pop", "palla")));


        wardrobe.getCategories().initializeAllCategories();
        wardrobe.getOutfits().initializeAllOutfits();

        assertTrue(wardrobe.getCategories().getDressList().isEmpty());
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Category.HEAD));
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Category.BODY));
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Category.FOOT));
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Category.HANDS));
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Category.LEGS));
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Category.NECK));


        final Dress dress = new DressImpl.DressBuilder().buildBrand("Lee").buildDescription("Ruined Jeans")
                .buildName("Fav Jeans").buildPrice(PRICE).buildPurchaseDate(date).buildSize(SIZE).build();

        assertTrue(dress.getBrand().get().equals("Lee"));
        assertTrue(dress.getDescription().get().equals("Ruined Jeans"));
        assertTrue(dress.getName().get().equals("Fav Jeans"));
        assertTrue(dress.getPrice().get().equals(PRICE));
        assertTrue(dress.getPurchaseDate().get().equals(date));
        assertTrue(dress.getSize().get().equals(SIZE));

        final Dress dress2 = new DressImpl.DressBuilder().buildBrand("Levis").buildDescription("Cool Jeans")
                .buildName("Jeans").buildPrice(PRICE).buildPurchaseDate(date).buildSize(SIZE).build();

        assertTrue(dress2.getBrand().get().equals("Levis"));
        assertTrue(dress2.getDescription().get().equals("Cool Jeans"));
        assertTrue(dress2.getName().get().equals("Jeans"));
        assertTrue(dress2.getPrice().get().equals(PRICE));
        assertTrue(dress2.getPurchaseDate().get().equals(date));
        assertTrue(dress2.getSize().get().equals(SIZE));

        final Dress dress1 = new DressImpl.DressBuilder().buildBrand("On Spirit").buildDescription("Violet Cool T-Shirt")
                .buildName("Fav T-Shirt").buildPrice(PRICE).buildPurchaseDate(date).buildSize(SIZE).build();

        assertTrue(dress1.getBrand().get().equals("On Spirit"));
        assertTrue(dress1.getDescription().get().equals("Violet Cool T-Shirt"));
        assertTrue(dress1.getName().get().equals("Fav T-Shirt"));
        assertTrue(dress1.getPrice().get().equals(PRICE));
        assertTrue(dress1.getPurchaseDate().get().equals(date));
        assertTrue(dress1.getSize().get().equals(SIZE));

        final Dress dress3 = new DressImpl.DressBuilder().buildBrand("Levis").buildDescription("prova")
                .buildName("prova").buildPrice(PRICE).buildPurchaseDate(date).buildSize(SIZE).build();

        wardrobe.getCategories().addDressToCategory(dress, Category.HEAD);
        System.out.println(dress.getCategoryName().getCategoryName());
        wardrobe.getCategories().addDressToCategory(dress2, Category.HEAD);
        System.out.println(dress2.getCategoryName().getCategoryName());
        wardrobe.getCategories().addDressToCategory(dress1, Category.BODY);
        System.out.println(dress1.getCategoryName().getCategoryName());
        wardrobe.getCategories().addDressToCategory(dress3, Category.HEAD);
        System.out.println(dress3.getCategoryName().getCategoryName());
        assertNotNull((wardrobe.getCategories().getAllCategories().get(Category.HEAD).getDress(dress.getId())));
        assertTrue(wardrobe.getCategories().getAllCategories().get(Category.HEAD).getDress(dress.getId()).equals(dress));
        assertNotNull((wardrobe.getCategories().getAllCategories().get(Category.HEAD).getDress(dress2.getId())));
        assertTrue(wardrobe.getCategories().getAllCategories().get(Category.HEAD).getDress(dress2.getId()).equals(dress2));
        assertNotNull((wardrobe.getCategories().getAllCategories().get(Category.BODY).getDress(dress1.getId())));
        assertTrue(wardrobe.getCategories().getAllCategories().get(Category.BODY).getDress(dress1.getId()).equals(dress1));
        System.out.println((wardrobe.countDresses()));
        System.out.println(wardrobe.getCategories().getAllCategories().toString());
        System.out.println(ModelSingleton.getInstance().getDressList().toString());
        wardrobe.getCategories().getCategory(Category.HEAD).getDress(dress.getId()).setName("new name");
        System.out.println(wardrobe.getCategories().getCategory(Category.HEAD).getDress(dress.getId()));
        wardrobe.getCategories().getCategory(Category.HEAD).removeDress(dress.getId());
        assertNull((wardrobe.getCategories().getAllCategories().get(Category.HEAD).getDress(dress.getId())));
        System.out.println((wardrobe.countDresses()));
        System.out.println("\n\n" + wardrobe.getCategories().getAllCategories().toString());
        System.out.println(ModelSingleton.getInstance().getDressList().toString());
        final Set<String> brands = wardrobe.getAllBrands();
        System.out.println(brands.toString());
        final Set<Dress> dressesOfBrand = wardrobe.getDressesOfBrand("Levis");
        System.out.println(dressesOfBrand.toString());
        System.out.println(ModelSingleton.getInstance().getDressQueue().toString());
        System.out.println("\n\n\n\n\n");

        someDresses.add(dress1.getId());
        someDresses.add(dress2.getId());
        firstOutfit = new UserOutfit().createOutfit(someDresses);
        wardrobe.getOutfits().addOutfit(firstOutfit, Outfit.USER);
        System.out.println(ModelSingleton.getInstance().getOutfitsList().size());
    }
}
