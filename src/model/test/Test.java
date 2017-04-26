package model.test;

import java.util.Date;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import model.classes.CategoryManagementImpl;
import model.classes.DressImpl;
import model.enumerations.Categories;

import model.interfaces.Dress;

/**
 * This class is used to test the features of the model package.
 *
 */
public final class Test {

    /**
     * Test the creation of a dress and its insertion in a category.
     */
    @org.junit.Test
    public void testCategory() {
        CategoryManagementImpl allCategories = new CategoryManagementImpl();
        Date date = new Date();
        allCategories.initializeAllCategories();

        assertTrue(allCategories.getIdSet().isEmpty());
        assertTrue(allCategories.getAllCategories().keySet().contains(Categories.BODY));
        assertTrue(allCategories.getAllCategories().keySet().contains(Categories.FOOT));
        assertTrue(allCategories.getAllCategories().keySet().contains(Categories.HANDS));
        assertTrue(allCategories.getAllCategories().keySet().contains(Categories.HEAD));
        assertTrue(allCategories.getAllCategories().keySet().contains(Categories.LEGS));
        assertTrue(allCategories.getAllCategories().keySet().contains(Categories.NECK));

        Dress dress = new DressImpl.DressBuilder().buildBrand("Levis").buildDescription("Ruined Jeans")
                .buildName("Fav Jeans").buildPrice(80).buildPurchaseDate(date).buildSize(44).build();
        /*
        assertTrue(dress.getBrand().equals("Levis"));
        assertTrue(dress.getDescription().equals("Ruined Jeans"));
        assertTrue(dress.getName().equals("Fav Jeans"));
        assertTrue(dress.getPrice().equals(80));
        assertTrue(dress.getPurchaseDate().equals(date));
        assertTrue(dress.getSize().equals(44));
        */
        allCategories.addDressToCategory(dress, Categories.HEAD);
        assertNotNull((allCategories.getAllCategories().get(Categories.HEAD).getDress(dress.getId())));
        assertTrue(allCategories.getAllCategories().get(Categories.HEAD).getDress(dress.getId()).equals(dress));
    }
}
