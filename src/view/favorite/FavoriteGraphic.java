package view.favorite;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
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
public class FavoriteGraphic extends ProgramUIImpl implements UI {
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.FAVORITE;

    private static final String NAMEOFSCREEN = "Favorite";
    private static final String DESCRIPTIONOFPANE = "";

    @FXML
    private ScrollPane scrollPnl;

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

        vBox.getChildren().add(titleStackPnl);
        vBox.getChildren().add(descriptionLabel);
        vBox.getChildren().add(sepTitle);

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
}
