package graph.arrayOfHeads;

public class Node {

	private int vertxName;
	private Node next;

	public Node(int vertexName) {
		this.vertxName = vertexName;
	}

	public int getValue() {
		return vertxName;
	}

	public void setValue(int value) {
		this.vertxName = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "" + vertxName;
	}

}
