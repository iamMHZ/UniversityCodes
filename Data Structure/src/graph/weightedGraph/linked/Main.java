package graph.weightedGraph.linked;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("D:\\Programming\\Files\\weightedGraph.txt");
		Scanner scanner = new Scanner(file);
		GraphFactory factory = new GraphFactory(scanner);

		factory.printGraph();
		
		String prime = factory.prime();
		System.out.println(prime);
	}

}
