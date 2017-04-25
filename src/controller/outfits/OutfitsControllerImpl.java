package controller.outfits;


/**
 * An implementation of the OutfitsController.
 *
 */
public final class OutfitsControllerImpl implements OutfitsController {
    /**
     * Singleton for OutfitsControllerImpl.
     */
    public static final OutfitsControllerImpl SINGLETON = new OutfitsControllerImpl();

    private OutfitsControllerImpl() {
    }

    /**
     * @return SINGLETON.
     */
    public static OutfitsControllerImpl getInstance() {
        return SINGLETON;
    }
}
