package graph.weightedGraph.linked;

public class Head {

	private Node first;
	private int vertexName;

	public Head(int vertexName) {
		this.vertexName = vertexName;
	}


	public void add(int weight , int vertexName) {
		Node addMe = new Node(weight ,vertexName);

		if (first == null) {
			first = addMe;
		} else {
			Node temp = first;
			while (temp.getNext() != null)
				temp = temp.getNext();

			temp.setNext(addMe);
		}
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public int getVertexName() {
		return vertexName;
	}

	public void setVertexName(int vertexName) {
		this.vertexName = vertexName;
	}

	@Override
	public String toString() {

		String result = new String();
		Node temp = first;
		result += "" + vertexName + " :: ";

		while (temp != null) {
			result += temp + " ~~~> ";
			temp = temp.getNext();
		}

		return result;
	}

}
