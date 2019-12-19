package polynomial;

public class Polynomial {

	private float[] coef;
	private int degree;

	public Polynomial(float[] coef, int degree) {
		this.coef = coef;
		this.degree = degree;
	}

	public Polynomial(int degree) {
		this.coef = new float[degree];

	}

	public void add(Polynomial other) {
		int maxDegree = degree;
		if (other.degree > degree)
			maxDegree = other.degree;

		for (int i = 0; i < maxDegree; i++) {

			if (i > degree || i > other.degree)
				return;
			coef[i] += other.coef[i];
		}

	}

	public Polynomial multiplt(Polynomial other) {

		int degree = this.degree + other.degree;
		Polynomial p = new Polynomial(degree);

		for (int i = 0; i < this.degree; i++) {
			if (coef[i] != 0)
				for (int j = 0; j < other.degree; j++) {
					if (other.coef[j] != 0)
						p.coef[i + j] = coef[i] * other.coef[j];
				}
		}

		return p;
	}

}
