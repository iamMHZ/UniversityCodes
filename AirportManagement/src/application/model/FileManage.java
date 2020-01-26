package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManage {

	// change this path to /resource/files of your project directory
	public static String baseFilePath = "D:\\Programming\\eclipse-workspace\\AirportManagement\\src\\application\\resource\\files\\";

	public void clearFile(File file) {
//		cleaning file with writing "" to it:

		try {
			FileWriter fileWriter = new FileWriter(file);

			fileWriter.write("");
//			saving to disk
			fileWriter.flush();

			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void appentToFile(File file, String data) {

		try {
			FileWriter fileWriter = new FileWriter(file, true);

			fileWriter.write(data + "\n");
//			saving to disk
			fileWriter.flush();

			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getFileContent(File file) {

		String content = "";

		try {
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				content += line + "\n";
			}

			scanner.close();
		} catch (FileNotFoundException e) {

			System.err.println("ERROR opening file" + file.getName());

			e.printStackTrace();
		}

		return content;
	}



}
