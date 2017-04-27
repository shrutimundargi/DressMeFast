package model.classes;

import model.interfaces.User;
import model.interfaces.Wardrobe;

/**
 * This class allows to manage a single user.
 *
 */
public class UserImpl implements User {

    private final String userName;
    private final String userPassword;
    private final Wardrobe wardrobe;

    /**
     * @param userName
     *        the user's name.
     *
     * @param userPassword
     *          the user's password.
     */
    public UserImpl(final String userName, final String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.wardrobe = new WardobeImpl();
    }

    @Override
    public String getName() {
        return this.userName;
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public Wardrobe getWardobe() {
        return this.wardrobe;
    }

}
