package model.classes;

import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import model.interfaces.CategoriesManagement;
import model.interfaces.Dress;
import model.interfaces.OutfitsManagement;
import model.interfaces.Wardrobe;

/**
 * The user's personal wardrobe.
 *
 */
public class WardobeImpl implements Wardrobe {

    private final CategoriesManagement categoryManagement;
    private final OutfitsManagement outfitsManagement;

    /**
     * Creates a container for the categories and outfits.
     */
    public WardobeImpl() {
        this.categoryManagement = new CategoriesManagementImpl();
        this.outfitsManagement = new OutfitsManagementImpl();
    }

    @Override
    public CategoriesManagement getCategories() {
        return this.categoryManagement;
    }

    @Override
    public OutfitsManagement getOutfits() {
        return this.outfitsManagement;
    }

    @Override
    public int countDresses() {
        return this.categoryManagement.getDressList().size();
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
        ModelSingleton.getInstance().getDressList().forEach(dress -> allBrand.add(dress.getBrand()));
        return Collections.unmodifiableSet(allBrand);
    }

    @Override
    public Set<Dress> getDressesOfBrand(final String brand) {
        final Set<Dress> dressesOfBrand = new HashSet<>();
        ModelSingleton.getInstance().getDressList().forEach(dress -> {
            if (dress.getBrand().equals(brand)) {
                dressesOfBrand.add(dress);
            }
        });
        return Collections.unmodifiableSet(dressesOfBrand);
    }

    @Override
    public Set<Integer> getAllSizes() {
        final Set<Integer> allSizes = new HashSet<Integer>();
        ModelSingleton.getInstance().getDressList().forEach(dress -> allSizes.add(dress.getSize()));
        return Collections.unmodifiableSet(allSizes);
    }

    @Override
    public Set<Dress> getFavouritedDresses() {
        final Set<Dress> dressesFavourited = new HashSet<>();
        ModelSingleton.getInstance().getDressList().forEach(dress -> {
            if (dress.getFavourited().booleanValue()) {
                dressesFavourited.add(dress);
            }
        });
        return Collections.unmodifiableSet(dressesFavourited);
    }

    @Override
    public Set<Dress> getDressesOfSize(final int size) {
        final Set<Dress> dressesOfSize = new HashSet<>();
        ModelSingleton.getInstance().getDressList().forEach(dress -> {
            if (dress.getSize().equals(size)) {
                dressesOfSize.add(dress);
            }
        });
        return Collections.unmodifiableSet(dressesOfSize);
    }

    @Override
    public Queue<Dress> getLastAddedDresses() {
        return ModelSingleton.getInstance().getDressQueue();
    }

}