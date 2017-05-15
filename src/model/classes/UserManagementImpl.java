package model.classes;

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

    private final SignUp signUp;
    private final Login login;

    /**
     * Instances the phases of both login and sign up.
     */
    public UserManagementImpl() {
        this.login = new LoginImpl();
        this.signUp = new SignUpImpl();
    }

    @Override
    public Status getSpecifiedUser(final String name, final String password) {
        return login.checkLogin(name, password, ModelSingleton.getInstance().getUserSet());
    }

    @Override
    public Status addUser(final String signUpName, final String signUpPassword) {
        return this.signUp.storeUser(signUpName, signUpPassword);
    }

    @Override
    public Set<User> getUsersSet() {
        return ModelSingleton.getInstance().getUserSet();
    }

    @Override
    public User getSignUpUser() {
        return signUp.getUser();
    }

    @Override
    public User getLoginUser() {
        return login.getUser();
    }

    @Override
    public void setUsers(final Set<User> usersSet) {
        if (usersSet.isEmpty()) {
            throw new IllegalArgumentException();
        }
        ModelSingleton.getInstance().setUsers(usersSet);
    }
}
