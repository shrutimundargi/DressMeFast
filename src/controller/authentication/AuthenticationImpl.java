package controller.authentication;

import controller.Controller;
import controller.ControllerImpl;
import model.AuthenticationStatus;
import model.UserManagementImpl;

import model.interfaces.User;
import model.interfaces.UserManagement;

/**
 * An implementation of the Authentication.
 *
 */
public final class AuthenticationImpl implements Authentication {

    private AuthenticationStatus status;
    private User user;
    private final UserManagement userM;

    /**
     * 
     */
    public AuthenticationImpl() {
        userM = new UserManagementImpl();
    }

    @Override
    public AuthenticationStatus checkLogin(final String username, final String pass) {
        status = userM.getSpecifiedUser(username, pass);
        if (this.status == AuthenticationStatus.USER_NOT_FOUND || this.status == AuthenticationStatus.WRONG_PASSWORD) {
            return status;
        } else {
            this.user = userM.getLoginUser();
            setUser();
            return this.status;
        }
    }

    @Override
    public AuthenticationStatus signUp(final String username, final String pass) {
        status = userM.addUser(username, pass);
        if (this.status == AuthenticationStatus.USERNAME_ALREADY_TAKEN
                || this.status == AuthenticationStatus.DUPLICATED_USER) {
            return status;
        } else {
            this.user = userM.getSignUpUser();
            setUser();
            return status;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see controller.authentication.Authentication#logout()
     * 
     * #########################################################################
     * Aspetto che il model mi crei uno stato per il logout effettuato con
     * succeso, ho messo uno stato temporaneo di prova
     * #########################################################################
     */
    @Override
    public AuthenticationStatus logout() {
        this.user = null;
        setUser();
        return AuthenticationStatus.CHANGE_SUCCESFULL;
    }

    @Override
    public User getUser() {
        return this.user;
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
