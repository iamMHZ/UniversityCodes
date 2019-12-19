package graph.tree.binarySearchTree;

public class TreeNode {
//	private int counter = 0;
	private int data;
	private TreeNode parent;
	private TreeNode leftChild;
	private TreeNode righChild;
	private boolean visited = false;
	private int nodeHeight;

	public TreeNode(int data) {
		this.data = data;
//		counter++;
	}

	public int getNodeHeight() {
		return nodeHeight;
	}

	public void setNodeHeight(int nodeHeight) {
		this.nodeHeight = nodeHeight;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public TreeNode getRighChild() {
		return righChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public void setRighChild(TreeNode righChild) {
		this.righChild = righChild;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	@Override
	public String toString() {
		if (this.getLeftChild() != null && this.getRighChild() != null)
			return "" + this.data + " ~~~> left: " + this.getLeftChild().getData() + " ~~~> Right: "
					+ this.getRighChild().getData();

		else
			return "" + this.getData();
	}

	// method for calculating the height of a node:
	public int getNodeHeight(TreeNode node) {

		if (node == null)
			return 0;

		int leftHight = getNodeHeight(node.getLeftChild());
		int rightHight = getNodeHeight(node.getRighChild());
		return max(leftHight, rightHight) + 1;

	}

	private int max(int number1, int number2) {

		if (number1 > number2)
			return number1;

		return number2;
	}

	public void insertNode(TreeNode addMe) {

		if (addMe.getData() == data) {
			System.out.println("this implementation doesn't allow you to insert repetitive data");

		} else if (addMe.getData() > data) {

			if (this.getRighChild() != null)
				this.getRighChild().insertNode(addMe);
			else
				this.setRighChild(addMe);
		}

		else if (addMe.getData() < data) {
			if (this.getLeftChild() != null)
				this.insertNode(addMe);
			else
				this.setLeftChild(addMe);

		}
	}

	public TreeNode findAndReturn(int data) {
		if (this == null)
			return null;
		else if (this.data == data)
			return this;

		else if (data > this.data)
			return this.righChild.findAndReturn(data);

		else
			return this.leftChild.findAndReturn(data);

//		else {
//			throw new Exception("NOT FOUND Value...");
//
//		}

	}

}
