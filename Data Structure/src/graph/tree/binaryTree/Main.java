package graph.tree.binaryTree;

public class Main {

	public static void main(String[] args) {
		// process of creating our tree:

//		 
//        	1 
//    	 /       \ 
// 		 2         3 
//		/   \       /    \ 
//		4    null   null  5 
//		 				/  \ 
//		 				6  7
//		 				 
//

		BTreeNode node4 = new BTreeNode(4);
		BTreeNode node6 = new BTreeNode(6);
		BTreeNode node7 = new BTreeNode(7);
		BTreeNode node5 = new BTreeNode(5, node6, node7);
		BTreeNode node2 = new BTreeNode(2, node4, null);
		BTreeNode node3 = new BTreeNode(3, null, node5);

		BTreeNode root = new BTreeNode(1, node2, node3);

		BinaryTree binaryTree = new BinaryTree(root);

//		System.out.println(binaryTree);

//		System.out.print("Iterative preorder:  ");
//		binaryTree.preorder();
//		
//		System.out.print("Recersive inorder:  ");
//		binaryTree.recursivePreorder(root);
//		
//		System.out.print("\nIterative inorder:  ");
//		binaryTree.inorder();
//
//		System.out.print("\nIterative inorder algorithm with O(n^2) :  ");
//		binaryTree.inorder2();
//
//		System.out.print("\nRecursive inorder:  ");
//		binaryTree.recersiveInorder(root);
//		
//		System.out.print("Iterative Postorder:  ");
//		binaryTree.postorder();
//		
//		System.out.print("\nRecursive Postorder: ");
//		binaryTree.recursivePostorder(root);
//		
//		System.out.print("\nLevel Order:  ");
//		binaryTree.levelOrder();
//		
//		System.out.println(binaryTree);
//		
//		binaryTree.sawpLeftToRight();
//		
//		System.out.println(binaryTree);
//		
//		
//		
//		BTreeNode node6_2 = new BTreeNode(6);
//		BTreeNode node7_2 = new BTreeNode(7);
//		BTreeNode node5_2= new BTreeNode(5, node6_2, node7_2);
//		BTreeNode node2_2 = new BTreeNode(2, null, null);
//		BTreeNode node3_2 = new BTreeNode(3, null, node5_2);
//		BTreeNode root_2 = new BTreeNode(1, node2_2, node3_2);
//
//		BinaryTree binaryTree2 = new BinaryTree(root_2);
//		
//		BinaryTree binaryTree3 = new BinaryTree(root);
//		
//		System.out.println(binaryTree.isEqualWith(binaryTree2));
//		System.out.println();
//		System.out.println(binaryTree.isEqualWith(binaryTree3));
//		binaryTree.inorder();
	}

}
