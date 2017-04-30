package application;

import java.util.Date;

import com.sun.javafx.application.PlatformImpl;

import controller.Controller;
import controller.ControllerImpl;
import controller.user.UserController;
import controller.user.UserControllerImpl;
import javafx.application.Platform;
import javafx.stage.Stage;
import model.enumerations.Categories;
import view.SceneSetting;
import view.ScreensGraphic;
import view.dialog.SingupDialogGraphic;
import view.home.HomeGraphic;
import view.login.LoginGraphic;
import view.singup.SingupGraphic;
import view.statistics.StatisticsGraphic;
public class Main{
         public static void main(String[] args) {
         PlatformImpl.startup(() -> {
         });
        
         Controller controller =  ControllerImpl.getInstance();
         SceneSetting sceneSetting = new SceneSetting(controller);
         LoginGraphic loginGraphic = new LoginGraphic(sceneSetting, controller);
         controller.attachUI(ScreensGraphic.LOGIN, loginGraphic);
         SingupGraphic singupGraphic = new SingupGraphic(sceneSetting, controller);
         controller.attachUI(ScreensGraphic.SINGUP, singupGraphic);
        
         SingupDialogGraphic singupPopUpGraphic = new SingupDialogGraphic(sceneSetting, controller);
         controller.attachUI(ScreensGraphic.DIALOGSINGUP, singupPopUpGraphic);
         
         HomeGraphic homeGraphic = new HomeGraphic(sceneSetting, controller);
         controller.attachUI(ScreensGraphic.HOME, homeGraphic);
         
         StatisticsGraphic statisticsGraphic = new StatisticsGraphic(sceneSetting, controller);
         controller.attachUI(ScreensGraphic.STATISTICS, statisticsGraphic);
        
        
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
}
