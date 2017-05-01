package view.user;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import view.ProgramUI;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;
import view.UI;
import controller.Controller;
import javafx.event.ActionEvent;

public class UserGraphic implements UI, ProgramUI{
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.USER;

    private ScreensGraphic lastPage;
    private static SceneSetting viewM;
    private final SceneSetting environment;
    private final Controller controller;
    private final SetupView setup;
    private Stage primaryStage;
    private boolean lockedPositionSlider;

    @FXML
    private Button btnGoBack;
    @FXML
    private Button btnGoAhead;
    @FXML
    private Button btnUser;
	@FXML
	private Button btnLogout;
	
	/**
     * @param environment
     * @param controller
     */
    public UserGraphic (final SceneSetting environment, final Controller controller, final SetupView setup){
        this.controller = controller;
        this.environment = environment;
        this.setup = setup;
        this.environment.loadScreen(ACTUALSCREEN, this);
        this.lockedPositionSlider = false;
        this.primaryStage = this.environment.getMainStage();
    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        
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
    
    public void setLastPage(ScreensGraphic screen){
        lastPage = screen;
    }

    @Override
    public void goStatistics(ActionEvent event) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void goBack(ActionEvent event) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void goAhead(ActionEvent event) {
        // TODO Auto-generated method stub
        
    }
}
