package view.general;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.DoubleStream;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.enumerations.Category;
import model.interfaces.Dress;
import model.interfaces.Outfits;
import view.ScreensGraphic;

public class GeneralObjectFx {
    private static final int RANDOM_NUM = 444;
    private static final String BTN_SMALL = "btn-small";
    private static final String BTN_NORMAL = "btn-normal";
    private static final String ADD_TITLE_INFO_STYLE = "add-title-info";
    private static final String ADD_CONT_TITLE_INFO_STYLE = "add-cont-title-info";
    private static final int LEFTRIGHT = 10;
    private static final int UPDOWN = 15;
    private static final int UPDOWN_LITTLE = 5;
    private static final int UPDOWN_BIG = 25;
    private static final int PERCENT_WIDTH_GRID = 33;
    private static final int WIDTH_IMAGE = 150;
    private static final int HEIGHT_IMAGE = 200;
    private static final int WIDTH_IMAGE_S = 100;
    private static final int HEIGHT_IMAGE_S = 150;
    private static final int SHADOW_HEIGHT = 20;
    private static final int PREFSIZE_TEXT = 235;
    private static final Insets STANDARD_INSET = new Insets(UPDOWN, LEFTRIGHT, UPDOWN, LEFTRIGHT);
    private static final Insets LITTLE_INSET = new Insets(UPDOWN_LITTLE, LEFTRIGHT, UPDOWN_LITTLE, LEFTRIGHT);
    private static final Insets NOUP_INSET = new Insets(0, LEFTRIGHT, UPDOWN, LEFTRIGHT);
    private static final Insets NODOWN_INSET = new Insets(UPDOWN, LEFTRIGHT, 0, LEFTRIGHT);
    private static final Insets HOME_INSET = new Insets(0, 0, 0, 0);
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.NEW_OUTFITS;

    public void setStandarBtnStkP(Button btn, StackPane stkP) {
        btn.getStyleClass().add(BTN_NORMAL);
        stkP.getChildren().add(btn);
        GridPane.setMargin(stkP, STANDARD_INSET);
    }

    public void setLittleMarginBtnStkP(Button btn, StackPane stkP) {
        btn.getStyleClass().add(BTN_NORMAL);
        stkP.getChildren().add(btn);
        GridPane.setMargin(stkP, LITTLE_INSET);
    }

    public void setSmallBtnStkP(Button btn, StackPane stkP) {
        btn.getStyleClass().add(BTN_NORMAL);
        btn.getStyleClass().add(BTN_SMALL);
        stkP.getChildren().add(btn);
        GridPane.setMargin(stkP, STANDARD_INSET);
    }

    public void setStandardLblStkP(final Label lbl, final StackPane stkP) {
        lbl.getStyleClass().add("text-info-item");
        stkP.getChildren().add(lbl);
    }

    public ChoiceBox<Category> setChoiseBoxCategory(final Text txtName, final StackPane stpTitle,
            final StackPane stpChoiseBox) {
        final Category[] allCategory = Category.values();
        ChoiceBox<Category> chBox = new ChoiceBox<>();
        txtName.getStyleClass().add(ADD_TITLE_INFO_STYLE);
        stpTitle.getStyleClass().add("add-cont-title-info-first");
        chBox.getStyleClass().add("chb-category");

        chBox.getItems().setAll(allCategory);
        chBox.getItems().remove(allCategory.length - 1);
        stpTitle.getChildren().add(txtName);
        stpChoiseBox.getChildren().add(chBox);
        return chBox;
    }

    public ChoiceBox<Category> setChoiseBoxCategoryBanner(final Text txtName, VBox vBox) {
        final Category[] allCategory = Category.values();
        final StackPane stpTitle = new StackPane();
        final StackPane stpChoiseBox = new StackPane();
        ChoiceBox<Category> chBox = new ChoiceBox<>();

        txtName.getStyleClass().add("add-title-info");
        stpTitle.getStyleClass().add("add-cont-title-info");
        stpChoiseBox.getStyleClass().add("pnl-category-chb");
        chBox.getStyleClass().add("chb-category");
        vBox.getStyleClass().add("vbox-select-cat");

        chBox.getItems().setAll(allCategory);
        chBox.getItems().remove(allCategory.length - 1);

        stpTitle.getChildren().add(txtName);
        stpChoiseBox.getChildren().add(chBox);
        vBox.getChildren().add(stpTitle);
        vBox.getChildren().add(stpChoiseBox);

        return chBox;
    }

    public void setItemOfOutfit(Dress dress, Button btn, GridPane gdpCat) {
        /* BUTTON Remove item */
        final StackPane skpBtn = new StackPane();
        setSmallBtnStkP(btn, skpBtn);

        /* LABEL Name of item */
        final Label lblNameItem = new Label(dress.getName());
        final StackPane skpName = new StackPane();
        setStandardLblStkP(lblNameItem, skpName);

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
        imageView.setFitWidth(WIDTH_IMAGE);
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
        gdpCat.add(skpBtn, 0, 0);
        gdpCat.add(skpName, 1, 0);
        gdpCat.add(stpImageView, 2, 0);
    }

    public void setBorderPaneExposition(boolean noLRMargin, BorderPane brpExpo, StackPane skpNameExpo, Label lblExpo,
            GridPane gridExpo) {

        brpExpo.getStyleClass().add("pnl-show-item");
        skpNameExpo.getStyleClass().add("pnl-show-item-title");
        lblExpo.getStyleClass().add("text-title-show-item");
        gridExpo.getStyleClass().add("pnl-show-item-dress");

        if (noLRMargin) {
            VBox.setMargin(brpExpo, HOME_INSET);
        } else {
            VBox.setMargin(brpExpo, STANDARD_INSET);
        }

        /* Grid________________ */
        gridExpo.getColumnConstraints()
                .addAll(DoubleStream.of(PERCENT_WIDTH_GRID, PERCENT_WIDTH_GRID, PERCENT_WIDTH_GRID).mapToObj(width -> {
                    ColumnConstraints constraints = new ColumnConstraints();
                    constraints.setPercentWidth(width);
                    constraints.setFillWidth(true);
                    return constraints;
                }).toArray(ColumnConstraints[]::new));

        final RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setVgrow(Priority.ALWAYS);
        gridExpo.getRowConstraints().add(rowConstraints);

        skpNameExpo.getChildren().add(lblExpo);
        brpExpo.setTop(skpNameExpo);
        brpExpo.setCenter(gridExpo);
    }

    public void setItemInsideGrid(boolean smallImage, final int count, final Dress dress, final Button btnAction,
            final GridPane gridExpo) {
        final int rowIndex = count % 3;
        final int columnIndex = count == 0 ? 0 : count / 3;
        final BorderPane brpIthem = new BorderPane();
        String dressName = dress.getName().equals("") ? "No name" : dress.getName();

        brpIthem.getStyleClass().add("pnl-specific-item");

        /* Name TOP__________________ */
        final StackPane stpName = new StackPane();
        final Label lblName = new Label(dressName);
        lblName.getStyleClass().add("text-title-show-item");
        stpName.getChildren().add(lblName);
        StackPane.setMargin(lblName, NODOWN_INSET);
        brpIthem.setTop(stpName);

        /* Image CENTER__________________ */
        final File imgFile = dress.getImage();
        Image img;
        final ImageView imageView = new ImageView();
        final StackPane stpImageView = new StackPane();

        BorderPane.setMargin(stpImageView, STANDARD_INSET);
        imageView.getStyleClass().add("image-item");

        try {
            img = new Image(new FileInputStream(imgFile.getAbsolutePath()));
            imageView.setImage(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (smallImage) {
            imageView.setFitHeight(HEIGHT_IMAGE_S);
            imageView.setFitWidth(WIDTH_IMAGE_S);
        } else {
            imageView.setFitHeight(HEIGHT_IMAGE);
            imageView.setFitWidth(WIDTH_IMAGE);
        }
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
        brpIthem.setCenter(stpImageView);

        /* Button see BUTTOM________________ */
        final StackPane stpBtnAction = new StackPane();
        btnAction.getStyleClass().add(BTN_NORMAL);
        btnAction.getStyleClass().add(BTN_SMALL);
        stpBtnAction.getChildren().add(btnAction);
        brpIthem.setBottom(stpBtnAction);

        StackPane.setMargin(btnAction, NOUP_INSET);

        GridPane.setMargin(brpIthem, STANDARD_INSET);

        gridExpo.add(brpIthem, rowIndex, columnIndex);

    }

    public void addTextFieldToVBox(final String name, final TextField txf, final VBox vBox) {
        final Text txtName = new Text(name);
        final StackPane pnlNameTitle = new StackPane();
        final StackPane pnlNameTxf = new StackPane();
        txtName.getStyleClass().add("add-title-info");
        pnlNameTitle.getStyleClass().add("add-cont-title-info");
        txf.getStyleClass().add("text-field-add");
        txf.setMaxWidth(PREFSIZE_TEXT);
        pnlNameTitle.getChildren().add(txtName);
        pnlNameTxf.getChildren().add(txf);

        vBox.getChildren().add(pnlNameTitle);
        vBox.getChildren().add(pnlNameTxf);

    }

    public void setOutfitInsideGrid(final int count, final Outfits outfit, final List<Dress> outfitDress,
            final Button btnAction, final GridPane gridExpo) {
        final int rowIndex = count % 3;
        final int columnIndex = count == 0 ? 0 : count / 3;
        final BorderPane brpIthem = new BorderPane();

        brpIthem.getStyleClass().add("pnl-specific-item");

        /* Name TOP__________________ */
        final StackPane stpName = new StackPane();
        final Label lblName = new Label(outfit.getName());
        lblName.getStyleClass().add("text-title-show-item");
        stpName.getChildren().add(lblName);
        StackPane.setMargin(lblName, NODOWN_INSET);
        brpIthem.setTop(stpName);

        /* Image CENTER__________________ */

        final Random rand = new Random();

        final File imgFile = outfitDress.get(rand.nextInt(outfitDress.size())).getImage();
        Image img;
        final ImageView imageView = new ImageView();
        final StackPane stpImageView = new StackPane();

        BorderPane.setMargin(stpImageView, STANDARD_INSET);
        imageView.getStyleClass().add("image-item");

        try {
            img = new Image(new FileInputStream(imgFile.getAbsolutePath()));
            imageView.setImage(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        imageView.setFitHeight(HEIGHT_IMAGE);
        imageView.setFitWidth(WIDTH_IMAGE);
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
        brpIthem.setCenter(stpImageView);

        /* Button see BUTTOM________________ */
        final StackPane stpBtnAction = new StackPane();
        btnAction.getStyleClass().add(BTN_NORMAL);
        btnAction.getStyleClass().add(BTN_SMALL);
        stpBtnAction.getChildren().add(btnAction);
        brpIthem.setBottom(stpBtnAction);

        StackPane.setMargin(btnAction, NOUP_INSET);

        GridPane.setMargin(brpIthem, STANDARD_INSET);

        gridExpo.add(brpIthem, rowIndex, columnIndex);

    }

    public Insets getStandardInset() {
        return STANDARD_INSET;
    }

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
    public void mouseDragDropped(final DragEvent e, File imgFile[], Image imgItem[], final ImageView imageView,
            final StackPane pane) {
        final Dragboard db = e.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;
            // Only get the first file from the list
            imgFile[0] = db.getFiles().get(0);
            try {
                imgItem[0] = new Image(new FileInputStream(imgFile[0].getAbsolutePath()));
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            /*
             * Platform.runLater(new Runnable() {
             * 
             * @Override public void run() { try { if
             * (!pane.getChildren().isEmpty()) { pane.getChildren().remove(0); }
             * 
             * imgItem[0] = new Image(new
             * FileInputStream(imgFile[0].getAbsolutePath()));
             * //addImage(imgItem, imageView, pane); } catch
             * (FileNotFoundException ex) { ex.printStackTrace(); } } });
             */
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
    public void mouseDragOver(final DragEvent e, final StackPane pane) {
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

    /**
     * Check if the string is an Integer.
     * 
     * @param str
     *            the value
     * @return TRUE if is a Integer and False if not
     */
    public boolean isInteger(final String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Check if the string is a Double.
     * 
     * @param str
     *            the value
     * @return TRUE if is a Double and False if not
     */
    public boolean isDouble(final String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
