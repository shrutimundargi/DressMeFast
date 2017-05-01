package view.home;


import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import view.ProgramUI;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;
import view.UI;

public class HomeGraphic implements UI, ProgramUI{

    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.HOME;
    
    private static SceneSetting viewM;
    private final SceneSetting environment;
    private final Controller controller;
    private final SetupView setup;
    private Stage primaryStage;
    private boolean lockedPositionSlider;
    
    @FXML
    private Circle imagePreviewDress1;
    @FXML
    private Circle imagePreviewDress2;
    @FXML
    private Circle imagePreviewDress3;
    @FXML
    private Circle imagePreviewDress4;
    @FXML
    private Button btnGoBack;
    @FXML
    private Button btnGoAhead;
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
    private Button btnUser;
    @FXML
    private ImageView logoHomePage;
    @FXML
    private Label btnMenuHome;
    @FXML
    private ButtonBar btnMenuBrand;
    @FXML
    private ImageView logoBrandPage;
    @FXML
    private ButtonBar btnMenuAdd;
    @FXML
    private ImageView logoAddPage;
    @FXML
    private ButtonBar btnMenuFavorite;
    @FXML
    private ImageView logoFavoritePage;
    @FXML
    private ButtonBar btnMenuOutfits;
    @FXML
    private ImageView logoOutfitsPage;
    @FXML
    private ButtonBar btnMenuSize;
    @FXML
    private ImageView logoSizePage;
    @FXML
    private ButtonBar btnMenuCategory;
    @FXML
    private ImageView logoCategoryPage;


    
    public HomeGraphic(final SceneSetting environment, final Controller controller, final SetupView setup){
        this.controller = controller;
        this.environment = environment;
        this.setup = setup;
        this.environment.loadScreen(ACTUALSCREEN, this);
        this.lockedPositionSlider = false;
        this.primaryStage = this.environment.getMainStage();

        Image im = new Image(getClass().getResourceAsStream("/images/vans-t-shirt.jpg"));
        imagePreviewDress1.setFill(new ImagePattern(im));
        
        Image logo = new Image(getClass().getResourceAsStream("/images/hoodie.png"));
        logoHomePage.setImage(logo);
        
    }

    @Override
    public void show() {
        this.primaryStage = this.environment.getMainStage();
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));
        this.environment.displayScreen(ACTUALSCREEN);
    }

    @Override
    public void showNowContent() {
        if(setup.haveBackQueue()){
            btnGoBack.setStyle("-fx-text-fill: #0075F2;");
        } else {
            btnGoBack.setStyle("-fx-text-fill: grey;");
        }
        
        if(setup.haveAheadQueue()){
            btnGoAhead.setStyle("-fx-text-fill: #0075F2;");
        } else {
            btnGoAhead.setStyle("-fx-text-fill: grey;");
        }
        
        btnUser.setText(controller.userController().getUsername());
    }
    
    /**
     * @param event
     */
    @FXML
    public void goStatistics(ActionEvent event) {
        this.environment.displayScreen(ScreensGraphic.USER);
    }
    
    /**
     * @param event
     */
    @FXML
    public void goBack(ActionEvent event) {
    }
    
    /**
     * @param event
     */
    @FXML
    public void goAhead(ActionEvent event) {
    }

}

