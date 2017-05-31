package controller.user;

import java.time.LocalDate;

import model.enumerations.Status;
import model.interfaces.User;
import model.interfaces.UserManagement;

/**
 * An implementation of the Authentication.
 *
 */
public final class UserControllerImpl implements UserController {
    private static final String STATUS_INIT = "not yet inizialized";

    private Status status;
    private String statusInizializedCategoryAndOutfits;
    private User user;
    private final UserManagement userM;

    /**
     * @param userManag
     *            : an instance of User management
     */
    public UserControllerImpl(final UserManagement userManag) {
        statusInizializedCategoryAndOutfits = STATUS_INIT;
        userM = userManag;
    }

    @Override
    public Status checkLogin(final String username, final String pass) {
        status = userM.getSpecifiedUser(username, pass);
        if (this.status == Status.USER_NOT_FOUND || this.status == Status.WRONG_PASSWORD) {
            return status;
        } else {
            this.user = userM.getLoginUser();
            inizialized();
            return this.status;
        }
    }

    @Override
    public Status signUp(final String username, final String pass) {
        status = userM.addUser(username, pass);
        if (this.status == Status.USERNAME_ALREADY_TAKEN || this.status == Status.DUPLICATED_USER) {
            return Status.USERNAME_ALREADY_TAKEN;
        } else {
            this.user = userM.getSignUpUser();
            inizialized();
            return status;
        }
    }

    @Override
    public Status logout() {
        this.user = null;
        statusInizializedCategoryAndOutfits = STATUS_INIT;
        return Status.LOGOUT_SUCCESFULL;
    }

    private void inizialized() {
        if (statusInizializedCategoryAndOutfits.equals(STATUS_INIT)) {
            statusInizializedCategoryAndOutfits = user.getWardobe().getCategories().initializeAllCategories().getText();
            statusInizializedCategoryAndOutfits = user.getWardobe().getOutfits().initializeAllOutfits().getText();
        }
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public LocalDate getSingUpDate() {
        return user.getSignUpDate();
    }

}
