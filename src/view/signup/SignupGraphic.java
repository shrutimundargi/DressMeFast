package view.signup;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.enumerations.Status;
import view.SceneSetting;
import view.ScreensGraphic;
import view.UI;

/**
 * 
 *
 *
 */
public class SignupGraphic implements UI {

    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.SIGNUP;
    private static final int MIN_LENGTH = 5;

    private final SceneSetting environment;
    private final Controller controller;
    private Stage primaryStage;
    @FXML
    private BorderPane brpBackground;
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
    public SignupGraphic(final SceneSetting environment, final Controller controller) {
        this.controller = controller;
        this.environment = environment;
        this.environment.loadScreen(ACTUALSCREEN, this);
        this.primaryStage = this.environment.getMainStage();
        //brpBackgroung.setStyle("-fx-background-image: url('/images/add.png');");
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
        } else if (user.matches("^\\s*$")) {
            txtErrUser.setText("Username can't contain white spaces");
            allRight = false;
        }
        if (passw.length() < MIN_LENGTH) {
            txtErrPassw.setText("Password to short, min. 5 charats");
            allRight = false;
        } else if (passw.matches("^\\s*$")) {
            txtErrPassw.setText("Password can't contain white spaces"); 
            allRight = false;
        } else if (!repPassw.equals(passw)) {
            txtErrRepPassw.setText("Passwords not equal");
            allRight = false;
        } else if (allRight) {
            if (controller.userController().signUp(user, passw) == Status.DUPLICATED_USER) {
                txtErrUser.setText(Status.DUPLICATED_USER.getText());
            } else {
                this.environment.displayScreen(ScreensGraphic.DIALOGSIGNUP);
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
        /*brpBackground.setStyle("-fx-background-image: url('/images/login-bg-4.jpg');");*/
        txfUser.setText("");
        txfPassword.setText("");
        txfRepPassword.setText("");
        txtErrUser.setText("");
        txtErrPassw.setText("");
        txtErrRepPassw.setText("");

    }
}
