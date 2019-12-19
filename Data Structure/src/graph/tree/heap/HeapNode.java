package graph.tree.heap;

public class HeapNode {

	private int data;
	private HeapNode parent;
	private HeapNode leftChild;
	private HeapNode rightChild;
	private boolean visited = false;

	public HeapNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public HeapNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(HeapNode leftChild) {
		this.leftChild = leftChild;
	}

	public HeapNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(HeapNode rightChild) {
		this.rightChild = rightChild;
	}

	public boolean getVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
