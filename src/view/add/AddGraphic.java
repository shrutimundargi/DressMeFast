package view.add;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Locale;

import controller.Controller;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.enumerations.Category;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;
import view.UI;
import view.generalUI.ProgramUIImpl;

/**
 * 
 * Screen that permit to add an item (dress).
 *
 */
public class AddGraphic extends ProgramUIImpl implements UI {
    private static final String REMEMBER = "Remember, ";
    private static final String OPSSS = "Opsss, ";
    private static final String ONLYNUMBER = "[0-9]*";
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.ADD;
    private static final String NAMEOFSCREEN = "Add Item";
    private static final String DESCRIPTIONOFPANE = "This page permit to add an item in your wordrobe,"
            + " it's very easy, you just need to choose the specific category of the item,"
            + " add a photo and then fill all the information about it.";

    private static final int PREFSIZE_IMG = 200;
    private static final int PREFSIZE_IMG_OFIMAGE = 235;
    private static final int PREFSIZE_TEXT = 235;

    @FXML
    private ScrollPane scrollPnl;

    private Image imgItem;
    private File imgFile;
    private final ImageView imvItem;
    private final StackPane imageStackPnl;
    private final ChoiceBox<Category> chbCategory;
    private final TextField txfName;
    private final TextField txfBrand;
    private final TextField txfSize;
    private final TextField txfPrice;
    private final DatePicker dtpDate;
    private final CheckBox ckbFavorite;
    private final TextArea txaInfo;

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
        chbCategory = new ChoiceBox<Category>();
        final StackPane pnlCategoryTitle = new StackPane();
        final StackPane pnlCategoryChb = new StackPane();
        txtCategory.getStyleClass().add("add-title-info"); // NOPMD - because I
                                                           // need to add the
                                                           // same style to more
                                                           // elements
        pnlCategoryTitle.getStyleClass().add("add-cont-title-info-first");
        chbCategory.getStyleClass().add("chb-category");

        chbCategory.getItems().setAll(Category.values());

        pnlCategoryTitle.getChildren().add(txtCategory);
        pnlCategoryChb.getChildren().add(chbCategory);
        /* ____________________ */

        /* Image_______________ */
        final Text txtImage = new Text("Drag and drop an image ");
        final Button btnRemoveImage = new Button("Remove image");
        imvItem = new ImageView();
        imageStackPnl = new StackPane();
        final StackPane pnlImageTitle = new StackPane();
        final StackPane pnlImage = new StackPane();
        final StackPane pnlButtonRemoveImage = new StackPane();
        imageStackPnl.setPrefSize(PREFSIZE_IMG, PREFSIZE_IMG);
        imageStackPnl.getStyleClass().add("pnl-image");
        btnRemoveImage.getStyleClass().add("btn-normal");
        btnRemoveImage.getStyleClass().add("btn-small");
        txtImage.getStyleClass().add("add-title-info");
        pnlImageTitle.getStyleClass().add("add-cont-title-info"); // NOPMD -
                                                                  // because I
                                                                  // need to add
                                                                  // the same
                                                                  // style to
                                                                  // more
                                                                  // elements
        pnlImage.getStyleClass().add("pnl-cont-image");
        pnlImageTitle.getChildren().add(txtImage);
        pnlImage.getChildren().add(imageStackPnl);
        pnlButtonRemoveImage.getChildren().add(btnRemoveImage);

        btnRemoveImage.setOnAction((event) -> {
            removeTheImage(imvItem, imageStackPnl);
        });

        imageStackPnl.setOnDragOver(new EventHandler<DragEvent>() {

            public void handle(final DragEvent event) {
                mouseDragOver(event, imageStackPnl);
            }
        });

        imageStackPnl.setOnDragDropped(new EventHandler<DragEvent>() {

            public void handle(final DragEvent event) {
                mouseDragDropped(event, imvItem, imageStackPnl);
            }
        });

        imageStackPnl.setOnDragExited(new EventHandler<DragEvent>() {

            public void handle(final DragEvent event) {
                imageStackPnl.setStyle("-fx-border-color: #C6C6C6;");
            }
        });
        /* ____________________ */

        /* Name_______________ */
        final Text txtName = new Text("Name");
        txfName = new TextField();
        final StackPane pnlNameTitle = new StackPane();
        final StackPane pnlNameTxf = new StackPane();
        txtName.getStyleClass().add("add-title-info");
        pnlNameTitle.getStyleClass().add("add-cont-title-info");
        txfName.getStyleClass().add("text-field-add"); // NOPMD - because I need
                                                       // to add the same style
                                                       // to more elements
        txfName.setMaxWidth(PREFSIZE_TEXT);
        pnlNameTitle.getChildren().add(txtName);
        pnlNameTxf.getChildren().add(txfName);
        /* ____________________ */

        /* Brand_______________ */
        final Text txtBrand = new Text("Brand");
        txfBrand = new TextField();
        final StackPane pnlBrandTitle = new StackPane();
        final StackPane pnlBrandTxf = new StackPane();
        txtBrand.getStyleClass().add("add-title-info");
        pnlBrandTitle.getStyleClass().add("add-cont-title-info");
        txfBrand.getStyleClass().add("text-field-add");
        txfBrand.setMaxWidth(PREFSIZE_TEXT);
        pnlBrandTitle.getChildren().add(txtBrand);
        pnlBrandTxf.getChildren().add(txfBrand);
        /* ____________________ */

        /* Size_______________ */
        final Text txtSize = new Text("Size");
        txfSize = new TextField();
        final StackPane pnlSizeTitle = new StackPane();
        final StackPane pnlSizeTxf = new StackPane();
        txtSize.getStyleClass().add("add-title-info");
        pnlSizeTitle.getStyleClass().add("add-cont-title-info");
        txfSize.getStyleClass().add("text-field-add");
        txfSize.setMaxWidth(PREFSIZE_TEXT);
        pnlSizeTitle.getChildren().add(txtSize);
        pnlSizeTxf.getChildren().add(txfSize);
        /* ____________________ */

        /* Price_______________ */
        final Text txtPrice = new Text("Price");
        txfPrice = new TextField();
        final StackPane pnlPriceTitle = new StackPane();
        final StackPane pnlPriceTxf = new StackPane();
        txtPrice.getStyleClass().add("add-title-info");
        pnlPriceTitle.getStyleClass().add("add-cont-title-info");
        txfPrice.getStyleClass().add("text-field-add");
        txfPrice.setMaxWidth(PREFSIZE_TEXT);
        pnlPriceTitle.getChildren().add(txtPrice);
        pnlPriceTxf.getChildren().add(txfPrice);
        /* ____________________ */

        /* Date_______________ */
        final Text txtDate = new Text("Purchase date");
        dtpDate = new DatePicker();
        final StackPane pnlDateTitle = new StackPane();
        final StackPane pnlDateTxf = new StackPane();
        txtDate.getStyleClass().add("add-title-info");
        pnlDateTitle.getStyleClass().add("add-cont-title-info");
        dtpDate.getStyleClass().add("date-picker");
        pnlDateTitle.getChildren().add(txtDate);
        pnlDateTxf.getChildren().add(dtpDate);
        /* ____________________ */

        /* Favorite_______________ */
        final Text txtFavorite = new Text("Set like favorite");
        ckbFavorite = new CheckBox();
        final StackPane pnlFavoriteTitle = new StackPane();
        final StackPane pnlFavoriteCkb = new StackPane();
        txtFavorite.getStyleClass().add("add-title-info");
        pnlFavoriteTitle.getStyleClass().add("add-cont-title-info");
        ckbFavorite.getStyleClass().add("check-box");
        pnlFavoriteTitle.getChildren().add(txtFavorite);
        pnlFavoriteCkb.getChildren().add(ckbFavorite);
        /* ____________________ */

        /* Some information_______________ */
        final Text txtInfo = new Text("Information");
        txaInfo = new TextArea();
        final StackPane pnlInfoTitle = new StackPane();
        final StackPane pnlInfoTxa = new StackPane();
        txtInfo.getStyleClass().add("add-title-info");
        pnlInfoTitle.getStyleClass().add("add-cont-title-info");
        txaInfo.getStyleClass().add("text-field-add-info");
        pnlInfoTitle.getChildren().add(txtInfo);
        pnlInfoTxa.getChildren().add(txaInfo);
        /* ____________________ */

        /* Button_______________ */
        final Button btnAdd = new Button("Add Item");
        final StackPane pnlAdd = new StackPane();
        btnAdd.getStyleClass().add("btn-normal");
        pnlAdd.getStyleClass().add("pnl-button-add");
        pnlAdd.getChildren().add(btnAdd);
        btnAdd.setOnAction((event) -> {
            final Alert alertEr = new Alert(AlertType.ERROR);
            final Alert alertOk = new Alert(AlertType.INFORMATION);
            alertEr.setTitle("Error Dialog");
            alertEr.setHeaderText("There's somthing wrong!");
            String messageNecessaryField = OPSSS;
            String messageNumericField = REMEMBER;
            String messageFinal = "";
            // Check if all the necessary field are filled
            if (chbCategory.getValue() == null && imvItem.getImage() == null) {
                messageNecessaryField += "you need to select a category and a photo of the item.";
            } else if (chbCategory.getValue() == null) {
                messageNecessaryField += "you need to select a category.";
            } else if (imvItem.getImage() == null) {
                messageNecessaryField += "you need insert a photo.";
            }

            // Check if all the numeric filed are correct
            if (!txfPrice.getText().equals("") || !txfSize.getText().equals("")) {
                if (!txfPrice.getText().matches(ONLYNUMBER) && !txfSize.getText().matches(ONLYNUMBER)) {
                    messageNumericField += "are allow only numeric character in the fields Price and Size";
                } else if (!txfPrice.getText().matches(ONLYNUMBER)) {
                    messageNumericField += "are allow only numeric character in the fild Price";
                } else if (!txfSize.getText().matches(ONLYNUMBER)) {
                    messageNumericField += "are allow only numeric character in the fild Size";
                }
            }

            if (!messageNecessaryField.equals(OPSSS) && !messageNumericField.equals(REMEMBER)) {
                messageFinal = messageNecessaryField + " " + messageNumericField;
            } else if (!messageNecessaryField.equals(OPSSS) && messageNumericField.equals(REMEMBER)) {
                messageFinal = messageNecessaryField;
            } else if (messageNecessaryField.equals(OPSSS) && !messageNumericField.equals(REMEMBER)) {
                messageFinal = messageNumericField;
            }

            if (!messageFinal.equals("")) {
                alertEr.setContentText(messageFinal);
                alertEr.showAndWait();
            } else {
                alertOk.setTitle("Information Dialog");
                alertOk.setHeaderText("Yea, you added your item");
                alertOk.setContentText("The item is add in the category " + chbCategory.getValue() + "!");
                System.out.println(dtpDate.getValue());

                // super.getController().dress().addDress(txfName.getText(),
                // txfBrand.getText(),
                // Integer.valueOf(txfSize.getText()),
                // Integer.valueOf(txtPrice.getText()), dtpDate.getValue(),
                // txaInfo.getText(), chbCategory.getValue(), imgFile);
                this.restField();
                alertOk.showAndWait();
            }

        });
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
        vBox.getChildren().add(pnlNameTitle);
        vBox.getChildren().add(pnlNameTxf);
        vBox.getChildren().add(pnlBrandTitle);
        vBox.getChildren().add(pnlBrandTxf);
        vBox.getChildren().add(pnlSizeTitle);
        vBox.getChildren().add(pnlSizeTxf);
        vBox.getChildren().add(pnlPriceTitle);
        vBox.getChildren().add(pnlPriceTxf);
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
        this.restField();
    }

    /**
     * Reset all value in the field.
     */
    public final void restField() {
        chbCategory.setValue(null);
        this.removeTheImage(imvItem, imageStackPnl);
        txfBrand.clear();
        txfSize.clear();
        dtpDate.setValue(null);
        ckbFavorite.setSelected(false);
        txaInfo.clear();
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
        imageView.setFitWidth(PREFSIZE_IMG_OFIMAGE);
        imageView.setPreserveRatio(true);

        if (!pane.getChildren().contains(imageView)) {
            pane.getChildren().add(imageView);
        }
        pane.setPrefHeight(imageView.getFitHeight());
        pane.setStyle("-fx-border-color: transparent; -fx-border-width: 0; -fx-background-color: transparent;");
    }

    /**
     * Permit to remove an image from an ImageView, if it doesn't contain an
     * image the method don't do nothing.
     * 
     * @param imageView
     *            is the ImageView
     * @param pane
     *            is the StackPane
     */
    public final void removeTheImage(final ImageView imageView, final StackPane pane) {
        if (imageView.getImage() != null) {
            imageView.setImage(null);
            pane.setStyle("-fx-background-color: #333333; -fx-border-color: #8A8A8A; -fx-border-radius: 4.0;"
                    + " -fx-background-radius: 4px;");
            pane.setPrefHeight(PREFSIZE_IMG);
            pane.setPrefWidth(PREFSIZE_IMG);
        }
    }

    /**
     * 
     * 
     * @param e
     *            the event
     */
    /**
     * The event of when you drop an image on the StackPane.
     * 
     * @param e
     *            the event
     * @param imageView
     *            the ImageView
     * @param pane
     *            the StackPane
     */
    private void mouseDragDropped(final DragEvent e, final ImageView imageView, final StackPane pane) {
        final Dragboard db = e.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;
            // Only get the first file from the list
            imgFile = db.getFiles().get(0);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    System.out.println(imgFile.getAbsolutePath());
                    try {
                        if (!pane.getChildren().isEmpty()) {
                            pane.getChildren().remove(0);
                        }

                        imgItem = new Image(new FileInputStream(imgFile.getAbsolutePath()));
                        addImage(imgItem, imageView, pane);
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
    private void mouseDragOver(final DragEvent e, final StackPane pane) {
        final Dragboard db = e.getDragboard();

        final boolean isAccepted = db.getFiles().get(0).getName().toLowerCase(Locale.US).endsWith(".png")
                || db.getFiles().get(0).getName().toLowerCase(Locale.US).endsWith(".jpeg")
                || db.getFiles().get(0).getName().toLowerCase(Locale.US).endsWith(".jpg");

        if (db.hasFiles()) {
            if (isAccepted) {
                pane.setStyle("-fx-border-color: white;" + "-fx-border-width: 5;" + "-fx-background-color: grey;");
                e.acceptTransferModes(TransferMode.COPY);
            }
        } else {
            e.consume();
        }
    }
}
