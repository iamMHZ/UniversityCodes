package graph.linkedList;

public class Node {

	private boolean visited = false;
	private int data;
	private Node next;

	public Node(int data) {
		this.data = data;
	}

//	public void addNext(T t) {
//		
//		
//	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
