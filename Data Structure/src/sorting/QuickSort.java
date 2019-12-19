package sorting;

public class QuickSort {

	static void partition(int[] arr, int low, int high, int pivoiIndex) {
		int pivot = arr[pivoiIndex];
		int leftlargeIndex = low, rightSmallIndex = high;

		while (true) {
			while (arr[leftlargeIndex] < pivot)
				leftlargeIndex++;

			while (arr[rightSmallIndex] > pivot)
				rightSmallIndex--;

			if (leftlargeIndex >= rightSmallIndex)
				return;

//			if (low > arr.length / 2 && high > arr.length / 2) {

			int temp = arr[leftlargeIndex];
			arr[leftlargeIndex] = arr[rightSmallIndex];
			arr[rightSmallIndex] = temp;
//			}

		}
	}

	static void quickSort(int[] arr, int low, int high) {
		if (low < high) {

			int pi = (low + high) / 2;
			partition(arr, low, high, pi);
			quickSort(arr, low, pi);
			quickSort(arr, pi + 1, high);
		}
	}

	static void printArray(int[] arr, int n) {
		for (int i = 0; i < n; i++)
			System.out.print(" " + arr[i]);
		System.out.println();
	}

	static public void main(String[] args) {
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;
		quickSort(arr, 0, n - 1);
		System.out.println("Sorted array: ");
		printArray(arr, n);
	}
}