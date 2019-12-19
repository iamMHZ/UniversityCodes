package graph.pureArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("D:\\Programming\\Files\\graph.txt");
		Scanner scanner = new Scanner(file);
		
		GraphFactory factory = new GraphFactory(scanner);
		factory.printGraph();
		
		
		factory.iterative_DFS_Traversal();
	}
}
