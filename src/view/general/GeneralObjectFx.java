package view.general;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.DoubleStream;

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

/**
 * 
 * GeneralObjectFx give the possibility to call some most used rows of code.
 *
 */
public class GeneralObjectFx {
    private static final String BTN_SMALL = "btn-small";
    private static final String BTN_NORMAL = "btn-normal";
    private static final String ADD_TITLE_INFO_STYLE = "add-title-info";
    private static final int LEFTRIGHT = 10;
    private static final int UPDOWN = 15;
    private static final int UPDOWN_LITTLE = 5;
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

    /**
     * Method that set the standard CSS for the button and margin for the
     * StackPane.
     * 
     * @param btn
     *            the button that we wont to put in the StackPane
     * @param stkP
     *            the StackPane where it will be receive the button
     */
    public void setStandarBtnStkP(final Button btn, final StackPane stkP) {
        btn.getStyleClass().add(BTN_NORMAL);
        stkP.getChildren().add(btn);
        GridPane.setMargin(stkP, STANDARD_INSET);
    }

    /**
     * Method that set the standard button and a little margin for the
     * StackPane.
     * 
     * @param btn
     *            the button that we wont to put in the StackPane
     * @param stkP
     *            the StackPane where it will be receive the button
     */
    public void setLittleMarginBtnStkP(final Button btn, final StackPane stkP) {
        btn.getStyleClass().add(BTN_NORMAL);
        stkP.getChildren().add(btn);
        GridPane.setMargin(stkP, LITTLE_INSET);
    }

    /**
     * Method that set the small button and a little margin for the StackPane.
     * 
     * @param btn
     *            the button that we wont to put in the StackPane
     * @param stkP
     *            the StackPane where it will be receive the button
     */
    public void setSmallBtnStkP(final Button btn, final StackPane stkP) {
        btn.getStyleClass().add(BTN_NORMAL);
        btn.getStyleClass().add(BTN_SMALL);
        stkP.getChildren().add(btn);
        GridPane.setMargin(stkP, STANDARD_INSET);
    }

    /**
     * Method that set the standard button and a little margin for the
     * StackPane.
     * 
     * @param lbl
     *            the Label that we wont to put in the StackPane
     * @param stkP
     *            the StackPane where it will be receive the button
     */
    public void setStandardLblStkP(final Label lbl, final StackPane stkP) {
        lbl.getStyleClass().add("text-info-item");
        stkP.getChildren().add(lbl);
    }

    /**
     * Used in the addGraphic when you need to select a category for the items.
     * 
     * @param txtName
     *            the Text over the ChoiseBox
     * @param stpTitle
     *            the StackPane of the title
     * @param stpChoiseBox
     *            the StackPane for the ChoiceBoxs
     * @return the ChoiceBox that permit to manage in other way.
     */
    public ChoiceBox<Category> setChoiseBoxCategory(final Text txtName, final StackPane stpTitle,
            final StackPane stpChoiseBox) {
        final Category[] allCategory = Category.values();
        final ChoiceBox<Category> chBox = new ChoiceBox<>();
        txtName.getStyleClass().add(ADD_TITLE_INFO_STYLE);
        stpTitle.getStyleClass().add("add-cont-title-info-first");
        chBox.getStyleClass().add("chb-category");

        chBox.getItems().setAll(allCategory);
        chBox.getItems().remove(allCategory.length - 1);
        stpTitle.getChildren().add(txtName);
        stpChoiseBox.getChildren().add(chBox);
        return chBox;
    }

    /**
     * Used in the graphic when you need a select a category to show the items.
     * 
     * @param txtName
     *            the Text over the ChoiseBox
     * @param vBox
     *            for add the entire StackPane inside the @param
     * @return the ChoiceBox that permit to manage in other way.
     */
    public ChoiceBox<Category> setChoiseBoxCategoryBanner(final Text txtName, final VBox vBox) {
        final Category[] allCategory = Category.values();
        final StackPane stpTitle = new StackPane();
        final StackPane stpChoiseBox = new StackPane();
        final ChoiceBox<Category> chBox = new ChoiceBox<>();

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

    /**
     * Set the item of the outfit inside the GridPane.
     * 
     * @param dress
     *            that we wont to add
     * @param btn
     *            button for the action of the preview's outfit
     * @param gdpCat
     *            where we wont to put the dress
     */
    public void setItemOfOutfit(final Dress dress, final Button btn, final GridPane gdpCat) {
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

    /**
     * Set the BorderPane with the specific class of CSS and the right column.
     * 
     * @param noLRMargin
     *            if we wont the grid without the margin
     * @param brpExpo
     *            BorderPane of the exposition
     * @param skpNameExpo
     *            StackPane where the function set the Text inside its
     * @param lblExpo
     *            Text of the BordePane
     * @param gridExpo
     *            GridPane of the item
     */
    public void setBorderPaneExposition(final boolean noLRMargin, final BorderPane brpExpo, final StackPane skpNameExpo,
            final Label lblExpo, final GridPane gridExpo) {

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
                    final ColumnConstraints constraints = new ColumnConstraints();
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

    /**
     * Set item inside a grid.
     * 
     * @param smallImage
     *            if we wont to have a small image (ex. in the home).
     * @param count
     *            of the number of dress
     * @param dress
     *            the specific dress
     * @param btnAction
     *            button for the action of the preview's dress
     * @param gridExpo
     *            GridPane of the item
     */
    public void setItemInsideGrid(final boolean smallImage, final int count, final Dress dress, final Button btnAction,
            final GridPane gridExpo) {
        final int rowIndex = count % 3;
        final int columnIndex = count == 0 ? 0 : count / 3;
        final BorderPane brpItem = new BorderPane();
        final String dressName = dress.getName().equals("") ? "No name" : dress.getName();

        brpItem.getStyleClass().add("pnl-specific-item");

        /* Name TOP__________________ */
        final StackPane stpName = new StackPane();
        final Label lblName = new Label(dressName);
        lblName.getStyleClass().add("text-title-show-item");
        stpName.getChildren().add(lblName);
        StackPane.setMargin(lblName, NODOWN_INSET);
        brpItem.setTop(stpName);

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
        brpItem.setCenter(stpImageView);

        /* Button see BUTTOM________________ */
        final StackPane stpBtnAction = new StackPane();
        btnAction.getStyleClass().add(BTN_NORMAL);
        btnAction.getStyleClass().add(BTN_SMALL);
        stpBtnAction.getChildren().add(btnAction);
        brpItem.setBottom(stpBtnAction);

        StackPane.setMargin(btnAction, NOUP_INSET);

        GridPane.setMargin(brpItem, STANDARD_INSET);

        gridExpo.add(brpItem, rowIndex, columnIndex);

    }

    /**
     * Add a TextField to a VBox.
     * @param name of the field
     * @param txf the specific TextField
     * @param vBox the VBox where it will put the TextField
     */
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


    /**
     * Set outfit inside a grid.
     * 
     * @param count number of the item in the list of all outfit we wont to show 
     * @param outfit that we wont to show in the preview
     * @param outfitDresses List of all dresses of the outfit to permit to get a random image for the preview of the outfit
     * @param btnAction
     *            button for the action of the preview's outfit
     * @param gridExpo
     *            GridPane of the item
     */
    public void setOutfitInsideGrid(final int count, final Outfits outfit, final List<Dress> outfitDresses,
            final Button btnAction, final GridPane gridExpo) {
        final int rowIndex = count % 3;
        final int columnIndex = count == 0 ? 0 : count / 3;
        final BorderPane brpItem = new BorderPane();

        brpItem.getStyleClass().add("pnl-specific-item");

        /* Name TOP__________________ */
        final StackPane stpName = new StackPane();
        final Label lblName = new Label(outfit.getName());
        lblName.getStyleClass().add("text-title-show-item");
        stpName.getChildren().add(lblName);
        StackPane.setMargin(lblName, NODOWN_INSET);
        brpItem.setTop(stpName);

        /* Image CENTER__________________ */
        final ImageView imageView = new ImageView();
        final StackPane stpImageView = new StackPane();

        BorderPane.setMargin(stpImageView, STANDARD_INSET);
        imageView.getStyleClass().add("image-item");

        final Random rand = new Random();
        final int numDress = outfitDresses.size();
        if (numDress > 0) {
            final File imgFile = outfitDresses.get(rand.nextInt(numDress)).getImage();
            Image img;
            try {
                img = new Image(new FileInputStream(imgFile.getAbsolutePath()));
                imageView.setImage(img);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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
        brpItem.setCenter(stpImageView);

        /* Button see BUTTOM________________ */
        final StackPane stpBtnAction = new StackPane();
        btnAction.getStyleClass().add(BTN_NORMAL);
        btnAction.getStyleClass().add(BTN_SMALL);
        stpBtnAction.getChildren().add(btnAction);
        brpItem.setBottom(stpBtnAction);

        StackPane.setMargin(btnAction, NOUP_INSET);

        GridPane.setMargin(brpItem, STANDARD_INSET);

        gridExpo.add(brpItem, rowIndex, columnIndex);

    }

    /**
     * Get the standard Inset(15, 10, 15, 10).
     * 
     * @return the standard inset
     */
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
    /**
     * The event of when you drop an image on the StackPane.
     * 
     * @param e
     *            the event
     * @param imgFile
     *            File where the function will put the path of the image
     * @param imgItem
     *            Image where the function will put the image
     * @param imageView
     *            ImageView where the function will put the image for the
     *            graphic
     * @param pane
     *            StackPane where will put the ImageView
     */
    public void mouseDragDropped(final DragEvent e, final File[] imgFile, final Image[] imgItem,
            final ImageView imageView, final StackPane pane) {
        final Dragboard db = e.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;
            // Only get the first file from the list
            imgFile[0] = db.getFiles().get(0);
            try {
                imgItem[0] = new Image(new FileInputStream(imgFile[0].getAbsolutePath()));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
        e.setDropCompleted(success);
        e.consume();
    }

    /**
     * The event of when you drag an image on the StackPane.
     * 
     * @param e
     *            the event
     * @param pane
     *            for setting the right CSS style
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
