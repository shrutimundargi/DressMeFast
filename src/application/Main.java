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
import view.SetupView;
import view.dialog.SingupDialogGraphic;
import view.home.HomeGraphic;
import view.login.LoginGraphic;
import view.singup.SingupGraphic;
import view.user.UserGraphic;
public class Main{
         public static void main(String[] args) {

         final Controller controller =  ControllerImpl.getInstance();
         SetupView setUp = new SetupView(controller);
         controller.userController().signUp("alexx", "11111");
         controller.userController().logout();
   }
}
