package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

	@FXML
	private TextField textfieldInput;

	@FXML
	private Button btnStart;

	@FXML
	private Button btnStop;

	@FXML
	void onClick(ActionEvent event) {

		if (event.getSource() == btnStart) {
			int queenNumbers = Integer.valueOf(textfieldInput.getText());
			
			
			Runnable runnable = new Runnable() {

				@Override
				public void run() {
					Queens queens = new Queens();
					int[] positions = new int[queenNumbers];
					queens.placeQueens(positions, 0);
					
					
				}
			};

			Thread thread = new Thread(runnable);
			thread.start();
			
			
			textfieldInput.clear();

		} else {
			System.exit(0);

		}

	}

}
