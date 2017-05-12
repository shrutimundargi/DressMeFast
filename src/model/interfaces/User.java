package model.interfaces;

import java.io.Serializable;

/**
 * This interface of an User.
 *
 */
public interface User extends Serializable {

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
