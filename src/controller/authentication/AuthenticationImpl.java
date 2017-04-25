package controller.authentication;

import model.Status;

import controller.Controller;
import controller.ControllerImpl;
import model.UserManagementImpl;

import model.interfaces.User;
import model.interfaces.UserManagement;

/**
 * An implementation of the Authentication.
 *
 */
public final class AuthenticationImpl implements Authentication {

    private Status status;
    private User user;
    private final UserManagement userM;

    /**
     * 
     */
    public AuthenticationImpl() {
        userM = new UserManagementImpl();
    }

    @Override
    public Status checkLogin(final String username, final String pass) {
        status = userM.getSpecifiedUser(username, pass);
        if (this.status == Status.USER_NOT_FOUND || this.status == Status.WRONG_PASSWORD) {
            return status;
        } else {
            this.user = userM.getLoginUser();
            setUser();
            return this.status;
        }
    }

    @Override
    public Status signUp(final String username, final String pass) {
        status = userM.addUser(username, pass);
        if (this.status == Status.USERNAME_ALREADY_TAKEN
                || this.status == Status.DUPLICATED_USER) {
            return status;
        } else {
            this.user = userM.getSignUpUser();
            setUser();
            return status;
        }
    }

    @Override
    public Status logout() {
        this.user = null;
        setUser();
        return Status.LOGOUT_SUCCESFULL;
    }

    private void setUser() {
        final Controller controller = ControllerImpl.getInstance();
        controller.setUser(user);
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

}
