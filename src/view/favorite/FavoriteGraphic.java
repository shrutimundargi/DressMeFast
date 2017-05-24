package view.favorite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.DoubleStream;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
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
public class FavoriteGraphic extends ProgramUIImpl implements UI {
    private static final int LEFTRIGHT = 10;
    private static final int UPDOWN = 15;
    private static final int PERCENT_WIDTH_GRID = 33;
    private static final int WIDTH_HEIGHT = 150;
    private static final int HEIGHT_IMAGE = 200;
    private static final int SHADOW_HEIGHT = 20;
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.FAVORITE;

    private static final String NAMEOFSCREEN = "Favorite";
    private static final String DESCRIPTIONOFPANE = "";

    @FXML
    private ScrollPane scrollPnl;
    private VBox vBox;

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
    public FavoriteGraphic(final SceneSetting environment, final Controller controller, final SetupView setup) {
        super(environment, controller, setup, ACTUALSCREEN);
        this.getSceneSetting().loadScreen(ACTUALSCREEN, this);
        super.getBtnFavorite().setStyle("-fx-background-image: url('/images/star.png');");

        /* Container (PANE) */
        vBox = new VBox();

        /* Title_______________ */
        final Text titlePane = new Text(NAMEOFSCREEN);
        final StackPane titleStackPnl = new StackPane();
        titlePane.getStyleClass().add("main-title");
        titleStackPnl.getStyleClass().add("pnl-main-title");
        titleStackPnl.getChildren().add(titlePane);
        /* ____________________ */



        vBox.getChildren().add(titleStackPnl);

        VBox.setVgrow(scrollPnl, javafx.scene.layout.Priority.ALWAYS);
        /* ___________________________________________ */
        scrollPnl.setFitToWidth(true);
        // scrollPnl.setFitToHeight(true);
        scrollPnl.setContent(vBox);

    }

    @Override
    public void showNowContent() {
        super.setupColorButtonsBH();
        returnTopPane();
        resetAllComponent();
        showItemOfFavegory();
    }

    @Override
    public void resetAllComponent() {
        final int nComponent = vBox.getChildren().size();
        for (int i = 1; i < nComponent; i++) {
            vBox.getChildren().remove(1);
        }
    }

    /**
     * @param Fav
     */
    private void showItemOfFavegory() {

        final Insets standarInset = new Insets(UPDOWN, LEFTRIGHT, UPDOWN, LEFTRIGHT);
        final Insets noUpInset = new Insets(0, LEFTRIGHT, UPDOWN, LEFTRIGHT);
        final Insets noDownInset = new Insets(UPDOWN, LEFTRIGHT, 0, LEFTRIGHT);

        // java.util.Collections.sort(FavsName);

        final BorderPane brpFav = new BorderPane();
        final StackPane skpNameFav = new StackPane();
        final Label nameFav = new Label("Favorite");
        final GridPane gridItem = new GridPane();

        brpFav.getStyleClass().add("pnl-show-item");
        skpNameFav.getStyleClass().add("pnl-show-item-title");
        nameFav.getStyleClass().add("text-title-show-item");
        gridItem.getStyleClass().add("pnl-show-item-dress");

        VBox.setMargin(brpFav, standarInset);

        /* Grid________________ */
        gridItem.getColumnConstraints()
                .addAll(DoubleStream.of(PERCENT_WIDTH_GRID, PERCENT_WIDTH_GRID, PERCENT_WIDTH_GRID).mapToObj(width -> {
                    final ColumnConstraints constraints = new ColumnConstraints();
                    constraints.setPercentWidth(width);
                    constraints.setFillWidth(true);
                    return constraints;
                }).toArray(ColumnConstraints[]::new));

        final RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setVgrow(Priority.ALWAYS);
        gridItem.getRowConstraints().add(rowConstraints);

        /* Specific_Item__________________ */
        final Set<Dress> dressItemSet = super.getController().dress().getFavoriteDresses();
        final List<Dress> dressItem = new LinkedList<>(dressItemSet);
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
            final Button btnSee = new Button("See more");
            btnSee.getStyleClass().add("btn-normal");
            btnSee.getStyleClass().add("btn-small");
            stpButtonSee.getChildren().add(btnSee);
            brpSpecificIthem.setBottom(stpButtonSee);

            StackPane.setMargin(btnSee, noUpInset);

            GridPane.setMargin(brpSpecificIthem, standarInset);

            gridItem.add(brpSpecificIthem, rowIndex, columnIndex);
        }

        skpNameFav.getChildren().add(nameFav);
        brpFav.setTop(skpNameFav);
        brpFav.setCenter(gridItem);

        vBox.getChildren().add(brpFav);

    }
}
