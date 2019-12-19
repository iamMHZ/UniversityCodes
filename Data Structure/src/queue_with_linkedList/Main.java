package queue_with_linkedList;

public class Main {

	public static void main(String[] args) {

		Queue queue = new Queue("20");

		queue.add("1");
		queue.add("2");
		queue.add("3");
		queue.add("4");

		queue.displayContent();

		queue.remove();

		queue.displayContent();
		
		
	}

}
