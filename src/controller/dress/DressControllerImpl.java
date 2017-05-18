package controller.dress;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import controller.exception.MyException;
import model.classes.DressImpl;
import model.enumerations.Category;
import model.enumerations.Status;
import model.interfaces.Categories;
import model.interfaces.Dress;
import model.interfaces.User;

/**
 * An implementation of the DressController.
 *
 */
public final class DressControllerImpl implements DressController {
    private static final String USER_ERROR = "User not found, you can't add a dress without a user";
    private static final String IMAGE_ERROR = "Impossible to save an immage";

    private static final String MAIN_PATH = System.getProperty("user.home") + File.separator + "dmfData";
    private static final String IMAGE_PATH = MAIN_PATH + File.separator + "images";

    private User user;

    /**
     * @param user
     *            : user
     */
    public DressControllerImpl(final User user) {
        this.user = user;

    }

    private String saveImage(final File imagePath) {
        File oldImagePath = imagePath;
        final File[] imageFolder = new File(MAIN_PATH + File.separator + "images" + File.separator).listFiles();
        int cont = 0;
        if (new File(IMAGE_PATH + File.separator + FilenameUtils.getName(imagePath.toString())).exists()) {
            for (final File files : imageFolder) {

                final String firstImageName = FilenameUtils.getName(files.toString());
                final String[] onlyName = firstImageName.split("_copy");
                final String secondImageName = FilenameUtils.getName(imagePath.toString());
                final String[] onlyName2 = secondImageName.split(".jpg");
                if (onlyName[0].equals(onlyName2[0])) {
                    cont++;
                }

            }
            String[] newName = new File(IMAGE_PATH + File.separator + FilenameUtils.getName(oldImagePath.toString()))
                    .getAbsolutePath().split(".jpg");
            newName[0] += "_copy_" + cont + ".jpg";
            oldImagePath = new File(newName[0]);
            try {

                FileUtils.copyFile(imagePath, oldImagePath);
                return oldImagePath.getPath().toString();
            } catch (IOException e) {
                final RuntimeException e2 = new MyException(IMAGE_ERROR);
                throw e2;
            }

        } else {
            try {
                FileUtils.copyFile(oldImagePath,
                        new File(IMAGE_PATH + File.separator + FilenameUtils.getName(oldImagePath.toString())));
                return IMAGE_PATH + File.separator + FilenameUtils.getName(oldImagePath.toString());
            } catch (IOException e) {
                final RuntimeException e2 = new MyException(IMAGE_ERROR);
                throw e2;
            }
        }

    }

    @Override
    public Status addDress(final String name, final String brand, final Integer size, final Integer price,
            final LocalDate purchaseDate, final String description, final Category categories, final File image) {
        try {
            Objects.requireNonNull(user);
        } catch (Exception e) {
            final RuntimeException e2 = new MyException(USER_ERROR);
            throw e2;
        }

        final Dress dress = new DressImpl.DressBuilder().buildImage(saveImage(image)).buildName(name).buildBrand(brand)
                .buildSize(size).buildPrice(price).buildPurchaseDate(purchaseDate).buildDescription(description)
                .build();

        return user.getWardobe().getCategories().addDressToCategory(dress, categories);
    }

    @Override
    public Set<Dress> getDressesOfBrand(final String brandName) {
        return user.getWardobe().getDressesOfBrand(brandName);
    }

    @Override

    public Set<Dress> getDressesOfCategory(final Category categoryName) {
        return new HashSet<>(user.getWardobe().getCategories().getCategory(categoryName).getAllDresses().values());
    }

    @Override
    public Set<Dress> getDressesOfSize(final int size) {
        return user.getWardobe().getDressesOfSize(size);
    }

    @Override
    public Set<Categories> getAllCategory() {
        return new HashSet<>(user.getWardobe().getCategories().getAllCategories().values());

    }

    @Override
    public Set<String> getAllBrand() {
        return user.getWardobe().getAllBrands();
    }

    @Override
    public Set<Integer> getAllSize() {
        return user.getWardobe().getAllSizes();
    }

    @Override
    public List<Dress> getAllDresses() {
        return user.getWardobe().getCategories().getAllDresses();
    }

    @Override

    public int getNumberOfDresses() {
        return getAllDresses().size();
    }

    @Override
    public Set<Dress> getFavoriteDresses() {
        return user.getWardobe().getFavouritedDresses();
    }

    @Override
    public Set<Dress> getLastAddedDresses() {
        return new HashSet<>(user.getWardobe().getLastAddedDresses());
    }

    @Override
    public void setUser(final User user) {
        this.user = user;
    }

    @Override
    public String getDressName(final Dress dress) {
        return dress.getName();
    }

    @Override
    public String getDressBrand(final Dress dress) {
        return dress.getBrand();
    }

    @Override
    public int getDressSize(final Dress dress) {
        return dress.getSize();
    }

    @Override
    public LocalDate getDressPurchaseDate(final Dress dress) {
        return dress.getPurchaseDate();
    }

    @Override
    public String getDressDescription(final Dress dress) {
        return dress.getDescription();
    }

    @Override
    public Boolean getFavoriteTag(final Dress dress) {
        return dress.getFavourited();
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
    public Status modifyDressPurchaseDate(final Dress dress, final LocalDate data) {
        return dress.setPurchaseDate(data);
    }

    @Override
    public Status modifyDressDescription(final Dress dress, final String description) {
        return dress.setDescription(description);
    }

    @Override
    public Status modifyDressCategory(final Dress dress, final Category category) {
        return user.getWardobe().getCategories().modifyCategoryOfDress(dress, category);
    }

    @Override
    public Status modifyFavoriteTag(final Dress dress, final Boolean favorite) {
        return dress.setFavourited(favorite);
    }

    @Override
    public Status deleteDress(final Dress dress) {
        try {
            dress.getImage().delete();
        } catch (Exception e) {
            final RuntimeException e2 = new MyException(IMAGE_ERROR);
            throw e2;
        }
        return user.getWardobe().getCategories().getCategory(dress.getCategoryName()).removeDress(dress);

    }

    @Override
    public void dressWorn(final Dress dress) {
        dress.setWornCount();
    }

    @Override
    public int numberTimeDressWorn(final Dress dress) {
        return dress.getWornCount();
    }

    @Override
    public List<String> getPopularBrand() {
        user.getWardobe().getMostPopularBrand();
        return null;
    }

    @Override
    public List<String> getAllBrandName(final Category categoryName) {
        return user.getWardobe().getBrandsOfCategory(categoryName);
    }

    @Override
    public List<Dress> getAllBrandDress(final Category categoryName, final String brand) {
        return user.getWardobe().getDressesOfBrandAndCategory(categoryName, brand);
    }

    @Override
    public List<Integer> getAllSizeName(final Category categoryName) {
        return user.getWardobe().getSizesOfCategory(categoryName);
    }

    @Override
    public List<Dress> getAllSizeDress(final Category categoryName, final int size) {
        return user.getWardobe().getDressesOfSizeAndCategory(categoryName, size);
    }

}
