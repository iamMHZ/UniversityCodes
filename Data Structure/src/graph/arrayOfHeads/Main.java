package graph.arrayOfHeads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File file = new File("D:\\Programming\\Files\\graph.txt");

		try {
			Scanner scanner = new Scanner(file);
			Graph graph = new Graph(scanner);
			graph.printGraph();
		} catch (FileNotFoundException e) {
			System.err.println("\tEXCEPTION happened while accesing file\n\n\n");
			e.printStackTrace();
		}

	}

}
