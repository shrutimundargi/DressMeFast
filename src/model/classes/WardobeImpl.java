package model.classes;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

import model.enumerations.Category;
import model.interfaces.CategoriesManagement;
import model.interfaces.Dress;
import model.interfaces.OutfitsManagement;
import model.interfaces.Wardrobe;

/**
 * The user's personal wardrobe.
 *
 */
public class WardobeImpl implements Wardrobe {

    /**
     * 
     */
    private static final long serialVersionUID = 4418864464274282296L;
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
        final int size;
        final List<Integer> list = new LinkedList<>();
        this.getCategories().getAllCategories().values().forEach(category -> {
            list.add(category.getAllDresses().keySet().size());

        });

        size = list.stream().reduce(0, Integer::sum);
        return size;
    };

    @Override
    public int countOutfits() {
        final int size;
        final List<Integer> list = new LinkedList<>();
        this.getOutfits().getAllOutfits().values().forEach(outfit -> {
            list.add(outfit.size());

        });

        size = list.stream().reduce(0, Integer::sum);
        return size;
    }

    @Override
    public String getMostPopularBrand() {
        List<Dress> dressList = new LinkedList<>();
        Map<String, Integer> tmpMap = new HashMap<>();
        Entry<String, Integer> maxEntry = null;

        this.categoryManagement.getAllCategories().values().forEach(category -> {
            category.getAllDresses().values().forEach(dress -> {
                dressList.add(dress);
            });
        });

        dressList.forEach(dress -> {
            if (!tmpMap.containsKey(dress.getBrand())) {
                tmpMap.put(dress.getBrand(), 0);
            } else if (tmpMap.containsKey(dress.getBrand())) {
                int tmp = tmpMap.get(dress.getBrand()).intValue();
                tmp++;
                tmpMap.put(dress.getBrand(), tmp);
            }
        });

        for (Entry<String, Integer> entry : tmpMap.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }

    @Override
    public Set<Dress> getDressesOfBrand(final String brand) {
        final Set<Dress> dressesOfBrand = new HashSet<>();
        this.categoryManagement.getAllCategories().values().forEach(category -> {
            category.getAllDresses().values().forEach(dress -> {
                if (dress.getBrand().equals(brand)) {
                    dressesOfBrand.add(dress);
                }
            });
        });
        return Collections.unmodifiableSet(dressesOfBrand);

    }

    @Override
    public Set<String> getAllBrands() {
        final Set<String> brands = new HashSet<>();
        this.categoryManagement.getAllCategories().values().forEach(category -> {
            category.getAllDresses().values().forEach(dress -> {
                final String name = dress.getBrand();
                brands.add(name);
            });
        });
        return Collections.unmodifiableSet(brands);
    }

    @Override
    public Set<Integer> getAllSizes() {
        final Set<Integer> allSizes = new HashSet<>();
        this.categoryManagement.getAllCategories().values().forEach(category -> {
            category.getAllDresses().values().forEach(dress -> {
                final int size = dress.getSize();
                allSizes.add(size);
            });
        });
        return Collections.unmodifiableSet(allSizes);

    }

    @Override
    public Set<Dress> getFavouritedDresses() {
        final Set<Dress> dressesFavourited = new HashSet<>();
        this.categoryManagement.getAllCategories().values().forEach(category -> {
            category.getAllDresses().values().forEach(dress -> {
                if (dress.getFavourited().booleanValue()) {
                    dressesFavourited.add(dress);
                }
            });
        });
        return Collections.unmodifiableSet(dressesFavourited);
    }

    @Override
    public Set<Dress> getDressesOfSize(final int size) {
        final Set<Dress> dressesOfSize = new HashSet<>();
        this.categoryManagement.getAllCategories().values().forEach(category -> {
            category.getAllDresses().values().forEach(dress -> {
                if (dress.getSize().equals(size)) {
                    dressesOfSize.add(dress);
                }
            });
        });
        return Collections.unmodifiableSet(dressesOfSize);
    }

    @Override
    public Set<String> getBrandsOfCategory(final Category category) {
        final Set<String> brandsOfCategory = new HashSet<>();
        this.categoryManagement.getCategory(category).getAllDresses().values().forEach(dress -> {
            if (!dress.getBrand().isEmpty()) {
                brandsOfCategory.add(dress.getBrand());
            }
        });
        return Collections.unmodifiableSet(brandsOfCategory);
    }

    @Override
    public Set<Dress> getDressesOfBrandAndCategory(final Category category, final String brand) {
        final Set<Dress> dressesOfBrandAndCategory = new HashSet<>();
        this.categoryManagement.getCategory(category).getAllDresses().values().forEach(dress -> {
            if (dress.getBrand().equals(brand)) {
                dressesOfBrandAndCategory.add(dress);
            }
        });
        return Collections.unmodifiableSet(dressesOfBrandAndCategory);
    }

    @Override
    public Set<Integer> getSizesOfCategory(final Category category) {
        final Set<Integer> sizesOfCategory = new HashSet<>();
        this.categoryManagement.getCategory(category).getAllDresses().values().forEach(dress -> {
            sizesOfCategory.add(dress.getSize());
        });
        return Collections.unmodifiableSet(sizesOfCategory);
    }

    @Override
    public Set<Dress> getDressesOfSizeAndCategory(final Category category, final int size) {
        final Set<Dress> dressesOfSizesAndCategory = new HashSet<>();
        this.categoryManagement.getCategory(category).getAllDresses().values().forEach(dress -> {
            if (dress.getSize().equals(size)) {
                dressesOfSizesAndCategory.add(dress);
            }
        });
        return Collections.unmodifiableSet(dressesOfSizesAndCategory);
    }

    @Override
    public Queue<Dress> getLastAddedDresses() {
        return this.categoryManagement.getLastDressesAdded();
    }

    @Override
    public String toString() {
        return "WardobeImpl [categoryManagement=" + categoryManagement + ", outfitsManagement=" + outfitsManagement
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((categoryManagement == null) ? 0 : categoryManagement.hashCode());
        result = prime * result + ((outfitsManagement == null) ? 0 : outfitsManagement.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof WardobeImpl)) {
            return false;
        }
        WardobeImpl other = (WardobeImpl) obj;
        if (categoryManagement == null) {
            if (other.categoryManagement != null) {
                return false;
            }
        } else if (!categoryManagement.equals(other.categoryManagement)) {
            return false;
        }
        if (outfitsManagement == null) {
            if (other.outfitsManagement != null) {
                return false;
            }
        } else if (!outfitsManagement.equals(other.outfitsManagement)) {
            return false;
        }
        return true;
    }

}