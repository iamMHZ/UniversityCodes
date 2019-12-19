package graph.linkedList;

public class HeadNode {

	private HeadNode downHead;
	private boolean visited = false;
	private Node firstLink;
	private int number;

	public HeadNode(int number) {
		this.number = number;
	}

	public HeadNode(HeadNode down, int number) {
		this.downHead = down;
		this.number = number;
	}

	public void addDown(HeadNode down) {

		if (downHead == null)
			down = downHead;

		HeadNode temp = downHead;

		while (temp.getDownHead() != null)
			temp = temp.getDownHead();

		temp.setDownHead(down);
	}

	public void addLink(Node addMe) {

		if (firstLink == null)
			firstLink = addMe;
		else {
			Node temp = firstLink;
			while (temp.getNext() != null)
				temp = temp.getNext();

			temp.setNext(addMe);
		}

	}

	public HeadNode goToHeadNode(int number) {
		HeadNode temp = this;

		while (temp != null) {
			if (temp.getNumber() == number)
				return temp;
			temp = temp.getDownHead();
		}

		return null;
	}

	public HeadNode getDownHead() {
		return downHead;
	}

	public void setDownHead(HeadNode down) {
		this.downHead = down;
	}

	public Node getFirstLink() {
		return firstLink;
	}

	public void setFirstLink(Node graphNode) {
		this.firstLink = graphNode;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
