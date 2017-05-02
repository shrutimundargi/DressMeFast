package view.home;


import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;
import view.UI;
import view.generalUI.ProgramUI;
import view.generalUI.ProgramUIImpl;

public class HomeGraphic extends ProgramUIImpl implements UI, ProgramUI{

    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.HOME;
    
    private static SceneSetting viewM;
    private Stage primaryStage;
    private boolean lockedPositionSlider;
    
    @FXML
    private Circle imagePreviewDress1;
    @FXML
    private Text txtPreviewDress1;
    @FXML
    private Button btnPreviewDress1;
    @FXML
    private Circle imagePreviewDress2;
    @FXML
    private Button btnPreviewDress2;
    @FXML
    private Circle imagePreviewDress3;
    @FXML
    private Button btnPreviewDress3;
    @FXML
    private Circle imagePreviewDress4;
    @FXML
    private Button btnPreviewDress4;
    @FXML
    private Button btnCenterBrand;
    @FXML
    private Button btnCenterOutfits;
    @FXML
    private Button btnCenterSize;
    @FXML
    private Button btnCenterAdd;
    @FXML
    private Button btnCenterFavorite;
    @FXML
    private Button btnCenterCategory;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnBrand;
    @FXML
    private Button btnAddDress;
    @FXML
    private Button btnFavorite;
    @FXML
    private Button btnOutfits;
    @FXML
    private Button btnSize;
    @FXML
    private Button btnCategory;


    
    public HomeGraphic(final SceneSetting environment, final Controller controller, final SetupView setup){
        super(environment, controller, setup, ACTUALSCREEN);
        this.environment.loadScreen(ACTUALSCREEN, this);
        this.lockedPositionSlider = false;
        this.primaryStage = this.environment.getMainStage();

        btnHome.setStyle("-fx-background-image: url('/images/hoodie.png');");

        Image im = new Image(getClass().getResourceAsStream("/images/vans-t-shirt.jpg"));
        imagePreviewDress1.setFill(new ImagePattern(im));
        
    }

    @Override
    public void show() {
        this.primaryStage = this.environment.getMainStage();
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));
        this.environment.displayScreen(ACTUALSCREEN);
    }

    @Override
    public void showNowContent() {
        super.setupButtonsBH();
    }

}

