package model.classes;

import java.util.HashSet;
import java.util.Set;

import model.enumerations.Status;
import model.interfaces.Login;
import model.interfaces.SignUp;
import model.interfaces.User;
import model.interfaces.UserManagement;

/**
 * This class allows to manage a multitude of users.
 *
 */
public class UserManagementImpl implements UserManagement {

    private Set<User> usersSet;
    private final SignUp signUp;
    private final Login login;

    /**
     * Creates a container for the users.
     */
    public UserManagementImpl() {
        this.usersSet = new HashSet<>();
        this.login = new LoginImpl();
        this.signUp = new SignUpImpl();
    }

    @Override
    public Status getSpecifiedUser(final String name, final String password) {
        return login.checkLogin(name, password, usersSet);
    }

    @Override
    public Status addUser(final String signUpName, final String signUpPassword) {
        Status status = signUp.storeUser(signUpName, signUpPassword, this.usersSet);
        this.usersSet = getUsersSet();
        return status;
    }

    @Override
    public Set<User> getUsersSet() {
        return signUp.getSet();
    }

    @Override
    public User getSignUpUser() {
        return signUp.getUser();
    }

    @Override
    public User getLoginUser() {
        return login.getUser();
    }
}
