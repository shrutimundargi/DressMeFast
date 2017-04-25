package model.interfaces;

/**
 * This interface of an User.
 *
 */
public interface User {

    /**
     * @return the name of the user.
     */
    String getName();

    /**
     * @return the password of the user.
     */
    String getPassword();

    /**
     * @return the wardrobe of the user.
     */
    Wardrobe getWardobe();

}
