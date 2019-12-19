package graph.tree.binarySearchTree;

import java.util.Stack;

public class BinarySearchTree {

	private TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	// get the height of a tree:
	public int getTreeHeight() {
		return root.getNodeHeight(root);
	}

	// method for adding a new node to binary tree and keeping its identity as a
	// binary search tree:
	public void insert(int data) {
		TreeNode addMe = new TreeNode(data);
		if (root == null)
			root = addMe;

		else {

			if (data < root.getData()) {
				if (root.getLeftChild() != null)
					root.getLeftChild().insertNode(addMe);
				else
					root.setLeftChild(addMe);
			}

			else if (data > root.getData()) {
				if (root.getRighChild() != null)
					root.getRighChild().insertNode(addMe);

				else
					root.setRighChild(addMe);
			}

		}

	}

	// inorder traversal method:
	public void inorder() {
		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<>();

		TreeNode temp = root;
		stack.push(temp);
		temp.setVisited(true);
		temp = temp.getLeftChild();

		while (!stack.isEmpty() || temp != null) {

			if (temp != null && temp.isVisited() == false) {
				stack.push(temp);
				temp.setVisited(true);
				temp = temp.getLeftChild();
			} else {
				temp = stack.pop();
				System.out.print(temp.getData() + " , ");
				temp = temp.getRighChild();
			}

		}
	}

	// method that does the inorder traversal recursively:
	public void recursiveInorder(TreeNode start) {
		if (start == null)
			return;

		recursiveInorder(start.getLeftChild());
		System.out.print(start.getData() + " , ");
		recursiveInorder(start.getRighChild());

	}

	// get information of a node:
	public TreeNode get(int data) {
		if (root == null)
			return null;

		return root.findAndReturn(data);
	}

	// get the minimum value of a tree:
	public void getMin(TreeNode start) {

		if (start.getLeftChild() == null) {
			System.out.println("\nMin: " + start.getData());
			return;
		}

		getMin(start.getLeftChild());

	}

	// get the maximum value of a tree:
	public void getMax(TreeNode start) {

		if (start.getRighChild() == null) {
			System.out.println("\nMax: " + start.getData());
			return;
		}

		getMax(start.getRighChild());

	}

	// search method:

	public TreeNode search(int data) {
		return search(data, root);
	}

	private TreeNode search(int data, TreeNode start) {
		if (start != null && start.getData() == data)
			return start;

		else if (data > start.getData())
			return search(data, start.getRighChild());

		else if (data < start.getData())
			return search(data, start.getLeftChild());
		else
			return null;
	}

	public void delete(int value) {
		TreeNode searched = search(value);
		if (searched == null)
			System.out.println(value + " is not in the tree");
		else
			delete(root, value);
	}

	private void delete(TreeNode start, int value) {

		if (value > start.getData()) {
			delete(start.getRighChild(), value);

		} else if (value < start.getData()) {
			delete(start.getLeftChild(), value);
		} else {
			if (start.getLeftChild() == null && start.getRighChild() == null) {
				start = null;
			} else if (start.getLeftChild() == null) {
				start = start.getRighChild();
			} else if (start.getRighChild() == null) {
				start = start.getLeftChild();
			} else {
				// if we come here it means that the node has both right and left child
				// and in this particular case we replace the node with the maximun value in its
				// left subtree:

				// finding the max value in its left subtree:
				TreeNode max = start;
//				TreeNode max = start.getLeftChild();
				
				while (max.getRighChild() != null) {
					max = max.getRighChild();
				}

				// first we delete the max value that we found:
				delete(start, max.getData());
				// now we delete the node that we wanted:
				start.setData(max.getData());

			}
		}

	}

//	public void delete(int value) {
//		TreeNode searched = search(value);
//
//		if (searched == null) {
//			System.out.println(value + " is not in the tree");
//		} else {
//
//			// handling cases 1 & 2 : node to delete has one or no child
//
//			if (searched.getLeftChild() == null && searched.getRighChild() == null) {
//				searched = null;
//			} else if (searched.getLeftChild() == null) {
//				searched = searched.getLeftChild();
//			} else {
//				searched = searched.getRighChild();
//			}
//
//		}
//
//	}

	// first i did search by inorder traversal:::::
	// search a node with the help of inorder traversal:
//	private TreeNode searched;
//
//	public TreeNode search(int data) {
//		recursiveInorderForSearchMehod(root , data);
//		return searched;
//	}
//
//	private void recursiveInorderForSearchMehod(TreeNode start, int data) {
//		if (start == null)
//			return;
//		if (start.getData() == data) {
//			searched = start;
//			return;
//		}
//		recursiveInorderForSearchMehod(start.getLeftChild(), data);
//		recursiveInorderForSearchMehod(start.getRighChild(), data);
//
//	}

//	public void print() {
//		TreeNode temp = root;
//
//		if (root == null) {
//			System.out.println("null");
//			return;
//		}
//
//		else {
//
//			System.out.println(temp.toString());
//			TreeNode left = temp.getLeftChild();
//			TreeNode right = temp.getRighChild();
//
//			while (left != null || right != null) {
//
//				left = temp.getLeftChild();
//				right = temp.getRighChild();
//
//				System.out.print(left.toString());
//				System.out.println(right.toString());
//
//			}
//		}
//
//	}
}
