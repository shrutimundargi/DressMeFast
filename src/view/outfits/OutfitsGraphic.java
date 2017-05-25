package view.outfits;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
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
import view.general.ProgramUIImpl;

/**
 * 
 * Screen that show the Information of the user and permit to logout.
 *
 */
public class OutfitsGraphic extends ProgramUIImpl implements UI {
    private static final int LEFTRIGHT = 10;
    private static final int UPDOWN = 15;
    private static final int UPDOWN_BIG = 25;
    private static final int PERCENT_WIDTH_GRID = 33;
    private static final int WIDTH_HEIGHT = 150;
    private static final int HEIGHT_IMAGE = 200;
    private static final int SHADOW_HEIGHT = 20;
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.OUTFITS;

    private static final String NAMEOFSCREEN = "Outfits";
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
    public OutfitsGraphic(final SceneSetting environment, final Controller controller, final SetupView setup) {
        super(environment, controller, setup, ACTUALSCREEN);
        this.getSceneSetting().loadScreen(ACTUALSCREEN, this);
        super.getBtnOutfits().setStyle("-fx-background-image: url('/images/dress.png');");

        /* Container (PANE) */
        final VBox vBox = new VBox();

        /* Title_______________ */
        final Text titlePane = new Text(NAMEOFSCREEN);
        final StackPane titleStackPnl = new StackPane();
        titlePane.getStyleClass().add("main-title");
        titleStackPnl.getChildren().add(titlePane);
        /* ____________________ */

        /*
         * Description_________ final Label descriptionLabel = new
         * Label(DESCRIPTIONOFPANE); final StackPane descriptionPnl = new
         * StackPane();
         * descriptionLabel.getStyleClass().add("text-description");
         * descriptionLabel.setWrapText(true);
         * descriptionLabel.setTextAlignment(TextAlignment.JUSTIFY);
         * descriptionPnl.getChildren().add(descriptionLabel); /*
         * ____________________
         */

        final Button btnCreateOutfits = new Button("Create now an Outfits");
        final StackPane skpBtnCrateOtf = new StackPane();
        skpBtnCrateOtf.getChildren().add(btnCreateOutfits);
        btnCreateOutfits.getStyleClass().add("btn-normal");
        btnCreateOutfits.getStyleClass().add("btn-outfits");

        btnCreateOutfits.setOnAction((event) -> {
            super.getSceneSetting().displayScreen(ScreensGraphic.NEW_OUTFITS);
        });

        VBox.setMargin(skpBtnCrateOtf, new Insets(UPDOWN_BIG, LEFTRIGHT, 0, LEFTRIGHT));

        vBox.getChildren().add(titleStackPnl);
        // vBox.getChildren().add(descriptionLabel);
        vBox.getChildren().add(skpBtnCrateOtf);

        VBox.setVgrow(scrollPnl, javafx.scene.layout.Priority.ALWAYS);
        /* ___________________________________________ */
        scrollPnl.setFitToWidth(true);
        // scrollPnl.setFitToHeight(true);
        scrollPnl.setContent(vBox);
    }

    @Override
    public void showNowContent() {
        super.setupColorButtonsBH();
    }

    @Override
    public void resetAllComponent() {
        // TODO Auto-generated method stub

    }
}
