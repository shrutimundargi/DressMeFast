package application;
	
import com.sun.javafx.application.PlatformImpl;

import controller.Controller;
import controller.ControllerImpl;
import view.SceneSetting;
import view.login.LoginGraphic;


public class Main{
    /*test*/
	/*public static void main(String[] args){
		Controller cont = ControllerImpl.getInstance();
		System.out.println(cont.signUp("pop", "palla"));
		System.out.println(cont.signUp("pop", "palla"));
		System.out.println(cont.signUp("ipop", "palla"));
		System.out.println(cont.signUp("ipeop", "palla"));
		System.out.println(cont.signUp("ipeop", "palla"));
		System.out.println(cont.signUp("ipoyp", "palla"));
		
		System.out.println(cont.checkLogin("pop", "palla"));
		System.out.println(cont.checkLogin("ipop", "palla"));
		System.out.println(cont.checkLogin("ipeop", "palla"));
		System.out.println(cont.checkLogin("ipoyp", "palla"));
	}*/

	public static void main(String[] args) {
		 PlatformImpl.startup(() -> {
	        });
		 SceneSetting setting = new SceneSetting();
		 Controller controller = ControllerImpl.getInstance();
		 LoginGraphic loginGraphic = new LoginGraphic(setting, controller);
	}
	
}

