package test;
/**
 * @author MHZ
 * iammhz77@gmail.com
 */

import java.util.Arrays;

public class ModiffiedMergeSort {

	void sort(int arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			sort(arr, l, m);
			sort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	public void merge(int[] array, int low, int mid, int high) {

		
		// at the last time when you call merge
		// low is 0 and high is array.length and at that time the array is already sorted in the
		// way we want 
		//so no needs of running the function
		// if we run it we will be in while loop forever
		if (low == 0 && high == array.length - 1)
			return;

		int p = low;
		int q = mid + 1;
		int[] temp = new int[high - low + 1];
		int k = 0;

		while (p <= mid && q <= high) {

			if ((high <= (array.length / 2)) && (low < (array.length / 2))) {

				if (array[p] == array[q]) {
					temp[k++] = array[p++];
					temp[k++] = array[q++];
				}
				else if (array[p] > array[q]) {

					temp[k++] = array[q++];

				}
				else if (array[p] < array[q]) {

					temp[k++] = array[p++];

				}

			}

			if ((high < array.length) && (low >= (array.length / 2))) {

				if (array[p] == array[q]) {
					temp[k++] = array[p++];
					temp[k++] = array[q++];
				}
				else if (array[p] > array[q]) {

					temp[k++] = array[p++];

				}
				else if (array[p] < array[q]) {
					temp[k++] = array[q++];
				}
			}

		}

		while (p <= mid)
			temp[k++] = array[p++];
		while (q <= high)
			temp[k++] = array[q++];

		k = 0;
		for (int i = low; i <= high; i++) {
			array[i] = temp[k++];
		}

	}

	public static void main(String[] args) {

		System.out.println("RUNNING");

		int[] arr = {110, 20, 20, 30, 2, 3, 7 ,80};

		ModiffiedMergeSort modiffiedMergeSort = new ModiffiedMergeSort();

		modiffiedMergeSort.sort(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));

	}

}
