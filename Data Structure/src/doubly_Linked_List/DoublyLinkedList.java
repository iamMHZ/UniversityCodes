package doubly_Linked_List;

public class DoublyLinkedList {

	private Node head;
	private Node tail;
	private int size = 0;

	// constructor:
	public DoublyLinkedList() {
	}

	public DoublyLinkedList(String data) {
		Node node = new Node(data);

		head = node;
		tail = head;

		size++;
	}

	// ADD methods:
	public void addToEnd(String data) {
		Node node = new Node(data);

		if (isEmpty()) {
			head = node;
			tail = head;

		} else {

			node.setBefore(tail);
			tail.setAfter(node);
			tail = node;

		}

		size++;

	}

	public void addAfter(String whatToAdd, String whereToAdd) {
		Node node = new Node(whatToAdd);

		Node searched = search(whereToAdd);

		if (searched == null) {
			System.out.println("Not found...");
			return;
		}

		Node afterSearch = searched.getAfter();

		searched.setAfter(node);
		node.setBefore(searched);

		node.setAfter(afterSearch);
		afterSearch.setBefore(node);

		size++;
	}

	public void addToFront(String data) {
		Node node = new Node(data);

		node.setAfter(head);

		if (isEmpty()) {
			tail = node;
		} else {
			head.setBefore(node);
		}
		head = node;
		size++;
	}

	// search method :
	public Node search(String search) {
		Node node = new Node(search);
		Node first = head;

		while (first != null) {
			if (first.getData().equals(node.getData()))
				return first;

			first = first.getAfter();
		}

		return null;
	}

	// remove methods:
	public void removeFromFront() {
		if (isEmpty()) {
			return;
		} else if (isEmpty() || size < 2) {
			head = null;
			size--;
			return;
		}
//		Node temp = head.getAfter();
//
//		head = null;
//		head = temp;

		head = head.getAfter();
		size--;

	}

	public void removeFromEnd() {

		if (isEmpty()) {
			return;
		} else if (isEmpty() || size < 2) {
			head = null;
			size--;
			return;
		}

		Node temp = tail.getBefore();
		temp.setAfter(null);
		tail = temp;
		size--;
	}

	public boolean isEmpty() {
		if (head == null)
			return true;

		return false;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public void print() {
		Node node = head;
		while (node != null) {
			System.out.print(node + " <=> ");
			node = node.getAfter();
		}
		System.out.println("null\n");
	}

}
