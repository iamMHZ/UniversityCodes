package graph.array;

public class GraphNode {

	private int data =0;
	private boolean visited = false;

	public GraphNode(int data) {
		this.data = data;
	}
	
	public GraphNode() {
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
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + (visited ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GraphNode other = (GraphNode) obj;
		if (data != other.data)
			return false;
		if (visited != other.visited)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ""+data ;
	}
	
	
	

}
