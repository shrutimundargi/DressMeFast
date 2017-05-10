package view.user;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;
import view.UI;
import view.generalUI.ProgramUIImpl;

/**
 * 
 * Screen that show the Information of the user and permit to logout.
 *
 */
public class UserGraphic extends ProgramUIImpl implements UI {
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.USER;

    @FXML
    private Button btnGoBack;
    @FXML
    private Button btnGoAhead;
    @FXML
    private Button btnLogout;
    @FXML
    private Text txtUser;

    /**
     * 
     * @param environment
     *            a reference of the instance of the class SceneSetting
     * @param controller
     *            a reference of the instance of the class Controller
     * @param setup
     *            a reference of the instance of the class SetupView that permit
     *            to manage the important thing of the view, like
     */
    public UserGraphic(final SceneSetting environment, final Controller controller, final SetupView setup) {
        super(environment, controller, setup, ACTUALSCREEN);
        this.getSceneSetting().loadScreen(ACTUALSCREEN, this);
        super.getBtnUser().setStyle("-fx-background-color: #292929");

    }

    @Override
    public void showNowContent() {
        super.setupColorButtonsBH();
        txtUser.setText(super.getController().userController().getUsername());
    }
    
    @FXML
    public void pressLogout(ActionEvent event) {
        super.getController().userController().logout();
        super.getSceneSetting().displayScreen(ScreensGraphic.LOGIN);
    }
}
