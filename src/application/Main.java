package application;

import java.util.Date;

import com.sun.javafx.application.PlatformImpl;

import controller.Controller;
import controller.ControllerImpl;
import controller.authentication.Authentication;
import controller.authentication.AuthenticationImpl;
import javafx.application.Platform;
import javafx.stage.Stage;
import model.CategoriesStatus;
import view.NameOfScreens;
import view.SceneSetting;
import view.dialog.SingupDialogGraphic;
import view.login.LoginGraphic;
import view.singup.SingupGraphic;
public class Main{
         public static void main(String[] args) {
         PlatformImpl.startup(() -> {
         });
        
         SceneSetting setting = new SceneSetting();
         Controller controller = ControllerImpl.getInstance();
         LoginGraphic loginGraphic = new LoginGraphic(setting, controller);
         controller.attachUI(NameOfScreens.LOGIN, loginGraphic);
         SingupGraphic singupGraphic = new SingupGraphic(setting, controller);
         controller.attachUI(NameOfScreens.SINGUP, singupGraphic);
        
         SingupDialogGraphic singupPopUpGraphic = new
         SingupDialogGraphic(setting, controller);
         controller.attachUI(NameOfScreens.DIALOGSINGUP, singupPopUpGraphic);
        
        
         Platform.runLater(() -> {
         try {
         Stage primaryStage = new Stage();
         primaryStage.setTitle("Dress Me Fast");
         setting.start(primaryStage);
         } catch (Exception e) {
         System.out.println("Unable to load graphic environment.");
         e.printStackTrace();
         }
         loginGraphic.show();
         });
   }
}
