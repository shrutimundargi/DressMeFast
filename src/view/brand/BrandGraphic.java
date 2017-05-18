package view.brand;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
public class BrandGraphic extends ProgramUIImpl implements UI {
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.BRAND;
    private static final String NAMEOFSCREEN = "Brand";
    private static final String DESCRIPTIONOFPANE = "In this page you can select the category and see all the item of its!";

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
    public BrandGraphic(final SceneSetting environment, final Controller controller, final SetupView setup) {
        super(environment, controller, setup, ACTUALSCREEN);
        this.getSceneSetting().loadScreen(ACTUALSCREEN, this);
        super.getBtnBrand().setStyle("-fx-background-image: url('/images/clothes.png');");

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
        chbCategory.getItems().setAll(Category.values());
        pnlCategoryTitle.getChildren().add(txtCategory);
        pnlCategoryChb.getChildren().add(chbCategory);

        vboxSelectCat.getChildren().add(pnlCategoryTitle);
        vboxSelectCat.getChildren().add(pnlCategoryChb);

        /* ____________________ */

        vBox.getChildren().add(titleStackPnl);
        vBox.getChildren().add(vboxSelectCat);

        vBox.setVgrow(scrollPnl, javafx.scene.layout.Priority.ALWAYS);
        /* ___________________________________________ */
        scrollPnl.setFitToWidth(true);
        // scrollPnl.setFitToHeight(true);
        scrollPnl.setContent(vBox);

        chbCategory.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                showItemOfCategory(chbCategory.getItems().get((Integer) number2));
            }
        });
    }

    @Override
    public void showNowContent() {
        super.setupColorButtonsBH();
        returnTopPane();
    }

    private void returnTopPane() {
        final Bounds bounds = scrollPnl.getViewportBounds();
        final int highestXPixelShown = -1 * (int) bounds.getMinX() + (int) bounds.getMaxX();
        if (highestXPixelShown != 0) {
            scrollPnl.setVvalue(scrollPnl.getMaxHeight());
        }
    }

    public void showItemOfCategory(Category cat) {
        Set<String> brandsName = super.getController().dress().getAllBrandName(cat);
        List<String> brandName = new ArrayList();
        brandName.add("Levis");
        brandName.add("Supreme");
        brandName.add("Moscot");
        brandName.add("Vans");
        int nBrand = brandName.size();

        java.util.Collections.sort(brandName);

        for (int i = 0; i < nBrand; i++) {

            BorderPane brpBrand = new BorderPane();
            StackPane skpNameBrand = new StackPane();
            Label nameBrand = new Label(brandName.get(i));
            GridPane gridItem = new GridPane();

            brpBrand.getStyleClass().add("pnl-show-item");
            skpNameBrand.getStyleClass().add("pnl-show-item-title");
            nameBrand.getStyleClass().add("text-title-show-item");
            gridItem.getStyleClass().add("pnl-show-item-dress");

            VBox.setMargin(brpBrand, new Insets(15, 10, 15, 10));

            /* Grid________________ */
            gridItem.getColumnConstraints().addAll(DoubleStream.of(33, 33, 33).mapToObj(width -> {
                ColumnConstraints constraints = new ColumnConstraints();
                constraints.setPercentWidth(width);
                constraints.setFillWidth(true);
                return constraints;
            }).toArray(ColumnConstraints[]::new));

            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.ALWAYS);
            gridItem.getRowConstraints().add(rowConstraints);

            /* Specific_Item__________________ */
            BorderPane brpSpecificIthem = new BorderPane();

            /* Name TOP__________________ */
            StackPane stpNameItem = new StackPane();
            Label nameSpecItem = new Label("Name");
            nameSpecItem.getStyleClass().add("text-title-show-item");
            stpNameItem.getChildren().add(nameSpecItem);

            brpSpecificIthem.setTop(stpNameItem);

            /* Image CENTER__________________ */
            brpSpecificIthem.getStyleClass().add("pnl-specific-item");
            File imgFile = new File("/Users/aleric/Desktop/images.jpg");
            Image img;
            ImageView imageView = new ImageView();
            try {
                img = new Image(new FileInputStream(imgFile.getAbsolutePath()));
                imageView.setImage(img);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            imageView.setFitWidth(brpSpecificIthem.getWidth());
            imageView.setPreserveRatio(true);

            brpSpecificIthem.setCenter(imageView);

            /* Button see BUTTOM________________ */
            StackPane stpButtonSee = new StackPane();
            Button btnSee = new Button("See more");
            btnSee.getStyleClass().add("btn-normal");
            btnSee.getStyleClass().add("btn-small");
            stpButtonSee.getChildren().add(btnSee);
            brpSpecificIthem.setBottom(stpButtonSee);

            //GridPane.setMargin(brpSpecificIthem, new Insets(15, 10, 15, 10));

            gridItem.add(brpSpecificIthem, 0, 0);
            gridItem.add(new Button("2"), 1, 0);
            gridItem.add(new Button("3"), 2, 0);
            /* ____________________ */
            skpNameBrand.getChildren().add(nameBrand);
            brpBrand.setTop(skpNameBrand);
            brpBrand.setCenter(gridItem);

            vBox.getChildren().add(brpBrand);
        }

    }

    public void prvItem() {

    }
}
