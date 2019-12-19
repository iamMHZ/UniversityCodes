package polynomial_dubbleArray;

import java.util.Arrays;

public class Polynomial {

	private int maxSize;
	private int[] exp;
	private float[] coef;

	public Polynomial(int[] exp, float[] coef) {
		this.maxSize = coef.length;
		this.exp = exp;
		this.coef = coef;
	}

	public Polynomial(int maxSize) {
		this.maxSize = maxSize;
		exp = new int[maxSize];
		coef = new float[maxSize];
	}

	public void add(Polynomial other) {

		for (int i = 0; i < maxSize; i++)
			for (int j = 0; j < other.maxSize; j++)
				if (exp[i] == other.exp[j])
					coef[i] += other.coef[j];
	}

	public Polynomial multiply(Polynomial other) {
		Polynomial p;
		if (this.maxSize > other.maxSize)
			p = new Polynomial(maxSize * maxSize);
		else
			p = new Polynomial(other.maxSize * other.maxSize);

		int k = 0;
		for (int i = 0; i < maxSize && k < p.maxSize; i++, k++) {
			for (int j = 0; j < other.maxSize && k < p.maxSize; j++, k++) {

				if (search(p.exp, k, other.exp[j] + exp[i]) != -1) {
					int d = search(p.exp, k, other.exp[j] + exp[i]);
					p.coef[d] += coef[i] * other.coef[j];
				} else {
					p.coef[k] = coef[i] * other.coef[j];
					p.exp[k] = other.exp[j] + exp[i];
				}

			}

		}

//		for (int i = 0; i < p.maxSize; i++) {
//			for (int j = 0; j < p.maxSize; j++)
//				if (p.exp[i] == p.exp[j]) {
//					p.coef[i] += p.coef[j];
//					for (int m = j; m + 1 < maxSize; m++) {
//						p.coef[m] = p.coef[m + 1];
//					}
//				}
//		}

		return p;
	}

	private int search(int[] exp, int bound, int data) {

		for (int i = 0; i < bound; i++) {
			if (exp[i] == data)
				return i;
		}

		return -1;

	}

	public int[] getExp() {
		return exp;
	}

	public void setExp(int[] exp) {
		this.exp = exp;
	}

	public float[] getCoef() {
		return coef;
	}

	public void setCoef(float[] coef) {
		this.coef = coef;
	}

	@Override
	public String toString() {
		return "Polynomial [maxSize=" + maxSize + ", exp=" + Arrays.toString(exp) + ", coef=" + Arrays.toString(coef)
				+ "]";
	}

}
