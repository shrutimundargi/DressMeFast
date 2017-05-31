package view.general;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;

/**
 * 
 * Interface implemented from the class ProgramUIImpl that is extended from all
 * the classes that they manage the standard screens (standard menu and the
 * queue page).
 *
 */
public interface ProgramUI {

    /**
     * Permit to set the color of the arrow of the page queue if the are page in
     * the specific queue.
     */
    void setupColorButtonsBH();

    /**
     * Method that permit to memorize in the back queue the specific page and it
     * need to be call only when you switch to another page.
     * 
     * @param futureScreen
     *            is the future screen we wont to change
     */
    void addScreenBack(ScreensGraphic futureScreen);

    /**
     * Pressing of the button HOME in the standard menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    void goHome(ActionEvent event);

    /**
     * Pressing of the button BRAND in the standard menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    void goBrand(ActionEvent event);

    /**
     * Pressing of the button ADD DRESS in the standard menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    void goAddDress(ActionEvent event);

    /**
     * Pressing of the button FAVORITE in the standard menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    void goFavorite(ActionEvent event);

    /**
     * Pressing of the button OUTFITS in the standard menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    void goOutfits(ActionEvent event);

    /**
     * Pressing of the button SIZE in the standard menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    void goSize(ActionEvent event);

    /**
     * Pressing of the button CATEGORY in the standard menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    void goCategory(ActionEvent event);

    /**
     * Pressing of the button USER in the standard menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    void goUser(ActionEvent event);

    /**
     * Pressing of the button BACK ( < ) in the TOP menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    void goBack(ActionEvent event);

    /**
     * Pressing of the button AHEAD ( > ) in the TOP menu.
     * 
     * @param event
     *            javafx.scene.control.Button has been fired
     */
    void goAhead(ActionEvent event);

    /**
     * 
     * @return the instance of the SceneSetting <i>enviorment</i>.
     */
    SceneSetting getSceneSetting();

    /**
     * 
     * @return the instance of the Controller.
     */
    Controller getController();

    /**
     * 
     * @return the instance of the SetupView.
     */
    SetupView getSetupView();

    /**
     * 
     * @return the instance of the ScreensGraphic.
     */
    ScreensGraphic getScreensGraphic();

    /**
     * 
     * @return the button btnHome of the standard menu.
     */
    Button getBtnHome();

    /**
     * 
     * @return the button btnBrand of the standard menu.
     */
    Button getBtnBrand();

    /**
     * 
     * @return the button btnAdd of the standard menu.
     */
    Button getBtnAdd();

    /**
     * 
     * @return the button btnFavorite of the standard menu.
     */
    Button getBtnFavorite();

    /**
     * 
     * @return the button btnOutfits of the standard menu.
     */
    Button getBtnOutfits();

    /**
     * 
     * @return the button btnSize of the standard menu.
     */
    Button getBtnSize();

    /**
     * 
     * @return the button btnCategory of the standard menu.
     */
    Button getBtnCategory();

    /**
     * 
     * @return the button btnUser of the standard menu.
     */
    Button getBtnUser();

    /**
     * Reset all component of the screen.
     */
    void resetAllComponent();

    /**
     * Return to the top of the ScrollPane.
     */
    void returnTopPane();

}
