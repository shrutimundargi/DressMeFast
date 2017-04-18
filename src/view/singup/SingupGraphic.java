package view.singup;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.SceneSetting;
import view.ScreensGraphic;
import view.UI;

import java.io.IOException;
import controller.Controller;
import javafx.event.ActionEvent;

public class SingupGraphic implements UI{
	
	private static SceneSetting viewM;
	private final ScreensGraphic FXMLSCREEN = ScreensGraphic.SINGUP;
    private final SceneSetting environment;
    private final Controller controller;
    private Stage primaryStage;
    private boolean lockedPositionSlider;
    
    @FXML
	private TextField txfUser;
	@FXML
	private PasswordField txfPassword;
	@FXML
	private PasswordField txfRepPassword;
	@FXML
	private Text txtError;
	
	public SingupGraphic(SceneSetting environment, Controller controller) {
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
		public void registerAction(ActionEvent event) {
			String user = txfUser.getText();
			String passw = txfPassword.getText();
			String repPassw = txfRepPassword.getText();
			
			if(user.length() < 5){
				txtError.setText("Username to short, min. 5 charats");
			}
			
			controller.signUp(user, passw);
		}
		// Event Listener on Button.onAction
		@FXML
		public void goToLogin(ActionEvent event) {
			this.environment.displayScreen(ScreensGraphic.LOGIN);
		}
	}
