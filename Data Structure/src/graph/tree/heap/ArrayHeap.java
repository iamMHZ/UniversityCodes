package graph.tree.heap;

import java.util.Arrays;

// this is a maxHeap implementation:
public class ArrayHeap {

	private Integer[] heap;
	private int size;

	public ArrayHeap(int[] heap) {
		size = heap.length;
		this.heap = new Integer[size];
		for (int i = 0; i < heap.length; i++) {
			this.heap[i] = new Integer(heap[i]);
		}

	}

	public Integer[] getHeap() {
		return heap;
	}

	public int getSize() {
		return size;
	}

	public boolean isFull() {
		if (size == heap.length)
			return true;
		return false;
	}

	public boolean isEmpty() {
		if (heap[0] == null)
			return true;

		return false;
	}

	private void resize() {

		Integer[] newHeap = new Integer[size * 2];

		size = heap.length;
		for (int i = 0; i < heap.length; i++) {
			newHeap[i] = heap[i];
		}

		heap = newHeap;

	}

	// this method finds the first null position in the array:
	private int getAddIndex() {
		if (heap[heap.length - 1] == null) {
			int i = heap.length - 1;
			for (; heap[i] == null && i >= 0;)
				i--;
			if (i + 1 < heap.length && i + 1 >= 0 && heap[i + 1] == null)
				return i + 1;
		}
		return -1;
	}

	// this method after any insertion is called by add method to
	// keep the the heap as a maxHeap any more:
	private void heapophy(int index) {

		while (index < heap.length) {
			int parentIndex = (index - 1) / 2;
			if (heap[index] > heap[parentIndex]) {
				swap(index, parentIndex);
				index = parentIndex;
			} else
				break;
		}

	}

	public void add(int value) {
		int indexToAdd = getAddIndex();
		if (indexToAdd >= 0) {
			heap[indexToAdd] = new Integer(value);

		} else {
			resize();
			indexToAdd = getAddIndex();
			heap[indexToAdd] = new Integer(value);

		}
		heapophy(indexToAdd);

	}

	// delete by index:
	public void deletebyIndex(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		heap[index] = heap[size - 1];
		heap[size - 1] = null;
		size--;
		while (index < size) {
			int j = 2 * index + 1;

			if (j + 1 < size && heap[j + 1] > heap[j])
				j++;
			if (j < size && heap[index] < heap[j]) {
				swap(index, j);
				index = j;
			} else
				return;
		}

	}

	// swap method to make things a little easier for other methods
	private void swap(int swaped, int swapWith) {
		int temp = heap[swaped];
		heap[swaped] = heap[swapWith];
		heap[swapWith] = temp;
	}

	// delete by value:
	public void deleteByValue(int value) {
		int index = search(value);
		deletebyIndex(index);
	}

	// search method
	private int search(int value) {
		for (int i = 0; i < heap.length; i++) {
			if (heap[i] == value)
				return i;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "ArrayHeap [heap=" + Arrays.toString(heap) + "]";
	}

}
