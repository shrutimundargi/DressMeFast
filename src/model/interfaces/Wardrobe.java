package model.interfaces;

/**
 * This interface is used to manage a user's wardrobe.
 *
 */
public interface Wardrobe {

    /**
     * @return all the categories objects.
     */
    CategoryManagement getCategories();

    /**
     * @return all the outfits objects.
     */
    OutfitsManagement getOutfits();

    int countDresses();

    int countOutfits();

    String getMostPopularBrand();

}
