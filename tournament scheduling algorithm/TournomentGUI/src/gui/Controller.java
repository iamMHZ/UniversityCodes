package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.TournomentSchedule;

public class Controller { 
	@FXML
	private TextArea outputTextArea;

	@FXML
	private Button button;

	@FXML
	private TextField numberTextFiled;

	@FXML
	private ProgressIndicator progressBar;

	@FXML
	private Label infoLabel;

	@FXML
	private void onClick(ActionEvent event) {

		String input = numberTextFiled.getText();
		if (input.isEmpty() || isNumber(input) == false) {
			infoLabel.setText("INVALID INPUT TYPE");
		} else {

			infoLabel.setText("");

			HelperThread helperThread = new HelperThread(Integer.valueOf(input), outputTextArea, progressBar);
			Thread thread = new Thread(helperThread);
			thread.start();
			

		}

		numberTextFiled.setText("");

	}

	private boolean isNumber(String input) {

		for (int i = 0; i < input.length(); i++) {

			if (Character.isDigit(input.charAt(i)) == false)
				return false;
		}

		return true;
	}

}

class HelperThread implements Runnable {

	private int numberOfTeams;
	private TextArea outputTextArea;
	private ProgressIndicator progressBar;

	public HelperThread(int numberOfTeams, TextArea output, ProgressIndicator progressBar) {
		this.numberOfTeams = numberOfTeams;
		this.outputTextArea = output;
		this.progressBar = progressBar;
	}

	@Override
	public void run() {
		progressBar.setVisible(true);
		TournomentSchedule schedule = new TournomentSchedule();

		try {
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		schedule.start(numberOfTeams);
		String table = schedule.printTable();
		outputTextArea.setText(table);

		progressBar.setVisible(false);

	}

}