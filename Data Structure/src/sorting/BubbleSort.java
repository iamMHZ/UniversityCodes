package sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] array = { 1, 70, 55, 44, 66, 8, 0 };
		System.out.println("Unsorted:  "+Arrays.toString(array));
		for (int i = array.length - 1; i >= 0; i--) {

			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		System.out.println("Sorted:  "+Arrays.toString(array));
	}
}
