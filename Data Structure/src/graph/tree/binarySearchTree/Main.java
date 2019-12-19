package graph.tree.binarySearchTree;

public class Main {

	public static void main(String[] args) throws Exception {

		BinarySearchTree binarySearchTree = new BinarySearchTree();

		binarySearchTree.insert(77);
		binarySearchTree.insert(12);
		binarySearchTree.insert(99);
		binarySearchTree.insert(400);
		binarySearchTree.insert(7);
		binarySearchTree.insert(17);

//		binarySearchTree.print();

		binarySearchTree.inorder();
		System.out.println();
		binarySearchTree.recursiveInorder(binarySearchTree.getRoot());
		System.out.println("\n\n" + binarySearchTree.get(77));
//		System.out.println(binarySearchTree.get(1245));

		binarySearchTree.getMin(binarySearchTree.getRoot());
		binarySearchTree.getMax(binarySearchTree.getRoot());

		TreeNode searched = binarySearchTree.search(99);
		System.out.println("Search result: " + searched);

		System.out.println("Height of the tree: " + binarySearchTree.getTreeHeight());

		System.out.println("\n\n");

		// testing delete method:
		binarySearchTree.delete(77);
		binarySearchTree.recursiveInorder(binarySearchTree.getRoot());
	}

}
