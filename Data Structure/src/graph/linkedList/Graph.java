package graph.linkedList;

import queue_with_linkedList.Queue;

public class Graph {

	private HeadNode root;

	public Graph() {
	}

	public Graph(HeadNode root) {
		this.root = root;
	}

	public HeadNode getRoot() {
		return root;
	}

	public void setRoot(HeadNode root) {
		this.root = root;

	}

	public Queue bfs() {
		Queue queue = new Queue();

		HeadNode start = this.getRoot();
		queue.add(String.valueOf(start.getNumber()));

		while (start != null) {

			Node temp = start.getFirstLink();

			if (start.isVisited() == false) {
				while (temp != null) {
					if (temp.isVisited() == false) {
						queue.add(String.valueOf(temp.getData()));
						temp.setVisited(true);
					}
					temp = temp.getNext();
				}
			}

			start.setVisited(true);

			String visitFormFirst = queue.visitFormFirst();
			start = start.goToHeadNode(Integer.valueOf(visitFormFirst));

		}

		return queue;
	}

	public void print() {

		HeadNode temp = root;

		while (temp != null) {
			Node t = temp.getFirstLink();
			System.out.print("'" + temp.getNumber() + "'" + " ==== ");
			while (t != null) {
				System.out.print(t.getData() + " ---- ");
				t = t.getNext();
			}

			System.out.println();

			temp = temp.getDownHead();

		}
	}

}
