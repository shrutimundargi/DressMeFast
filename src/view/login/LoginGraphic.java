package view.login;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.enumerations.Status;
import view.SceneSetting;
import view.ScreensGraphic;
import view.UI;

/**
 * 
 *
 */
public class LoginGraphic implements UI {

    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.LOGIN;

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
    private Text txtErrUser;
    @FXML
    private Text txtErrPassw;

    /**
     * 
     * @param environment
     *            a reference of the instance of the class SceneSetting
     * @param controller
     *            a reference of the instance of the class Controller
     */
    public LoginGraphic(final SceneSetting environment, final Controller controller) {
        this.controller = controller;
        this.environment = environment;
        this.environment.loadScreen(ACTUALSCREEN, this);
        this.lockedPositionSlider = false;
        this.primaryStage = this.environment.getMainStage();
    }

    /**
     * Call when the application is start to set.
     */
    public void show() {
        this.primaryStage = this.environment.getMainStage();
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));
        this.environment.displayScreen(ACTUALSCREEN);

    }

    // Event Listener on Button.onAction
    /**
     * @param event
     */
    @FXML
    public void loginAction(ActionEvent event) {
        final String user = txfUser.getText();
        final String passw = txfPassword.getText();
        final Status status = controller.userController().checkLogin(user, passw);
        this.clearErrorField();
        if (status == Status.USER_FOUND) {
            this.environment.displayScreen(ScreensGraphic.HOME);
        } else if (status == Status.USER_NOT_FOUND) {
            txtErrUser.setText("User not found");
        } else if (status == Status.WRONG_PASSWORD) {
            txtErrPassw.setText("Wrong password");
        }
    }

    private void clearErrorField() {
        txtErrUser.setText("");
        txtErrPassw.setText("");
    }

    // Event Listener on Button.onAction
    /**
     * @param event
     */
    @FXML
    public void goToSingup(ActionEvent event) {
        this.environment.displayScreen(ScreensGraphic.SINGUP);
    }

    @Override
    public void showNowContent() {
        // TODO Auto-generated method stub

    }

}
