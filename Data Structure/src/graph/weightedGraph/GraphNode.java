package graph.weightedGraph;

public class GraphNode {

	private int nodeNumber;
	private int data;
	private boolean visited = false;

	public GraphNode() {
	}

	public GraphNode(int nodeNumber, int data, boolean visited) {
		this.nodeNumber = nodeNumber;
		this.data = data;
		this.visited = visited;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getNodeNumber() {
		return nodeNumber;
	}

}
