package graph.weightedGraph.linked;

public class Node {

	private int vertexName;
	private int weight;

	private Node next;
	private boolean visited = false;

	public Node(int weight, int vertexName) {
		this.weight = weight;
		this.vertexName = vertexName;
	}

//	public void add(Node addMe) {
//		
//	}

	public int getWeight() {
		return weight;
	}

	public int getVertexName() {
		return vertexName;
	}

	public void setVertexName(int vertexName) {
		this.vertexName = vertexName;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "" + vertexName + " (" + weight + ")";
	}

}
