package controller.dress;

import java.util.Date;
import java.util.Set;

import controller.authentication.Authentication;
import controller.authentication.AuthenticationImpl;
import model.CategoriesStatus;
import model.DressImpl;
import model.interfaces.Dress;
import model.interfaces.User;

/**
 * An implementation of the DressController.
 *
 */
public final class DressControllerImpl implements DressController {

    private Authentication auth;
    private User user;

    /**
     * Singleton for DressControllerImpl.
     */
    public static final DressControllerImpl SINGLETON = new DressControllerImpl();

    private DressControllerImpl() {
        auth = AuthenticationImpl.getInstance();
        user = auth.getUser();
    }

    /**
     * @return SINGLETON.
     */
    public static DressControllerImpl getInstance() {
        return SINGLETON;
    }

    @Override
    public Set<DressController> getThreeLastDresses() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<String> getAllBrand() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<DressController> getDressesOfBrand(final String brandName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<DressController> getFavoriteDresses() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Integer> getAllSize() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<DressController> getDressesOfSize(final int size) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<String> getAllCategory() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<DressController> getDressesOfCategory(final String categoryName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CategoriesStatus addDress(final String name, final String brand, final int size, final int price, final Date purchaseDate,
            final String description, final CategoriesStatus categories) {
        
        final Dress dress = new DressImpl.DressBuilder().buildName(name).buildBrand(brand).buildSize(size).buildPurchaseDate(purchaseDate)
                .buildDescription(description).build();

        return user.getWardobe().getAllCategories().addDressToCategory(dress, categories);
    }
    
    public void setUser(User user){
        this.user = user;
    }

}
