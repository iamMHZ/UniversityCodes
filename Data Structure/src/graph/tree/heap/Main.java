package graph.tree.heap;

public class Main {

	public static void main(String[] args) {
		int[] arrayHeap = { 11, 8, 7, 3, 5, 4, -1 };
		ArrayHeap heap = new ArrayHeap(arrayHeap);
		System.out.println(heap);
		heap.add(23);
		System.out.println(heap);

	}

}
