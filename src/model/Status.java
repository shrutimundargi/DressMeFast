package model;

/**
 * This enumeration is used to express a particular state.
 *
 */
public enum Status {

    /**
     * User not found.
     */
    USER_NOT_FOUND("User not found"),
    /**
     * User found.
     */
    USER_FOUND("User found."),
    /**
     * User already registered.
     */
    DUPLICATED_USER("User already registered"),
    /**
     * Wrong password.
     */
    WRONG_PASSWORD("The insert password is wrong"),
    /**
     * Username already taken.
     */
    USERNAME_ALREADY_TAKEN("Your username is already taken"),
    /**
     * User registered.
     */
    USER_REGISTERED("The user has been registered succesfully"),
    /**
     * Change succesfull.
     */
    CHANGE_SUCCESFULL("Change succesfull"),
    /**
     * The Status of a dress id.
     */
    ID_ALREADY_EXISTS("Dress id already exists"),
    /**
     * The positive result by adding a dress.
     */
    DRESS_ADDED("Dress added succesfully"),
    /**
     * The positive result by removing a dress.
     */
    DRESS_REMOVED("Dress removed succesfully"),
    /**
     * The status of the logout operation.
     */
    LOGOUT_SUCCESFULL("Logging out");

    private String text;

    /**
     * @return the status of the object
     */
    public String getText() {
        return this.text;
    }

    Status(final String text) {
        this.text = text;
    }

}
