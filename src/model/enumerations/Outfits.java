package model.enumerations;

/**
 * An enumeration for the types of an outfit.
 *
 */
public enum Outfits {

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
    Outfits(final String type) {
        this.outfitType = type;
    }
}
