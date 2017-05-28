package view.general;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;

import controller.Controller;
import javafx.scene.Scene;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.enumerations.Category;
import model.interfaces.Dress;
import model.interfaces.Outfits;
import view.ScreensGraphic;
import view.UI;

/**
 * 
 * Class that permit to launch a dialog preview of item and outfit.
 *
 */
public class DialogPreviewIO {
    private static final String ADD_TITLE_INFO_STYLE = "add-title-info";
    private static final String ADD_CONT_TITLE_INFO_STYLE = "add-cont-title-info";
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
    private static final int HEIGHT_DIALOG = 400;
    private static final int WIDTH_DIALOG = 660;

    private final GeneralObjectFx genObjFx;

    /**
     * Initialize the class.
     */
    public DialogPreviewIO() {
        genObjFx = new GeneralObjectFx();
    }

    /**
     * Launch a dialog preview of item.
     * 
     * @param owner
     *            the parent DialogPane
     * @param dress
     *            that we wont to see
     * @param controller
     *            that permit to modify and delete the item
     * @param ui
     *            of the specific graphic that permit to refresh the screen when
     *            you do a update or delete
     */
    public void createDialogDress(final Window owner, final Dress dress, final Controller controller, final UI ui) {
        final File[] imgFile = { dress.getImage() };
        final Image[] imgItem = new Image[1];
        final ImageView imvItem;
        final StackPane imageStackPnl;
        final ChoiceBox<Category> chbCategory;
        final TextField txfName;
        final TextField txfBrand;
        final TextField txfSize;
        final TextField txfPrice;
        final DatePicker dtpDate;
        final CheckBox ckbFavorite;
        final TextArea txaInfo;

        final URL url1 = this.getClass().getResource("../mainStyle.css");
        final URL url2 = this.getClass().getResource("../add/Add.css");
        final String css1 = url1.toExternalForm();
        final String css2 = url2.toExternalForm();
        final Stage dialog = new Stage();
        final ScrollPane scrollPnlDialog;
        final StackPane stkVbox;
        final VBox dialogVbox;
        final List<String> brandsName;
        final int nBrand;
        final Scene dialogScene;
        final String dressName = dress.getName().equals("") ? "No name" : dress.getName();

        dialog.setMinWidth(WIDTH_DIALOG);
        dialog.setMinHeight(HEIGHT_DIALOG);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(owner);
        dialog.setTitle(dressName);

        scrollPnlDialog = new ScrollPane();
        scrollPnlDialog.getStyleClass().add("srp-padding-left");
        stkVbox = new StackPane();
        VBox.setVgrow(scrollPnlDialog, Priority.ALWAYS);
        scrollPnlDialog.setFitToWidth(true);

        dialogVbox = new VBox();
        stkVbox.getStyleClass().add("main-pane-user");
        stkVbox.getStyleClass().add("pane-user");

        /* Title_______________ */
        final Text titlePane = new Text(dressName);
        final StackPane titleStackPnl = new StackPane();
        titlePane.getStyleClass().add("main-title");
        titleStackPnl.getChildren().add(titlePane);
        dialogVbox.getChildren().add(titleStackPnl);
        /* ____________________ */

        /* Description_________ */
        final Label lblDescr = new Label("You've dressed that item " + dress.getWornCount() + " times");
        final StackPane stkDescription = new StackPane();
        lblDescr.getStyleClass().add("text-description");
        lblDescr.setWrapText(true);
        lblDescr.setTextAlignment(TextAlignment.JUSTIFY);
        stkDescription.getChildren().add(lblDescr);
        dialogVbox.getChildren().add(stkDescription);
        /* ____________________ */

        /* Separator___________ */
        final Separator sepTitle = new Separator();
        sepTitle.getStyleClass().add("sep-title");
        dialogVbox.getChildren().add(sepTitle);
        /* ____________________ */

        /* Category_______________ */
        final Text txtCategory = new Text("Category");
        chbCategory = new ChoiceBox<Category>();
        final StackPane pnlCategoryTitle = new StackPane();
        final StackPane pnlCategoryChb = new StackPane();
        txtCategory.getStyleClass().add(ADD_TITLE_INFO_STYLE);
        pnlCategoryTitle.getStyleClass().add("add-cont-title-info-first");
        chbCategory.getStyleClass().add("chb-category");
        chbCategory.getItems().setAll(Category.values());
        chbCategory.setValue(dress.getCategoryName());
        pnlCategoryTitle.getChildren().add(txtCategory);
        pnlCategoryChb.getChildren().add(chbCategory);

        dialogVbox.getChildren().add(pnlCategoryTitle);
        dialogVbox.getChildren().add(pnlCategoryChb);
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
        txtImage.getStyleClass().add(ADD_TITLE_INFO_STYLE);
        pnlImageTitle.getStyleClass().add(ADD_CONT_TITLE_INFO_STYLE);
        pnlImage.getStyleClass().add("pnl-cont-image");
        pnlImageTitle.getChildren().add(txtImage);
        pnlImage.getChildren().add(imageStackPnl);
        pnlButtonRemoveImage.getChildren().add(btnRemoveImage);

        try {
            imgItem[0] = new Image(new FileInputStream(imgFile[0].getAbsolutePath()));
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        addImage(imgItem[0], imvItem, imageStackPnl);

        btnRemoveImage.setOnAction((event) -> {
            removeTheImage(imvItem, imageStackPnl);
        });

        imageStackPnl.setOnDragOver(e -> {
            genObjFx.mouseDragOver(e, imageStackPnl);
        });

        imageStackPnl.setOnDragDropped(e -> {
            genObjFx.mouseDragDropped(e, imgFile, imgItem, imvItem, imageStackPnl);
            addImage(imgItem[0], imvItem, imageStackPnl);
        });

        imageStackPnl.setOnDragExited(e -> {
            imageStackPnl.setStyle("-fx-border-color: #C6C6C6;");
        });
        /* ____________________ */

        /* Name_______________ */
        final Text txtName = new Text("Name");
        txfName = new TextField(dressName);
        final StackPane pnlNameTitle = new StackPane();
        final StackPane pnlNameTxf = new StackPane();
        txtName.getStyleClass().add(ADD_TITLE_INFO_STYLE);
        pnlNameTitle.getStyleClass().add(ADD_CONT_TITLE_INFO_STYLE);
        txfName.getStyleClass().add("text-field-add");
        txfName.setMaxWidth(PREFSIZE_TEXT);
        pnlNameTitle.getChildren().add(txtName);
        pnlNameTxf.getChildren().add(txfName);
        /* ____________________ */

        /* Brand_______________ */
        final Text txtBrand = new Text("Brand");
        txfBrand = new TextField(dress.getBrand());
        final StackPane pnlBrandTitle = new StackPane();
        final StackPane pnlBrandTxf = new StackPane();
        txtBrand.getStyleClass().add(ADD_TITLE_INFO_STYLE);
        pnlBrandTitle.getStyleClass().add(ADD_CONT_TITLE_INFO_STYLE);

        txfBrand.getStyleClass().add("text-field-add");
        txfBrand.setMaxWidth(PREFSIZE_TEXT);

        pnlBrandTitle.getChildren().add(txtBrand);
        pnlBrandTxf.getChildren().add(txfBrand);
        /* ____________________ */

        /* Size_______________ */
        int size = dress.getSize();
        String sizeString = size == -1 ? "" : "" + size;
        final Text txtSize = new Text("Size");
        txfSize = new TextField(sizeString);
        final StackPane pnlSizeTitle = new StackPane();
        final StackPane pnlSizeTxf = new StackPane();
        txtSize.getStyleClass().add(ADD_TITLE_INFO_STYLE);
        pnlSizeTitle.getStyleClass().add(ADD_CONT_TITLE_INFO_STYLE);
        txfSize.getStyleClass().add("text-field-add");
        txfSize.setMaxWidth(PREFSIZE_TEXT);
        pnlSizeTitle.getChildren().add(txtSize);
        pnlSizeTxf.getChildren().add(txfSize);
        /* ____________________ */

        /* Price_______________ */
        final double price = dress.getPrice();
        final String priceString = price == -1.0 ? "" : "" + price;
        final Text txtPrice = new Text("Price");
        txfPrice = new TextField(priceString);
        final StackPane pnlPriceTitle = new StackPane();
        final StackPane pnlPriceTxf = new StackPane();
        txtPrice.getStyleClass().add(ADD_TITLE_INFO_STYLE);
        pnlPriceTitle.getStyleClass().add(ADD_CONT_TITLE_INFO_STYLE);
        txfPrice.getStyleClass().add("text-field-add");
        txfPrice.setMaxWidth(PREFSIZE_TEXT);
        pnlPriceTitle.getChildren().add(txtPrice);
        pnlPriceTxf.getChildren().add(txfPrice);
        /* ____________________ */

        /* Date_______________ */
        final Text txtDate = new Text("Purchase date");
        dtpDate = new DatePicker(dress.getPurchaseDate());
        final StackPane pnlDateTitle = new StackPane();
        final StackPane pnlDateTxf = new StackPane();
        txtDate.getStyleClass().add(ADD_TITLE_INFO_STYLE);
        pnlDateTitle.getStyleClass().add(ADD_CONT_TITLE_INFO_STYLE);
        dtpDate.getStyleClass().add("date-picker");
        pnlDateTitle.getChildren().add(txtDate);
        pnlDateTxf.getChildren().add(dtpDate);
        /* ____________________ */

        /* Favorite_______________ */
        final Text txtFavorite = new Text("Set like favorite");
        ckbFavorite = new CheckBox();
        final StackPane pnlFavoriteTitle = new StackPane();
        final StackPane pnlFavoriteCkb = new StackPane();
        txtFavorite.getStyleClass().add(ADD_TITLE_INFO_STYLE);
        pnlFavoriteTitle.getStyleClass().add(ADD_CONT_TITLE_INFO_STYLE);
        ckbFavorite.getStyleClass().add("check-box");
        pnlFavoriteTitle.getChildren().add(txtFavorite);
        pnlFavoriteCkb.getChildren().add(ckbFavorite);
        ckbFavorite.setSelected(dress.getFavourited());
        /* ____________________ */

        /* Some information_______________ */
        final Text txtInfo = new Text("Information");
        txaInfo = new TextArea(dress.getDescription());
        final StackPane pnlInfoTitle = new StackPane();
        final StackPane pnlInfoTxa = new StackPane();
        txtInfo.getStyleClass().add(ADD_TITLE_INFO_STYLE);
        pnlInfoTitle.getStyleClass().add(ADD_CONT_TITLE_INFO_STYLE);
        txaInfo.getStyleClass().add("text-field-add-info");
        pnlInfoTitle.getChildren().add(txtInfo);
        pnlInfoTxa.getChildren().add(txaInfo);
        /* ____________________ */

        /* Update _____________ */
        final Button btnUpdate = new Button("Update");
        final StackPane stkUpdate = new StackPane();
        stkUpdate.getStyleClass().add("pnl-other-add");
        genObjFx.setStandarBtnStkP(btnUpdate, stkUpdate);
        btnUpdate.setOnAction((event) -> {
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
                if (!txfSize.getText().equals("") && !genObjFx.isInteger(txfSize.getText())) {
                    messageNumericField += "are allow only numeric character in the field size";
                } else if (!txfPrice.getText().equals("") && !genObjFx.isDouble(txfPrice.getText())) {
                    messageNumericField += "are allow only numeric character in the field price";
                } else if (!txfSize.getText().equals("") && Integer.parseInt(txfSize.getText()) < 0) {
                    messageNumericField += "are allow only positive character in the fild Size";
                } else if (!txfPrice.getText().equals("") && Double.parseDouble(txfPrice.getText()) < 0) {
                    messageNumericField += "are allow only positive character in the fild Price";
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

                final Integer newSize = txfSize.getText().equals("") ? -1 : Integer.valueOf(txfSize.getText());
                Double newPrice = txfPrice.getText().equals("") ? -1 : Double.parseDouble(txfPrice.getText());

                controller.dress().modifyDressCategory(dress, chbCategory.getValue());
                controller.dress().modifyDressBrand(dress, txfBrand.getText());
                controller.dress().modifyDressDescription(dress, txaInfo.getText());
                controller.dress().modifyDressName(dress, txfName.getText());
                controller.dress().modifyDressPurchaseDate(dress, dtpDate.getValue());
                controller.dress().modifyDressSize(dress, newSize);
                controller.dress().modifyDressPrice(dress, newPrice);
                controller.dress().modifyFavoriteTag(dress, ckbFavorite.isSelected());
                alertOk.showAndWait();
                dialog.close();
                ui.showNowContent();
            }
        });
        /* _____________________ */

        /* Button Delate_________ */
        final Button btnDelate = new Button("Delate");
        final StackPane stkDelate = new StackPane();
        stkDelate.getStyleClass().add("pnl-other-add");
        genObjFx.setLittleMarginBtnStkP(btnDelate, stkDelate);
        btnDelate.setOnAction(event -> {
            controller.dress().deleteDress(dress);
            dialog.close();
            ui.showNowContent();
        });
        /* _____________________ */

        /* Button Cancel_______________ */
        final Button btnCancel = new Button("Cancel");
        final StackPane stkCancel = new StackPane();
        stkCancel.getStyleClass().add("pnl-other-add");
        genObjFx.setLittleMarginBtnStkP(btnCancel, stkCancel);
        btnCancel.setOnAction(event -> {
            dialog.close();
        });
        /* _____________________ */

        dialogVbox.getChildren().add(pnlImageTitle);
        dialogVbox.getChildren().add(pnlImage);
        dialogVbox.getChildren().add(pnlButtonRemoveImage);
        dialogVbox.getChildren().add(pnlNameTitle);
        dialogVbox.getChildren().add(pnlNameTxf);
        dialogVbox.getChildren().add(pnlBrandTitle);
        dialogVbox.getChildren().add(pnlBrandTxf);
        dialogVbox.getChildren().add(pnlSizeTitle);
        dialogVbox.getChildren().add(pnlSizeTxf);
        dialogVbox.getChildren().add(pnlPriceTitle);
        dialogVbox.getChildren().add(pnlPriceTxf);
        dialogVbox.getChildren().add(pnlDateTitle);
        dialogVbox.getChildren().add(pnlDateTxf);
        dialogVbox.getChildren().add(pnlFavoriteTitle);
        dialogVbox.getChildren().add(pnlFavoriteCkb);
        dialogVbox.getChildren().add(pnlInfoTitle);
        dialogVbox.getChildren().add(pnlInfoTxa);
        dialogVbox.getChildren().add(stkUpdate);
        dialogVbox.getChildren().add(stkDelate);
        dialogVbox.getChildren().add(stkCancel);
        /* ___________________________________________ */
        VBox.setVgrow(scrollPnlDialog, Priority.ALWAYS);
        /* ___________________________________________ */
        scrollPnlDialog.setFitToWidth(true);
        // scrollPnl.setFitToHeight(true);
        scrollPnlDialog.setContent(dialogVbox);

        scrollPnlDialog.setContent(dialogVbox);
        stkVbox.getChildren().add(scrollPnlDialog);

        dialogScene = new Scene(stkVbox, WIDTH_DIALOG, HEIGHT_DIALOG);
        dialogScene.getStylesheets().add(css1);
        dialogScene.getStylesheets().add(css2);
        dialog.setScene(dialogScene);

        dialog.show();

    }

    /**
     * Launch a dialog preview of item.
     * 
     * @param owner
     *            the parent DialogPane
     * @param outfit
     *            that we wont to see
     * @param controller
     *            that permit to modify and delete the item
     * @param ui
     *            of the specific graphic that permit to refresh the screen when
     *            you do a update or delete
     */
    public void createDialogOutfit(final Window owner, final Outfits outfit, final Controller controller, final UI ui) {
        Category[] allCat = Category.values();

        final URL url1 = this.getClass().getResource("../mainStyle.css");
        final URL url2 = this.getClass().getResource("../add/Add.css");
        final String css1 = url1.toExternalForm();
        final String css2 = url2.toExternalForm();
        final Stage dialog = new Stage();
        final ScrollPane scrollPnlDialog;
        final StackPane stkVbox;
        final VBox dialogVbox;
        final List<String> brandsName;
        final int nBrand;
        final Scene dialogScene;
        final String dressName = outfit.getName().equals("") ? "No name" : outfit.getName();

        dialog.setMinWidth(WIDTH_DIALOG);
        dialog.setMinHeight(HEIGHT_DIALOG);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(owner);
        dialog.setTitle(dressName);

        scrollPnlDialog = new ScrollPane();
        scrollPnlDialog.getStyleClass().add("srp-padding-left");
        stkVbox = new StackPane();
        VBox.setVgrow(scrollPnlDialog, Priority.ALWAYS);
        scrollPnlDialog.setFitToWidth(true);

        dialogVbox = new VBox();
        stkVbox.getStyleClass().add("main-pane-user");
        stkVbox.getStyleClass().add("pane-user");

        VBox.setVgrow(scrollPnlDialog, Priority.ALWAYS);
        /* ___________________________________________ */
        scrollPnlDialog.setFitToWidth(true);
        // scrollPnl.setFitToHeight(true);
        scrollPnlDialog.setContent(dialogVbox);

        scrollPnlDialog.setContent(dialogVbox);
        stkVbox.getChildren().add(scrollPnlDialog);

        dialogScene = new Scene(stkVbox, WIDTH_DIALOG, HEIGHT_DIALOG);
        dialogScene.getStylesheets().add(css1);
        dialogScene.getStylesheets().add(css2);
        dialog.setScene(dialogScene);

        /* Title_______________ */
        final Text titlePane = new Text(dressName);
        final StackPane titleStackPnl = new StackPane();
        titlePane.getStyleClass().add("main-title");
        titleStackPnl.getChildren().add(titlePane);
        dialogVbox.getChildren().add(titleStackPnl);
        /* ____________________ */

        /* Separator___________ */
        final Separator sepTitle = new Separator();
        sepTitle.getStyleClass().add("sep-title");
        dialogVbox.getChildren().add(sepTitle);
        /* ____________________ */

        /* Name_______________ */
        final TextField txfName = new TextField();
        genObjFx.addTextFieldToVBox("Name", txfName, dialogVbox);
        /* ____________________ */

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
            lblCat = new Label(nameCat);
            gridCat = new GridPane();
            genObjFx.setBorderPaneExposition(false, brpCat, skpNameCat, lblCat, gridCat);

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
                // createDialogSelectItem(Category.valueOf(allCat[indexCat].name()));
            });

            dialogVbox.getChildren().add(brpCat);
        }

        /* Update _____________ */
        final Button btnUpdate = new Button("Update");
        final StackPane stkUpdate = new StackPane();
        stkUpdate.getStyleClass().add("pnl-other-add");
        genObjFx.setStandarBtnStkP(btnUpdate, stkUpdate);
        dialogVbox.getChildren().add(stkUpdate);
        btnUpdate.setOnAction((event) -> {

        });
 
        /* Button Delate_________ */
        final Button btnDelate = new Button("Delate");
        final StackPane stkDelate = new StackPane();
        stkDelate.getStyleClass().add("pnl-other-add");
        genObjFx.setLittleMarginBtnStkP(btnDelate, stkDelate);
        dialogVbox.getChildren().add(stkDelate);
        btnDelate.setOnAction(event -> {

            dialog.close();
            ui.showNowContent();
        });
        /* _____________________ */

        /* Button Cancel_______________ */
        final Button btnCancel = new Button("Cancel");
        final StackPane stkCancel = new StackPane();
        stkCancel.getStyleClass().add("pnl-other-add");
        genObjFx.setLittleMarginBtnStkP(btnCancel, stkCancel);
        dialogVbox.getChildren().add(stkCancel);
        btnCancel.setOnAction(event -> {
            dialog.close();
        });
        /* _____________________ */

        dialog.show();
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

}
