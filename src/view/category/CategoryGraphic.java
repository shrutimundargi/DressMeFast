package view.category;

import java.util.List;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.enumerations.Category;
import model.interfaces.Dress;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;
import view.UI;
import view.general.DialogPreviewIO;
import view.general.GeneralObjectFx;
import view.general.ProgramUIImpl;

/**
 * 
 * Screen that show the Information of the user and permit to logout.
 *
 */
public class CategoryGraphic extends ProgramUIImpl implements UI {
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.CATEGORY;

    private static final String NAMEOFSCREEN = "Category";

    @FXML
    private ScrollPane scrollPnl;
    private final VBox vBox;
    private final ChoiceBox<Category> chbCategory;
    private final DialogPreviewIO dialogItem;
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
    public CategoryGraphic(final SceneSetting environment, final Controller controller, final SetupView setup) {
        super(environment, controller, setup, ACTUALSCREEN);
        this.getSceneSetting().loadScreen(ACTUALSCREEN, this);
        super.getBtnCategory().setStyle("-fx-background-image: url('/images/clipboard-1.png');");

        dialogItem = new DialogPreviewIO();
        genObjFx = new GeneralObjectFx();

        /* Container (PANE) */
        vBox = new VBox();

        /* Title_______________ */
        final Text titlePane = new Text(NAMEOFSCREEN);
        final StackPane titleStackPnl = new StackPane();
        titlePane.getStyleClass().add("main-title");
        titleStackPnl.getStyleClass().add("pnl-main-title");
        titleStackPnl.getChildren().add(titlePane);
        /* ____________________ */

        /* Category_______________ */
        final Text txtCategory = new Text("Select the category");
        final VBox vboxSelectCat = new VBox();
        chbCategory = genObjFx.setChoiseBoxCategoryBanner(txtCategory, vboxSelectCat);
        /* ____________________ */

        vBox.getChildren().add(titleStackPnl);
        vBox.getChildren().add(vboxSelectCat);

        VBox.setVgrow(scrollPnl, Priority.ALWAYS);
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

    /**
     * @param cat
     *            the category that i wont to show.
     */
    private void showItemOfCategory(final Category cat) {

        final BorderPane brpBrand = new BorderPane();
        final StackPane skpNameBrand = new StackPane();
        final Label lblBrand = new Label(cat.getCategoryName());
        final GridPane gridBrand = new GridPane();
        genObjFx.setBorderPaneExposition(false, brpBrand, skpNameBrand, lblBrand, gridBrand);

        /* Specific_Item__________________ */
        final List<Dress> dressItem = super.getController().dress().getDressIntoCategory(cat);
        for (int j = 0; j < dressItem.size(); j++) {
            final Dress dress = dressItem.get(j);
            final Button btnSelect = new Button("See more");

            genObjFx.setItemInsideGrid(false, j, dress, btnSelect, gridBrand);

            btnSelect.setOnAction(event -> {
                dialogItem.createDialogDress(super.getSceneSetting().getMainStage(), dress, super.getController(),
                        this);
                this.showNowContent();
            });
        }

        vBox.getChildren().add(brpBrand);
    }

}
