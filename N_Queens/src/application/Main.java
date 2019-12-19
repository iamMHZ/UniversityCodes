/**
 * @author Mohammad Hossein Ziaadini
 * 
 * 
 */

package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws IOException {

		Parent parent = FXMLLoader.load(getClass().getResource("/application/View.fxml"));

		Scene scene = new Scene(parent);
		stage.setTitle("Shortest path");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
