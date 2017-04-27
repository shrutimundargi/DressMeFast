package model.test;

import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import model.classes.CategoryManagementImpl;
import model.classes.DressImpl;
import model.enumerations.Categories;

import model.interfaces.Dress;

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
        final CategoryManagementImpl allCategories = new CategoryManagementImpl();
        final Date date = new Date();
        allCategories.initializeAllCategories();
        /*
         * assertTrue(allCategories.getIdSet().isEmpty());
         * assertTrue(allCategories.getAllCategories().keySet().contains(
         * Categories.BODY));
         * assertTrue(allCategories.getAllCategories().keySet().contains(
         * Categories.FOOT));
         * assertTrue(allCategories.getAllCategories().keySet().contains(
         * Categories.HANDS));
         * assertTrue(allCategories.getAllCategories().keySet().contains(
         * Categories.HEAD));
         * assertTrue(allCategories.getAllCategories().keySet().contains(
         * Categories.LEGS));
         * assertTrue(allCategories.getAllCategories().keySet().contains(
         * Categories.NECK));
         */
        final Dress dress = new DressImpl.DressBuilder().buildBrand("Levis").buildDescription("Ruined Jeans")
                .buildName("Fav Jeans").buildPrice(PRICE).buildPurchaseDate(date).buildSize(SIZE).build();

        assertTrue(dress.getBrand().get().equals("Levis"));
        assertTrue(dress.getDescription().get().equals("Ruined Jeans"));
        assertTrue(dress.getName().get().equals("Fav Jeans"));
        assertTrue(dress.getPrice().get().equals(PRICE));
        assertTrue(dress.getPurchaseDate().get().equals(date));
        assertTrue(dress.getSize().get().equals(SIZE));

        allCategories.addDressToCategory(dress, Categories.HEAD);
        assertNotNull((allCategories.getAllCategories().get(Categories.HEAD).getDress(dress.getId())));
        assertTrue(allCategories.getAllCategories().get(Categories.HEAD).getDress(dress.getId()).equals(dress));
    }
}
