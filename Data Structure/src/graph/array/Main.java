package graph.array;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		File file = new File("D:\\Programming\\Files\\graph.txt");
		Scanner scanner = new Scanner(file);

		GraphFactory factory = new GraphFactory(scanner);

//		Stream.of(graphArray).forEach((a) -> System.out.print(a + "\t"));

		System.out.println(factory.printArray() + "\n\n");
		
//
//		Queue<Integer> bfsQueue = factory.bfs();
//
//		for (Integer integer : bfsQueue) {
//			System.out.print(integer + "\t");
//		}
//		
//		
//		factory.addVertex();
//		System.out.println("\n\n"+factory.printArray() + "\n\n");
//		

//		
//		graph.implementdQueueForGraph.Queue arrayQueue = factory.bfsPrinting();
//		arrayQueue.print();
//
//		LinkList list = factory.bfWithList();
//		list.Print();
		
		System.out.println(factory.dfs(0));
		System.out.println("\n\n");
		System.out.println(factory.BFS(0));
		

		System.out.println("\nDone");

		scanner.close();
	}
}
