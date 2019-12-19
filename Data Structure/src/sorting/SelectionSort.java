package sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {

		int[] array = { 1, 70, 55, 44, 66, 8, 0 };

		System.out.println(Arrays.toString(array));

		for (int i = array.length - 1; i >= 0; i--) {

			int indexOfLargest = 0;

			// now here we wanna find the largest element in the array and we keep its index
			// in indexOfLargest variable
			for (int j = 0; j <= i; j++) {

				if (array[i] < array[j])
					indexOfLargest = j;

//				if (array[i] > array[j])
//					indexOfLargest = j;

			}

			int temp = array[i];
			array[i] = array[indexOfLargest];
			array[indexOfLargest] = temp;

		}

		System.out.println(Arrays.toString(array));

	}

}
