package controller.user;

import controller.Controller;
import controller.ControllerImpl;
import model.classes.UserManagementImpl;
import model.enumerations.Status;
import model.interfaces.User;
import model.interfaces.UserManagement;

/**
 * An implementation of the Authentication.
 *
 */
public final class UserControllerImpl implements UserController {
    private static final String STATUSINITCATEGORY = "not yet inizialized";

    private Status status;
    private String statusInizializedCategory;
    private User user;
    private final UserManagement userM;

    /**
     * 
     */
    public UserControllerImpl() {
        statusInizializedCategory = STATUSINITCATEGORY;
        userM = new UserManagementImpl();
    }

    @Override
    public Status checkLogin(final String username, final String pass) {
        status = userM.getSpecifiedUser(username, pass);
        if (this.status == Status.USER_NOT_FOUND || this.status == Status.WRONG_PASSWORD) {
            return status;
        } else {
            this.user = userM.getLoginUser();
            inizializedCategory();
            setUser();
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
            inizializedCategory();
            setUser();
            return status;
        }
    }

    @Override
    public Status logout() {
        this.user = null;
        statusInizializedCategory = STATUSINITCATEGORY;
        setUser();
        return Status.LOGOUT_SUCCESFULL;
    }

    private void setUser() {
        final Controller controller = ControllerImpl.getInstance();
        controller.setUser(user);
    }

    private void inizializedCategory() {
        if (!statusInizializedCategory.equals(Status.CATEGORIES_INITIALIZED.getText())) {
            statusInizializedCategory = user.getWardobe().getCategories().initializeAllCategories().getText();
        }

    }

    @Override
    public String getUsername() {
        return user.getName();
    }

}
