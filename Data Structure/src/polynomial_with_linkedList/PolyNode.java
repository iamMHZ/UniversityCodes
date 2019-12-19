package polynomial_with_linkedList;

public class PolyNode {

	private int exp;
	private float coef;
	private PolyNode next;

	public PolyNode(int exp, float coef) {
		this.exp = exp;
		this.coef = coef;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public float getCoef() {
		return coef;
	}

	public void setCoef(float coef) {
		this.coef = coef;
	}

	public PolyNode getNext() {
		return next;
	}

	public void setNext(PolyNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "PolyNode [exp=" + exp + ", coef=" + coef + ", next=" + next + "]";
	}

}
