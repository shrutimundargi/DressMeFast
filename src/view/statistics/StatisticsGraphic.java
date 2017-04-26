package view.statistics;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.SceneSetting;
import view.ScreensGraphic;
import view.UI;
import controller.Controller;
import javafx.event.ActionEvent;

public class StatisticsGraphic implements UI{
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.STATISTICS;

    private ScreensGraphic lastPage;
    private static SceneSetting viewM;
    private final SceneSetting environment;
    private final Controller controller;
    private Stage primaryStage;
    private boolean lockedPositionSlider;

	@FXML
	private Button btnGoBack;
	@FXML
	private Button btnLogout;
	
	/**
     * @param environment
     * @param controller
     */
    public StatisticsGraphic (SceneSetting environment, Controller controller) {
        this.controller = controller;
        this.environment = environment;
        this.environment.loadScreen(ACTUALSCREEN, this);
        this.lockedPositionSlider = false;
        this.primaryStage = this.environment.getMainStage();
    }

	// Event Listener on Button[#btnGoBack].onAction
	@FXML
	public void goBack(ActionEvent event) {
        this.environment.displayScreen(lastPage);
	}
	// Event Listener on Button[#btnLogout].onAction
	@FXML
	public void logout(ActionEvent event) {
        this.environment.displayScreen(ScreensGraphic.LOGIN);
        this.controller.authentication().logout();
	}

    @Override
    public void show() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void showNowContent() {
    }
    
    public void setLastPage(ScreensGraphic screen){
        lastPage = screen;
    }
}
