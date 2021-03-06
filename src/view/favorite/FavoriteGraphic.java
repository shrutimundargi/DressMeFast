package view.favorite;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
 * Screen that show the Information of the user and permit to logout.
 *
 */
public class FavoriteGraphic extends ProgramUIImpl implements UI {
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.FAVORITE;

    private static final String NAMEOFSCREEN = "Favorite";

    @FXML
    private ScrollPane scrollPnl;
    private final VBox vBox;
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
    public FavoriteGraphic(final SceneSetting environment, final Controller controller, final SetupView setup) {
        super(environment, controller, setup, ACTUALSCREEN);
        this.getSceneSetting().loadScreen(ACTUALSCREEN, this);
        super.getBtnFavorite().setStyle("-fx-background-image: url('/images/star.png');");

        dialogItem = new DialogPreviewIO();
        genObjFx = new GeneralObjectFx();

        /* Container (PANE) */
        vBox = new VBox();

        /* Title_______________ */
        final Text titlePane = new Text(NAMEOFSCREEN);
        final StackPane titleStackPnl = new StackPane();
        titlePane.getStyleClass().add("main-title");
        titleStackPnl.getStyleClass().add("pnl-main-title");
        titleStackPnl.getChildren().add(titlePane);
        /* ____________________ */

        vBox.getChildren().add(titleStackPnl);

        VBox.setVgrow(scrollPnl, javafx.scene.layout.Priority.ALWAYS);
        /* ___________________________________________ */
        scrollPnl.setFitToWidth(true);
        // scrollPnl.setFitToHeight(true);
        scrollPnl.setContent(vBox);

    }

    @Override
    public void showNowContent() {
        super.setupColorButtonsBH();
        returnTopPane();
        resetAllComponent();
        showItemOfFavegory();
    }

    @Override
    public void resetAllComponent() {
        final int nComponent = vBox.getChildren().size();
        for (int i = 1; i < nComponent; i++) {
            vBox.getChildren().remove(1);
        }
    }

    /**
     * @param Fav
     */
    private void showItemOfFavegory() {
        final BorderPane brpBrand = new BorderPane();
        final StackPane skpNameBrand = new StackPane();
        final Label lblBrand = new Label("Favorite");
        final GridPane gridBrand = new GridPane();
        genObjFx.setBorderPaneExposition(false, brpBrand, skpNameBrand, lblBrand, gridBrand);

        /* Specific_Item__________________ */
        final Set<Dress> dressItemSet = super.getController().dress().getFavoriteDresses();
        final List<Dress> dressItem = new LinkedList<>(dressItemSet);
        for (int j = 0; j < dressItem.size(); j++) {
            final Dress dress = dressItem.get(j);
            final Button btnSelect = new Button("See more");

            genObjFx.setItemInsideGrid(false, j, dress, btnSelect, gridBrand);

            btnSelect.setOnAction(event -> {
                dialogItem.createDialogDress(super.getSceneSetting().getMainStage(), dress,
                        super.getController(), this);
                this.showNowContent();
            });
        }

        vBox.getChildren().add(gridBrand);

    }
}
