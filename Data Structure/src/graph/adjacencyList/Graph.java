package graph.adjacencyList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	private int vertexName;
	private boolean isVisited = false;
	private LinkedList<Graph> adjacentVertecis;

	public Graph(int vertexName) {
		this.vertexName = vertexName;
		adjacentVertecis = new LinkedList<>();
	}

	public void addNeighbor(Graph addMe) {
		adjacentVertecis.add(addMe);
	}

	public void addAllNeighbors(LinkedList<Graph> addME) {
		adjacentVertecis.addAll(addME);
	}

	public int getVertexName() {
		return vertexName;
	}

	public void setVertexName(int vertexName) {
		this.vertexName = vertexName;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public LinkedList<Graph> getAdjacentVertecis() {
		return adjacentVertecis;
	}

	public void setAdjacentVertecis(LinkedList<Graph> adjacentVertecis) {
		this.adjacentVertecis = adjacentVertecis;
	}

	public static String bfs(Graph start) {
		Queue<Graph> queue = new LinkedList<>();
		String result = "";

		queue.add(start);
		start.setVisited(true);

		while (!queue.isEmpty()) {
			start = queue.remove();
			result += start.getVertexName() + " , ";
			for (Graph graph : start.adjacentVertecis) {
				if (graph.isVisited == false) {
					queue.add(graph);
					graph.setVisited(true);
				}

			}

		}

		return result;

	}

	public static String dfs(Graph start) {
		String result = "";
		Stack<Graph> stack = new Stack<>();

		stack.push(start);

		while (!stack.isEmpty()) {

			for (Graph graph : start.getAdjacentVertecis()) {
				if (graph.isVisited == false) {
					stack.push(graph);
					graph.setVisited(true);
					result += graph.getVertexName() + ",";
				}
			}
			start.setVisited(true);
			start = stack.pop();

		}

		return result;
	}

}
