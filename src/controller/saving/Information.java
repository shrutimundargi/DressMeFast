package controller.saving;

/**
 * 
 *
 */
public enum Information {

    /**
     * 
     */
    SAVING_OK("Saving succesful"),
    /**
     * 
     */
    LOADING_OK("Loading succesful");

    private String info;

    /**
     * @return the category name.
     */
    public String getInformation() {
        return this.info;
    }

    /**
     * @param name
     *            the category name.
     */
    Information(final String inf) {
        this.info = inf;
    }

}
