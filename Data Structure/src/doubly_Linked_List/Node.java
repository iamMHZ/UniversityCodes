package doubly_Linked_List;

public class Node {

	private String data;
	private Node after;
	private Node before;

	public Node(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getAfter() {
		return after;
	}

	public void setAfter(Node after) {
		this.after = after;
	}

	public Node getBefore() {
		return before;
	}

	public void setBefore(Node before) {
		this.before = before;
	}

	@Override
	public String toString() {
		return data;
	}

}
