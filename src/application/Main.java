package application;

import controller.Controller;
import controller.ControllerImpl;
import view.SetupView;
public class Main{
         public static void main(String[] args) {

         final Controller controller =  ControllerImpl.getInstance();
         SetupView setUp = new SetupView(controller);
         controller.userController().signUp("a", "1");
         controller.userController().logout();
   }
}
