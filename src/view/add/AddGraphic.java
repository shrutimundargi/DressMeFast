package view.add;

import java.io.File;
import java.util.Set;

import org.controlsfx.control.textfield.TextFields;

import controller.Controller;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import model.enumerations.Category;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;
import view.UI;
import view.general.GeneralObjectFx;
import view.general.ProgramUIImpl;

/**
 * 
 * Screen that permit to add an item (dress).
 *
 */
public class AddGraphic extends ProgramUIImpl implements UI {
    private static final String ADD_TITLE_INFO_STYLE = "add-title-info";
    private static final String ADD_CONT_TITLE_INFO_STYLE = "add-cont-title-info";
    private static final String REMEMBER = "Remember, ";
    private static final String OPSSS = "Opsss, ";
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.ADD;
    private static final String NAMEOFSCREEN = "Add Item";
    private static final String DESCRIPTIONOFPANE = "This page permits to add an item in your wardrobe,"
            + " it's very easy, you just need to choose the specific category of the item,"
            + " add a photo and then fill all the information about it.";

    private static final int PREFSIZE_IMG = 200;
    private static final int PREFSIZE_IMG_OFIMAGE = 235;
    private static final int PREFSIZE_TEXT = 235;

    @FXML
    private ScrollPane scrollPnl;

    private final Image[] imgItem;
    private final File[] imgFile;
    private final ImageView imvItem;
    private final StackPane imageStackPnl;
    private final ChoiceBox<Category> chbCategory;
    private final TextField txfName;
    private final TextField txfBrand;
    private final TextField txfSize;
    private final TextField txfPrice;
    private final DatePicker dtpDate;
    private final TextArea txaInfo;

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
    public AddGraphic(final SceneSetting environment, final Controller controller, final SetupView setup) {
        super(environment, controller, setup, ACTUALSCREEN);
        this.getSceneSetting().loadScreen(ACTUALSCREEN, this);
        super.getBtnAdd().setStyle("-fx-background-image: url('/images/add.png');");

        genObjFx = new GeneralObjectFx();
        imgFile = new File[1];
        imgItem = new Image[1];
        /* Container (PANE) */
        final VBox vBox = new VBox();

        /* Title_______________ */
        final Text titlePane = new Text(NAMEOFSCREEN);
        final StackPane titleStackPnl = new StackPane();
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
        final Text txtChoiseBox = new Text("Select the category");
        final StackPane pnlCategoryTitle = new StackPane();
        final StackPane pnlCategoryChb = new StackPane();
        chbCategory = genObjFx.setChoiseBoxCategory(txtChoiseBox, pnlCategoryTitle, pnlCategoryChb);
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

        btnRemoveImage.setOnAction((event) -> {
            removeTheImage(imvItem, imageStackPnl);
        });

        imageStackPnl.setOnDragOver(new EventHandler<DragEvent>() {

            public void handle(final DragEvent event) {
                genObjFx.mouseDragOver(event, imageStackPnl);
            }
        });

        imageStackPnl.setOnDragDropped(new EventHandler<DragEvent>() {

            public void handle(final DragEvent event) {
                genObjFx.mouseDragDropped(event, imgFile, imgItem, imvItem, imageStackPnl);
                addImage(imgItem[0], imvItem, imageStackPnl);
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

        txtName.getStyleClass().add(ADD_TITLE_INFO_STYLE);
        pnlNameTitle.getStyleClass().add(ADD_CONT_TITLE_INFO_STYLE);
        txfName.getStyleClass().add("text-field-add");
        txfName.setMaxWidth(PREFSIZE_TEXT);
        pnlNameTitle.getChildren().add(txtName);
        pnlNameTxf.getChildren().add(txfName);
        /* ____________________ */

        /* Brand_______________ */
        final Text txtBrand = new Text("Brand");
        txfBrand = new TextField();
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
        final Text txtSize = new Text("Size");
        txfSize = new TextField();
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
        final Text txtPrice = new Text("Price");
        txfPrice = new TextField();
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
        dtpDate = new DatePicker();
        final StackPane pnlDateTitle = new StackPane();
        final StackPane pnlDateTxf = new StackPane();
        txtDate.getStyleClass().add(ADD_TITLE_INFO_STYLE);
        pnlDateTitle.getStyleClass().add(ADD_CONT_TITLE_INFO_STYLE);
        dtpDate.getStyleClass().add("date-picker");
        pnlDateTitle.getChildren().add(txtDate);
        pnlDateTxf.getChildren().add(dtpDate);
        /* ____________________ */

        /* Some information_______________ */
        final Text txtInfo = new Text("Information");
        txaInfo = new TextArea();
        final StackPane pnlInfoTitle = new StackPane();
        final StackPane pnlInfoTxa = new StackPane();
        txtInfo.getStyleClass().add(ADD_TITLE_INFO_STYLE);
        pnlInfoTitle.getStyleClass().add(ADD_CONT_TITLE_INFO_STYLE);
        txaInfo.getStyleClass().add("text-field-add-info");
        pnlInfoTitle.getChildren().add(txtInfo);
        pnlInfoTxa.getChildren().add(txaInfo);
        /* ____________________ */

        /* Button_______________ */
        final Button btnAdd = new Button("Add Item");
        final StackPane stkAdd = new StackPane();
        genObjFx.setStandarBtnStkP(btnAdd, stkAdd);
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

            if (!messageNecessaryField.equals(OPSSS) && !messageNumericField.equals(REMEMBER)) {
                messageFinal = messageNecessaryField + " " + messageNumericField;
            } else if (!messageNecessaryField.equals(OPSSS) && messageNumericField.equals(REMEMBER)) {
                messageFinal = messageNecessaryField;
            } else if (messageNecessaryField.equals(OPSSS) && !messageNumericField.equals(REMEMBER)) {
                messageFinal = messageNumericField;
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
                final String name = txfName.getText().equals("") ? "No name" : txfName.getText();
                final String brand = txfBrand.getText().equals("") ? "Not set" : txfBrand.getText();
                final Integer size = txfSize.getText().equals("") ? -1 : Integer.valueOf(txfSize.getText());
                final Double price = txfPrice.getText().equals("") ? -1 : Double.parseDouble(txfPrice.getText());

                alertOk.setTitle("Information Dialog");
                alertOk.setHeaderText("Yea, you added your item");
                alertOk.setContentText("The item is add in the category " + chbCategory.getValue() + "!");

                super.getController().dress().addDress(name, brand, size, price,
                        dtpDate.getValue(), txaInfo.getText(), chbCategory.getValue(), imgFile[0]);

                this.resetAllComponent();
                this.autoComplete();
                returnTopPane();

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
        vBox.getChildren().add(pnlInfoTitle);
        vBox.getChildren().add(pnlInfoTxa);
        vBox.getChildren().add(stkAdd);
        /* ___________________________________________ */
        VBox.setVgrow(scrollPnl, javafx.scene.layout.Priority.ALWAYS);
        /* ___________________________________________ */
        scrollPnl.setFitToWidth(true);
        // scrollPnl.setFitToHeight(true);
        scrollPnl.setContent(vBox);
    }

    @Override
    public void showNowContent() {
        super.setupColorButtonsBH();
        this.resetAllComponent();
        this.autoComplete();
        super.returnTopPane();
    }

    @Override
    public final void resetAllComponent() {
        chbCategory.setValue(null);
        this.removeTheImage(imvItem, imageStackPnl);
        txfName.clear();
        txfBrand.clear();
        txfSize.clear();
        txfPrice.clear();
        dtpDate.setValue(null);
        txaInfo.clear();
    }

    /**
     * 
     */
    public final void autoComplete() {
        final Set<String> allBrand = super.getController().dress().getAllBrand();
        final String[] autoCoBrand = allBrand.stream().toArray(String[]::new);
        TextFields.bindAutoCompletion(txfBrand, autoCoBrand);
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
