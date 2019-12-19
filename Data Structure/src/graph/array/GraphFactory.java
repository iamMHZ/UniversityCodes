package graph.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GraphFactory {

	private Scanner scanner;
	private GraphNode[][] graph;

	public GraphFactory(Scanner scanner) {
		this.scanner = scanner;
		ConvertFileToGraph();
	}

	
	private ArrayList<Integer> visitedVertices = new ArrayList<>();
	public String BFS(int start) {
		Stack<Integer> stack = new Stack<>();

		String result = null;

		stack.push(start);
		result = start + "  ";
		visitedVertices.add(start);

		while (!stack.isEmpty()) {

			int poped = stack.pop();

			for (int i = 0; i < graph.length; i++) {
				boolean condition = visitedVertices.contains(i);
				int data = graph[poped][i].getData();
				if (condition == false && data == 1) {
					stack.push(i);

					result += i + "  ";

					visitedVertices.add(i);

					break;
				}

			}
		}

		return result;

	}

	// Wrong bfs
	// its not working because it can not put vertices in visited mood correctly
	// so that i used visitedVertices
	public String dfs(int start) {
		Stack<Integer> stack = new Stack<>();

		String result = new String("");

		stack.push(start);

		while (!stack.isEmpty()) {

			int poped = stack.pop();

			for (int i = 0; i < graph.length; i++) {
				if (graph[poped][i].isVisited() == false) {
					stack.push(i);

					result += i + "  ";

					graph[poped][i].setVisited(true);
					graph[i][poped].setVisited(true);
				}
			}
		}

		return result;

	}

	private void ConvertFileToGraph() {
		int read;
		try {

			int vertices = scanner.nextInt();
			graph = new GraphNode[vertices][vertices];

			for (int i = 0; i < vertices; i++) {

				for (int j = 0; j < vertices; j++) {

					read = scanner.nextInt();
					graph[i][j] = new GraphNode(read);

				}

			}

		} catch (Exception e) {
			System.err.println("\n\n EXCEPTION IN CLASSS graph.array.GraphFactory\n\n\n");
		} finally {
			scanner.close();
		}

	}

	// this method just does the iteration:
	public Queue<Integer> bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		graph[0][0].setVisited(true);
		int start = 0;

		while (!queue.isEmpty()) {
			start = queue.remove();
			for (int i = 0; i < graph.length; i++) {
				if (graph[start][i].getData() == 1 && graph[start][i].isVisited() == false) {
					graph[start][i].setVisited(true);
					queue.add(i);
				}
			}

		}

		return queue;
	}

	public void addVertex() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the relationls of new vertex with other vertises\na numbers between 0 to "
				+ (graph.length - 1) + "\nor Enter no to terminate the while loop\n: ");
		GraphNode[][] newGraph = new GraphNode[graph.length + 1][graph.length + 1];

		for (int i = 0; i < newGraph.length; i++) {

			for (int j = 0; j < newGraph.length; j++) {
				if (j == newGraph.length - 1 || i == newGraph.length - 1)
					newGraph[i][j] = new GraphNode();
				else
					newGraph[i][j] = graph[i][j];
			}
		}

//		System.arraycopy(graph, 0, newGraph, 0, graph.length + graph.length);

		while (true) {

			System.out.print("Enter: ");
			String x = scanner.next();

			if (x.equalsIgnoreCase("no"))
				break;
			int number = Integer.parseInt(x);

			newGraph[newGraph.length - 1][number] = new GraphNode(1);
			newGraph[number][newGraph.length - 1] = new GraphNode(1);
		}

		graph = newGraph;

		scanner.close();
	}

	public void removeVertex(int remove) {
		GraphNode[][] newGraph = new GraphNode[graph.length][graph.length];

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				if (j == remove || i == remove)
					continue;

			}
		}

	}

//	@SuppressWarnings("static-access")
//	public graph.implementdQueueForGraph.Queue bfsPrinting() {
//		graph.implementdQueueForGraph.Queue queue = new graph.implementdQueueForGraph.Queue(graph.length);
//
//		queue.add(0);
//		graph[0][0].setVisited(true);
//		int start = 0;
//
//		do {
//
//			start = Integer.valueOf(queue.peekFrom());
//
//			for (int i = 0; i < graph.length; i++) {
//				if (graph[start][i].getData() == 1 && graph[start][i].isVisited() == false) {
//					graph[start][i].setVisited(true);
//					queue.add(0);
//					queue.incrementNumberOfCalls();
//				}
//			}
//
//		}while(queue.getNumberOfcallsToClass() < graph.length);
//
//		return queue;
//
//	}

	// using liked list in bfs iteration :
//	public LinkList bfWithList() {
//		LinkList list = new LinkList();
//
//		int i = 0;
//		list.addLast(i);
//		graph[0][0].setVisited(true);
//
//		for (int k = 0; k < graph.length; k++) {
//
//			i = list.peek().getData();
//
//			for (int j = 0; j < graph.length; j++) {
//
//				if (graph[k][j].getData() == 1 && graph[k][j].isVisited() == false) {
//					list.addLast(j);
//					graph[k][j].setVisited(true);
//					graph[j][k].setVisited(true);
//				}
//			}
//
//		}
//
//		return list;
//
//	}

	public void visit(int i) {

	}

	public String printArray() {

		String result = new String("");

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				result += graph[i][j].getData() + "  ";
			}
			result += "\n";
		}
		return result;
	}

}
