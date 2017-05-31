package model.classes;

import java.util.Set;

import model.enumerations.Status;
import model.interfaces.Login;
import model.interfaces.User;

/**
 * The class to manage the login step.
 *
 */
public class LoginImpl implements Login {

    private User user;

    @Override
    public Status checkLogin(final String name, final String pass, final Set<User> usersSet) {
        for (final User user : usersSet) {
            if (user.getName().equals(name) && user.getPassword().equals(pass)) {
                this.user = user;
                return Status.USER_FOUND;
            } else if (user.getName().equals(name) && !user.getPassword().equals(pass)) {
                return Status.WRONG_PASSWORD;
            }
        }
        return Status.USER_NOT_FOUND;
    }

    @Override
    public User getUser() {
        return this.user;
    }

}
