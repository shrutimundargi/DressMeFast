package view.add;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

import controller.Controller;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
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
public class AddGraphic extends ProgramUIImpl implements UI {
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.ADD;
    private static final String NAMEOFSCREEN = "Add Item";
    private static final String DESCRIPTIONOFPANE = "This page permit to add an item in your wordrobe,"
            + " it's very easy, you just need to choose the specific category of the item,"
            + " add a photo and then fill all the information about it.";
    @FXML
    private ScrollPane scrollPnl;
    private ImageView imageView;
    private StackPane contentPane;

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
        VBox vBox = new VBox();
        StackPane titleStackPnl = new StackPane();

        /* Title_______________ */
        Text titlePane = new Text(NAMEOFSCREEN);
        titlePane.getStyleClass().add("main-title");
        titleStackPnl.getChildren().add(titlePane);
        /* ____________________ */

        /* Description_________ */
        Label descriptionLabel = new Label(DESCRIPTIONOFPANE);
        descriptionLabel.getStyleClass().add("text-description");
        descriptionLabel.setWrapText(true);
        descriptionLabel.setTextAlignment(TextAlignment.JUSTIFY);
        // descriptionPnl.getChildren().add(descriptionLabel);
        /* ____________________ */

        /* Separator___________ */
        Separator sepTitle = new Separator();
        sepTitle.getStyleClass().add("sep-title");
        /* ____________________ */

        /* Brand_______________ */
        Text txtBrand = new Text("Select the brand");
        ChoiceBox chbBrand = new ChoiceBox();
        StackPane pnlBrandTitle = new StackPane();
        StackPane pnlBrandChb = new StackPane();
        txtBrand.getStyleClass().add("add-title-info");
        pnlBrandTitle.getStyleClass().add("add-cont-title-info-first");
        chbBrand.getStyleClass().add("");
        pnlBrandTitle.getChildren().add(txtBrand);
        pnlBrandChb.getChildren().add(chbBrand);
        /* ____________________ */

        /* Image_______________ */
        Text txtImage = new Text("Drag and drop an image ");
        contentPane = new StackPane();
        contentPane.setPrefSize(200,200);
        contentPane.getStyleClass().add("pnl-image");
        contentPane.setOnDragOver(new EventHandler<DragEvent>() {

            public void handle(DragEvent event) {
                mouseDragOver(event);
            }
        });

        contentPane.setOnDragDropped(new EventHandler<DragEvent>() {

            public void handle(DragEvent event) {
                mouseDragDropped(event);
            }
        });

        contentPane.setOnDragExited(new EventHandler<DragEvent>() {

            public void handle(DragEvent event) {
                contentPane.setStyle("-fx-border-color: #C6C6C6;");
            }
        });

        StackPane pnlImageTitle = new StackPane();
        StackPane pnlImage = new StackPane();
        txtImage.getStyleClass().add("add-title-info");
        pnlImageTitle.getStyleClass().add("add-cont-title-info");
        pnlImage.getStyleClass().add("pnl-cont-image");
        pnlImageTitle.getChildren().add(txtImage);
        pnlImage.getChildren().add(contentPane);
        /* ____________________ */

        /* Adding of graphic elements to PANE_________ */
        vBox.getChildren().add(titleStackPnl);
        vBox.getChildren().add(descriptionLabel);
        vBox.getChildren().add(sepTitle);
        vBox.getChildren().add(pnlBrandTitle);
        vBox.getChildren().add(pnlBrandChb);
        vBox.getChildren().add(pnlImageTitle);
        vBox.getChildren().add(pnlImage);
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
    }

    void addImage(Image i, StackPane pane) {

        imageView = new ImageView();
        imageView.setImage(i);
        pane.getChildren().add(imageView);
    }

    private void mouseDragDropped(final DragEvent e) {
        final Dragboard db = e.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;
            // Only get the first file from the list
            final File file = db.getFiles().get(0);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    System.out.println(file.getAbsolutePath());
                    try {
                        if (!contentPane.getChildren().isEmpty()) {
                            contentPane.getChildren().remove(0);
                        }
                        Image img = new Image(new FileInputStream(file.getAbsolutePath()));

                        addImage(img, contentPane);
                    } catch (FileNotFoundException ex) {
                        // Logger.getLogger(DragAndDropExample.class.getName()).log(Level.SEVERE,
                        // null, ex);
                    }
                }
            });
        }
        e.setDropCompleted(success);
        e.consume();
    }

    private void mouseDragOver(final DragEvent e) {
        final Dragboard db = e.getDragboard();

        final boolean isAccepted = db.getFiles().get(0).getName().toLowerCase().endsWith(".png")
                || db.getFiles().get(0).getName().toLowerCase().endsWith(".jpeg")
                || db.getFiles().get(0).getName().toLowerCase().endsWith(".jpg");

        if (db.hasFiles()) {
            if (isAccepted) {
                contentPane.setStyle("-fx-border-color: white;" + "-fx-border-width: 5;"
                        + "-fx-background-color: grey;");
                e.acceptTransferModes(TransferMode.COPY);
            }
        } else {
            e.consume();
        }
    }
}
