package graph.arrayOfHeads;

public class HeadNode {

	private Node first;
	private int vertexName;

	public HeadNode(int vertexName) {
		this.vertexName = vertexName;

	}

	public HeadNode() {
	}

	public void addVertex(int addME) {
		Node newNode = new Node(addME);

		if (first == null) {
			first = newNode;
		} else {
			Node temp = first;
			while (temp.getNext() != null)
				temp = temp.getNext();

			temp.setNext(newNode);
		}

	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public int getVetexName() {
		return vertexName;
	}

	public void setVetexName(int vetexName) {
		this.vertexName = vetexName;
	}

	@Override
	public String toString() {

		String result = new String();
		Node temp = first;
		result+=""+vertexName+" :: ";
		
		while (temp != null) {
			result += temp + " ~~~> ";
			temp = temp.getNext();
		}

		return result;
	}

}
