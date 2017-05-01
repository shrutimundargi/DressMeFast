package view.user;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;
import view.UI;
import view.generalUI.ProgramUIImpl;

public class UserGraphic extends ProgramUIImpl implements UI{
    private static final ScreensGraphic ACTUALSCREEN = ScreensGraphic.USER;

    private ScreensGraphic lastPage;
    private static SceneSetting viewM;
    private Stage primaryStage;
    private boolean lockedPositionSlider;

    @FXML
    private Button btnGoBack;
    @FXML
    private Button btnGoAhead;
	@FXML
	private Button btnLogout;
	@FXML
    private Text txtUser;
	
	/**
     * @param environment
     * @param controller
     */
    public UserGraphic (final SceneSetting environment, final Controller controller, final SetupView setup){
        super(environment, controller, setup, ACTUALSCREEN);
        this.environment.loadScreen(ACTUALSCREEN, this);
        this.lockedPositionSlider = false;
        this.primaryStage = this.environment.getMainStage();
        btnUser.setStyle("-fx-background-color: #292929");

    }

    @Override
    public void show() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void showNowContent() {
        super.setupButtonsBH();
        txtUser.setText(controller.userController().getUsername());
    }
    
    public void setLastPage(ScreensGraphic screen){
        lastPage = screen;
    }
}
