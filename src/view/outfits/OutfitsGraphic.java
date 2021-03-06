package view.outfits;

import java.util.List;
import java.util.UUID;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.interfaces.Dress;
import model.interfaces.Outfits;
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
public class OutfitsGraphic extends ProgramUIImpl implements UI {
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.OUTFITS;

    private static final String NAMEOFSCREEN = "Outfits";

    @FXML
    private ScrollPane scrollPnl;
    private final VBox vBox;
    private final GeneralObjectFx genObjFx;
    private final DialogPreviewIO dialogItem;

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
    public OutfitsGraphic(final SceneSetting environment, final Controller controller, final SetupView setup) {
        super(environment, controller, setup, ACTUALSCREEN);
        this.getSceneSetting().loadScreen(ACTUALSCREEN, this);
        super.getBtnOutfits().setStyle("-fx-background-image: url('/images/dress.png');");

        /* Container (PANE) */
        genObjFx = new GeneralObjectFx();
        dialogItem = new DialogPreviewIO();

        vBox = new VBox();
        final Button btnCreateOutfits;
        final StackPane skpBtnCrateOtf;
        final Button btnUIOutfits;
        final StackPane skpBtnUIOutfits;

        /* Title_______________ */
        final Text titlePane = new Text(NAMEOFSCREEN);
        final StackPane titleStackPnl = new StackPane();
        titlePane.getStyleClass().add("main-title");
        titleStackPnl.getChildren().add(titlePane);
        vBox.getChildren().add(titleStackPnl);
        /* ____________________ */

        /* Button_______________ */
        btnCreateOutfits = new Button("Create now an Outfit");
        btnCreateOutfits.getStyleClass().add("btn-outfits");
        skpBtnCrateOtf = new StackPane();
        VBox.setMargin(skpBtnCrateOtf, genObjFx.getStandardInset());
        genObjFx.setStandarBtnStkP(btnCreateOutfits, skpBtnCrateOtf);
        vBox.getChildren().add(skpBtnCrateOtf);
        /* ____________________ */

        /******* ACTION *******/
        btnCreateOutfits.setOnAction((event) -> {
            super.getSceneSetting().displayScreen(ScreensGraphic.NEW_OUTFITS);
        });

        /* Button_______________ */
        btnUIOutfits = new Button("Generate a intelligent Outfit");
        btnUIOutfits.getStyleClass().add("btn-outfits");
        skpBtnUIOutfits = new StackPane();
        VBox.setMargin(skpBtnUIOutfits, genObjFx.getStandardInset());
        genObjFx.setStandarBtnStkP(btnUIOutfits, skpBtnUIOutfits);
        vBox.getChildren().add(skpBtnUIOutfits);
        /* ____________________ */

        /******* ACTION *******/
        btnCreateOutfits.setOnAction((event) -> {
            super.getSceneSetting().displayScreen(ScreensGraphic.NEW_OUTFITS);
        });

        btnUIOutfits.setOnAction((event) -> {
            super.getController().outfits().createAIOutfit();
            showNowContent();
        });

        VBox.setVgrow(scrollPnl, Priority.ALWAYS);
        scrollPnl.setFitToWidth(true);
        scrollPnl.setContent(vBox);
    }

    @Override
    public final void showNowContent() {
        super.setupColorButtonsBH();
        resetAllComponent();
        showAllOutfits();
    }

    @Override
    public final void resetAllComponent() {
        final int nComponent = vBox.getChildren().size();
        for (int i = 0; i < nComponent; i++) {
            if (vBox.getChildren().get(i) instanceof GridPane) {
                vBox.getChildren().remove(i);
            }
        }
    }

    private void showAllOutfits() {
        /* Outfits list ________ */
        final BorderPane brpOutfit = new BorderPane();
        final StackPane skpNameOutfit = new StackPane();
        final Label lblOutfit = new Label("Favorite");
        final GridPane gridOutfits = new GridPane();
        genObjFx.setBorderPaneExposition(false, brpOutfit, skpNameOutfit, lblOutfit, gridOutfits);
        final List<Outfits> allOutfits = super.getController().outfits().getAllOutfits();
        for (int i = 0; i < allOutfits.size(); i++) {
            final Button btnSelect = new Button("See More");
            final Outfits outfit = allOutfits.get(i);
            final List<UUID> idsOfDress = outfit.getOutfit();
            final List<Dress> dressesOfOutfit = super.getController().dress().getDressesOfIds(idsOfDress);

            genObjFx.setOutfitInsideGrid(i, outfit, dressesOfOutfit, btnSelect, gridOutfits);

            btnSelect.setOnAction(event -> {
                dialogItem.createDialogOutfit(super.getSceneSetting().getMainStage(), outfit, super.getController(),
                        this);
            });
        }
        vBox.getChildren().add(gridOutfits);
    }
}
