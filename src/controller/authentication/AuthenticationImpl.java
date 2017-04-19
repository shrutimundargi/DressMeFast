package controller.authentication;

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
     * Esegue il SignUp dell'utente e restituisce un messaggio sello stato
     * dell'operazione, in oltre ottiene l'User appena registrato.
     */
    @Override
    public AuthenticationStatus addUser(final String username, final String pass) {
        status = userM.addUser(username, pass);
        if (this.status == AuthenticationStatus.USERNAME_ALREADY_TAKEN
                || this.status == AuthenticationStatus.DUPLICATED_USER) {
            return status;
        } else {
            this.user = userM.getSignUpUser();
            return status;
        }
    }

    /**
     * Esegue il Login dell'utente e ne restituisce lo stato dell'operzione, in
     * oltre ottiene l'User appena loggato.
     */
    @Override
    public AuthenticationStatus checkAuthentication(final String username, final String pass) {
        status = userM.getSpecifiedUser(username, pass);
        if (this.status == AuthenticationStatus.USER_NOT_FOUND || this.status == AuthenticationStatus.WRONG_PASSWORD) {
            return status;
        } else {
            this.user = userM.getLoginUser();
            return this.status;
        }
    }

    /**
     * Restituise l'utente.
     */
    @Override
    public User getUser() {
        return this.user;
    }
}
