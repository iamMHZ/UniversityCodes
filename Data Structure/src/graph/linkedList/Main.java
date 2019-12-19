package graph.linkedList;

import java.io.File;

import queue_with_linkedList.Queue;

public class Main {

	public static void main(String[] args) {

		File file = new File("D:\\Programming\\Files\\graph.txt");
		Graphfactory graphfactory = new Graphfactory(file);
		Graph graph = graphfactory.ConvertFileToGraph();
		graph.print();

		System.out.println("\n\n");

		Queue bfs = graph.bfs();
		bfs.displayContent();

	}
}
