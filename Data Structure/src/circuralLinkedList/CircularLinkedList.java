package circuralLinkedList;

public class CircularLinkedList {

	private Node first;
	private Node last;

	public CircularLinkedList(String data) {
		Node first = new Node(data);
		this.first = first;
		last = first;
		last.setNext(first);
		this.first.setNext(last);
	}

	public CircularLinkedList() {

	}

	public void add(String data) {
		Node addMe = new Node(data);

		if (isEmpty()) {
			this.first = addMe;
			last = addMe;
			last.setNext(addMe);
			this.first.setNext(last);
		} else {

			addMe.setNext(first);
			last.setNext(addMe);
			last = addMe;
		}

	}

	public boolean isEmpty() {
		if (first == null)
			return true;

		return false;
	}

	public void print() {
		
		Node temp = first.getNext();

		System.out.print(first.getData() + " ");

		while (!temp.getData().equals(first.getData())) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
	}
}
