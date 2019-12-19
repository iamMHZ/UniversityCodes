package graph.tree.threaded;

public class Main {

	public static void main(String[] args) {
		// process of creating our tree:

//		 
//       	1 
//   	 /       \ 
//		 2         3 
//		/   \       /    \ 
//		4    null   null  5 
//		 				/  \ 
//		 				6  7
//		 				 
//

		Node node4 = new Node(4);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node5 = new Node(5, node6, node7);
		Node node2 = new Node(2, node4, null);
		Node node3 = new Node(3, null, node5);

		Node root = new Node(1, node2, node3);

		ThreadedBTree tree = new ThreadedBTree(root);
		tree.getInorderTraversalAsAnArrayList();

	}

}
