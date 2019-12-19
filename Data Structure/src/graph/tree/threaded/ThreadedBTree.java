package graph.tree.threaded;

import java.util.ArrayList;

public class ThreadedBTree {

	private Node root;
	private ArrayList<Node> preorder = new ArrayList<>();
	private ArrayList<Node> inorder = new ArrayList<>();
	private ArrayList<Node> postorder = new ArrayList<>();

	public ThreadedBTree(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void convert_tree_to_inorder_threaded_tree() {
		
		

	}

	private void inorderTraversal(Node start) {
		if (start == null)
			return;

		if (start.getLeft() != null && start.getLeft().isVisited() == false)
			inorderTraversal(start.getLeft());

		System.out.print(start.getData() + " , ");
		inorder.add(start);

		if (start.getRight() != null && start.getRight().isVisited() == false)
			inorderTraversal(start.getRight());

	}

	private void preorderTraversal(Node start) {

		if (start == null)
			return;

		System.out.print(start.getData() + " , ");
		preorder.add(start);

		preorderTraversal(start.getLeft());
		preorderTraversal(start.getRight());

	}

	private void postorderTraversal(Node start) {

		if (start == null)
			return;

		start.setVisited(true);
		if (start.getLeft() != null && start.getLeft().isVisited() == false)
			postorderTraversal(start.getLeft());

		if (start.getRight() != null && start.getRight().isVisited() == false)
			postorderTraversal(start.getRight());

		System.out.print(start.getData() + " , ");
		postorder.add(start);
	}

	public ArrayList<Node> getPreorderTraversalAsAnArrayList() {
		preorder.clear();
		preorderTraversal(root);
		return preorder;
	}

	public ArrayList<Node> getInorderTraversalAsAnArrayList() {
		inorder.clear();
		inorderTraversal(root);
		return inorder;
	}

	public ArrayList<Node> getPostorderTraversalAsAnArrayList() {
		postorder.clear();
		postorderTraversal(root);
		return postorder;
	}

}
