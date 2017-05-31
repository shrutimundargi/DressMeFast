package view;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import controller.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * An utility class to load and store the .fxml nodes of the view.
 * 
 * The caching mechanism is useful when switching between views it prevents to
 * reload the nodes and all the values stored in their components (textboxes
 * content, sliders position, ecc...).
 * 
 * It is also possible to force the reloading of the nodes for heavy .fxml files
 * instead of keeping them cached.
 */
public final class ScreenLoader {

    private final Map<ScreensGraphic, Node> cache;

    /**
     * 
     */
    public ScreenLoader() {
        this.cache = new HashMap<>();
    }

    /**
     * Sets the loaded Node as main screen in the container.
     * 
     * @param screen
     *            screen screen to be loaded
     * @param mainPane
     *            the screen is load in the mainPane
     * @throws IOException
     *             IOException if the resource is not found
     */
    public void loadScreen(final ScreensGraphic screen, final Pane mainPane) throws IOException {
        mainPane.getChildren().setAll(getLoadedNode(screen));
    }

    /**
     * 
     * @param screen
     *            that we wont to get
     * @return return the screen or an exception
     * @throws IllegalStateException
     *             if there isn't any screen in the cache screen.
     */
    public Node getLoadedNode(final ScreensGraphic screen) throws IllegalStateException {
        if (!this.cache.containsKey(screen)) {
            throw new IllegalStateException();
        } else {
            return this.cache.get(screen);
        }
    }

    /**
     * Seeks for the required screen in the cache If not present it is loaded
     * then returned.
     * 
     * @param screen
     *            screen to be loaded
     * @param controller
     *            understood as the <i>class</i>Graphic that control the FXML
     * @return the Node loaded
     * @throws IOException
     *             if the resource is not found
     */
    public Node loadFXMLInCache(final ScreensGraphic screen, final Object controller) throws IOException {

        if (cache.containsKey(screen)) {
            return cache.get(screen);
        } else {
            final Node loadedNode = loadFXML(screen, controller);
            cache.put(screen, loadedNode);
            return loadedNode;
        }
    }

    /**
     * Bypass the cache and loads directly the .fxml.
     * 
     * @param screen
     *            screen to be loaded
     * @param controller
     *            understood as the <i>class</i>Graphic that control the FXML
     * @return the Node loaded
     * @throws IOException
     *             if the resource is not found
     */
    public Node loadFXML(final ScreensGraphic screen, final Object controller) throws IOException {
        final FXMLLoader loader = new FXMLLoader();
        loader.setController(controller);
        loader.setLocation(Main.class.getResource(screen.getPath()));
        return loader.load();

    }

}
