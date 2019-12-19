package graph.adjacencyList;

public class Main {

	public static void main(String[] args) {

		Graph root = new Graph(0);
		Graph a1 = new Graph(1);
		Graph a2 = new Graph(2);
		Graph a3 = new Graph(3);
		Graph a4 = new Graph(4);

		root.addNeighbor(a1);
		root.addNeighbor(a2);
		root.addNeighbor(a4);

		a1.addNeighbor(a2);
		a1.addNeighbor(a3);
		a1.addNeighbor(root);

		String bfs = Graph.bfs(root);

		System.out.println("BFS: " + bfs);

		String dfs = Graph.dfs(root);
		System.out.println("\nDFS: " + dfs);
	}

}
