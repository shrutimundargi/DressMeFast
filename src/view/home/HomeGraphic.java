package view.home;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import view.SceneSetting;
import view.ScreensGraphic;
import view.UI;

public class HomeGraphic implements UI{

    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.HOME;
    
    private static SceneSetting viewM;
    private final SceneSetting environment;
    private final Controller controller;
    private Stage primaryStage;
    private boolean lockedPositionSlider;
    
    public HomeGraphic(final SceneSetting environment, final Controller controller){
        this.controller = controller;
        this.environment = environment;
        this.environment.loadScreen(ACTUALSCREEN, this);
        this.lockedPositionSlider = false;
        this.primaryStage = this.environment.getMainStage();
    }

    @Override
    public void show() {
        this.primaryStage = this.environment.getMainStage();
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));
        this.environment.displayScreen(ACTUALSCREEN);
    }
}

