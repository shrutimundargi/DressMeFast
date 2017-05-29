package view.user;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;
import view.UI;
import view.general.ProgramUIImpl;

/**
 * 
 * Screen that show the Information of the user and permit to logout.
 *
 */
public class UserGraphic extends ProgramUIImpl implements UI {
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.USER;

    @FXML
    private ScrollPane scrollPnl;
    @FXML
    private Text txtUser;
    @FXML
    private Label lblDateRegistration;
    @FXML
    private Label lblNumItem;
    @FXML
    private Label lblFavItem;
    @FXML
    private Label lblNumBrand;
    @FXML
    private Label lblNumOutfits;
    @FXML
    private Label lblBrandMostUsed;

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
        resetAllComponent();
        fillTheInfo();
    }

    @Override
    public void resetAllComponent() {
        scrollPnl.setVvalue(scrollPnl.getMaxHeight());
    }

    private void fillTheInfo() {
        lblDateRegistration
                .setText("Registred the " + super.getController().userController().getSingUpDate().toString());
        lblNumItem.setText(String.valueOf((super.getController().dress().getAllDresses().size())));
        lblFavItem.setText(String.valueOf(super.getController().dress().getFavoriteDresses().size()));
        lblNumBrand.setText(String.valueOf(super.getController().dress().getAllBrand().size()));
        lblNumOutfits.setText(String.valueOf(super.getController().outfits().getAllOutfits().size()));
        lblBrandMostUsed.setText(String.valueOf(super.getController().dress().getPopularBrand()));
    }
}
