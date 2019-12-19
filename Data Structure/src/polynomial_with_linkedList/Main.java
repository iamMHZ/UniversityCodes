package polynomial_with_linkedList;

public class Main {

	public static void main(String[] args) {

		LinkedPolynomial polynomial = new LinkedPolynomial();
		
		polynomial.addTerm(2, 2);
		polynomial.addTerm(1, 1);

		polynomial.displayContent();
		
		polynomial.multiply(polynomial);
		
		polynomial.displayContent();
	}

}
