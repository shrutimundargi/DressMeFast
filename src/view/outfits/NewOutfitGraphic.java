package view.outfits;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.enumerations.Category;
import model.interfaces.Dress;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;
import view.UI;
import view.general.GeneralObjectFx;
import view.general.ProgramUIImpl;

/**
 * 
 * Screen that show the Information of the user and permit to logout.
 *
 */
public class NewOutfitGraphic extends ProgramUIImpl implements UI {
    private static final int HEIGHT_DIALOG = 400;
    private static final int WIDTH_DIALOG = 650;

    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.NEW_OUTFITS;

    private static final String NAMEOFSCREEN = "New outfit";
    private static final String DESCRIPTIONOFPANE = "";

    @FXML
    private ScrollPane scrollPnl;
    private final VBox vBox;
    private final TextField txfName;

    private Dress[] outfitItem;
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
    public NewOutfitGraphic(final SceneSetting environment, final Controller controller, final SetupView setup) {
        super(environment, controller, setup, ACTUALSCREEN);
        this.getSceneSetting().loadScreen(ACTUALSCREEN, this);
        super.getBtnOutfits().setStyle("-fx-background-image: url('/images/dress.png');");
        final Text titlePane;
        final StackPane titleStackPnl;
        final Button btnAddOutfit;
        final StackPane skpBtnAddOutfit;

        final Category[] allCat;

        /* Container (PANE) */
        vBox = new VBox();
        outfitItem = new Dress[Category.values().length];
        genObjFx = new GeneralObjectFx();

        /* Title_______________ */
        titlePane = new Text(NAMEOFSCREEN);
        titleStackPnl = new StackPane();
        titlePane.getStyleClass().add("main-title");
        titleStackPnl.getChildren().add(titlePane);

        vBox.getChildren().add(titleStackPnl);
        VBox.setVgrow(scrollPnl, Priority.ALWAYS);
        /* ____________________ */

        /*
         * Description_________ final Label descriptionLabel = new
         * Label(DESCRIPTIONOFPANE); final StackPane descriptionPnl = new
         * StackPane();
         * descriptionLabel.getStyleClass().add("text-description");
         * descriptionLabel.setWrapText(true);
         * descriptionLabel.setTextAlignment(TextAlignment.JUSTIFY);
         * descriptionPnl.getChildren().add(descriptionLabel); /*
         * ____________________
         */

        /* Name_______________ */
        txfName = new TextField();
        genObjFx.addTextFieldToVBox("Name", txfName, vBox);
        /* ____________________ */

        allCat = Category.values();
        for (int i = 0; i < allCat.length - 1; i++) {
            final String nameCat = allCat[i].name();
            final BorderPane brpCat;
            final StackPane skpNameCat;
            final Label lblCat;
            final GridPane gridCat;
            final Button btnAddItem;
            final StackPane skpBtnAddItem;
            final Label lblItemInfo;
            final StackPane skpLblInfoItem;
            final int indexCat;

            /* GRID creation */
            brpCat = new BorderPane();
            skpNameCat = new StackPane();
            lblCat = new Label(allCat[i].name());
            gridCat = new GridPane();
            genObjFx.setBorderPaneExposition(nameCat, brpCat, skpNameCat, lblCat, gridCat);

            /* BUTTON add ithem */
            btnAddItem = new Button("Add item");
            skpBtnAddItem = new StackPane();
            genObjFx.setSmallBtnStkP(btnAddItem, skpBtnAddItem);

            /* LABEL No item selected */
            lblItemInfo = new Label("No item selected");
            skpLblInfoItem = new StackPane();
            lblItemInfo.getStyleClass().add("text-info-item");
            skpLblInfoItem.getChildren().add(lblItemInfo);

            gridCat.add(skpBtnAddItem, 0, 0);
            gridCat.add(skpLblInfoItem, 1, 0);

            /******* ACTION *******/
            indexCat = i;
            btnAddItem.setOnAction((event) -> {
                createDialogSelectItem(Category.valueOf(allCat[indexCat].name()));
            });

            vBox.getChildren().add(brpCat);
        }

        btnAddOutfit = new Button("Add outfit");
        skpBtnAddOutfit = new StackPane();

        genObjFx.setStandarBtnStkP(btnAddOutfit, skpBtnAddOutfit);

        /******* ACTION *******/
        btnAddOutfit.setOnAction(event -> {
            if (outfitItem.length != 0) {
                final List<UUID> dressesId = new LinkedList<>();
                final Alert alertOk = new Alert(AlertType.INFORMATION);
                alertOk.setTitle("Information Dialog");
                alertOk.setHeaderText("Yea, you added a new outfit");

                for (int i = 0; i < outfitItem.length; i++) {
                    if (outfitItem[i] != null) {
                        dressesId.add(outfitItem[i].getId());
                    }
                }
                super.getController().outfits().addOutfits(dressesId);
                this.resetAllComponent();
                super.returnTopPane();
                alertOk.show();
            } else {
                final Alert alertEr = new Alert(AlertType.ERROR);
                alertEr.setTitle("Error Dialog");
                alertEr.setHeaderText("There's somthing wrong!");
                alertEr.setContentText("Select at least one item");
                alertEr.show();
            }
        });

        vBox.getChildren().add(skpBtnAddOutfit);

        VBox.setVgrow(scrollPnl, Priority.ALWAYS);
        scrollPnl.setFitToWidth(true);
        scrollPnl.setContent(vBox);

    }

    @Override
    public void showNowContent() {
        super.setupColorButtonsBH();
        super.returnTopPane();
        resetAllComponent();
    }

    @Override
    public void resetAllComponent() {
        final Category[] allCat = Category.values();
        int indexOfFirstCategory = 0;
        for (int i = 0; i < vBox.getChildren().size(); i++) {
            if (vBox.getChildren().get(i) instanceof BorderPane) {
                indexOfFirstCategory = i;
            }
        }
        for (int i = 0; i < allCat.length - 1; i++) {
            final BorderPane brpCat = (BorderPane) vBox.getChildren().get(i + indexOfFirstCategory);
            final GridPane gridCat = (GridPane) brpCat.getCenter();

            if (gridCat.getChildren().size() > 2) {
                final Button btnAddItem;
                final StackPane skpBtnAdd;
                final Label lblItemInfo;
                final StackPane skpLblInfoItem;
                /* Remove the Button, Label and the Image */
                while (!gridCat.getChildren().isEmpty()) {
                    gridCat.getChildren().remove(0);
                }

                /* BUTTON add ithem */
                btnAddItem = new Button("Add item");
                skpBtnAdd = new StackPane();
                genObjFx.setSmallBtnStkP(btnAddItem, skpBtnAdd);

                /* LABEL No item selected */
                lblItemInfo = new Label("No item selected");
                skpLblInfoItem = new StackPane();
                genObjFx.setStandardLblStkP(lblItemInfo, skpLblInfoItem);

                gridCat.add(skpBtnAdd, 0, 0);
                gridCat.add(skpLblInfoItem, 1, 0);

                /******* ACTION *******/
                final int indexCat = i;
                btnAddItem.setOnAction(e -> {
                    createDialogSelectItem(Category.valueOf(allCat[indexCat].name()));
                });
            }
        }
    }

    private void createDialogSelectItem(final Category cat) {
        final URL url1 = this.getClass().getResource("NewOutfit.css");
        final URL url2 = this.getClass().getResource("../mainStyle.css");
        final String css1 = url1.toExternalForm();
        final String css2 = url2.toExternalForm();
        final Stage dialog = new Stage();
        final ScrollPane scrollPnlDialog;
        final StackPane stkVbox;
        final VBox dialogVbox;
        final List<String> brandsName;
        final int nBrand;
        final Scene dialogScene;

        dialog.setMinWidth(WIDTH_DIALOG);
        dialog.setMinHeight(HEIGHT_DIALOG);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(super.getSceneSetting().getMainStage());
        dialog.setTitle(cat.name());

        scrollPnlDialog = new ScrollPane();
        stkVbox = new StackPane();
        VBox.setVgrow(scrollPnlDialog, Priority.ALWAYS);
        scrollPnlDialog.setFitToWidth(true);

        dialogVbox = new VBox();
        stkVbox.getStyleClass().add("main-pane-user");
        stkVbox.getStyleClass().add("pane-user");

        brandsName = super.getController().dress().getAllBrandName(cat);
        nBrand = brandsName.size();

        // java.util.Collections.sort(brandsName);

        for (int i = 0; i < nBrand; i++) {

            final String nameBrand = brandsName.get(i);
            final BorderPane brpBrand = new BorderPane();
            final StackPane skpNameBrand = new StackPane();
            final Label lblBrand = new Label();
            final GridPane gridBrand = new GridPane();
            genObjFx.setBorderPaneExposition(nameBrand, brpBrand, skpNameBrand, lblBrand, gridBrand);

            /* Specific_Item__________________ */
            final List<Dress> dressItem = super.getController().dress().getAllBrandDress(cat, brandsName.get(i));
            for (int j = 0; j < dressItem.size(); j++) {
                final Dress dress = dressItem.get(j);
                final Button btnSelect = new Button("Select");

                btnSelect.setOnAction(event -> {
                    addSpecItem(cat, dress);
                    dialog.close();
                });

                genObjFx.setItemInsideGrid(j, dress, btnSelect, gridBrand);
            }
            dialogVbox.getChildren().add(brpBrand);
        }

        scrollPnlDialog.setContent(dialogVbox);
        stkVbox.getChildren().add(scrollPnlDialog);

        dialogScene = new Scene(stkVbox, 650, 400);
        dialogScene.getStylesheets().add(css1);
        dialogScene.getStylesheets().add(css2);
        dialog.setScene(dialogScene);

        dialog.show();

    }

    private void addSpecItem(final Category cat, final Dress dress) {
        final Category[] allCat = Category.values();
        int indexOfFirstCategory = 0;
        for (int i = 0; i < vBox.getChildren().size(); i++) {
            if (vBox.getChildren().get(i) instanceof BorderPane) {
                indexOfFirstCategory = i;
            }
        }
        for (int i = 0; i < allCat.length - 1; i++) {
            if (allCat[i].name().equals(cat.name())) {
                final BorderPane brpCat = (BorderPane) vBox.getChildren().get(i + indexOfFirstCategory);
                final GridPane gdpCat = (GridPane) brpCat.getCenter();
                final Button btnRemoveItem;
                final int indexCat;
                outfitItem[i] = dress;

                /* Remove the Button and the Label */
                while (!gdpCat.getChildren().isEmpty()) {
                    gdpCat.getChildren().remove(0);
                }

                /* BUTTON Remove item */
                btnRemoveItem = new Button("Remove it");

                genObjFx.setItemOfOutfit(dress, btnRemoveItem, gdpCat);

                /******* ACTION *******/
                indexCat = i;
                btnRemoveItem.setOnAction(event -> {
                    final Button btnAddItem;
                    final StackPane skpBtnAdd;
                    final Label lblItemInfo;
                    final StackPane skpLblInfoItem;
                    outfitItem[indexCat] = null;

                    /* Remove the Button and the Label */
                    while (!gdpCat.getChildren().isEmpty()) {
                        gdpCat.getChildren().remove(0);
                    }

                    /* BUTTON add item */
                    btnAddItem = new Button("Add item");
                    skpBtnAdd = new StackPane();
                    genObjFx.setSmallBtnStkP(btnAddItem, skpBtnAdd);

                    /* LABEL No item selected */
                    lblItemInfo = new Label("No item selected");
                    skpLblInfoItem = new StackPane();
                    genObjFx.setStandardLblStkP(lblItemInfo, skpLblInfoItem);

                    gdpCat.add(skpBtnAdd, 0, 0);
                    gdpCat.add(skpLblInfoItem, 1, 0);

                    btnAddItem.setOnAction(e -> {
                        createDialogSelectItem(Category.valueOf(allCat[indexCat].name()));
                    });
                });
            }

        }
    }
}
