package view.generalUI;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;

public class ProgramUIImpl implements ProgramUI {
    protected final ScreensGraphic actualScreen;
    protected SceneSetting environment;
    protected final Controller controller;
    protected final SetupView setup;

    @FXML
    protected Button btnGoBack;
    @FXML
    protected Button btnGoAhead;
    @FXML
    protected Button btnUser;

    public ProgramUIImpl(final SceneSetting environment, Controller controller, final SetupView setup,
            final ScreensGraphic actualScreen) {
        this.environment = environment;
        this.controller = controller;
        this.setup = setup;
        this.actualScreen = actualScreen;
    }

    @Override
    public void setupButtonsBH() {
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
    public void goHome(ActionEvent event) {
        this.addScreenBack(ScreensGraphic.HOME);
        this.environment.displayScreen(ScreensGraphic.HOME);
    }

    @Override
    public void goBrand(ActionEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void goAddDress(ActionEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void goFavorite(ActionEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void goOutfits(ActionEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void goSize(ActionEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void goCategory(ActionEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void goUser(ActionEvent event) {
        this.addScreenBack(ScreensGraphic.USER);
        this.environment.displayScreen(ScreensGraphic.USER);
    }

    @Override
    public void goBack(ActionEvent event) {
        ScreensGraphic sgBack = setup.getScreenBack();
        this.setup.addScreenAhead(actualScreen, sgBack);
        this.environment.displayScreen(sgBack);
    }

    @Override
    public void goAhead(ActionEvent event) {
        ScreensGraphic sgAhead = setup.getScreenAhead();
        this.addScreenBack(sgAhead);
        this.environment.displayScreen(sgAhead);
    }

}
