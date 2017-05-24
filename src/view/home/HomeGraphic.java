package view.home;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.DoubleStream;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import model.interfaces.Dress;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;
import view.UI;
import view.generalUI.ProgramUI;
import view.generalUI.ProgramUIImpl;

/**
 * 
 * Class extended from all the screens that implements a standard graphic (with
 * standard menu and screen queue).
 *
 */
public class HomeGraphic extends ProgramUIImpl implements UI, ProgramUI {
    private static final int LEFTRIGHT = 10;
    private static final int UPDOWN = 15;
    private static final int PERCENT_WIDTH_GRID = 33;
    private static final int WIDTH_HEIGHT = 120;
    private static final int HEIGHT_IMAGE = 180;
    private static final int SHADOW_HEIGHT = 20;
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.HOME;

    @FXML
    private VBox vBoxLastAdded;
    @FXML
    private Button btnCenterBrand;
    @FXML
    private Button btnCenterOutfits;
    @FXML
    private Button btnCenterHome;
    @FXML
    private Button btnCenterAdd;
    @FXML
    private Button btnCenterFavorite;
    @FXML
    private Button btnCenterCategory;

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
    public HomeGraphic(final SceneSetting environment, final Controller controller, final SetupView setup) {
        super(environment, controller, setup, ACTUALSCREEN);
        super.getSceneSetting().loadScreen(ACTUALSCREEN, this);
        super.getBtnHome().setStyle("-fx-background-image: url('/images/hoodie.png');");

        /*
         * btnHome.setStyle("-fx-background-image: url('/images/hoodie.png');");
         * 
         * Image im = new
         * Image(getClass().getResourceAsStream("/images/vans-t-shirt.jpg"));
         * imagePreviewDress1.setFill(new ImagePattern(im));
         */
    }

    @Override
    public void showNowContent() {
        super.setupColorButtonsBH();
        resetAllComponent();
        showItemOfCategory();
    }

    /**
     * Pressing of the button BRAND in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterBrand(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.ADD);
    }

    /**
     * Pressing of the button ADD in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterAdd(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.ADD);
    }

    /**
     * Pressing of the button FAVORITE in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterFavorite(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.ADD);
    }

    /**
     * Pressing of the button OUTFITS in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterOutfits(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.ADD);
    }

    /**
     * Pressing of the button SIZE in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterSize(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.ADD);
    }

    /**
     * Pressing of the button CATEGORY in the center menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    @FXML
    public void goCenterCategory(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        super.getSceneSetting().displayScreen(ScreensGraphic.ADD);
    }

    @Override
    public void resetAllComponent() {
        if (vBoxLastAdded.getChildren().size() > 0) {
            vBoxLastAdded.getChildren().remove(0);
        }
    }

    private void showItemOfCategory() {
        Set<Dress> lastDressSet = super.getController().dress().getLastAddedDresses();
        List<Dress> lastDress = new LinkedList<>(lastDressSet);
        Insets standarInset = new Insets(UPDOWN, LEFTRIGHT, UPDOWN, LEFTRIGHT);
        Insets noUpInset = new Insets(0, LEFTRIGHT, UPDOWN, LEFTRIGHT);
        Insets noDownInset = new Insets(UPDOWN, LEFTRIGHT, 0, LEFTRIGHT);

        BorderPane brpHome = new BorderPane();
        StackPane skpNameHome = new StackPane();
        Label nameHome = new Label("List of last added");
        GridPane gridItem = new GridPane();

        brpHome.getStyleClass().add("pnl-show-item");
        skpNameHome.getStyleClass().add("pnl-show-item-title");
        nameHome.getStyleClass().add("text-title-show-item");
        gridItem.getStyleClass().add("pnl-show-item-dress");


        /* Grid________________ */
        gridItem.getColumnConstraints()
                .addAll(DoubleStream.of(PERCENT_WIDTH_GRID, PERCENT_WIDTH_GRID, PERCENT_WIDTH_GRID).mapToObj(width -> {
                    ColumnConstraints constraints = new ColumnConstraints();
                    constraints.setPercentWidth(width);
                    constraints.setFillWidth(true);
                    return constraints;
                }).toArray(ColumnConstraints[]::new));

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setVgrow(Priority.ALWAYS);
        gridItem.getRowConstraints().add(rowConstraints);

        /* Specific_Item__________________ */
        for (int j = 0; j < lastDress.size() && j < 3; j++) {
            Dress dress = lastDress.get(j);
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

        skpNameHome.getChildren().add(nameHome);
        brpHome.setTop(skpNameHome);
        brpHome.setCenter(gridItem);

        vBoxLastAdded.getChildren().add(brpHome);

    }

}
