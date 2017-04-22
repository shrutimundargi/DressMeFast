package model;

/**
 * An enumeration for the dresses categories and status.
 *
 */
public enum CategoriesStatus {

    /**
     * Head category.
     */
    HEAD("Head"),
    /**
     * Neck category.
     */
    NECK("Neck"),
    /**
     * Hands category.
     */
    HANDS("Hands"),
    /**
     * Body category.
     */
    BODY("Body"),
    /**
     * Legs category.
     */
    LEGS("Legs"),
    /**
     * Foot category.
     */
    FOOT("Foot"),
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
    DRESS_REMOVED("Dress removed succesfully");

    private String categoryName;

    /**
     * @return the category name or a particular status
     */
    public String getCategoryName() {
        return this.categoryName;
    }

    /**
     * @param name
     *            the category name or a particular status
     */
    CategoriesStatus(final String name) {
        this.categoryName = name;
    }

}
