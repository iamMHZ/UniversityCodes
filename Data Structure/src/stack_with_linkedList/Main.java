package stack_with_linkedList;

public class Main {

	public static void main(String[] args) {
		Stack stack = new Stack();

		stack.add("MHZ");
		stack.add("x");
		stack.add("y");
		stack.add("z");

		stack.displayContent();

		stack.remove();
		stack.remove();
		stack.remove();

		stack.add("MHZ is the best");
		stack.add("MHZ loves F12");

		stack.displayContent();
	}

}
