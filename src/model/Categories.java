package model;

/**
 * An enumeration for the dresses categories and status.
 *
 */
public enum Categories {

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
    FOOT("Foot");

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
    Categories(final String name) {
        this.categoryName = name;
    }

}
