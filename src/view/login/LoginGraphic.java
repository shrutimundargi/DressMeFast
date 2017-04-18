package view.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.SceneSetting;
import view.ScreensGraphic;
import view.UI;

import java.io.IOException;
import controller.Controller;
import javafx.event.ActionEvent;

public class LoginGraphic implements UI{
	
	private static SceneSetting viewM;
	private final ScreensGraphic FXMLSCREEN = ScreensGraphic.LOGIN;
    private final SceneSetting environment;
    private final Controller controller;
    private Stage primaryStage;
    private boolean lockedPositionSlider;
	
	public LoginGraphic(SceneSetting environment, Controller controller) {
		this.controller = controller;
        this.environment = environment;
        this.environment.loadScreen(FXMLSCREEN, this);
        this.lockedPositionSlider = false;
        this.primaryStage = this.environment.getMainStage();
	}
	
	public void show() {
        this.primaryStage = this.environment.getMainStage();
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));
        this.environment.displayScreen(FXMLSCREEN);

    }

	// Event Listener on Button.onAction
	@FXML
	public void loginAccess(ActionEvent event) {

	}
	// Event Listener on Button.onAction
	@FXML
	public void singupChange(ActionEvent event) {
		// TODO Autogenerated
	}
}
