package model.enumerations;

import java.io.Serializable;

/**
 * An enumeration for the dresses categories.
 *
 */
public enum Category implements Serializable {

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
     * Category not chosen yet.
     */
    EMPTY("Empty");

    private String categoryName;

    /**
     * @return the category name.
     */
    public String getCategoryName() {
        return this.categoryName;
    }

    /**
     * @param name
     *            the category name.
     */
    Category(final String name) {
        this.categoryName = name;
    }

}
