package model.classes;

import model.interfaces.CategoryManagement;
import model.interfaces.Wardrobe;

/**
 * The user's personal wardrobe.
 *
 */
public class WardobeImpl implements Wardrobe {

    private final CategoryManagement categoryManagement;

    /**
     * Creates a container for the categories and outfits.
     */
    public WardobeImpl() {
        this.categoryManagement = new CategoryManagementImpl();
    }

    @Override
    public CategoryManagement getAllCategories() {
        return this.categoryManagement;
    }
}