package sorting.radix;

import java.util.Arrays;

public class RadixSort {

	private Node[] nodes = new Node[10];
	private String[] sortedNumbers;

	public RadixSort(String[] numbers) {

		this.sortedNumbers = numbers;
		// initialization to avoid NullPointerException
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(String.valueOf(i));
		}
	}

	public void listToArray() {

		int j = 0;
		for (int i = 0; i < nodes.length; i++) {

			Node temp = nodes[i].getNext();

			while (temp != null && j < sortedNumbers.length) {

				sortedNumbers[j] = temp.getData();
				++j;
				temp = temp.getNext();
			}

		}

	}

	public void attachToList(String value, int index) {
		nodes[index].add(value);

	}

	public void sort() {

		sort(1);
		
		sort(0);

	}

	private void sort(int position) {

		for (int i = 0; i < sortedNumbers.length; i++) {
			char c = sortedNumbers[i].charAt(position);
			Integer index = Integer.valueOf(String.valueOf(c));
			attachToList(sortedNumbers[i], index);

		}

		listToArray();

	}

	@Override
	public String toString() {
		return "RadixSort [numbers=" + Arrays.toString(sortedNumbers) + "]";
	}

	public Node[] getNodes() {
		return nodes;
	}

	public void setNodes(Node[] nodes) {
		this.nodes = nodes;
	}

	public String[] getSortedNumbers() {
		return sortedNumbers;
	}

	public void setSortedNumbers(String[] sortedNumbers) {
		this.sortedNumbers = sortedNumbers;
	}

}
