package polynomial_with_linkedList;

public class LinkedPolynomial {

	private PolyNode first;

	public LinkedPolynomial() {

		first = null;
	}

	public LinkedPolynomial(int exp, float coef) {
		PolyNode first = new PolyNode(exp, coef);
		this.first = first;
	}

// addTerm method adds plyNodes in order(based on their exp):
	public void addTerm(int exp, float coef) {
		PolyNode addMe = new PolyNode(exp, coef);

		if (first == null) {
			first = addMe;

		} else if (first.getExp() < addMe.getExp()) {
			addMe.setNext(first);
			first = addMe;
		} else {

			PolyNode temp = first;
			if (temp.getExp() == exp) {
				temp.setCoef(temp.getCoef() + coef);
				return;
			}
			while (temp.getNext() != null && temp.getNext().getExp() >= addMe.getExp()) {
				temp = temp.getNext();
				if (temp.getExp() == exp) {
					temp.setCoef(temp.getCoef() + coef);
					return;
				}
			}

			addMe.setNext(temp.getNext());
			temp.setNext(addMe);

//			if (temp == null)
//				temp = addMe;
//			else if (temp.getExp() == exp) {
//				float newCoef = temp.getCoef() + coef;
//				temp.setCoef(newCoef);
//			}else {
//				addMe.setNext(temp);
//				temp.setNext(addMe);
//			}

		}

	}

	// addition method does the addition task with the help of addTerm method:

	public void addition(LinkedPolynomial other) {
		if (other.first == null || first == null)
			return;

		PolyNode temp = other.first;
		while (temp != null) {
			this.addTerm(temp.getExp(), temp.getCoef());
			temp = temp.getNext();
		}

	}

	public void multiply(LinkedPolynomial other) {
		PolyNode this_Polynomila_Temp_Node = first;
		PolyNode other_Polynomila_Temp_Node = other.first;

		while (other_Polynomila_Temp_Node != null) {
			if (this_Polynomila_Temp_Node == null) {
				addTerm(other_Polynomila_Temp_Node.getExp(), other_Polynomila_Temp_Node.getCoef());
			}

			else {
				float coef = this_Polynomila_Temp_Node.getCoef() * other_Polynomila_Temp_Node.getCoef();
				int exp = this_Polynomila_Temp_Node.getExp() + other_Polynomila_Temp_Node.getExp();

				this_Polynomila_Temp_Node.setCoef(coef);
				this_Polynomila_Temp_Node.setExp(exp);

//				this.addTerm(exp, coef);
			}

			this_Polynomila_Temp_Node = this_Polynomila_Temp_Node.getNext();
			other_Polynomila_Temp_Node = other_Polynomila_Temp_Node.getNext();

		}

	}

	public void displayContent() {
		PolyNode temp = first;

		while (temp != null) {

			if (temp.getCoef() < 0 && temp.getExp() == 0)
				System.out.print(temp.getCoef() + " ");

			else if (temp.getCoef() > 0 && temp.getExp() == 0)
				System.out.print("+" + temp.getCoef() + " ");

			else if (temp.getCoef() > 0)
				System.out.print("+" + temp.getCoef() + "x^" + temp.getExp() + " ");
			else if (temp.getCoef() < 0)
				System.out.print(temp.getCoef() + "x^" + temp.getExp() + " ");

//			System.out.print("+" + temp.getCoef() + "x^" + temp.getExp() + " ");
			temp = temp.getNext();
		}

		System.out.println("\n");
	}

}
