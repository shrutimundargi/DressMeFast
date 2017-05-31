package view.dialog;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import view.SceneSetting;
import view.ScreensGraphic;
import view.UI;

/**
 * 
 * Screen that appear when the User is register.
 *
 */
public class SignupDialogGraphic implements UI {

    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.DIALOGSIGNUP;

    private final SceneSetting environment;
    private final Controller controller;

    @FXML
    private BorderPane brpBackground;
    @FXML
    private Label txtPopupName;

    /**
     * 
     * @param environment
     *            a reference of the instance of the class SceneSetting
     * @param controller
     *            a reference of the instance of the class Controller
     */
    public SignupDialogGraphic(final SceneSetting environment, final Controller controller) {
        this.controller = controller;
        this.environment = environment;
        this.environment.loadScreen(ACTUALSCREEN, this);
        txtPopupName.setWrapText(true); // Futile bug, because the txtPopupName
                                        // is already initialized by default.

    }

    /**
     * Pressing of the button GO HOME in the dialog screen after the
     * registration.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    public void goToHome(final ActionEvent event) {
        this.environment.displayScreen(ScreensGraphic.HOME);
    }

    @Override
    public void showNowContent() {
        /*brpBackground.setStyle("-fx-background-image: url('/images/login-bg-4.jpg');");*/
        txtPopupName
                .setText("Thank you " + controller.userController().getUsername() + " for joining in Dress Me Fast");
    }

}
