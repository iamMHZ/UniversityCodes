package application;





public class AVLNode {
//	private int counter = 0;
	private int data;
	private AVLNode parent;
	private AVLNode leftChild;
	private AVLNode rightChild;
	private boolean visited = false;
	private int height;
	private int balance;

	public AVLNode(int data) {
		this.data = data;
	}

	public boolean hasChildren() {
		if (this.leftChild != null || this.rightChild != null)
			return true;

		return false;
	}

	public boolean hasRightChild() {
		if (this.rightChild != null)
			return true;

		return false;
	}

	public boolean isImbalance() {

		if (this.getBalance() > 1 || this.getBalance() < -1)
			return true;

		return false;
	}

	public boolean hasLeftChild() {
		if (leftChild != null)
			return true;

		return false;
	}

	public AVLNode getParent() {
		return parent;
	}

	public void setParent(AVLNode parent) {
		this.parent = parent;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int nodeHeight) {
		this.height = nodeHeight;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public AVLNode getLeftChild() {
		return leftChild;
	}

	public AVLNode getRightChild() {
		return rightChild;
	}

	public void setLeftChild(AVLNode leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(AVLNode righChild) {
		this.rightChild = righChild;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		if (this.getLeftChild() != null && this.getRightChild() != null)
			return "" + this.data + " ~~~> left: " + this.getLeftChild().getData() + " ~~~> Right: "
					+ this.getRightChild().getData();
		else if (this.getLeftChild() != null)
			return "" + this.data + " ~~~> left: " + this.getLeftChild().getData();

		else if (this.getRightChild() != null)
			return "" + this.data + " ~~~> Right: " + this.getRightChild().getData();

		else
			return "" + this.getData();
	}

//	private void disconnectParent(AVLNode temp, AVLNode newNode) {
//		AVLNode tempParent = temp.parent;
//
//		if (temp.parent != null) {
//			if (tempParent.leftChild != null && tempParent.leftChild.data == temp.data)
//				tempParent.leftChild = newNode;
//			else if (tempParent.rightChild != null && tempParent.rightChild.data == temp.data)
//				tempParent.rightChild = newNode;
//		}
//
//	}
//
//	public void delete(AVLNode start, int value) {
//
//		AVLNode temp = start;
//
//		while (temp != null) {
//
//			if (value > temp.data) {
//				temp = temp.rightChild;
//			} else if (value < temp.data) {
//				temp = temp.leftChild;
//
//			} else
//				break;
//		}
//
//		// delete process:
//
//		if (temp.rightChild == null && temp.leftChild == null) {
//
//			disconnectParent(temp, null);
//
//			temp.parent = null;
//			temp = null;
//		} else if (temp.leftChild != null && temp.rightChild == null) {
//			AVLNode tempParent = temp.parent;
//
//			disconnectParent(temp, temp.leftChild);
//
//			temp.leftChild.parent = tempParent;
//			temp = temp.leftChild;
//
//		} else if (temp.rightChild != null && temp.leftChild == null) {
//			AVLNode tempParent = temp.parent;
//
//			disconnectParent(temp, temp.rightChild);
//
//			temp.rightChild.parent = tempParent;
//			temp = temp.rightChild;
//		} else {
//			// node to delete has 2 children:
//			// delete STRATEGY: use the maximum value in the left subtree:
//
//			AVLNode max = temp.leftChild;
//
//			while (max.rightChild != null)
//				max = max.rightChild;
//
//			AVLNode tempParent = temp.parent;
//
//			temp = max;
//
//			temp.parent = tempParent;
//		}
//
//	}

//	public void delete(AVLNode start, int value) {
//
//		AVLNode temp = start;
//		AVLNode startParent = start.parent;
//
//		while (temp != null) {
//
//			if (value > temp.data) {
//				temp = temp.rightChild;
//			} else if (value < temp.data) {
//				temp = temp.leftChild;
//
//			} else
//				break;
//		}
//
//		// delete process:
//
//		if (temp.rightChild == null && temp.leftChild == null) {
////			if (temp.parent != null) {
////				if (temp.parent.hasLeftChild() && temp.parent.leftChild.data == temp.data)
////					temp.parent.leftChild = null;
////				else
////					temp.parent.rightChild = null;
////			}
//			temp.parent = null;
//			temp = null;
////					break;
//		} else if (temp.leftChild != null && temp.rightChild == null) {
//			AVLNode tempParent = temp.parent;
//			temp = temp.leftChild;
//			temp.parent = tempParent;
////			break;
//		} else if (temp.rightChild != null && temp.leftChild == null) {
//			AVLNode tempParent = temp.parent;
//			temp = temp.rightChild;
//			temp.parent = tempParent;
////					break;
//		} else {
//			// node to delete has 2 children:
//			// delete STRATEGY: use the maximum value in the left subtree:
//
//			AVLNode max = temp.leftChild;
//
//			while (max.rightChild != null)
//				max = max.rightChild;
//
//			AVLNode tempParent = temp.parent;
//
//			temp = max;
//
//			temp.parent = tempParent;
////					break;
//		}
//
//
//	}

//		}

//	}

//	public AVLNode delete(AVLNode start, int value) {
//
//		if (start == null)
//			return null;
//		else if (value > this.data) {
//			start.rightChild = delete(start.rightChild, value);
//		} else if (value < this.data) {
//			start.leftChild = delete(start.leftChild, value);
//		} else {
//
//			// delete process:
//
//			if (rightChild == null && leftChild == null)
//				start = null;
//
//			else if (leftChild != null && rightChild == null) {
//
//				start.data = leftChild.data;
//				start.leftChild = delete(start.leftChild, leftChild.data);
//
//			} else if (rightChild != null && leftChild == null) {
//
//				start.data = rightChild.data;
//				start.rightChild = delete(start.rightChild, rightChild.data);
//
//			} else {
//				// has both children:
//
//				// deleting STRATEGY ==> use the maximum value in the left subtree:
//
//				AVLNode maxOfLeftSubtree = start.getLeftChild();
//				while (maxOfLeftSubtree.rightChild != null)
//					maxOfLeftSubtree = maxOfLeftSubtree.getRightChild();
//
//				start.data = maxOfLeftSubtree.data;
//
//				start.leftChild = delete(start.rightChild, maxOfLeftSubtree.data);
//
//			}
//		}
//
//		return start;
//
//	}

//	public void insertNode(AVLNode addMe) {
//
//		if (addMe.getData() == data) {
//			System.out.println("this implementation doesn't allow you to insert repetitive data");
//
//		} else if (addMe.getData() > data) {
//
//			if (this.getRightChild() != null)
//				this.getRightChild().insertNode(addMe);
//			else {
//				this.setRightChild(addMe);
//				addMe.setParent(this);
//			}
//		}
//
//		else if (addMe.getData() < data) {
//			if (this.getLeftChild() != null)
//				this.insertNode(addMe);
//			else {
//				this.setLeftChild(addMe);
//				addMe.setParent(this);
//			}
//
//		}
//	}

}
