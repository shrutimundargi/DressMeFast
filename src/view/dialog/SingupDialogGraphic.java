package view.dialog;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.SceneSetting;
import view.ScreensGraphic;
import view.UI;
import controller.Controller;
import javafx.event.ActionEvent;

public class SingupDialogGraphic implements UI {

    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.DIALOGSINGUP;
    private static final int MIN_LENGTH = 5;

    private static SceneSetting viewM;
    private final SceneSetting environment;
    private final Controller controller;
    private Stage primaryStage;
    private boolean lockedPositionSlider;

    @FXML
    private Label txtPopupName;
    @FXML
    private Text txtPopupPassw;

    boolean pressed = false;

    public SingupDialogGraphic(final SceneSetting environment, final Controller controller) {
        this.controller = controller;
        this.environment = environment;
        this.environment.loadScreen(ACTUALSCREEN, this);
        this.lockedPositionSlider = false;
        this.primaryStage = this.environment.getMainStage();
        txtPopupName.setWrapText(true);
        txtPopupName.setAlignment(Pos.CENTER);
    }

    // Event Listener on Button.onAction
    @FXML
    public void goToHome(ActionEvent event) {
        pressed = true;
        this.environment.displayScreen(ScreensGraphic.HOME);
    }

    @Override
    public void show() {
        this.primaryStage = this.environment.getMainStage();
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));
        this.environment.displayScreen(ACTUALSCREEN);
    }

    @Override
    public void showNowContent() {
        txtPopupName.setText("Thank you " + controller.authentication().getUsername() + " for joining in Dress Me Fast");
    }

    @Override
    public void setLastPage(ScreensGraphic screen) {
        // TODO Auto-generated method stub
        
    }
}
