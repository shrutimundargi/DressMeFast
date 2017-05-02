package model.classes;

import model.interfaces.CategoryManagement;
import model.interfaces.OutfitsManagement;
import model.interfaces.Wardrobe;

/**
 * The user's personal wardrobe.
 *
 */
public class WardobeImpl implements Wardrobe {

    private final CategoryManagement categoryManagement;
    private final OutfitsManagement outfitsManagement;

    /**
     * Creates a container for the categories and outfits.
     */
    public WardobeImpl() {
        this.categoryManagement = new CategoryManagementImpl();
        this.outfitsManagement = new OutfitsManagementImpl();
    }

    @Override
    public CategoryManagement getCategories() {
        return this.categoryManagement;
    }

    @Override
    public OutfitsManagement getOutfits() {
        return this.outfitsManagement;
    }

    @Override
    public int countDresses() {
        return this.categoryManagement.getIdSet().size();
    }

    @Override
    public int countOutfits() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getMostPopularBrand() {
        // TODO Auto-generated method stub
        return null;
    }
}