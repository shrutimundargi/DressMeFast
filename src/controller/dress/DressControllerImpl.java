package controller.dress;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import controller.exception.MyException;
import model.classes.DressImpl;
import model.enumerations.Categories;
import model.enumerations.Status;
import model.interfaces.Dress;
import model.interfaces.User;

/**
 * An implementation of the DressController.
 *
 */
public final class DressControllerImpl implements DressController {
    private static final String USER_ERROR = "User not found, you can't add a dress without a user";
    private User user;

    /**
     * @param user
     *            : user
     */
    public DressControllerImpl(final User user) {
        this.user = user;
    }

    @Override
    public Status addDress(final String name, final String brand, final int size, final int price,
            final Date purchaseDate, final String description, final Categories categories) {
        try {
            Objects.requireNonNull(user);
        } catch (Exception e) {
            final RuntimeException e2 = new MyException(USER_ERROR);
            throw e2;
        }

        final Dress dress = new DressImpl.DressBuilder().buildName(name).buildBrand(brand).buildSize(size)
                .buildPrice(price).buildPurchaseDate(purchaseDate).buildDescription(description).build();

        return user.getWardobe().getAllCategories().addDressToCategory(dress, categories);
    }

    @Override
    public Set<Dress> getDressesOfBrand(final String brandName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Dress> getDressesOfCategory(final Categories categoryName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Dress> getDressesOfSize(final int size) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Dress> getDressesResearch() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Categories> getAllCategory() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<String> getAllBrand() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Integer> getAllSize() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Dress> getFavoriteDresses() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Dress> getThreeLastDresses() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setUser(final User user) {
        this.user = user;
    }

    @Override
    public Status modifyDressName(final Dress dress, final String name) {
        return dress.setName(name);
    }

    @Override
    public Status modifyDressBrand(final Dress dress, final String brand) {
        return dress.setBrand(brand);
    }

    @Override
    public Status modifyDressSize(final Dress dress, final int size) {
        return dress.setSize(size);
    }

    @Override
    public Status modifyDressPurchaseDate(final Dress dress, final Date data) {
        return dress.setPurchaseDate(data);
    }

    @Override
    public Status modifyDressDescription(final Dress dress, final String description) {
        return dress.setDescription(description);
    }

    @Override
    public String getDressDescription(final Dress dress) {
        return dress.getDescription().get();
    }
    

    @Override
    public Status modifyDressCategory(final Dress dress, final Categories category) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Status modifyFavoriteTag(final Dress dress, final Boolean favorite) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Status deleteDress(final Dress dress) {
        // TODO Auto-generated method stub
        return null;
    }

}
