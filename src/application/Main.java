package application;
	
import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main /*extends Application*/ {
	public static void main(String[] args){
		Controller cont = ControllerImpl.getInstance();
		System.out.println(cont.singUp("pop", "palla"));
	}
	
	/*@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	*/
}

