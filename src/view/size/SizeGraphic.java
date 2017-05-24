package view.size;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.DoubleStream;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
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
public class SizeGraphic extends ProgramUIImpl implements UI {
    private static final int LEFTRIGHT = 10;
    private static final int UPDOWN = 15;
    private static final int PERCENT_WIDTH_GRID = 33;
    private static final int WIDTH_HEIGHT = 150;
    private static final int HEIGHT_IMAGE = 200;
    private static final int SHADOW_HEIGHT = 20;
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.SIZE;

    private static final String NAMEOFSCREEN = "Size";
    private static final String DESCRIPTIONOFPANE = "";

    @FXML
    private ScrollPane scrollPnl;
    private VBox vBox;
    private final ChoiceBox<Category> chbCategory;

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
    public SizeGraphic(final SceneSetting environment, final Controller controller, final SetupView setup) {
        super(environment, controller, setup, ACTUALSCREEN);
        this.getSceneSetting().loadScreen(ACTUALSCREEN, this);
        super.getBtnSize().setStyle("-fx-background-image: url('/images/ruler.png');");

        /* Container (PANE) */
        vBox = new VBox();

        /* Title_______________ */
        final Text titlePane = new Text(NAMEOFSCREEN);
        final StackPane titleStackPnl = new StackPane();
        titlePane.getStyleClass().add("main-title");
        titleStackPnl.getStyleClass().add("pnl-main-title");
        titleStackPnl.getChildren().add(titlePane);
        /* ____________________ */

        /* Select Category___________ */
        final Text txtCategory = new Text("Select the Category");
        chbCategory = new ChoiceBox<Category>();
        final StackPane pnlCategoryTitle = new StackPane();
        final StackPane pnlCategoryChb = new StackPane();
        final VBox vboxSelectCat = new VBox();
        txtCategory.getStyleClass().add("add-title-info");
        pnlCategoryTitle.getStyleClass().add("add-cont-title-info");
        pnlCategoryChb.getStyleClass().add("pnl-category-chb");
        chbCategory.getStyleClass().add("chb-category");
        vboxSelectCat.getStyleClass().add("vbox-select-cat");
        for (final Category cat : Category.values()) {
            if (cat != Category.EMPTY) {
                chbCategory.getItems().add(cat);
            }
        }
        pnlCategoryTitle.getChildren().add(txtCategory);
        pnlCategoryChb.getChildren().add(chbCategory);

        vboxSelectCat.getChildren().add(pnlCategoryTitle);
        vboxSelectCat.getChildren().add(pnlCategoryChb);

        /* ____________________ */

        vBox.getChildren().add(titleStackPnl);
        vBox.getChildren().add(vboxSelectCat);

        VBox.setVgrow(scrollPnl, javafx.scene.layout.Priority.ALWAYS);
        /* ___________________________________________ */
        scrollPnl.setFitToWidth(true);
        // scrollPnl.setFitToHeight(true);
        scrollPnl.setContent(vBox);

        chbCategory.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(final ObservableValue<? extends Number> observableValue, final Number number,
                    final Number number2) {
                resetAllComponent();
                showItemOfCategory(chbCategory.getItems().get((Integer) number2));
            }
        });
    }

    @Override
    public void showNowContent() {
        final Category switchCategory = chbCategory.getValue();
        super.setupColorButtonsBH();
        returnTopPane();
        resetAllComponent();
        if (switchCategory != null) {
            showItemOfCategory(chbCategory.getValue());
        }
    }

    @Override
    public void resetAllComponent() {
        final int nComponent = vBox.getChildren().size();
        for (int i = 2; i < nComponent; i++) {
            vBox.getChildren().remove(2);
        }
    }

    private void showItemOfCategory(final Category cat) {
        List<Integer> sizesName = super.getController().dress().getAllSizeName(cat);
        int nSizes = sizesName.size();

        Insets standarInset = new Insets(UPDOWN, LEFTRIGHT, UPDOWN, LEFTRIGHT);
        Insets noUpInset = new Insets(0, LEFTRIGHT, UPDOWN, LEFTRIGHT);
        Insets noDownInset = new Insets(UPDOWN, LEFTRIGHT, 0, LEFTRIGHT);

        // java.util.Collections.sort(SizesName);

        for (int i = 0; i < nSizes; i++) {
            int numSize = sizesName.get(i);
            String stringSize = numSize == -1 ? "Not setted" : String.valueOf(numSize);
            BorderPane brpSize = new BorderPane();
            StackPane skpNameSize = new StackPane();
            Label nameSize = new Label(stringSize);
            GridPane gridItem = new GridPane();

            brpSize.getStyleClass().add("pnl-show-item");
            skpNameSize.getStyleClass().add("pnl-show-item-title");
            nameSize.getStyleClass().add("text-title-show-item");
            gridItem.getStyleClass().add("pnl-show-item-dress");

            VBox.setMargin(brpSize, standarInset);

            /* Grid________________ */
            gridItem.getColumnConstraints().addAll(
                    DoubleStream.of(PERCENT_WIDTH_GRID, PERCENT_WIDTH_GRID, PERCENT_WIDTH_GRID).mapToObj(width -> {
                        ColumnConstraints constraints = new ColumnConstraints();
                        constraints.setPercentWidth(width);
                        constraints.setFillWidth(true);
                        return constraints;
                    }).toArray(ColumnConstraints[]::new));

            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.ALWAYS);
            gridItem.getRowConstraints().add(rowConstraints);

            /* Specific_Item__________________ */
            List<Dress> dressItem = super.getController().dress().getAllSizeDress(cat, sizesName.get(i));
            for (int j = 0; j < dressItem.size(); j++) {
                Dress dress = dressItem.get(j);
                BorderPane brpSpecificIthem = new BorderPane();
                int rowIndex = j % 3;
                int columnIndex = j == 0 ? 0 : j / 3;

                /* Name TOP__________________ */
                StackPane stpNameItem = new StackPane();
                Label nameSpecItem = new Label(dress.getName());
                nameSpecItem.getStyleClass().add("text-title-show-item");
                stpNameItem.getChildren().add(nameSpecItem);
                StackPane.setMargin(nameSpecItem, noDownInset);
                brpSpecificIthem.setTop(stpNameItem);

                /* Image CENTER__________________ */
                brpSpecificIthem.getStyleClass().add("pnl-specific-item");
                File imgFile = dress.getImage();
                Image img;
                ImageView imageView = new ImageView();
                StackPane stpImageView = new StackPane();

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
                brpSpecificIthem.setCenter(stpImageView);

                /* Button see BUTTOM________________ */
                StackPane stpButtonSee = new StackPane();
                Button btnSee = new Button("See more");
                btnSee.getStyleClass().add("btn-normal");
                btnSee.getStyleClass().add("btn-small");
                stpButtonSee.getChildren().add(btnSee);
                brpSpecificIthem.setBottom(stpButtonSee);

                StackPane.setMargin(btnSee, noUpInset);

                GridPane.setMargin(brpSpecificIthem, standarInset);

                gridItem.add(brpSpecificIthem, rowIndex, columnIndex);
            }

            skpNameSize.getChildren().add(nameSize);
            brpSize.setTop(skpNameSize);
            brpSize.setCenter(gridItem);

            vBox.getChildren().add(brpSize);
        }

    }
}
