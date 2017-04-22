package controller.authentication;

import java.util.Objects;

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

    /**
     * Singleton for AuthenticationImpl.
     */
    public static final AuthenticationImpl SINGLETON = new AuthenticationImpl();

    private final UserManagement userM;

    private AuthenticationImpl() {
        userM = new UserManagementImpl();
    }

    /**
     * @return SINGLETON.
     */
    public static AuthenticationImpl getInstance() {
        return SINGLETON;
    }
    /**
     * Restituise l'utente.
     */
    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public AuthenticationStatus checkLogin(final String username, final String pass) {
        status = userM.getSpecifiedUser(username, pass);
        if (this.status == AuthenticationStatus.USER_NOT_FOUND || this.status == AuthenticationStatus.WRONG_PASSWORD) {
            return status;
        } else {
            this.user = userM.getLoginUser();
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
            return status;
        }
    }

    @Override
    public AuthenticationStatus logout() {
        user = null;
        if (Objects.isNull(user)) {
            return null;
        }
        return null;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return null;
    }
}
