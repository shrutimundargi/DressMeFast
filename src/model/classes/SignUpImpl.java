package model.classes;

import model.enumerations.Status;
import model.interfaces.SignUp;
import model.interfaces.User;

/**
 * The class to manage the sign up step.
 *
 */
public class SignUpImpl implements SignUp {

    private User user;

    /**
     * Creates a container to store the users at the sign up step.
     */
    public SignUpImpl() {
        this.user = null;
    }

    @Override
    public Status storeUser(final String signUpName, final String signUpPassword) {
        if (ModelSingleton.getInstance().getUserSet().isEmpty()) {
            this.user = new UserImpl(signUpName, signUpPassword);
            ModelSingleton.getInstance().getUserSet().add(user);
            return Status.USER_REGISTERED;
        } else {
            for (final User user : ModelSingleton.getInstance().getUserSet()) {
                if (user.getName().equals(signUpName) && user.getPassword().equals(signUpPassword)) {
                    return Status.DUPLICATED_USER;
                } else if (user.getName().equals(signUpName)) {
                    return Status.USERNAME_ALREADY_TAKEN;
                }
            }
            this.user = new UserImpl(signUpName, signUpPassword);
            ModelSingleton.getInstance().getUserSet().add(user);
        }
        return Status.USER_REGISTERED;
    }

    @Override
    public User getUser() {
        return this.user;
    }

}
