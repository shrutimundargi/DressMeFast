package view.outfits;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.DoubleStream;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.enumerations.Category;
import model.interfaces.Dress;
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
public class NewOutfitGraphic extends ProgramUIImpl implements UI {
    private static final String BTN_SMALL = "btn-small";
    private static final String BTN_NORMAL = "btn-normal";
    private static final int LEFTRIGHT = 10;
    private static final int UPDOWN = 15;
    private static final int UPDOWN_BIG = 25;
    private static final int PERCENT_WIDTH_GRID = 33;
    private static final int WIDTH_HEIGHT = 150;
    private static final int HEIGHT_IMAGE = 200;
    private static final int SHADOW_HEIGHT = 20;
    private static final Insets STANDARD_INSET = new Insets(UPDOWN, LEFTRIGHT, UPDOWN, LEFTRIGHT);
    private static final Insets NOUP_INSET = new Insets(0, LEFTRIGHT, UPDOWN, LEFTRIGHT);
    private static final Insets NODOWN_INSET = new Insets(UPDOWN, LEFTRIGHT, 0, LEFTRIGHT);
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.NEW_OUTFITS;

    private static final String NAMEOFSCREEN = "New outfit";
    private static final String DESCRIPTIONOFPANE = "";

    @FXML
    private ScrollPane scrollPnl;
    private VBox vBox;

    private Dress[] outfitsBrand;

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
    /**
     * @param environment
     * @param controller
     * @param setup
     */
    public NewOutfitGraphic(final SceneSetting environment, final Controller controller, final SetupView setup) {
        super(environment, controller, setup, ACTUALSCREEN);
        this.getSceneSetting().loadScreen(ACTUALSCREEN, this);
        super.getBtnOutfits().setStyle("-fx-background-image: url('/images/dress.png');");

        /* Container (PANE) */
        vBox = new VBox();

        outfitsBrand = new Dress[6];

        /* Title_______________ */
        final Text titlePane = new Text(NAMEOFSCREEN);
        final StackPane titleStackPnl = new StackPane();
        titlePane.getStyleClass().add("main-title");
        titleStackPnl.getChildren().add(titlePane);
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

        vBox.getChildren().add(titleStackPnl);
        // vBox.getChildren().add(descriptionLabel);

        VBox.setVgrow(scrollPnl, javafx.scene.layout.Priority.ALWAYS);
        /* ___________________________________________ */
        scrollPnl.setFitToWidth(true);
        // scrollPnl.setFitToHeight(true);
        scrollPnl.setContent(vBox);

        Category[] allCat = Category.values();
        for (int i = 0; i < allCat.length - 1; i++) {

            BorderPane brpCat = new BorderPane();
            StackPane skpNameCat = new StackPane();
            Label nameCat = new Label(allCat[i].name());
            GridPane gridItem = new GridPane();

            brpCat.getStyleClass().add("pnl-show-item");
            skpNameCat.getStyleClass().add("pnl-show-item-title");
            nameCat.getStyleClass().add("text-title-show-item");
            gridItem.getStyleClass().add("pnl-show-item-dress");

            VBox.setMargin(brpCat, STANDARD_INSET);

            /* Grid________________ */
            gridItem.getColumnConstraints().addAll(
                    DoubleStream.of(PERCENT_WIDTH_GRID, PERCENT_WIDTH_GRID, PERCENT_WIDTH_GRID).mapToObj(width -> {
                        ColumnConstraints constraints = new ColumnConstraints();
                        constraints.setPercentWidth(width);
                        constraints.setFillWidth(true);
                        return constraints;
                    }).toArray(ColumnConstraints[]::new));

            final RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.ALWAYS);
            gridItem.getRowConstraints().add(rowConstraints);

            /* BUTTON add ithem */
            final Button btnAddItem = new Button("Add item");
            final StackPane skpBtnAdd = new StackPane();
            btnAddItem.getStyleClass().add(BTN_NORMAL);
            btnAddItem.getStyleClass().add(BTN_SMALL);
            skpBtnAdd.getChildren().add(btnAddItem);
            GridPane.setMargin(skpBtnAdd, STANDARD_INSET);

            /* LABEL No item selected */
            final Label lblItemInfo = new Label("No item selected");
            final StackPane skpLblInfoItem = new StackPane();
            lblItemInfo.getStyleClass().add("text-info-item");
            skpLblInfoItem.getChildren().add(lblItemInfo);

            gridItem.add(skpBtnAdd, 0, 0);
            gridItem.add(skpLblInfoItem, 1, 0);
            // gridItem.add(new Button("3"), 2, 0);
            skpNameCat.getChildren().add(nameCat);
            brpCat.setTop(skpNameCat);
            brpCat.setCenter(gridItem);

            final int indexCat = i;
            btnAddItem.setOnAction((event) -> {
                createPopUpSelectItem(Category.valueOf(allCat[indexCat].name()));
            });

            vBox.getChildren().add(brpCat);
        }

        final Button btnAddOutfit = new Button("Add outfit");
        final StackPane skpBtnAdd = new StackPane();
        btnAddOutfit.getStyleClass().add(BTN_NORMAL);
        skpBtnAdd.getChildren().add(btnAddOutfit);
        GridPane.setMargin(skpBtnAdd, STANDARD_INSET);

        btnAddOutfit.setOnAction(event -> {

        });

    }

    @Override
    public void showNowContent() {
        super.setupColorButtonsBH();
        resetAllComponent();
    }

    @Override
    public void resetAllComponent() {
        Category[] allCat = Category.values();
        for (int i = 0; i < allCat.length - 1; i++) {
            final BorderPane brpCat = (BorderPane) vBox.getChildren().get(i + 1);
            final GridPane gdpCat = (GridPane) brpCat.getCenter();

            if (gdpCat.getChildren().size() > 2) {
                /* Remove the Button, Label and the Image */
                while (!gdpCat.getChildren().isEmpty()) {
                    gdpCat.getChildren().remove(0);
                }

                /* BUTTON add ithem */
                final Button btnAddItem = new Button("Add item");
                final StackPane skpBtnAdd = new StackPane();
                btnAddItem.getStyleClass().add(BTN_NORMAL);
                btnAddItem.getStyleClass().add(BTN_SMALL);
                skpBtnAdd.getChildren().add(btnAddItem);
                GridPane.setMargin(skpBtnAdd, STANDARD_INSET);

                /* LABEL No item selected */
                final Label lblItemInfo = new Label("No item selected");
                final StackPane skpLblInfoItem = new StackPane();
                lblItemInfo.getStyleClass().add("text-info-item");
                skpLblInfoItem.getChildren().add(lblItemInfo);

                gdpCat.add(skpBtnAdd, 0, 0);
                gdpCat.add(skpLblInfoItem, 1, 0);
                final int indexCat = i;
                btnAddItem.setOnAction(e -> {
                    createPopUpSelectItem(Category.valueOf(allCat[indexCat].name()));
                });
            }
        }
    }

    private void createPopUpSelectItem(Category cat) {
        final Stage dialog = new Stage();
        dialog.setMinWidth(650);
        dialog.setMinHeight(400);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(super.getSceneSetting().getMainStage());
        dialog.setTitle(cat.name());

        VBox dialogVbox = new VBox();

        final List<String> brandsName = super.getController().dress().getAllBrandName(cat);
        final int nBrand = brandsName.size();

        final Insets standarInset = new Insets(UPDOWN, LEFTRIGHT, UPDOWN, LEFTRIGHT);
        final Insets noUpInset = new Insets(0, LEFTRIGHT, UPDOWN, LEFTRIGHT);
        final Insets noDownInset = new Insets(UPDOWN, LEFTRIGHT, 0, LEFTRIGHT);

        // java.util.Collections.sort(brandsName);

        for (int i = 0; i < nBrand; i++) {

            final BorderPane brpBrand = new BorderPane();
            final StackPane skpNameBrand = new StackPane();
            final Label nameBrand = new Label(brandsName.get(i));
            final GridPane gridItem = new GridPane();

            brpBrand.getStyleClass().add("pnl-show-item");
            skpNameBrand.getStyleClass().add("pnl-show-item-title");
            nameBrand.getStyleClass().add("text-title-show-item");
            gridItem.getStyleClass().add("pnl-show-item-dress");

            VBox.setMargin(brpBrand, standarInset);

            /* Grid________________ */
            gridItem.getColumnConstraints().addAll(
                    DoubleStream.of(PERCENT_WIDTH_GRID, PERCENT_WIDTH_GRID, PERCENT_WIDTH_GRID).mapToObj(width -> {
                        final ColumnConstraints constraints = new ColumnConstraints();
                        constraints.setPercentWidth(width);
                        constraints.setFillWidth(true);
                        return constraints;
                    }).toArray(ColumnConstraints[]::new));

            final RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.ALWAYS);
            gridItem.getRowConstraints().add(rowConstraints);

            /* Specific_Item__________________ */
            final List<Dress> dressItem = super.getController().dress().getAllBrandDress(cat, brandsName.get(i));
            for (int j = 0; j < dressItem.size(); j++) {
                final Dress dress = dressItem.get(j);
                final BorderPane brpSpecificIthem = new BorderPane();
                final int rowIndex = j % 3;
                final int columnIndex = j == 0 ? 0 : j / 3;

                /* Name TOP__________________ */
                final StackPane stpNameItem = new StackPane();
                final Label nameSpecItem = new Label(dress.getName());
                nameSpecItem.getStyleClass().add("text-title-show-item");
                stpNameItem.getChildren().add(nameSpecItem);
                StackPane.setMargin(nameSpecItem, noDownInset);
                brpSpecificIthem.setTop(stpNameItem);

                /* Image CENTER__________________ */
                brpSpecificIthem.getStyleClass().add("pnl-specific-item");
                final File imgFile = dress.getImage();
                Image img;
                final ImageView imageView = new ImageView();
                final StackPane stpImageView = new StackPane();

                BorderPane.setMargin(stpImageView, standarInset);
                imageView.getStyleClass().add("image-item");

                try {
                    img = new Image(new FileInputStream(imgFile.getAbsolutePath()));
                    imageView.setImage(img);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                imageView.setFitHeight(HEIGHT_IMAGE);
                imageView.setFitWidth(WIDTH_HEIGHT);
                imageView.setPreserveRatio(true);

                // snapshot the rounded image.
                final SnapshotParameters parameters = new SnapshotParameters();
                parameters.setFill(Color.TRANSPARENT);
                final WritableImage image = imageView.snapshot(parameters, null);

                // remove the rounding clip so that our effect can show through.
                imageView.setClip(null);

                // apply a shadow effect.
                imageView.setEffect(new DropShadow(SHADOW_HEIGHT, Color.BLACK));

                // store the rounded image in the imageView.
                imageView.setImage(image);

                stpImageView.getChildren().add(imageView);
                brpSpecificIthem.setCenter(stpImageView);

                /* Button see BUTTOM________________ */
                final StackPane stpButtonSee = new StackPane();
                final Button btnSelect = new Button("Select");
                btnSelect.getStyleClass().add(BTN_NORMAL);
                btnSelect.getStyleClass().add(BTN_SMALL);
                stpButtonSee.getChildren().add(btnSelect);
                brpSpecificIthem.setBottom(stpButtonSee);

                btnSelect.setOnAction(event -> {
                    addSpecItem(cat, dress);
                    dialog.close();
                });

                StackPane.setMargin(btnSelect, noUpInset);

                GridPane.setMargin(brpSpecificIthem, standarInset);

                gridItem.add(brpSpecificIthem, rowIndex, columnIndex);
            }

            skpNameBrand.getChildren().add(nameBrand);
            brpBrand.setTop(skpNameBrand);
            brpBrand.setCenter(gridItem);

            dialogVbox.getChildren().add(brpBrand);
        }

        ScrollPane scrollPnlDialog = new ScrollPane();
        VBox vbxScrollPnl = new VBox();
        StackPane stkVbox = new StackPane();
        VBox.setVgrow(scrollPnlDialog, javafx.scene.layout.Priority.ALWAYS);
        scrollPnlDialog.setFitToWidth(true);
        scrollPnlDialog.setContent(dialogVbox);

        stkVbox.getChildren().add(scrollPnlDialog);
        stkVbox.getStyleClass().add("main-pane-user");
        stkVbox.getStyleClass().add("pane-user");

        Scene dialogScene = new Scene(stkVbox, 650, 400);

        dialog.setScene(dialogScene);

        URL url1 = this.getClass().getResource("NewOutfit.css");
        URL url2 = this.getClass().getResource("../mainStyle.css");

        String css1 = url1.toExternalForm();
        String css2 = url2.toExternalForm();
        dialogScene.getStylesheets().add(css1);
        dialogScene.getStylesheets().add(css2);

        dialog.show();

    }

    private void addSpecItem(final Category cat, final Dress dress) {
        Category[] allCat = Category.values();
        for (int i = 0; i < allCat.length - 1; i++) {
            if (allCat[i].name().equals(cat.name())) {
                final BorderPane brpCat = (BorderPane) vBox.getChildren().get(i + 1);
                final GridPane gdpCat = (GridPane) brpCat.getCenter();
                
                outfitsBrand[i] = dress;

                /* Remove the Button */
                gdpCat.getChildren().remove(0);
                /* Remove the Label */
                gdpCat.getChildren().remove(0);

                /* BUTTON Remove item */
                final Button btnRemoveItem = new Button("Remove it");
                final StackPane skpRemoveItem = new StackPane();
                btnRemoveItem.getStyleClass().add(BTN_NORMAL);
                btnRemoveItem.getStyleClass().add(BTN_SMALL);
                btnRemoveItem.getStyleClass().add("btn-remove");
                skpRemoveItem.getChildren().add(btnRemoveItem);
                GridPane.setMargin(skpRemoveItem, STANDARD_INSET);

                /* LABEL Name of item */
                final Label lblNameItem = new Label(dress.getName());
                final StackPane skpInfoItem = new StackPane();
                lblNameItem.getStyleClass().add("text-name-item");
                skpInfoItem.getChildren().add(lblNameItem);

                /* IMAGE of item */
                final File imgFile = dress.getImage();
                final Image img;
                final ImageView imageView = new ImageView();
                final StackPane stpImageView = new StackPane();

                GridPane.setMargin(stpImageView, STANDARD_INSET);
                imageView.getStyleClass().add("image-item");

                try {
                    img = new Image(new FileInputStream(imgFile.getAbsolutePath()));
                    imageView.setImage(img);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                imageView.setFitHeight(HEIGHT_IMAGE);
                imageView.setFitWidth(WIDTH_HEIGHT);
                imageView.setPreserveRatio(true);

                // snapshot the rounded image.
                SnapshotParameters parameters = new SnapshotParameters();
                parameters.setFill(Color.TRANSPARENT);
                WritableImage image = imageView.snapshot(parameters, null);

                // remove the rounding clip so that our effect can show through.
                imageView.setClip(null);

                // apply a shadow effect.
                imageView.setEffect(new DropShadow(SHADOW_HEIGHT, Color.BLACK));

                // store the rounded image in the imageView.
                imageView.setImage(image);

                stpImageView.getChildren().add(imageView);

                final int indexCat = i;
                btnRemoveItem.setOnAction(event -> {
                    /* Remove the Button */
                    gdpCat.getChildren().remove(0);
                    /* Remove the Label */
                    gdpCat.getChildren().remove(0);
                    /* Remove the Image */
                    gdpCat.getChildren().remove(0);

                    /* BUTTON add ithem */
                    final Button btnAddItem = new Button("Add item");
                    final StackPane skpBtnAdd = new StackPane();
                    btnAddItem.getStyleClass().add(BTN_NORMAL);
                    btnAddItem.getStyleClass().add(BTN_SMALL);
                    skpBtnAdd.getChildren().add(btnAddItem);
                    GridPane.setMargin(skpBtnAdd, STANDARD_INSET);

                    /* LABEL No item selected */
                    final Label lblItemInfo = new Label("No item selected");
                    final StackPane skpLblInfoItem = new StackPane();
                    lblItemInfo.getStyleClass().add("text-info-item");
                    skpLblInfoItem.getChildren().add(lblItemInfo);

                    gdpCat.add(skpBtnAdd, 0, 0);
                    gdpCat.add(skpLblInfoItem, 1, 0);

                    btnAddItem.setOnAction(e -> {
                        createPopUpSelectItem(Category.valueOf(allCat[indexCat].name()));
                    });
                });

                gdpCat.add(skpRemoveItem, 0, 0);
                gdpCat.add(skpInfoItem, 1, 0);
                gdpCat.add(stpImageView, 2, 0);
            }

        }
    }
}
