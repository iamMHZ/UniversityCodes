package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import application.model.Customer;
import application.model.FileManage;
import application.model.Ticket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Controller {

	private FileManage fileManage = new FileManage();

	private String customersFilePath = FileManage.baseFilePath + "allCustomers.txt";
	private File customersFile = new File(customersFilePath);

	/// for checking whether today is a discount day or not :
	private String discountFilePath = FileManage.baseFilePath + "discountDays.txt";
	private File discountDaysFile = new File(discountFilePath);
	private boolean isDiscount = false;
	private int discountPercentage = 30;
	private int finalTicketPrice;

	private Customer currentCustomer;
//	
	// @FXML
//    private ImageView Img1;

	@FXML
	private AnchorPane rootPane;

	@FXML
	private AnchorPane loginPane;

	@FXML
	private TextField loginUsername;

	@FXML
	private Button logInBtn;

	@FXML
	private Button singUpBtn;

	@FXML
	private PasswordField loginPassword;

	@FXML
	private AnchorPane singUpPane;

	@FXML
	private TextField singInFullName;

	@FXML
	private TextField singInNationalID;

	@FXML
	private TextField singInUsername;

	@FXML
	private Button registerBtn;

	@FXML
	private PasswordField singInPassword;

	@FXML
	private PasswordField singInConfirmPassword;

	@FXML
	private TextField singUpPhoneNumber;

	@FXML
	private TabPane dashboardPane;

	@FXML
	private ListView<String> ticketListView;

	@FXML
	private Button exitBtn;

	@FXML
	private Label customerInfoLable;

	@FXML
	private AnchorPane ticketDate;

	@FXML
	private DatePicker datePicker;

	@FXML
	private ComboBox<String> originCombobox;

	@FXML
	private ComboBox<String> destinationComboBox;

	@FXML
	private Label labelPrice;

	@FXML
	private Button purchaseBtn;

	@FXML
	private Label priceLabel;

	@FXML
	private Label discoutLabel;

	@FXML
	private TextField cancelTicketTextField;

	@FXML
	private Button cancelTicketBtn;

	@FXML
	void onClick(ActionEvent event) {

		if (event.getTarget() == logInBtn) {

			String username = loginUsername.getText();
			String password = loginPassword.getText();

			if (isRegistered(username, password)) {

				refreshScreen(loginPane, dashboardPane);

				System.err.println("Currnt Customer : " + currentCustomer);

				// fill listView with this customer's tickets :
				updateListView();

				setUserInfo();

			} else {
				refreshScreen(loginPane, singUpPane);
			}

		}

		else if (event.getTarget() == registerBtn) {
			register();
			refreshScreen(singUpPane, loginPane);
			System.err.println("Currnt Customer : " + currentCustomer);

		}

		else if (event.getTarget() == singUpBtn) {
			refreshScreen(loginPane, singUpPane);
		}

		else if (event.getTarget() == purchaseBtn) {

			purchaseTicket();

		}

		else if (event.getTarget() == cancelTicketBtn) {

			String cancalId = cancelTicketTextField.getText();

			cancelTicket(cancalId);
		} else if (event.getTarget() == exitBtn) {

			refreshScreen(dashboardPane, loginPane);
		}

	}

	private void setUserInfo() {

		String info = "Name : " + currentCustomer.getFirstName() + " " + currentCustomer.getLastName() + "\n"
				+ "Username : " + currentCustomer.getUsername();

		customerInfoLable.setText(info);
	}

	@FXML
	void comboBoxChanged(ActionEvent event) {
		Random random = new Random();
		int price = random.nextInt(10000);
		if (isDiscount) {
			System.out.println("Real Price : $" + price);
			int discounted = (price * (100 - discountPercentage) / 100);
			price = discounted;
			System.err.println("Price with discount  : " + price);
		} else {
			System.out.println("Price : " + price);
		}

		finalTicketPrice = price;

		priceLabel.setText("Price : $" + String.valueOf(finalTicketPrice));

	}

	@FXML
	public void initialize() {

		// initialize comboBoxes:
		String content = fileManage.getFileContent(new File(FileManage.baseFilePath + "destinations.txt"));
		String[] destinations = content.split("#");
		destinationComboBox.getItems().addAll(destinations);

		content = fileManage.getFileContent(new File(FileManage.baseFilePath + "origins.txt"));
		String[] origins = content.split("#");
		originCombobox.getItems().addAll(origins);

//		checking  if today is a discount day :
		this.isDiscount = ckeckDiscountDay();

		if (this.isDiscount) {
			discoutLabel.setText(
					" Today, there is a "+discountPercentage + "% discount on all tickets " + "\n" );
			System.err.println("Today is a discount day");
		}

	}

	private void updateListView() {

		ticketListView.getItems().clear();

		String customerTickets = fileManage.getFileContent(currentCustomer.getFile());

		if (customerTickets.length() > 0)
			ticketListView.getItems().addAll(customerTickets.split("\n"));
	}

	private void refreshScreen(Node back, Node front) {

		front.toFront();

		back.toBack();

	}

	private boolean isRegistered(String username, String password) {

		try {
			Scanner scanner = new Scanner(customersFile);

			while (scanner.hasNextLine()) {

				String line = scanner.nextLine();

				line = line.trim();
				String[] split = line.split(" ");
				String savedUsername = split[0];
				String savedPassword = split[1];

				if (savedUsername.equals(username) && savedPassword.equals(password)) {

					scanner.close();
					System.out.println("REGISTERED CUSTOMER");

					currentCustomer = new Customer(split[2], split[3], split[4], savedUsername, password, split[5]);

					return true;
				}

			}

			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("UREGISTERED CUNSTOMER");

		return false;
	}

	private void register() {

//		person with one name or two names:
		String firstName, lastName;
		if (singInFullName.getText().split(" ").length > 1) {
			firstName = singInFullName.getText().split(" ")[0];
			lastName = singInFullName.getText().split(" ")[1];
		} else {
			firstName = singInFullName.getText();
			lastName = firstName;
		}

		String password = singInPassword.getText();
		String username = singInUsername.getText();

		String id = singInNationalID.getText();
		String phoneNumber = singUpPhoneNumber.getText();

		currentCustomer = new Customer(firstName, lastName, id, username, password, phoneNumber);

		fileManage.appentToFile(customersFile, currentCustomer.toString());

	}

	private void purchaseTicket() {

		LocalDate date = datePicker.getValue();
		String origin = originCombobox.getValue();
		String destination = destinationComboBox.getValue();

		Random random = new Random();
		int id = random.nextInt(100);
		int price = finalTicketPrice;

		Ticket ticket = new Ticket(origin, destination, date, price, String.valueOf(id));

		this.currentCustomer.addTicket(ticket);

		System.out.println("Ticket : " + ticket);

		updateListView();

//		show alert dialog:
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Result");
		String header = "Purchased successfully";
		alert.setHeaderText(header);

		alert.showAndWait();

	}

	private void cancelTicket(String id) {

		File file = currentCustomer.getFile();

		String content = "";

		Scanner scanner;

//		read all of file except the line that starts with id
//		and then write this new content to file:

		try {
			scanner = new Scanner(file);

			while (scanner.hasNextLine()) {

				String line = scanner.nextLine();
				String ticketID = line.split(" ")[0];
				if (ticketID.trim().equals(id) == false) {
					content += line + "\n";
				} else {
					System.err.println("Ticket " + id + " Canceled");
				}

			}

			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file);

			fileWriter.write(content);
			fileWriter.flush();
			fileWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
//		show alert dialog:
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Result");
		String header = "Canceled successfully";
		alert.setHeaderText(header);

		alert.showAndWait();


		updateListView();

	}

	private boolean ckeckDiscountDay() {

		LocalDate today = LocalDate.now();
		System.out.println("TODAY is : " + today);

//		getting content of discountsDaysFile and comparing it with today if they are equal 
		// this means that today we can have diacount:
		String discountDays = fileManage.getFileContent(this.discountDaysFile);
		String[] split = discountDays.split("\n");

		for (String day : split) {

			String[] splitDate = day.split("-");
			int year = Integer.valueOf(splitDate[0]);
			int month = Integer.valueOf(splitDate[1]);
			int dayOfMonth = Integer.valueOf(splitDate[2]);

			LocalDate date = LocalDate.of(year, month, dayOfMonth);

			if (today.equals(date))
				return true;

		}

		return false;
	}

//	private void loadCustomer(String username) {
//
//		fileManage.getFileContent(customersFile);
//		
//
//	}

}
