
/**
 * @author Mohammad Hossein Ziaadini
 * 
 * 
 */

package application;

import java.util.Arrays;

public class Queens {

	private static int answer = 1;



	public void placeQueens(int[] columnPositions, int q) {

		if (q == columnPositions.length) {
			System.out.println(answer++ + " : \n" + Arrays.toString(columnPositions) + "\n");
//			print(columnPositions);

		}

		else {

			// Iterate over queens:
			for (int i = 0; i < columnPositions.length; i++) {

				if (canPalce(columnPositions, i, q)) {
					columnPositions[q] = i;
					placeQueens(columnPositions, q + 1);

				}

			}

		}

	}

	private void print(int[] array) {

		int queen = 1;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (j == array[i]) {
					System.out.print(" " + queen++ + " ");
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
		System.out
				.println("\n**************************************************************************************\n");

	}

	private boolean canPalce(int[] columnPositions, int col, int row) {

		if (row == 0)
			return true;

		for (int j = 0; j < row; j++) {
			if (col == columnPositions[j] || row - col == j - columnPositions[j] || row + col == j + columnPositions[j])
				return false;
		}

		return true;
	}



}
