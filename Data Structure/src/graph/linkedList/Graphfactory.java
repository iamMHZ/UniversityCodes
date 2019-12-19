package graph.linkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graphfactory {

	private File file;

	private Graph graph;

	private HeadNode root = new HeadNode(0);

	public Graphfactory(File file) {
		this.file = file;
	}

	public Graph ConvertFileToGraph() {
		Scanner scanner = null;
		int[][] array;

		try {
			scanner = new Scanner(file);

			int vertices = scanner.nextInt();
			array = new int[vertices][vertices];

			for (int i = 0; i < vertices; i++) {

				for (int j = 0; j < vertices; j++) {

					array[i][j] = scanner.nextInt();

				}

			}

			/// time to create our graph using root:

			HeadNode temp = root;
			for (int i = 0; i < array.length; i++) {

				for (int j = 0; j < array.length; j++) {
					if (array[i][j] == 1) {
						Node addMe = new Node(j);
						temp.addLink(addMe);
					}

				}
				
				if(i+1>=array.length )
					break;

				HeadNode next = new HeadNode(i + 1);
				temp.setDownHead(next);

				temp = next;
			}

			graph = new Graph(root);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return graph;
	}

}
