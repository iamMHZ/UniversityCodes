package graph.tree.threaded;

public class Node {

	private int data;
	private Node left;
	private Node right;
	private boolean visited = false;

	// constructor for a node that has both of its children:
	public Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	// constructor for a node that has no child (leaf):
	public Node(int data) {
		this.data = data;
	}

	// constructor for a node that has only LEFT child:
//	public BTreeNode(int data, BTreeNode left) {
//		this.data = data;
//		this.left = left;
//	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
