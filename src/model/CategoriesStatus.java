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
     * Legs category.
     */
    FOOT("Foot"),
    /**
     * Foot category.
     */
    NAME_ALREADY_EXISTS("Dress name already exists");
    /**
     * Status of a dress name.
     */

    private String categoryName;

    /**
     * @return the category name or a particular status
     */
    public String getCategoryName() {
        return this.categoryName;
    }

    /**
     * @param categoryName
     *            the category name or a particular status
     */
    CategoriesStatus(final String name) {
        this.categoryName = name;
    }

}
