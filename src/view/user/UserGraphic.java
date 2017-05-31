package view.user;

import controller.Controller;
import javafx.event.ActionEvent;
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
        super.returnTopPane();
        fillTheInfo();
    }

    @Override
    public void resetAllComponent() {
        scrollPnl.setVvalue(scrollPnl.getMaxHeight());
    }

    /**
     * Pressing of the button ADD in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void logoutAction(final ActionEvent event) {
        super.getController().userController().logout();
        super.getSceneSetting().displayScreen(ScreensGraphic.LOGIN);
    }

    private void fillTheInfo() {
        final String dateRegistration = super.getController().userController().getSingUpDate().toString();
        final int numOfDresses = super.getController().dress().getAllDresses().size();
        final int numFavDresses = super.getController().dress().getFavoriteDresses().size();
        final int numBrand = super.getController().dress().getAllBrand().size();
        final int numOutfits = super.getController().outfits().getAllOutfits() == null ? 0
                : super.getController().outfits().getAllOutfits().size();
        String popBrand = super.getController().dress().getPopularBrand();
        popBrand = popBrand == null ? "" : popBrand;
        lblDateRegistration.setText("Registred the " + dateRegistration);
        lblNumItem.setText(String.valueOf((numOfDresses)));
        lblFavItem.setText(String.valueOf(numFavDresses));
        lblNumBrand.setText(String.valueOf(numBrand));
        lblNumOutfits.setText(String.valueOf(numOutfits));
        lblBrandMostUsed.setText(String.valueOf(popBrand));
    }
}
