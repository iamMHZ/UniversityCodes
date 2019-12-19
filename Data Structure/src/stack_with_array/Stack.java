package stack_with_array;

public class Stack {

	private int[] stack;
	// top holds the position of next element in the stack:
	private int top = 0;

	public Stack(int maxSize) {
		stack = new int[maxSize];
	}

	public void push(int next) {
		if (isFull()) {
			int[] newStack = new int[2 * stack.length];
			System.arraycopy(stack, 0, newStack, 0, stack.length);
			//
			stack = newStack;
		}

		stack[top++] = next;

	}

	public int pop() {
		if (isEmpty()) {
			return -1;
		}

		return stack[--top];
	}

	public int peek() {
		if (isEmpty()) {
			return -1;
		}

		return stack[top - 1];
	}

	public boolean isFull() {
		if (top == stack.length)
			return true;
		return false;
	}

	public boolean isEmpty() {
		if (top == 0)
			return true;

		return false;
	}

	public void print() {
		for (int i = 0; i < stack.length; i++) {
			System.out.println(stack[i]);
		}
	}

	public int getTop() {
		return top;
	}

}
