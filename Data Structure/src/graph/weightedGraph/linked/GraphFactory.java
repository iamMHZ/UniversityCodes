package graph.weightedGraph.linked;

import java.util.ArrayList;
import java.util.Scanner;

public class GraphFactory {

	private Scanner scanner;
	private Head[] heads;
	private int numberOfVertivces;

	public GraphFactory(Scanner scanner) {
		this.scanner = scanner;
		numberOfVertivces = scanner.nextInt();
		heads = new Head[numberOfVertivces];

		convertFileToGraph();

	}

	private void convertFileToGraph() {

		for (int i = 0; i < heads.length; i++) {
			if (heads[i] == null)
				heads[i] = new Head(i);
			for (int j = 0; j < heads.length; j++) {
				int weight = scanner.nextInt();

				if (weight != 0) {
					if (heads[j] == null) {
						heads[j] = new Head(j);
					}
					if (i < j) {
						heads[j].add(weight, i);
						heads[i].add(weight, j);
					}
				}
			}
		}
	}

	ArrayList<Integer> visitedVertices = new ArrayList<>();

	public String prime() {
		int vertex = -1;
		String result = new String();
		
		for (int i = 0; i < heads.length; i++) {
			Node temp = heads[i].getFirst();
			int minimumWeight = Integer.MAX_VALUE;
			while (temp.getNext() != null) {

				if (temp.getWeight() < minimumWeight && temp.getWeight() > 0 && temp.isVisited() == false) {
					minimumWeight = temp.getWeight();
					vertex = temp.getVertexName();
					temp.setVisited(true);
				}

				temp = temp.getNext();
			}

			if (visitedVertices.contains(vertex) == false) {
				visitedVertices.add(vertex);
				result += vertex +" , ";
			}

		}

		return result;

	}

	public void printGraph() {
		for (int i = 0; i < heads.length; i++) {
			System.out.println(heads[i].toString());
		}
	}

}
