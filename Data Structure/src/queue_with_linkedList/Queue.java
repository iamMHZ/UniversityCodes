package queue_with_linkedList;

public class Queue {

	private Node front;
	private Node rear;
	// for bfs search it is needed:
	private Node temp = new Node("I am temp node");
	/// use this static property for visit from First:
	private static int numberOfCalls = 0;

	public Queue() {
		front = null;
		rear = null;
	}

	public Queue(String addMe) {
		Node newNode = new Node(addMe);

		front = newNode;
		rear = front;

	}

	public Node getFront() {
		return front;
	}

	public Node getRear() {
		return rear;
	}

	public void add(String addMe) {
		Node newNode = new Node(addMe);

		if (isEmpty()) {
			front = newNode;
			rear = front;

		} else {

			rear.setNext(newNode);
			rear = newNode;

		}

	}

	// this method is used for bfs search in graph.linkedList package:
	public String visitFormFirst() {
		numberOfCalls++;

		temp = front;
		for (int i = 1; i < numberOfCalls && temp.getNext() != null; i++)
			temp = temp.getNext();

		return temp.getData();
	}

	public void remove() {
		if (isEmpty()) {
			System.out.println("Queue is EMPTY");
		} else {

			Node temp = front.getNext();

			front = null;
			front = temp;

		}
	}

	public boolean isEmpty() {
		if (front == null) {
			return true;
		}

		return false;
	}

	public void displayContent() {
		Node temp = front;

		while (temp != null) {
			System.out.print(temp.getData() + "  ::  ");
			temp = temp.getNext();
		}

		System.out.println("null\n");

	}

	public static int getNumberOfCalls() {
		return numberOfCalls;
	}

}
