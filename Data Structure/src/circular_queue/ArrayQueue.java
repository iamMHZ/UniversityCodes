package circular_queue;

public class ArrayQueue {

	private int front = 0;
	private int back = 0;
	private String[] queue;

	public ArrayQueue(int capacity) {
		queue = new String[capacity];
	}

	public void add(String data) {

		if (isFull() && back - front > 1) {

		}

	}

	public void remove() {

	}

	public boolean isFull() {
		if (queue.length - back == 1) {
			return true;
		}
		return false;
	}
}
