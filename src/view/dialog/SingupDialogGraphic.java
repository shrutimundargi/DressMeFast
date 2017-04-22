package view.dialog;

import javafx.fxml.FXML;

import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.SceneSetting;
import view.ScreensGraphic;
import view.UI;
import controller.Controller;
import javafx.event.ActionEvent;

public class SingupDialogGraphic implements UI {
    
    private static final ScreensGraphic FXMLSCREEN = ScreensGraphic.DIALOGSINGUP;
    private static final int MIN_LENGTH = 5;
    
    private static SceneSetting viewM;
    private final SceneSetting environment;
    private final Controller controller;
    private Stage primaryStage;
    private boolean lockedPositionSlider;
    
	@FXML
	private Text txtPopupName;
	@FXML
	private Text txtPopupPassw;
	
	boolean pressed = false;
	
	public SingupDialogGraphic(final SceneSetting environment, final Controller controller) {
        this.controller = controller;
        this.environment = environment;
        this.environment.loadScreen(FXMLSCREEN, this);
        this.lockedPositionSlider = false;
        this.primaryStage = this.environment.getMainStage();
        txtPopupName.setText("Thank you " + "" + " for joining in Dress Me Fast");
    }

	// Event Listener on Button.onAction
	@FXML
	public void goToHome(ActionEvent event) {
	    pressed = true;
	    this.environment.displayScreen(ScreensGraphic.LOGIN);
	}
	

    @Override
    public void show() {
        // TODO Auto-generated method stub
        
    }
}
