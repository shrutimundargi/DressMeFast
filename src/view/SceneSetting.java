package view;

import java.io.IOException;

import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;
import view.login.LoginGraphic;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.fxml.FXMLLoader;

public class SceneSetting extends Application {
	
    private final Controller controller;
	private final ScreenLoader loader;
    private final Pane mainPane;
    private final Scene mainScene;
    private Stage primaryStage;
    
	
	public SceneSetting(Controller controller) {
        this.controller = controller;
        this.mainPane = new StackPane();
        this.mainScene = new Scene(this.mainPane);
        loader = new ScreenLoader();
	}
	
	/* (non-Javadoc)
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setMinWidth(900);
        this.primaryStage.setMinHeight(700);
        this.primaryStage.setScene(mainScene);
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));

    }

    /**
     * @return The main application window
     */
    public Stage getMainStage() {
        return primaryStage;
    }

    /**
     * Display the main window
     */
    public void show(ScreensGraphic screen) {
        this.primaryStage.show();
        controller.getUI(screen).showNowContent();
    }

    /**
     * @param screen the screen to display
     */
    public void displayScreen(ScreensGraphic screen) {
        try {
            this.loader.loadScreen(screen, this.mainPane);
            show(screen);
        } catch (IOException e) {
            System.out.println("Unable to display screen " + screen);
            e.printStackTrace();
        }
    }

    /**
     * Loads a screen ad sets its controller
     * @param screen
     * @param controller
     */
    public void loadScreen(ScreensGraphic screen, Object controller) {
        try {
            this.loader.loadFXMLInCache(screen, controller);
        } catch (IOException e) {
            System.out.println("Unable to load screen " + screen);
            e.printStackTrace();
        }
    }

}
