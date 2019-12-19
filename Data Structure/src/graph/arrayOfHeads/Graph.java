package graph.arrayOfHeads;

import java.util.Scanner;

public class Graph {

	private Scanner scanner; // scanner to the file of Graph
	private int numberOfVertices;
	private HeadNode[] heads;

	public Graph(Scanner scanner) {
		this.scanner = scanner;
		numberOfVertices = scanner.nextInt();
		heads = new HeadNode[numberOfVertices];

		// process of generating graph out of File
		for (int i = 0; i < numberOfVertices; i++) {
			heads[i] = new HeadNode(i);
			for (int j = 0; j < numberOfVertices; j++) {
				int read = this.scanner.nextInt();
				if (read != 0) {
					heads[i].addVertex(j);
				}
			}
		}

	}

	public HeadNode[] getGraph() {
		return heads;
	}

	public void printGraph() {
		for (int i = 0; i < heads.length; i++) {
			System.out.println(heads[i]);
		}
	}

}
