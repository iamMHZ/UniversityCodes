package graph.pureArray;

import java.util.Scanner;
import java.util.Stack;

public class GraphFactory {

	private int[][] graph;
	private Scanner scanner;
	private int numberOfVertices;
	private boolean[] visitedVertices;

	public GraphFactory(Scanner scanner) {
		this.scanner = scanner;

		this.numberOfVertices = scanner.nextInt();
		graph = new int[numberOfVertices][numberOfVertices];

		visitedVertices = new boolean[numberOfVertices];

		ConvertFileToGraph();
	}

	private void ConvertFileToGraph() {
		int read;

		for (int i = 0; i < numberOfVertices; i++) {

			for (int j = 0; j < numberOfVertices; j++) {

				read = scanner.nextInt();
				graph[i][j] = read;

			}

		}

	}

	public void iterative_DFS_Traversal() {

		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		while (!stack.isEmpty()) {

			int v = stack.pop();

			if (visitedVertices[v] == false) {

				visitedVertices[v] = true;

				System.out.print(v + " , ");

				for (int i = 0; i < graph.length; i++) {
					if (graph[v][i] == 1)
						stack.push(i);

				}

			}
		}

	}

	public void printGraph() {

		String result = new String("");

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				result += graph[i][j] + "  ";
			}
			result += "\n";
		}
		System.out.println(result);
	}
}
