package view.home;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.interfaces.Dress;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;
import view.UI;
import view.general.DialogPreviewIO;
import view.general.GeneralObjectFx;
import view.general.ProgramUIImpl;

/**
 * 
 * Class extended from all the screens that implements a standard graphic (with
 * standard menu and screen queue).
 *
 */
public class HomeGraphic extends ProgramUIImpl implements UI {
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.HOME;

    @FXML
    private VBox vBoxLastAdded;

    private final DialogPreviewIO dialogItem;
    private final GeneralObjectFx genObjFx;

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
        dialogItem = new DialogPreviewIO();
        genObjFx = new GeneralObjectFx();
    }

    @Override
    public void showNowContent() {
        super.setupColorButtonsBH();
        resetAllComponent();
        showItemOfCategory();
    }

    /**
     * Pressing of the button BRAND in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterBrand(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.BRAND);
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
     * Pressing of the button FAVORITE in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterFavorite(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.FAVORITE);
    }

    /**
     * Pressing of the button OUTFITS in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterOutfits(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.OUTFITS);
    }

    /**
     * Pressing of the button SIZE in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterSize(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.SIZE);
    }

    /**
     * Pressing of the button CATEGORY in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterCategory(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.CATEGORY);
    }

    @Override
    public void resetAllComponent() {
        if (vBoxLastAdded.getChildren().size() > 0) {
            vBoxLastAdded.getChildren().remove(0);
        }
    }

    private void showItemOfCategory() {
        final Set<Dress> lastDressSet = super.getController().dress().getLastAddedDresses();
        final List<Dress> lastDress = new LinkedList<>(lastDressSet);

        final BorderPane brpHome = new BorderPane();
        final StackPane skpNameHome = new StackPane();
        final Label lblHome = new Label("Last added");
        final GridPane gridHome = new GridPane();
        genObjFx.setBorderPaneExposition(true, brpHome, skpNameHome, lblHome, gridHome);

        /* Specific_Item__________________ */
        for (int j = 0; j < lastDress.size() && j < 3; j++) {
            final Dress dress = lastDress.get(j);
            final Button btnSee = new Button("See more");

            genObjFx.setItemInsideGrid(true, j, dress, btnSee, gridHome);

            btnSee.setOnAction(event -> {
                dialogItem.createDialogDress(super.getSceneSetting().getMainStage(), dress,
                        super.getController(), this);
            });
        }
        vBoxLastAdded.getChildren().add(brpHome);

    }

}
