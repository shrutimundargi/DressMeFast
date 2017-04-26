package view.singup;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Status;
import view.SceneSetting;
import view.ScreensGraphic;
import view.UI;
import view.dialog.SingupDialogGraphic;

import java.io.IOException;
import controller.Controller;
import javafx.event.ActionEvent;

/**
 * 
 *
 *
 */
public class SingupGraphic implements UI {

    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.SINGUP;
    private static final int MIN_LENGTH = 5;

    private static SceneSetting viewM;
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
    private Text txtErrUser;
    @FXML
    private Text txtErrPassw;
    @FXML
    private Text txtErrRepPassw;

    /**
     * 
     * @param environment
     *            from the main to have the same instance
     * @param controller
     *            from the main to have the same instance
     */
    public SingupGraphic(final SceneSetting environment, final Controller controller) {
        this.controller = controller;
        this.environment = environment;
        this.environment.loadScreen(ACTUALSCREEN, this);
        this.lockedPositionSlider = false;
        this.primaryStage = this.environment.getMainStage();
    }

    /**
     * 
     */
    public void show() {
        this.primaryStage = this.environment.getMainStage();
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));
        this.environment.displayScreen(ACTUALSCREEN);

    }

    /**
     * 
     * @param event
     *            of action
     */
    // Event Listener on Button.onAction
    @FXML
    public void registerAction(final ActionEvent event) {
        final String user = txfUser.getText();
        final String passw = txfPassword.getText();
        final String repPassw = txfRepPassword.getText();
        boolean allRight = true;

        txtErrUser.setText("");
        txtErrPassw.setText("");
        txtErrRepPassw.setText("");

        if (user.length() < MIN_LENGTH) {
            txtErrUser.setText("Username to short, min. 5 charats");
            allRight = false;
        }
        if (passw.length() < MIN_LENGTH) {
            txtErrPassw.setText("Password to short, min. 5 charats");
            allRight = false;
        } else if (!repPassw.equals(passw)) {
            txtErrRepPassw.setText("Passwords not equal");
            allRight = false;
        } else if (allRight) {
            if (controller.authentication().signUp(user, passw) == Status.DUPLICATED_USER) {
                txtErrUser.setText(Status.DUPLICATED_USER.getText());
            } else {
                this.environment.displayScreen(ScreensGraphic.DIALOGSINGUP);
                this.controller.getUI(ScreensGraphic.DIALOGSINGUP).showNowContent();
            }
        }
    }

    /**
     * 
     * @param event
     *            of action
     */
    // Event Listener on Button.onAction
    @FXML
    public void goToLogin(final ActionEvent event) {
        this.environment.displayScreen(ScreensGraphic.LOGIN);
    }

    @Override
    public void showNowContent() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setLastPage(ScreensGraphic screen) {
        // TODO Auto-generated method stub
        
    }
}
