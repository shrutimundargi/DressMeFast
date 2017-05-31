package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * 
 * Manage the the main important thing of the view.
 *
 */
public class SceneSetting extends Application {

    private static final int MIN_HEIGHT_STAGE = 700;
    private static final int MIN_WIDTH_STAGE = 950;
    private final SetupView setup;
    private final ScreenLoader loader;
    private final Pane mainPane;
    private final Scene mainScene;
    private Stage primaryStage;

    /**
     * 
     * @param setup is the main setup of the view where there are memorized the instance of all <i>Class</i>Graphic.
     */
    public SceneSetting(final SetupView setup) {
        super();
        this.setup = setup;
        this.mainPane = new StackPane();
        this.mainScene = new Scene(this.mainPane);
        loader = new ScreenLoader();
    }

    @Override
    public void start(final Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setMinWidth(MIN_WIDTH_STAGE);
        this.primaryStage.setMinHeight(MIN_HEIGHT_STAGE);
        this.primaryStage.setScene(mainScene);
        this.primaryStage.setOnCloseRequest(e -> {
            primaryStage.close();
            try {
                super.stop();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            setup.getController().saveData();
            System.exit(0);

        });
    }

    /**
     * @return The main application window
     */
    public Stage getMainStage() {
        return primaryStage;
    }

    /**
     * Display the screen loaded in the @param primaryStage.
     * @param screen that permit to call a 
     */
    public void show(final ScreensGraphic screen) {
        this.primaryStage.show();
        setup.getUI(screen).showNowContent();
    }

    /**
     * @param screen
     *            the screen to display
     */
    public void displayScreen(final ScreensGraphic screen) {
        try {
            this.loader.loadScreen(screen, this.mainPane);
            show(screen);
        } catch (IOException e) {
            System.out.println("Unable to display screen " + screen);
            e.printStackTrace();
        }
    }

    /**
     * Loads a screen ad sets its controller.
     * 
     * @param screen that we wont to load
     * @param controller of the specific screen
     */
    public void loadScreen(final ScreensGraphic screen, final Object controller) {
        try {
            this.loader.loadFXMLInCache(screen, controller);
        } catch (IOException e) {
            System.out.println("Unable to load screen " + screen);
            e.printStackTrace();
        }
    }

}
