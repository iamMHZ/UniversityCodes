package measurment_statments;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {

	private String postfix = new String("");
	private String infix;

	private Stack<String> stack;

	public InfixToPostfix(String infix) {
		this.infix = infix;
		stack = new Stack<>();
	}

	public boolean proiority(char a, char b) {
		if ((a == '*' || a == '/' || a == '^') && (b == '*' || b == '/' || b == '^'))
			return true;
		if ((a == '+' || a == '-' || a == '%') && (b == '+' || b == '-' || b == '%'))
			return true;
		if ((a == '*' || a == '/' || a == '^') && (b == '+' || b == '-' || b == '%'))
			return true;

		return false;
	}

	public void convert() {

		for (int i = 0; i < infix.length(); i++) {

			if (Character.isLetterOrDigit(infix.charAt(i))) {
				postfix += infix.charAt(i);
			}

			else {
				stack.push(String.valueOf(infix.charAt(i)));
				
			}

		}
	}

	public String getInfix() {
		return infix;
	}

	public void setInfix(String infix) {
		this.infix = infix;
	}

	public String getPostfix() {
		return postfix;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Infix:  ");
		String infix = scanner.nextLine();

		InfixToPostfix toPostfix = new InfixToPostfix(infix);

		System.out.println("\nPostfix: " + toPostfix.getPostfix());

		scanner.close();

	}

}
