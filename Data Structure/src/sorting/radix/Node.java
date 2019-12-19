package sorting.radix;

public class Node {

	private String data;
	private Node next;

	public Node(String data) {
		this.data = data;
	}

	public void add(String addMe) {
		Node newNode = new Node(addMe);

		if (next == null)
			next = newNode;
		else {
			Node temp = next;

			while (temp.getNext() != null)
				temp = temp.getNext();

			temp.next = newNode;
		}

	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

}
