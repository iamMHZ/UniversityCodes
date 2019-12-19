package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
 
		Parent parent = FXMLLoader.load(getClass().getResource("/gui/View.fxml"));
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.setTitle("ROURNOMENT");
		stage.show();

	}

}
