package model.enumerations;

/**
 * An enumeration for the types of an outfit.
 *
 */
public enum Outfit {

    /**
     * User outfit.
     */
    USER("User outfit"),
    /**
     * AI outfit.
     */
    AI("AI outfit");

    private String outfitType;

    /**
     * @return the outfit type.
     */
    public String getOutfitName() {
        return this.outfitType;
    }

    /**
     * @param name
     *            the outfit type.
     */
    Outfit(final String type) {
        this.outfitType = type;
    }
}
