package stack_with_linkedList;

public class Stack {

	private Node top;

	// constructors & getters & setters:
	public Stack(String addME) {
		Node top = new Node(addME);
		this.top = top;
	}

	public Stack() {
	}

	public Node getTop() {
		return top;
	}

	public void setTop(Node top) {
		this.top = top;
	}

	public void add(String addMe) {
		Node newNode = new Node(addMe);
		if (top == null) {
			top = newNode;
		} else {

			newNode.setNext(top);
			top = newNode;
		}

	}

	public void remove() {
		Node temp = top.getNext();
		top = null;

		top = temp;
	}

	public void displayContent() {

		Node temp = top;

		while (temp != null) {
			System.out.print(temp.getData() + " ---> ");
			temp = temp.getNext();
		}

		System.out.println("null\n");
	}

}
