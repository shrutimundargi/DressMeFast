package model.test;

import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import model.classes.DressImpl;
import model.classes.WardobeImpl;
import model.enumerations.Categories;
import model.enumerations.Outfits;
import model.interfaces.Dress;
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
        /*final CategoryManagement allCategories = new CategoryManagementImpl();
        final OutfitsManagement allOutfits = new OutfitsManagementImpl();
        */
        final Wardrobe wardrobe = new WardobeImpl();
        final Date date = new Date();

        wardrobe.getCategories().initializeAllCategories();
        wardrobe.getOutfits().initializeAllOutfits();

        assertTrue(wardrobe.getCategories().getIdSet().isEmpty());
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Categories.HEAD));
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Categories.BODY));
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Categories.FOOT));
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Categories.HANDS));
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Categories.LEGS));
        assertTrue(wardrobe.getCategories().getAllCategories().keySet().contains(Categories.NECK));
        assertTrue(wardrobe.getOutfits().getAllOutfits().keySet().contains(Outfits.USER));
        assertTrue(wardrobe.getOutfits().getAllOutfits().keySet().contains(Outfits.AI));

        final Dress dress = new DressImpl.DressBuilder().buildBrand("Levis").buildDescription("Ruined Jeans")
                .buildName("Fav Jeans").buildPrice(PRICE).buildPurchaseDate(date).buildSize(SIZE).build();

        assertTrue(dress.getBrand().get().equals("Levis"));
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

        wardrobe.getCategories().addDressToCategory(dress, Categories.HEAD);
        wardrobe.getCategories().addDressToCategory(dress2, Categories.HEAD);
        wardrobe.getCategories().addDressToCategory(dress1, Categories.BODY);
        wardrobe.getCategories().addDressToCategory(dress3, Categories.HEAD);
        assertNotNull((wardrobe.getCategories().getAllCategories().get(Categories.HEAD).getDress(dress.getId())));
        assertTrue(wardrobe.getCategories().getAllCategories().get(Categories.HEAD).getDress(dress.getId()).equals(dress));
        assertNotNull((wardrobe.getCategories().getAllCategories().get(Categories.HEAD).getDress(dress2.getId())));
        assertTrue(wardrobe.getCategories().getAllCategories().get(Categories.HEAD).getDress(dress2.getId()).equals(dress2));
        assertNotNull((wardrobe.getCategories().getAllCategories().get(Categories.BODY).getDress(dress1.getId())));
        assertTrue(wardrobe.getCategories().getAllCategories().get(Categories.BODY).getDress(dress1.getId()).equals(dress1));
        System.out.println((wardrobe.countDresses()));

    }
}
