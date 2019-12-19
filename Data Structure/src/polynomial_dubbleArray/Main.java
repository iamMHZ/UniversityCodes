package polynomial_dubbleArray;

import polynomial_dubbleArray.Polynomial;

public class Main {

	public static void main(String[] args) {

		int[] exp = { 2, 1, 0 };
		float[] coef = { 2, 3, 4 };

		Polynomial polynomial = new Polynomial(exp, coef);

		Polynomial multiply = polynomial.multiply(polynomial);
		System.out.println(polynomial);
		System.out.println(multiply);

	}

}
