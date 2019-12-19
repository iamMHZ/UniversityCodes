package queue;

public class ArrayQueue {

	private int front = 0;
	private int back = 0;
	private String[] queue;
	

	public ArrayQueue(int capacity) {
		queue = new String[capacity];
	}

	public void add(String data) {
		if (back == queue.length) {

			String[] newQueue = new String[2 * queue.length];

			System.arraycopy(queue, 0, newQueue, 0, queue.length);
			queue = newQueue;
		}

		queue[back] = data;
		back++;

	}

	public String remove() {

		if (getSize() == 0) {
			System.out.println("QUEUE IS EMPTY");
			return null;
		}

		String removed = queue[front];
		queue[front] = null;
		front++;

		if (getSize() == 0) {

			front = 0;
			back = 0;
		}

		return removed;

	}

	/// this method is used in class graph.array.GraphFactory:
	// to pick after a specific place in our queue
	// and it is used in bfsPrinting algorithm:
	private static int numberOfcallsToClass = 0;

	public String peekFrom() {
		return queue[numberOfcallsToClass];
	}
	
	public void incrementNumberOfCalls() {
		numberOfcallsToClass++;
	}

	public int getSize() {
		return front - back;
	}
	
	public  boolean isFull() {
		if(back == queue.length)
			return true;
		return false;
	}

	public boolean isEmpty() {

		if (back == 0)
			return true;

		return false;
	}

	public void print() {

		for (int i = front; i < back; i++) {
			System.out.print(queue[i] + " ~ ");
		}

		System.out.println("\n\n");

	}
}
