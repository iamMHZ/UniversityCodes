package MyLinkList;

public class LinkList {

	private Node head;
	private int size = 0;

//	public LinkList(Node first) {
//		this.first = first;
//	}

	public void addToFront(String front) {
		Node node = new Node(front);
		node.setNext(head);
		head = node;
		size++;

	}

	public void addLast(String last) {
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

	public void addNext(String x, String addnext) {

		Node node = new Node(x);
		Node addNextToMe = new Node(addnext);

		Node search = search(addnext);

		node.setNext(search);
		addNextToMe.setNext(node);
		size++;

	}

	public Node search(String x) {
		if (head == null)
			return null;
		else {
			Node node = head;

			while (!node.getNext().getData().equals(x))
				node = node.getNext();

			return (node.getNext()).getNext();
		}
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

}
