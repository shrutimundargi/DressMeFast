package view;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sun.javafx.application.PlatformImpl;

import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Platform;
import javafx.stage.Stage;
import view.dialog.SingupDialogGraphic;
import view.home.HomeGraphic;
import view.login.LoginGraphic;
import view.singup.SingupGraphic;
import view.user.UserGraphic;

public class SetupView {

    private Controller controller;
    private SceneSetting sceneSetting;
    private LoginGraphic loginGraphic;
    private SingupGraphic singupGraphic;
    private SingupDialogGraphic singupPopUpGraphic;
    private HomeGraphic homeGraphic;
    private UserGraphic userGraphic;
    private Queue<ScreensGraphic> backScreensQueue;
    private Queue<ScreensGraphic> aheadScreensQueue;

    public SetupView(Controller controller) {
        backScreensQueue = new LinkedList<>();
        aheadScreensQueue = new LinkedList<>();

        PlatformImpl.startup(() -> {
        });

        this.controller = controller;
        this.sceneSetting = new SceneSetting(controller);
        this.loginGraphic = new LoginGraphic(sceneSetting, controller);
        controller.attachUI(ScreensGraphic.LOGIN, loginGraphic);
        this.singupGraphic = new SingupGraphic(sceneSetting, controller);
        controller.attachUI(ScreensGraphic.SINGUP, singupGraphic);

        this.singupPopUpGraphic = new SingupDialogGraphic(sceneSetting, controller);
        controller.attachUI(ScreensGraphic.DIALOGSINGUP, singupPopUpGraphic);

        this.homeGraphic = new HomeGraphic(sceneSetting, controller, this);
        controller.attachUI(ScreensGraphic.HOME, homeGraphic);

        this.userGraphic = new UserGraphic(sceneSetting, controller, this);
        controller.attachUI(ScreensGraphic.USER, userGraphic);

        Platform.runLater(() -> {
            try {
                Stage primaryStage = new Stage();
                primaryStage.setTitle("Dress Me Fast");
                sceneSetting.start(primaryStage);
            } catch (Exception e) {
                System.out.println("Unable to load graphic environment.");
                e.printStackTrace();
            }
            loginGraphic.show();
        });
    }

    /**
     * 
     * @param screen to put in the back queue
     */
    public void addScreenBack(final ScreensGraphic screen) {
        if (screen != null) {
            backScreensQueue.add(screen);
        }
    }

    /**
     * 
     * @param screen to put in the ahead queue
     */
    public void addScreenAhead(final ScreensGraphic screen) {
        if (screen != null) {
            aheadScreensQueue.add(screen);
        }
    }

    /**
     * 
     * @return the last back screen
     */
    public ScreensGraphic getScreenBack() {
        return backScreensQueue.poll();
    }

    /**
     * 
     * @return the last ahead screen
     */
    public ScreensGraphic getScreenAhead() {
        return aheadScreensQueue.poll();
    }
    
    public boolean haveBackQueue(){
        return !backScreensQueue.isEmpty();
    }
    
    public boolean haveAheadQueue(){
        return !aheadScreensQueue.isEmpty();
    }
}
