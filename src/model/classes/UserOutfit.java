package model.classes;

import java.util.HashSet;
import java.util.Set;

import model.interfaces.CategoriesManagement;
import model.interfaces.Dress;
import model.interfaces.Outfits;

/**
 * This class allows the user to create its own outfit.
 *
 */
public class UserOutfit implements Outfits {

    private final Set<Dress> userOutfit;
    //private final Set<CategoryManagement> categoryM;

    public UserOutfit() {
        this.userOutfit = new HashSet<>();
        //this.categoryM  = new HashSet<>();
    }

}
