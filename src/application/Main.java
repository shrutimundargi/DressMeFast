package application;

import controller.Controller;
import controller.ControllerImpl;
import controller.user.UserController;
import controller.user.UserControllerImpl;
import javafx.application.Platform;
import javafx.stage.Stage;
import model.enumerations.Category;
import view.SceneSetting;
import view.ScreensGraphic;
import view.SetupView;
public class Main{
         public static void main(String[] args) {

         final Controller controller =  ControllerImpl.getInstance();
         SetupView setUp = new SetupView(controller);
   }
}
