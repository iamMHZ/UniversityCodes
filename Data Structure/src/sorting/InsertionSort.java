package sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] array = { 1, 70, 55, 44, 66, 8, 0 };
		System.out.println("Unsorted:  " + Arrays.toString(array));

		for (int i = 1; i < array.length; i++) {
			int newValue = array[i];

			int j;

			for (j = i; j > 0 && array[j - 1] > newValue; j--) {
				array[j] = array[j - 1];
			}

			array[j] = newValue;

		}

		System.out.println("S" + "orted:  " + Arrays.toString(array));
	}

}
