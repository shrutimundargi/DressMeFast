package model.classes;

import java.util.HashSet;
import java.util.Set;

import model.interfaces.Dress;
import model.interfaces.Outfit;

/**
 * This class allows the user to create its own outfit.
 *
 */
public class UserOutfit implements Outfit {

    private final Set<Dress> userOutfit;

    public UserOutfit() {
        this.userOutfit = new HashSet<>();
    }

}
