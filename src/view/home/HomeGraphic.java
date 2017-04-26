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
import javafx.fxml.FXML;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import view.SceneSetting;
import view.ScreensGraphic;
import view.UI;

public class HomeGraphic implements UI{

    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.HOME;
    
    private static SceneSetting viewM;
    private final SceneSetting environment;
    private final Controller controller;
    private Stage primaryStage;
    private boolean lockedPositionSlider;
    
    @FXML
    private Circle imagePreviewDress1;
    private Circle imagePreviewDress2;
    private Circle imagePreviewDress3;

    
    public HomeGraphic(final SceneSetting environment, final Controller controller){
        this.controller = controller;
        this.environment = environment;
        this.environment.loadScreen(ACTUALSCREEN, this);
        this.lockedPositionSlider = false;
        this.primaryStage = this.environment.getMainStage();
        
        
        Image im = new Image(getClass().getResourceAsStream("/image/login-bg-3.jpg"));
        imagePreviewDress1.setFill(new ImagePattern(im));
    }

    @Override
    public void show() {
        this.primaryStage = this.environment.getMainStage();
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));
        this.environment.displayScreen(ACTUALSCREEN);
    }
}

