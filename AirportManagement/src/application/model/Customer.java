package application.model;

import java.io.File;
import java.io.IOException;

public class Customer {

	private String firstName;
	private String lastName;

	private String id;
	String phoneNumber;

	private String username;
	private String password;

	// file for saving tickets
	private File file;

	private FileManage fileManage = new FileManage();

	public Customer(String firstName, String lastName, String id, String username, String password,
			String phoneNumber) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;

		this.username = username;
		this.password = password;

		this.phoneNumber = phoneNumber;

		// creating file for user or loading old one:
		loadFile(username);
	}

	private void loadFile(String username) {
		this.file = new File(FileManage.baseFilePath + "\\customersFiles\\" + username + ".txt");

		try {
			if (file.createNewFile()) {
				System.out.println("FILE for " + username + "Created");

			} else {
				System.out.println("loaded old file for " + username);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getId() {
		return id;
	}

	public void addTicket(Ticket ticket) {

		fileManage.appentToFile(this.file, ticket.toString());

	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return username.trim() + " " + password.trim() + " " + firstName.trim() + " " + lastName.trim() + " "
				+ id.trim() + " " + phoneNumber.trim();
	}

}
