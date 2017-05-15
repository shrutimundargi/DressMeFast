package view.generalUI;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;

public class ProgramUIImpl implements ProgramUI {

    private final SceneSetting environment;
    private final Controller controller;
    private final SetupView setup;
    private final ScreensGraphic actualScreen;

    @FXML
    private Button btnGoBack;
    @FXML
    private Button btnGoAhead;
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
    @FXML
    private Button btnUser;

    public ProgramUIImpl(final SceneSetting environment, Controller controller, final SetupView setup,
            final ScreensGraphic actualScreen) {
        this.environment = environment;
        this.controller = controller;
        this.setup = setup;
        this.actualScreen = actualScreen;
    }

    @Override
    public void setupColorButtonsBH() {
        if (setup.haveBackQueue()) {
            btnGoBack.setStyle("-fx-text-fill: #0075F2;");
        } else {
            btnGoBack.setStyle("-fx-text-fill: grey;");
        }

        if (setup.haveAheadQueue()) {
            btnGoAhead.setStyle("-fx-text-fill: #0075F2;");
        } else {
            btnGoAhead.setStyle("-fx-text-fill: grey;");
        }

        btnUser.setText(controller.userController().getUsername());
    }

    @Override
    public void addScreenBack(final ScreensGraphic futureScreen) {
        this.setup.addScreenBack(actualScreen, futureScreen);
    }

    @Override
    public void goHome(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.HOME);
        this.environment.displayScreen(ScreensGraphic.HOME);
    }

    @Override
    public void goBrand(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.BRAND);
        this.environment.displayScreen(ScreensGraphic.BRAND);
    }

    @Override
    public void goAddDress(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.ADD);
        this.environment.displayScreen(ScreensGraphic.ADD);
    }

    @Override
    public void goFavorite(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.FAVORITE);
        this.environment.displayScreen(ScreensGraphic.FAVORITE);
    }

    @Override
    public void goOutfits(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.OUTFITS);
        this.environment.displayScreen(ScreensGraphic.OUTFITS);
    }

    @Override
    public void goSize(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.SIZE);
        this.environment.displayScreen(ScreensGraphic.SIZE);
    }

    @Override
    public void goCategory(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.CATEGORY);
        this.environment.displayScreen(ScreensGraphic.CATEGORY);
    }

    @Override
    public void goUser(final ActionEvent event) {
        this.addScreenBack(ScreensGraphic.USER);
        this.environment.displayScreen(ScreensGraphic.USER);
    }

    @Override
    public void goBack(final ActionEvent event) {
        if (setup.haveBackQueue()) {
            ScreensGraphic sgBack = setup.getScreenBack();
            this.setup.addScreenAhead(actualScreen, sgBack);
            this.environment.displayScreen(sgBack);
        }
    }

    @Override
    public void goAhead(final ActionEvent event) {
        if (setup.haveAheadQueue()) {
            ScreensGraphic sgAhead = setup.getScreenAhead();
            this.addScreenBack(sgAhead);
            this.environment.displayScreen(sgAhead);
        }
    }

    @Override
    public SceneSetting getSceneSetting() {
        return environment;
    }

    @Override
    public Controller getController() {
        return controller;
    }

    @Override
    public SetupView getSetupView() {
        return setup;
    }

    @Override
    public ScreensGraphic getScreensGraphic() {
        return actualScreen;
    }

    @Override
    public Button getBtnHome() {
        return btnHome;
    }

    @Override
    public Button getBtnBrand() {
        return btnBrand;
    }
    
    @Override
    public Button getBtnAdd() {
        return btnAddDress;
    }
    
    @Override
    public Button getBtnFavorite() {
        return btnFavorite;
    }
    
    @Override
    public Button getBtnOutfits() {
        return btnOutfits;
    }
    
    @Override
    public Button getBtnSize() {
        return btnSize;
    }
    
    @Override
    public Button getBtnCategory() {
        return btnCategory;
    }

    @Override
    public Button getBtnUser() {
        return btnUser;
    }

}
