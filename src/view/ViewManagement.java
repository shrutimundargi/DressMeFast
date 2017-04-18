package view;

import javafx.application.Application;
import javafx.stage.Stage;
import view.login.LoginGraphic;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class ViewManagement extends Application {
	private Pane root;
	
	public ViewManagement() {
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			root = (Pane) FXMLLoader.load(getClass().getResource("login/Login.fxml"));
			Scene scene = new Scene(root, 1000, 700);
			scene.getStylesheets().add(getClass().getResource("login/Login.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void changeScene(Pane paneToLoad){
		root.getChildren().setAll(paneToLoad);
	}

}
