package view;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.sun.javafx.application.PlatformImpl;

import controller.Controller;
import javafx.application.Platform;
import javafx.stage.Stage;
import view.add.AddGraphic;
import view.brand.BrandGraphic;
import view.category.CategoryGraphic;
import view.dialog.SignupDialogGraphic;
import view.favorite.FavoriteGraphic;
import view.home.HomeGraphic;
import view.login.LoginGraphic;
import view.outfits.OutfitsGraphic;
import view.signup.SignupGraphic;
import view.size.SizeGraphic;
import view.user.UserGraphic;

/**
 * Initialization of the view and managing of the screen queue.
 *
 */
public class SetupView {

    private Controller controller;
    private SceneSetting sceneSetting;
    private LoginGraphic loginGraphic;
    private SignupGraphic singupGraphic;
    private SignupDialogGraphic singupPopUpGraphic;
    private HomeGraphic homeGraphic;
    private UserGraphic userGraphic;
    private BrandGraphic brandGraphic;
    private AddGraphic addGraphic;
    private FavoriteGraphic favoriteGraphic;
    private OutfitsGraphic outfitsGraphic;
    private SizeGraphic sizeGraphic;
    private CategoryGraphic categoryGraphic;

    private Queue<ScreensGraphic> backScreensQueue;
    private Queue<ScreensGraphic> aheadScreensQueue;
    private final Map<ScreensGraphic, UI> screenUI;

    /**
     * 
     * @param controller
     *            a reference of the instance of the class Controller
     */
    public SetupView(final Controller controller) {
        backScreensQueue = new LinkedList<>();
        aheadScreensQueue = new LinkedList<>();
        screenUI = new HashMap<>();

        PlatformImpl.startup(() -> {
        });

        this.controller = controller;
        this.sceneSetting = new SceneSetting(this);
        this.loginGraphic = new LoginGraphic(sceneSetting, controller);
        screenUI.put(ScreensGraphic.LOGIN, loginGraphic);

        this.singupGraphic = new SignupGraphic(sceneSetting, controller);
        screenUI.put(ScreensGraphic.SINGUP, singupGraphic);

        this.singupPopUpGraphic = new SignupDialogGraphic(sceneSetting, controller);
        screenUI.put(ScreensGraphic.DIALOGSINGUP, singupPopUpGraphic);

        this.homeGraphic = new HomeGraphic(sceneSetting, controller, this);
        screenUI.put(ScreensGraphic.HOME, homeGraphic);

        this.userGraphic = new UserGraphic(sceneSetting, controller, this);
        screenUI.put(ScreensGraphic.USER, userGraphic);

        this.brandGraphic = new BrandGraphic(sceneSetting, controller, this);
        screenUI.put(ScreensGraphic.BRAND, brandGraphic);

        this.addGraphic = new AddGraphic(sceneSetting, controller, this);
        screenUI.put(ScreensGraphic.ADD, addGraphic);

        this.favoriteGraphic = new FavoriteGraphic(sceneSetting, controller, this);
        screenUI.put(ScreensGraphic.FAVORITE, favoriteGraphic);

        this.outfitsGraphic = new OutfitsGraphic(sceneSetting, controller, this);
        screenUI.put(ScreensGraphic.OUTFITS, outfitsGraphic);

        this.sizeGraphic = new SizeGraphic(sceneSetting, controller, this);
        screenUI.put(ScreensGraphic.SIZE, sizeGraphic);

        this.categoryGraphic = new CategoryGraphic(sceneSetting, controller, this);
        screenUI.put(ScreensGraphic.CATEGORY, categoryGraphic);

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
     * @param screenToQueue
     *            to put in the backScreensQueue.
     * @param futureScreen
     *            to help to understand if the User try to switch in a page
     *            already put in the backScreensQueue
     */
    public void addScreenBack(final ScreensGraphic screenToQueue, final ScreensGraphic futureScreen) {
        if (screenToQueue != null && screenToQueue != futureScreen && screenToQueue != backScreensQueue.peek()) {
            backScreensQueue.add(screenToQueue);
        }

        if (futureScreen == backScreensQueue.peek()) {
            backScreensQueue.remove();
        }

        if (futureScreen == aheadScreensQueue.peek()) {
            aheadScreensQueue.remove();
        }
    }

    /**
     * 
     * @param screenToQueue
     *            to put in the aheadScreensQueue.
     * @param futureScreen
     *            to help to understand if the User try to switch in a page
     *            already put in the aheadScreensQueue
     */
    public void addScreenAhead(final ScreensGraphic screenToQueue, final ScreensGraphic futureScreen) {
        if (screenToQueue != null && screenToQueue != futureScreen && screenToQueue != aheadScreensQueue.peek()) {
            aheadScreensQueue.add(screenToQueue);
        }

        if (futureScreen == backScreensQueue.peek()) {
            backScreensQueue.remove();
        }

        if (futureScreen == backScreensQueue.peek()) {
            backScreensQueue.remove();
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

    /**
     * 
     * @return TRUE if the back queue is NOT empty and FALSE if is empty
     */
    public boolean haveBackQueue() {
        return !backScreensQueue.isEmpty();
    }

    /**
     * 
     * @return TRUE if the ahead queue is NOT empty and FALSE if is empty
     */
    public boolean haveAheadQueue() {
        return !aheadScreensQueue.isEmpty();
    }

    /**
     * Permit to get the controller of the specific screen.
     * 
     * @param screen
     *            of the ScreensGraphic
     * @return the UI
     */
    public UI getUI(final ScreensGraphic screen) {
        return screenUI.get(screen);
    }
}
