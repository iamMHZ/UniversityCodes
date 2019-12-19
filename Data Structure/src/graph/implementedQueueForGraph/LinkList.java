package graph.implementedQueueForGraph;

public class LinkList {

	private Node head;
	private int size = 0;

	private int numberOfCalls = 0;

//	public LinkList(Node first) {
//		this.first = first;
//	}

	public void addToFront(int front) {
		Node node = new Node(front);
		node.setNext(head);
		head = node;
		size++;

	}

	public void addLast(int last) {
		Node node = new Node(last);
		if (head == null) {
			head = node;
		} else {
			Node next = head;
			while (next.getNext() != null) {
				next = next.getNext();
			}

			next.setNext(node);
			size++;
		}
	}

	public void addNext(int x, int addnext) {

		Node node = new Node(x);
		Node addNextToMe = new Node(addnext);

		Node search = search(addnext);

		node.setNext(search);
		addNextToMe.setNext(node);
		size++;

	}

	public Node search(int x) {
		if (head == null)
			return null;
		else {
			Node node = head;

			while (node.getNext().getData() != x)
				node = node.getNext();

			return (node.getNext()).getNext();
		}
	}

	public Node peek() {

		Node node = head;
		int i = 0;

		while (i < numberOfCalls && node.getNext() != null) {
			node = node.getNext();
			i++;
		}

		numberOfCalls++;
		return node;
	}

	public void Print() {
		Node n = head;

		while (n != null) {
			System.out.print(n.getData() + " -> ");
			n = n.getNext();
		}
		System.out.print("null");
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		Node n = head;

		String result = "";
		while (n != null) {
			result += n.getData() + " -> ";
			n = n.getNext();
		}
		result += "null";

		return result;
	}

}
