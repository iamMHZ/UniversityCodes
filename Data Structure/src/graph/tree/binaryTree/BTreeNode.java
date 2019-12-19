package graph.tree.binaryTree;

public class BTreeNode {

	private int data;
	private BTreeNode left;
	private BTreeNode right;
	private boolean visited = false;
	

	// constructor for a node that has both of its children:
	public BTreeNode(int data, BTreeNode left, BTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	// constructor for a node that has no child (leaf):
	public BTreeNode(int data) {
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

	public BTreeNode getLeft() {
		return left;
	}

	public BTreeNode getRight() {
		return right;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void setLeft(BTreeNode left) {
		this.left = left;
	}

	public void setRight(BTreeNode right) {
		this.right = right;
	}

//	@Override
//	public String toString() {
//		return "" + data;
//	}

	@Override
	public String toString() {
		return " [" + data + "] " + " left= " + left + " right= " + right + "\n";
	}

}
