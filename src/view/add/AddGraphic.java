package view.add;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.logging.Logger;

import controller.Controller;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
public class AddGraphic extends ProgramUIImpl implements UI {
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.ADD;
    private static final String NAMEOFSCREEN = "Add Item";
    private static final String DESCRIPTIONOFPANE = "This page permit to add an item in your wordrobe,"
            + " it's very easy, you just need to choose the specific category of the item,"
            + " add a photo and then fill all the information about it.";
    @FXML
    private ScrollPane scrollPnl;
    private ImageView imvItem;
    private StackPane imageStackPnl;
    private Image imgItem;

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
    public AddGraphic(final SceneSetting environment, final Controller controller, final SetupView setup) {
        super(environment, controller, setup, ACTUALSCREEN);
        this.getSceneSetting().loadScreen(ACTUALSCREEN, this);
        super.getBtnAdd().setStyle("-fx-background-image: url('/images/add.png');");

        /* Container (PANE) */
        final VBox vBox = new VBox();
        final StackPane titleStackPnl = new StackPane();

        /* Title_______________ */
        final Text titlePane = new Text(NAMEOFSCREEN);
        titlePane.getStyleClass().add("main-title");
        titleStackPnl.getChildren().add(titlePane);
        /* ____________________ */

        /* Description_________ */
        final Label descriptionLabel = new Label(DESCRIPTIONOFPANE);
        descriptionLabel.getStyleClass().add("text-description");
        descriptionLabel.setWrapText(true);
        descriptionLabel.setTextAlignment(TextAlignment.JUSTIFY);
        // descriptionPnl.getChildren().add(descriptionLabel);
        /* ____________________ */

        /* Separator___________ */
        final Separator sepTitle = new Separator();
        sepTitle.getStyleClass().add("sep-title");
        /* ____________________ */

        /* Category_______________ */
        final Text txtCategory = new Text("Select the Category");
        final ChoiceBox chbCategory = new ChoiceBox();
        final StackPane pnlCategoryTitle = new StackPane();
        final StackPane pnlCategoryChb = new StackPane();
        txtCategory.getStyleClass().add("add-title-info");
        pnlCategoryTitle.getStyleClass().add("add-cont-title-info-first");
        chbCategory.getStyleClass().add("");
        pnlCategoryTitle.getChildren().add(txtCategory);
        pnlCategoryChb.getChildren().add(chbCategory);
        /* ____________________ */

        /* Image_______________ */
        final Text txtImage = new Text("Drag and drop an image ");
        final Button btnRemoveImage = new Button("Remove image");
        final StackPane pnlImageTitle = new StackPane();
        final StackPane pnlImage = new StackPane();
        final StackPane pnlButtonRemoveImage = new StackPane();
        imvItem = new ImageView();
        imageStackPnl = new StackPane();
        imageStackPnl.setPrefSize(200, 200);
        imageStackPnl.getStyleClass().add("pnl-image");
        btnRemoveImage.getStyleClass().add("btn-normal");
        btnRemoveImage.getStyleClass().add("btn-small");
        txtImage.getStyleClass().add("add-title-info");
        pnlImageTitle.getStyleClass().add("add-cont-title-info");
        pnlImage.getStyleClass().add("pnl-cont-image");
        pnlImageTitle.getChildren().add(txtImage);
        pnlImage.getChildren().add(imageStackPnl);
        pnlButtonRemoveImage.getChildren().add(btnRemoveImage);

        btnRemoveImage.setOnAction((event) -> {
            this.removeImage(imvItem, imageStackPnl);
        });

        imageStackPnl.setOnDragOver(new EventHandler<DragEvent>() {

            public void handle(final DragEvent event) {
                mouseDragOver(event);
            }
        });

        imageStackPnl.setOnDragDropped(new EventHandler<DragEvent>() {

            public void handle(final DragEvent event) {
                mouseDragDropped(event);
            }
        });

        imageStackPnl.setOnDragExited(new EventHandler<DragEvent>() {

            public void handle(final DragEvent event) {
                imageStackPnl.setStyle("-fx-border-color: #C6C6C6;");
            }
        });
        /* ____________________ */

        /* Brand_______________ */
        final Text txtBrand = new Text("Category");
        final TextField txfBrand = new TextField();
        final StackPane pnlBrandTitle = new StackPane();
        final StackPane pnlBrandTxf = new StackPane();
        txtBrand.getStyleClass().add("add-title-info");
        pnlBrandTitle.getStyleClass().add("add-cont-title-info");
        txfBrand.getStyleClass().add("");
        pnlBrandTitle.getChildren().add(txtBrand);
        pnlBrandTxf.getChildren().add(txfBrand);
        /* ____________________ */

        /* Size_______________ */
        final Text txtSize = new Text("Size");
        final TextField txfSize = new TextField();
        final StackPane pnlSizeTitle = new StackPane();
        final StackPane pnlSizeTxf = new StackPane();
        txtSize.getStyleClass().add("add-title-info");
        pnlSizeTitle.getStyleClass().add("add-cont-title-info");
        txfSize.getStyleClass().add("");
        pnlSizeTitle.getChildren().add(txtSize);
        pnlSizeTxf.getChildren().add(txfSize);
        /* ____________________ */

        /* Date_______________ */
        final Text txtDate = new Text("Purchase date");
        final TextField txfDate = new TextField();
        final StackPane pnlDateTitle = new StackPane();
        final StackPane pnlDateTxf = new StackPane();
        txtDate.getStyleClass().add("add-title-info");
        pnlDateTitle.getStyleClass().add("add-cont-title-info");
        txfDate.getStyleClass().add("");
        pnlDateTitle.getChildren().add(txtDate);
        pnlDateTxf.getChildren().add(txfDate);
        /* ____________________ */

        /* Favorite_______________ */
        final Text txtFavorite = new Text("Set like favorite");
        final CheckBox ckbFavorite = new CheckBox();
        final StackPane pnlFavoriteTitle = new StackPane();
        final StackPane pnlFavoriteCkb = new StackPane();
        txtFavorite.getStyleClass().add("add-title-info");
        pnlFavoriteTitle.getStyleClass().add("add-cont-title-info");
        ckbFavorite.getStyleClass().add("");
        pnlFavoriteTitle.getChildren().add(txtFavorite);
        pnlFavoriteCkb.getChildren().add(ckbFavorite);
        /* ____________________ */

        /* Some information_______________ */
        final Text txtInfo = new Text("Information");
        final TextArea txaInfo = new TextArea();
        final StackPane pnlInfoTitle = new StackPane();
        final StackPane pnlInfoTxa = new StackPane();
        txtInfo.getStyleClass().add("add-title-info");
        pnlInfoTitle.getStyleClass().add("add-cont-title-info");
        txaInfo.getStyleClass().add("");
        pnlInfoTitle.getChildren().add(txtInfo);
        pnlInfoTxa.getChildren().add(txaInfo);
        /* ____________________ */

        /* Button_______________ */
        final Button btnAdd = new Button("Add Item");
        btnAdd.getStyleClass().add("btn-normal");
        final StackPane pnlAdd = new StackPane();
        pnlAdd.getChildren().add(btnAdd);
        /* _____________________ */

        /* Adding of graphic elements to PANE_________ */
        vBox.getChildren().add(titleStackPnl);
        vBox.getChildren().add(descriptionLabel);
        vBox.getChildren().add(sepTitle);
        vBox.getChildren().add(pnlCategoryTitle);
        vBox.getChildren().add(pnlCategoryChb);
        vBox.getChildren().add(pnlImageTitle);
        vBox.getChildren().add(pnlImage);
        vBox.getChildren().add(pnlButtonRemoveImage);
        vBox.getChildren().add(pnlBrandTitle);
        vBox.getChildren().add(pnlBrandTxf);
        vBox.getChildren().add(pnlSizeTitle);
        vBox.getChildren().add(pnlSizeTxf);
        vBox.getChildren().add(pnlDateTitle);
        vBox.getChildren().add(pnlDateTxf);
        vBox.getChildren().add(pnlFavoriteTitle);
        vBox.getChildren().add(pnlFavoriteCkb);
        vBox.getChildren().add(pnlInfoTitle);
        vBox.getChildren().add(pnlInfoTxa);
        vBox.getChildren().add(pnlAdd);
        /* ___________________________________________ */

        vBox.setVgrow(scrollPnl, javafx.scene.layout.Priority.ALWAYS);
        /* ___________________________________________ */
        scrollPnl.setFitToWidth(true);
        // scrollPnl.setFitToHeight(true);
        scrollPnl.setContent(vBox);
    }

    @Override
    public void showNowContent() {
        super.setupColorButtonsBH();
    }

    /**
     * Add an image in a ImageView and then in a StackPane.
     * 
     * @param img
     *            is the image that the user dropped on
     * @param imageView
     *            is the container of the image
     * @param pane
     *            is the container of the imageView
     */
    public void addImage(final Image img, final ImageView imageView, final StackPane pane) {
        System.out.println(img);
        imageView.setImage(img);
        imageView.setFitWidth(235);
        imageView.setPreserveRatio(true);

        if (!pane.getChildren().contains(imvItem)) {
            pane.getChildren().add(imvItem);
        }
        pane.setPrefHeight(imvItem.getFitHeight());
        pane.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-color: transparent;");
    }

    /**
     * Permit to remove an image from an ImageView, if it doesn't contain an
     * image the method don't do nothing.
     * 
     * @param imv
     *            is the ImageView
     * @param pane
     *            is the StackPane
     */
    public void removeImage(final ImageView imv, final StackPane pane) {
        if (imvItem.getImage() != null) {
            imvItem.setImage(null);
            pane.setStyle("-fx-background-color: #333333; -fx-border-color: #8A8A8A; -fx-border-radius: 4.0;"
                    + " -fx-background-radius: 4px;");
            pane.setPrefHeight(200);
            pane.setPrefWidth(200);
        }
    }

    /**
     * The event of when you drop an image on the StackPane.
     * 
     * @param e
     *            the event
     */
    private void mouseDragDropped(final DragEvent e) {
        final Dragboard db = e.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;
            // Only get the first file from the list
            final File file = db.getFiles().get(0);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    System.out.println(file.getAbsolutePath());
                    try {
                        if (!imageStackPnl.getChildren().isEmpty()) {
                            imageStackPnl.getChildren().remove(0);
                        }

                        imgItem = new Image(new FileInputStream(file.getAbsolutePath()));
                        addImage(imgItem, imvItem, imageStackPnl);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
        e.setDropCompleted(success);
        e.consume();
    }

    /**
     * The event of when you drag an image on the StackPane.
     * 
     * @param e
     *            the event
     */
    private void mouseDragOver(final DragEvent e) {
        final Dragboard db = e.getDragboard();

        final boolean isAccepted = db.getFiles().get(0).getName().toLowerCase(Locale.US).endsWith(".png")
                || db.getFiles().get(0).getName().toLowerCase(Locale.US).endsWith(".jpeg")
                || db.getFiles().get(0).getName().toLowerCase(Locale.US).endsWith(".jpg");

        if (db.hasFiles()) {
            if (isAccepted) {
                imageStackPnl
                        .setStyle("-fx-border-color: white;" + "-fx-border-width: 5;" + "-fx-background-color: grey;");
                e.acceptTransferModes(TransferMode.COPY);
            }
        } else {
            e.consume();
        }
    }
}
