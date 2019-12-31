package application;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

	private AVLNode root;
	private int size = 0;

	private int number_of_LL_rotation = 0;
	private int number_of_RR_rotation = 0;
	private int number_of_RL_rotation = 0;
	private int number_of_LR_rotation = 0;

	// method that is called after each deletion and addition to check the property
	// of being AVL
	// and balances the tree:

	private void AVL_IT(AVLNode node) {
		if (isEmpty() == true) {
			return;
		}
		// updating heights:
		calculateHeightAndBalances(root);

		// condition for L-L rotation:
		if (node.getParent() != null && node.getBalance() == 1 && node.getParent().getBalance() >= 2) {
			LL_rotation(node);

			number_of_LL_rotation++;
		}
		// condition for R-R rotation:
		else if (node.getParent() != null && node.getBalance() == -1 && node.getParent().getBalance() <= -2) {
			RR_rotation(node);

			number_of_RR_rotation++;
		}

		// condition for L-R rotation:
		else if (node.getParent() != null && node.getBalance() == -1 && node.getRightChild() != null
				&& node.getParent().getBalance() >= 2) {
			LR_rotation(node);

			number_of_LR_rotation++;

			// instead of rotating L-R Directly
			// we tried to rotate in 2 steps but it was not useful
//			AVLNode temp = node.getRightChild();
//			RR_rotation(temp);
//			LL_rotation(temp);

		}

		// condition for R-L rotation:
		else if (node.getParent() != null && node.getBalance() == 1 && node.getLeftChild() != null
				&& node.getParent().getBalance() <= -2) {
			RL_rotaion(node);

			number_of_RL_rotation++;
		}

		// Handling a special case that happens when we are deleting:
		else {

			if (node.getParent() == null && node.getBalance() >= 2
					&& (node.hasLeftChild() && node.getLeftChild().getBalance() == 0)) {
				LL_rotation(node.getLeftChild());

				number_of_LL_rotation++;

			} else if (node.getParent() == null && node.getBalance() <= -2
					&& (node.hasRightChild() && node.getRightChild().getBalance() == 0)) {
				RR_rotation(node.getRightChild());

				number_of_RR_rotation++;
			}

		}

		// after running ROTATE
		// we check if tree steal is imbalance so we call AVL_IT
		// function again
		// we start iterating from bottom of the tree:

		// updating height:
		calculateHeightAndBalances(root);
		AVLNode temp = node;
		while (temp != null && root.isImbalance()) {

			if (temp.getBalance() > 1 || temp.getBalance() < -1) {

				AVLNode leftChild = temp.getLeftChild();
				AVLNode rightChild = temp.getRightChild();

				if (leftChild != null && (leftChild.getBalance() < 0 || leftChild.getBalance() > 0)) {

					AVL_IT(leftChild);
				} else if (rightChild != null && (rightChild.getBalance() < 0 || rightChild.getBalance() > 0)) {
					AVL_IT(rightChild);
				}
			}

			temp = temp.getParent();
		}

	}

	private void LL_rotation(AVLNode start) {

		// get parent and grand parents of the node
		AVLNode parent = start.getParent();
		AVLNode grandParent = parent.getParent();

		// get parent and grand parents of the node
		// according to the rules of AVL Tree we connect new links:

		// store the right child of start node
		// so we don't miss it:
		AVLNode rightChildOfStart = start.getRightChild();

		// According to AVl rules we cut and connect links (pointers):
		start.setRightChild(parent);

		/// if grandparent is null it means that the parent is the root node
		if (grandParent == null) {
			root = start;
			start.setParent(null);
		} else {
			grandParent.setLeftChild(start);
			start.setParent(grandParent);
		}
		// here we cut the link between previous parent of the node and the node
		parent.setLeftChild(null);
		parent.setParent(start);

		// if right of the the start was not null we add it to modified tree in the
		// correct position

		if (rightChildOfStart != null)
			insert(parent, rightChildOfStart);
	}

	// I commented LL and everything is the same
	// i just replaced Right with Left:
	private void RR_rotation(AVLNode node) {
		AVLNode parent = node.getParent();
		AVLNode grandParent = parent.getParent();

		AVLNode leftChildOfNode = node.getLeftChild();
		node.setLeftChild(parent);

		if (grandParent == null) {
			root = node;
			node.setParent(null);
		} else {
			grandParent.setRightChild(node);
			node.setParent(grandParent);

		}

		parent.setRightChild(null);
		parent.setParent(node);

		if (leftChildOfNode != null)
			insert(parent, leftChildOfNode);

	}

	private void LR_rotation(AVLNode node) {

		// get parent & grand parent & rightChild of node
		AVLNode parent = node.getParent();
		AVLNode grandparent = parent.getParent();
		AVLNode rightChild = node.getRightChild();

		// store left & right child of RIGHT
		// so we don't miss them:
		AVLNode rightChildOfRight = rightChild.getRightChild();
		AVLNode leftChildOfRight = rightChild.getLeftChild();

		// According to AVl rules we cut and connect links (pointers):

		rightChild.setLeftChild(node);
		rightChild.setRightChild(parent);

		if (grandparent == null) {
			root = rightChild;
			rightChild.setParent(null);
		} else {
			rightChild.setParent(grandparent);

			// we find that where was the location of parent beside the grand children
			// and then we connect the links:

//			grandparent.setRightChild(rightChild);

			if (parent.getData() == grandparent.getLeftChild().getData()) {
				grandparent.setLeftChild(rightChild);
			} else
				grandparent.setRightChild(rightChild);
		}

		// connect and disconnect links:

		node.setParent(rightChild);
		parent.setParent(rightChild);

		node.setRightChild(null);
		parent.setLeftChild(null);

		// if the right of right 's child weren't null so add them:
		if (rightChildOfRight != null)
			insert(rightChild, rightChildOfRight);

		if (leftChildOfRight != null)
			insert(rightChild, leftChildOfRight);

	}

	private void RL_rotaion(AVLNode node) {

		AVLNode parent = node.getParent();
		AVLNode grandparent = parent.getParent();

		AVLNode leftChild = node.getLeftChild();
		AVLNode leftChildOfLeft = leftChild.getLeftChild();
		AVLNode rightChildOfleft = leftChild.getRightChild();

		leftChild.setLeftChild(parent);
		leftChild.setRightChild(node);

		if (grandparent == null) {
			root = leftChild;
			leftChild.setParent(null);
		} else {
//			grandparent.setLeftChild(leftChild);
			leftChild.setParent(grandparent);
			if (parent.getData() == grandparent.getLeftChild().getData()) {
				grandparent.setLeftChild(leftChild);
			} else
				grandparent.setRightChild(leftChild);
		}

		node.setParent(leftChild);
		parent.setParent(leftChild);

		parent.setRightChild(null);
		node.setLeftChild(null);

		if (leftChildOfLeft != null)
			insert(leftChild, leftChildOfLeft);

		if (rightChildOfleft != null)
			insert(leftChild, rightChildOfleft);

	}

	// get balance factor of root:

	public int getRootBalance() {
		if (isEmpty())
			return 0;
		calculateHeightAndBalances(root);
		return root.getBalance();
	}

	// get height of a tree:
	public int getTreeHeight() {
		calculateHeightAndBalances(root);
		return root.getHeight();
	}

	// method for calculating height and balances of all nodes in the tree:
	private int calculateHeightAndBalances(AVLNode node) {

		if (isEmpty()) {
			System.err.println("TREE IS EMPTY");
			return 0;
		}
		if (node == null)
			return 0;

		int leftHight = calculateHeightAndBalances(node.getLeftChild());
		int rightHight = calculateHeightAndBalances(node.getRightChild());

//		int nodeHeight = max(leftHight, rightHight) + 1;
		int nodeHeight;
		if (leftHight > rightHight)
			nodeHeight = leftHight + 1;
		else
			nodeHeight = rightHight + 1;

		node.setHeight(nodeHeight);
		node.setBalance(leftHight - rightHight);

		return nodeHeight;

	}

	// get the minimum value of the tree:
	public AVLNode getMin(AVLNode start) {

		if (isEmpty())
			return null;

		AVLNode current = start;

		while (current.getLeftChild() != null)
			current = current.getLeftChild();
		return current;

	}

	// get the maximum value of the tree:
	public AVLNode getMax(AVLNode start) {
		if (isEmpty())
			return null;

		AVLNode current = start;

		while (current.getRightChild() != null)
			current = current.getRightChild();
		return current;

	}

	// method for adding a new node to binary tree and keeping its identity as a
	// binary search tree:

	public void insert(int data) {
		AVLNode addMe = new AVLNode(data);

		if (search(data) != null)
			System.err.println("this implementation doesn't allow you to insert repetitive data");
		else if (root == null) {
			root = addMe;
			size++;
		} else {
			insert(root, addMe);
			size++;
		}

	}

	private void insert(AVLNode start, AVLNode addMe) {

//		if (addMe.getData() == start.getData())
//			System.err.println("this implementation doesn't allow you to insert repetitive data");

		if (addMe.getData() < start.getData()) {
			if (start.getLeftChild() != null)
				insert(start.getLeftChild(), addMe);
			else {
				start.setLeftChild(addMe);
				addMe.setParent(start);

				AVL_IT(start);
			}
		}

		else if (addMe.getData() > start.getData()) {
			if (start.getRightChild() != null)
				insert(start.getRightChild(), addMe);

			else {
				start.setRightChild(addMe);
				addMe.setParent(start);

				AVL_IT(start);
			}
		}

	}

	// search method:

	public AVLNode search(int data) {
		return search(data, root);
	}

	private AVLNode search(int data, AVLNode start) {
		if (start != null && start.getData() == data)
			return start;

		else if (start != null && data > start.getData())
			return search(data, start.getRightChild());

		else if (start != null && data < start.getData())
			return search(data, start.getLeftChild());
		else
			return null;
	}

	// delete
	public void delete(int value) {

		if (isEmpty() == true) {
			System.err.println("TREE IS EMPTY");
			return;
		}

		AVLNode searched = search(value);
		if (searched == null)
			System.err.println("\n" + value + " is not in the tree");
		else {

			root = delete(root, value);
			size--;

			AVLNode min = getMin(root);
			AVLNode max = getMax(root);

			if (min != null)
				AVL_IT(min);
			if (max != null)
				AVL_IT(max);
		}
	}

	private AVLNode delete(AVLNode subtreeRoot, int value) {
		if (subtreeRoot == null)
			return subtreeRoot;
		else if (value < subtreeRoot.getData())
			subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
		else if (value > subtreeRoot.getData())
			subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));

		else {

			if (subtreeRoot.getLeftChild() == null && subtreeRoot.getRightChild() == null) {
				subtreeRoot = null;

			} else if (subtreeRoot.getLeftChild() == null && subtreeRoot.getRightChild() != null) {
				AVLNode rightchild = subtreeRoot.getRightChild();
				subtreeRoot.setData(rightchild.getData());
				subtreeRoot.setRightChild(delete(rightchild, rightchild.getData()));
			} else if (subtreeRoot.getRightChild() == null && subtreeRoot.getLeftChild() != null) {
				AVLNode leftChild = subtreeRoot.getLeftChild();
				subtreeRoot.setData(leftChild.getData());

				subtreeRoot.setLeftChild(delete(leftChild, leftChild.getData()));
			}

			else {

				AVLNode max = getMax(subtreeRoot.getLeftChild());

				subtreeRoot.setData(max.getData());

				subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), max.getData()));
			}

		}

		return subtreeRoot;
	}

	// inorder traversal:
	public void inorderTraversal() {
		if (isEmpty()) {
			System.err.println("TREE IS EMPTY");
			return;
		}
		privateInorder(root);
	}

	private void privateInorder(AVLNode start) {
		if (start == null)
			return;

		privateInorder(start.getLeftChild());
		System.out.print(start.getData() + " , ");
		privateInorder(start.getRightChild());

	}

	// getters & setters:
	public AVLNode getRoot() {
		return root;
	}

	public boolean isEmpty() {

		if (root == null)
			return true;

		return false;
	}

	public int getSize() {
		return size;
	}

	public int getNumber_of_LL_rotation() {
		return number_of_LL_rotation;
	}

	public int getNumber_of_RR_rotation() {
		return number_of_RR_rotation;
	}

	public int getNumber_of_RL_rotation() {
		return number_of_RL_rotation;
	}

	public int getNumber_of_LR_rotation() {
		return number_of_LR_rotation;
	}

	public void print() {

		if (isEmpty()) {
			System.err.println("TREE IS EMPTY");
			return;
		}

		Queue<AVLNode> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()) {

			int size = queue.size();

			for (; size > 0; size--) {

				AVLNode removed = queue.remove();
				System.out.print(removed.getData() + " ");

				if (removed.getLeftChild() != null)
					queue.add(removed.getLeftChild());
				if (removed.getRightChild() != null)
					queue.add(removed.getRightChild());
			}

			System.out.println();

		}

	}

	public void display() {
		final int height = 5, width = 64;

		int len = width * height * 2 + 2;
		StringBuilder sb = new StringBuilder(len);
		for (int i = 1; i <= len; i++)
			sb.append(i < len - 2 && i % width == 0 ? "\n" : ' ');

		displayR(sb, width / 2, 1, width / 4, width, root, " ");
		System.out.println(sb);
	}

	private void displayR(StringBuilder sb, int c, int r, int d, int w, AVLNode n, String edge) {
		if (n != null) {
			displayR(sb, c - d, r + 2, d / 2, w, n.getLeftChild(), " /");

			String s = String.valueOf(n.getData());
			int idx1 = r * w + c - (s.length() + 1) / 2;
			int idx2 = idx1 + s.length();
			int idx3 = idx1 - w;
			if (idx2 < sb.length())
				sb.replace(idx1, idx2, s).replace(idx3, idx3 + 2, edge);

			displayR(sb, c + d, r + 2, d / 2, w, n.getRightChild(), "\\ ");
		}
	}

//	private void LL_rotation(AVLNode start) {
//
//		AVLNode parent = start.getParent();
//		AVLNode grandparent = parent.getParent();
//
//		AVLNode rightChild = start.getRightChild();
//		AVLNode leftChild = start.getLeftChild();
//
//		start.setRightChild(parent);
//
//		if (grandparent == null) {
//			root = start;
//			start.setParent(null);
//		} else {
//			grandparent.setLeftChild(start);
//			start.setParent(grandparent);
//		}
//
//		parent.setLeftChild(null);
//		parent.setParent(start);
//
//		if (rightChild != null)
//			insert(parent, rightChild);
//
//	}

	////////////////////////

	////////////////////////////////
//	private void delete3(int value) {
//	if (isEmpty()) {
//		System.err.println("TREE IS EMPTY");
//
//	} else {
//
//		root.delete(root, value);
//
//	}
//}

//private void delete2(int value) {
//
//	if (isEmpty()) {
//		System.err.println("TREE IS EMPTY");
//
//	} else {
//
//		root.delete(root, value);
//
//	}

//	} else {
//
//		AVLNode temp = root;
//		while (temp != null) {
//
//			// we found our target node:
//			if (temp.getData() == value) {
//
//				if (temp.hasChildren()) {
//
//					if (temp.hasLeftChild() && temp.hasRightChild()) {
//						// what to do in this case
//					}
//
//					else if (temp.hasLeftChild()) {
//						temp.setData(temp.getLeftChild().getData());
//					} else if (temp.hasRightChild()) {
//						temp.setData(temp.getRightChild().getData());
//					}
//
//				}
//
//			} else if (value > temp.getData()) {
//				temp = temp.getRightChild();
//			} else if (value < temp.getData()) {
//				temp = temp.getLeftChild();
//			}
//
//		}
//
//	}

//}

	/////////

	////////////////

	// this insert method has a high call stack
	// and causes stack overflow error
//	public void insert(int data) {
//	AVLNode addMe = new AVLNode(data);
//	if (root == null) {
//		root = addMe;
//	}
//
//	else {
//
//		if (addMe.getData() == root.getData())
//			System.out.println("this implementation doesn't allow you to insert repetitive data");
//
//		else if (data < root.getData()) {
//			if (root.getLeftChild() != null)
//				root.getLeftChild().insertNode(addMe);
//			else {
//				root.setLeftChild(addMe);
//				addMe.setParent(root);
//			}
//		}
//
//		else if (data > root.getData()) {
//			if (root.getRightChild() != null)
//				root.getRightChild().insertNode(addMe);
//
//			else {
//				addMe.setParent(root);
//				root.setRightChild(addMe);
//			}
//		}
//
//	}
//
//}

	// DO NOT write a method that does a repetitive task :
//	public int setBalances(AVLNode start) {
//	if (start == null)
//		return 0;
//
//	int balance = setBalances(start.getLeftChild()) - setBalances(start.getRightChild());
//	start.setBalance(balance);
//	return balance;
//}

//	private AVLNode delete(AVLNode subtreeRoot, int value) {
//	if (subtreeRoot == null)
//		return subtreeRoot;
//	else if (value < subtreeRoot.getData())
//		subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
//	else if (value > subtreeRoot.getData())
//		subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
//
//	else {
//		if ((subtreeRoot.getLeftChild() == null) || (subtreeRoot.getRightChild() == null)) {
//
//			AVLNode temp;
//			if (subtreeRoot.getLeftChild() != null)
//				temp = subtreeRoot.getLeftChild();
//			else
//				temp = subtreeRoot.getRightChild();
//
//			if (temp == null) {
//				subtreeRoot = null;
//			} else {
//				subtreeRoot.setData(temp.getData());
//				temp = null;
//			}
//
//		} else {
//
//			AVLNode max = getMax(subtreeRoot.getLeftChild());
//
//			subtreeRoot.setData(max.getData());
//
//			subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), max.getData()));
//		}
//
//	}
//	return subtreeRoot;
//}

}
