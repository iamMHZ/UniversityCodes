package graph.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	private BTreeNode root;

	public BinaryTree(BTreeNode root) {
		this.root = root;
	}

	public BTreeNode getRoot() {
		return root;
	}

	@Override
	public String toString() {
		return " root ===> " + root;
	}

	public void preorder() {

		if (root == null)
			return;

		Stack<BTreeNode> stack = new Stack<>();

		stack.push(root);

		while (!stack.isEmpty()) {
			BTreeNode temp = stack.pop();

			System.out.print(temp.getData() + " , ");

			temp.setVisited(true);

			if (temp.getRight() != null && temp.getRight().isVisited() == false)
				stack.push(temp.getRight());

			if (temp.getLeft() != null && temp.getLeft().isVisited() == false)
				stack.push(temp.getLeft());

		}

		System.out.println();

	}

	public void recursivePreorder(BTreeNode start) {

		if (start == null)
			return;

		System.out.print(start.getData() + " , ");

		recursivePreorder(start.getLeft());
		recursivePreorder(start.getRight());

	}

	public void recersiveInorder(BTreeNode start) {
		if (start == null)
			return;

		if (start.getLeft() != null && start.getLeft().isVisited() == false)
			recersiveInorder(start.getLeft());

		System.out.print(start.getData() + " , ");

		if (start.getRight() != null && start.getRight().isVisited() == false)
			recersiveInorder(start.getRight());

	}

	public void inorder() {
		if (root == null)
			return;

		Stack<BTreeNode> stack = new Stack<>();

		BTreeNode temp = root;
		stack.push(temp);
		temp.setVisited(true);
		temp = temp.getLeft();

		while (!stack.isEmpty() || temp != null) {

			if (temp != null && temp.isVisited() == false) {
				stack.push(temp);
				temp.setVisited(true);
				temp = temp.getLeft();
			} else {
				temp = stack.pop();
				System.out.print(temp.getData() + " , ");
				temp = temp.getRight();
			}

		}
	}

	public void inorder2() {
		if (root == null)
			return;

		Stack<BTreeNode> s = new Stack<>();
		BTreeNode curr = root;

		// traverse the tree
		while (curr != null || !s.isEmpty()) {

			// get to the left most side of the current:
			while (curr != null) {

				s.push(curr);
				curr = curr.getLeft();
			}

			curr = s.pop();

			System.out.print(curr.getData() + " , ");

			curr = curr.getRight();
		}
	}

//	public void postorder() {
//		Stack<BTreeNode> stack = new Stack<>();
//
//		if (root == null)
//			return;
//
//		BTreeNode temp = root;
//		stack.push(temp);
//		temp.setVisited(true);
//
//		while (!stack.isEmpty()) {
//
//			if (temp.getLeft() != null && temp.getLeft().isVisited() == false) {
//				temp = temp.getLeft();
//				stack.push(temp);
//				temp.setVisited(true);
//			} else if (temp.getRight() != null && temp.getRight().isVisited() == false) {
//				temp = temp.getRight();
//				stack.push(temp);
//				temp.setVisited(true);
//			} else {
//				temp = stack.pop();
//				System.out.print(temp.getData() + " , ");
//
//			}
//
//		}
//
//	}

	public void recursivePostorder(BTreeNode start) {

		if (start == null)
			return;
		start.setVisited(true);
		if (start.getLeft() != null && start.getLeft().isVisited() == false)
			recursivePostorder(start.getLeft());

		if (start.getRight() != null && start.getRight().isVisited() == false)
			recursivePostorder(start.getRight());

		System.out.print(start.getData() + " , ");

	}

	public void levelOrder() {
		if (root == null)
			return;

		Queue<BTreeNode> queue = new LinkedList<>();

		queue.add(root);

		BTreeNode temp = root;

		while (!queue.isEmpty()) {
			temp = queue.remove();
			System.out.print(temp.getData() + " , ");

			if (temp.getLeft() != null)
				queue.add(temp.getLeft());

			if (temp.getRight() != null)
				queue.add(temp.getRight());

		}

	}

//	public void postorder() {
//		if (root == null)
//			return;
//		Stack<BTreeNode> stack = new Stack<>();
//
//		BTreeNode temp = root;
//
//		stack.push(temp);
//		temp.setVisited(true);
//
//		while (!stack.isEmpty()) {
//
//			if (temp.getLeft() != null && temp.getLeft().isVisited() == false) {
//				temp.setVisited(true);
//				stack.push(temp);
//				temp = temp.getLeft();
//			}
//
//			else if (temp.getRight() == null) {
//				System.out.println(temp.getData() + " , ");
//				temp = stack.pop();
//			} else {
//				temp = stack.pop();
//				stack.push(temp);
//				temp = temp.getRight();
//			}
//		}
//
//	}

	public void postorder2() {
		if (root == null)
			return;

		Stack<BTreeNode> s1 = new Stack<>();
		Stack<BTreeNode> s2 = new Stack<>();

		BTreeNode temp = root;
		s1.push(temp);

		while (!s1.isEmpty()) {
			temp = s1.pop();
			s2.push(temp);

			if (temp.getLeft() != null)
				s1.push(temp.getLeft());

			if (temp.getRight() != null)
				s1.push(temp.getRight());
		}

		while (!s2.isEmpty())
			System.out.print(s2.pop().getData() + " , ");

	}

	public void sawpLeftToRight() {

		BTreeNode left = root.getLeft();
		BTreeNode right = root.getRight();
		BTreeNode temp;

		temp = left;

		root.setLeft(right);
		root.setRight(temp);

	}

	private String perorderResutl = new String();

	private void privatePreorder(BTreeNode start) {
		if (start == null) {
			return;
		}

		perorderResutl += start.getData();

		privatePreorder(start.getLeft());
		privatePreorder(start.getRight());

	}

	// i tried to understand that if a tree
	// is equal to another one by using one of Traversals
	public boolean isEqualWith(BinaryTree tree) {
		this.perorderResutl = new String();
		tree.perorderResutl = new String();

		this.privatePreorder(this.root);
		System.out.println(this.perorderResutl);

		tree.privatePreorder(tree.root);
		System.out.println(tree.perorderResutl);

		return this.perorderResutl.equals(tree.perorderResutl);
	}

	public int getDepth() {
		return -1;
	}

//	public void showStructure() {
//		if (root == null) {
//			System.out.println("Empty tree");
//		} else {
//			System.out.println();
//			showSub(this.root, 1);
//			System.out.println();
//		}
//	}
//
//	private void showSub(BTreeNode p, int level) {
//		int j;
//
//		if (p == null) {
//			return;
//		}
//
//		showSub(p.getRight(), level + 1);
//		for (j = 0; j < level; j++)
//			System.out.print("\t");
//		System.out.print(" " + this.root);
//		if ((p.getLeft() != null) && (p.getRight() != null))
//			System.out.print("<");
//		else if (p.getRight() != null)
//			System.out.print("/");
//		else if (p.getLeft() != null)
//			System.out.print("\\");
//		System.out.println();
//		showSub(p.getLeft(), level + 1);
//	}

//	public void inOrder() {
//		Stack<BTreeNode> stack = new Stack<>();
//		if (root == null)
//			return;
//
//		BTreeNode poped = root;
//		stack.push(poped.getRight());
//		poped.getRight().setVisited(true);
//
//		while (!stack.isEmpty()) {
//
//			if (poped.getRight() != null && poped.getRight().isVisited() == false) {
//				stack.push(poped.getRight());
//				poped.getRight().setVisited(true);
//			}
//
//			if (poped.isVisited() == false) {
//				stack.push(poped);
//				poped.setVisited(true);
//			}
//
//			if (poped.getLeft() != null && poped.getLeft().isVisited() == false) {
//				stack.push(poped.getLeft());
//				poped.getLeft().setVisited(true);
//			}
//
//			poped = stack.pop();
//			System.out.print(poped.getData()+" , ");
//
//		}
//		System.out.println();
//	}

	// another preorder algorithm with O(n^2):
//	public String preOrder2() {
//
//		if (root == null)
//			return null;
//
//		Stack<BTreeNode> stack = new Stack<>();
//		stack.push(root);
//
//		BTreeNode temp = root;
//		temp.setVisited(true);
//		String rerult = temp.getData() + " , ";
//
//		while (!stack.isEmpty()) {
//
//			if (temp.getLeft() != null && temp.getLeft().isVisited() == false) {
//				stack.push(temp.getLeft());
//				temp.setVisited(true);
//				rerult += temp.getData() + " , ";
////				temp = temp.getLeft();
//			}
//
//			else if (temp.getRight() != null && temp.getRight().isVisited() == false
//					&& temp.getLeft().isVisited() == true) {
//				stack.push(temp.getRight());
//				rerult += temp.getData() + " , ";
//			}
//			temp = stack.pop();
//
//		}
//
//		return rerult;
//
//	}

}
