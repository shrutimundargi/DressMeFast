package model.classes;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import model.interfaces.CategoryManagement;
import model.interfaces.Dress;
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
        return this.categoryManagement.getDressSet().size();
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

    @Override
    public Set<String> getAllBrands() {
        final Set<String> allBrand = new HashSet<String>();
        ModelSingleton.getInstance().getDressSet().forEach(dress -> allBrand.add(dress.getBrand().get()));
        return Collections.unmodifiableSet(allBrand);
    }

    @Override
    public Set<Dress> getDressesOfBrand(final String brand) {
        final Set<Dress> dressesOfBrand = new HashSet<>();
        ModelSingleton.getInstance().getDressSet().forEach(dress -> {
            if (dress.getBrand().get().equals(brand)) {
                dressesOfBrand.add(dress);
            }
        });
        return Collections.unmodifiableSet(dressesOfBrand);
    }

    @Override
    public Set<Integer> getAllSizes() {
        final Set<Integer> allSizes = new HashSet<Integer>();
        ModelSingleton.getInstance().getDressSet().forEach(dress -> allSizes.add(dress.getSize().get()));
        return Collections.unmodifiableSet(allSizes);
    }

    @Override
    public Set<Dress> getFavouritedDresses() {
        final Set<Dress> dressesFavourited = new HashSet<>();
        ModelSingleton.getInstance().getDressSet().forEach(dress -> {
            if (dress.getFavourited().booleanValue()) {
                dressesFavourited.add(dress);
            }
        });
        return Collections.unmodifiableSet(dressesFavourited);
    }

}