package view.home;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;
import view.UI;
import view.generalUI.ProgramUI;
import view.generalUI.ProgramUIImpl;

/**
 * 
 * Class extended from all the screens that implements a standard graphic (with
 * standard menu and screen queue).
 *
 */
public class HomeGraphic extends ProgramUIImpl implements UI, ProgramUI {

    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.HOME;

    @FXML
    private Circle imagePreviewDress1;
    @FXML
    private Text txtPreviewDress1;
    @FXML
    private Button btnPreviewDress1;
    @FXML
    private Circle imagePreviewDress2;
    @FXML
    private Button btnPreviewDress2;
    @FXML
    private Circle imagePreviewDress3;
    @FXML
    private Button btnPreviewDress3;
    @FXML
    private Circle imagePreviewDress4;
    @FXML
    private Button btnPreviewDress4;
    @FXML
    private Button btnCenterBrand;
    @FXML
    private Button btnCenterOutfits;
    @FXML
    private Button btnCenterSize;
    @FXML
    private Button btnCenterAdd;
    @FXML
    private Button btnCenterFavorite;
    @FXML
    private Button btnCenterCategory;

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
    public HomeGraphic(final SceneSetting environment, final Controller controller, final SetupView setup) {
        super(environment, controller, setup, ACTUALSCREEN);
        super.getSceneSetting().loadScreen(ACTUALSCREEN, this);
        super.getBtnHome().setStyle("-fx-background-image: url('/images/hoodie.png');");
        /*
         * btnHome.setStyle("-fx-background-image: url('/images/hoodie.png');");
         * 
         * Image im = new
         * Image(getClass().getResourceAsStream("/images/vans-t-shirt.jpg"));
         * imagePreviewDress1.setFill(new ImagePattern(im));
         */
    }

    @Override
    public void showNowContent() {
        super.setupColorButtonsBH();
    }

    /**
     * Pressing of the button ADD in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterBrand(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.ADD);
    }

    /**
     * Pressing of the button ADD in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterAdd(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.ADD);
    }

    /**
     * Pressing of the button ADD in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterFavorite(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.ADD);
    }

    /**
     * Pressing of the button ADD in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterOutfits(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.ADD);
    }
    
    /**
     * Pressing of the button ADD in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterSize(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.ADD);
    }

    /**
     * Pressing of the button ADD in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterCategory(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.ADD);
    }

    @Override
    public void resetAllComponent() {
        // TODO Auto-generated method stub
        
    }


}
