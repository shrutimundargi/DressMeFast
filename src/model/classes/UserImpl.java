package model.classes;

import java.time.LocalDate;

import model.interfaces.User;
import model.interfaces.Wardrobe;

/**
 * This class allows to manage a single user.
 *
 */
public class UserImpl implements User {

    /**
     * 
     */
    private static final long serialVersionUID = 1075178897632172278L;
    private LocalDate signUpDate;
    private final String userName;
    private final String userPassword;
    private final Wardrobe wardrobe;

    /**
     * @param userName
     *            the user's name.
     *
     * @param userPassword
     *            the user's password.
     */
    public UserImpl(final String userName, final String userPassword) {
        this.signUpDate = LocalDate.now();
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

    @Override
    public String toString() {
        return "UserImpl [userName=" + userName + ", userPassword=" + userPassword + ", wardrobe=" + wardrobe + "]";
    }

    public LocalDate getSignUpDate() {
        return this.signUpDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
        result = prime * result + ((wardrobe == null) ? 0 : wardrobe.hashCode());
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
        if (!(obj instanceof UserImpl)) {
            return false;
        }
        UserImpl other = (UserImpl) obj;
        if (userName == null) {
            if (other.userName != null) {
                return false;
            }
        } else if (!userName.equals(other.userName)) {
            return false;
        }
        if (userPassword == null) {
            if (other.userPassword != null) {
                return false;
            }
        } else if (!userPassword.equals(other.userPassword)) {
            return false;
        }
        if (wardrobe == null) {
            if (other.wardrobe != null) {
                return false;
            }
        } else if (!wardrobe.equals(other.wardrobe)) {
            return false;
        }
        return true;
    }

}
