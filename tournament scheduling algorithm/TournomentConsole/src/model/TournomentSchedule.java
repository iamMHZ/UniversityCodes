package model;

import java.util.Arrays;
import java.util.Scanner;

public class TournomentSchedule {

	private int[][] table;

	public TournomentSchedule() {

	}

	public int[][] start(int number) {
		table = startScheduling(number, 1, number);
		String result = print();

		System.out.println(result);

		return table;

	}

	private String print() {

		String result = "";

		for (int i = 0; i < table.length; i++) {
			result += "\n";
			if (isInvalidRow(table[i]) == false)
				for (int j = 0; j < table.length; j++) {
					if (j == 0)
						result += String.format("%2s %2s  %2s", "Team ", String.valueOf(table[i][j]), " : ");
					else {
						if (table[i][j] == -1)
							result += String.format("%4s", "-");
						else
							result += String.format("  %2s ", String.valueOf(table[i][j]));
					}

				}

		}

		return result;

	}

	private int[][] startScheduling(int n, int start, int end) {

		// base case:
		if (n == 2) {
			int[][] baseCase = { { start, end }, { end, start } };
			return baseCase;
		}

		// odd:
		if (isOdd(n)) {

			int[][] even = startScheduling(n + 1, start, end + 1);

			even = clearNumber(even, end + 1);
			even = clearRow(even, n);

			return even;

		}

		// even:
		else if (isEven(n) && isEven(n / 2)) {
			int a[][];
			a = startScheduling(n / 2, start, start + (n / 2) - 1);

			int[][] b = latin(start + (n / 2), end);

			int[][] c = increase(a, n / 2);
			int[][] d = decrease(b, n / 2);

			int[][] merged = merge(a, b, c, d, n / 2);
			return merged;

		} else if (isEven(n) && isOdd(n / 2)) {

			int[][] firstHalf = startScheduling(n / 2, start, start + (n / 2) - 1);
			int[][] secondHalf = startScheduling(n / 2, start + (n / 2), end);

			int[][] firstLatin = latin(end, start + (n / 2));
			int[][] secondLatin = latin(start, start + (n / 2) - 1);

			int[][] mergedVertically = mergeVertically(firstHalf, secondHalf);
			int[][] result = find_and_fill(mergedVertically, firstLatin, secondLatin);

			return result;

		}
		return null;

	}

	private int[][] find_and_fill(int[][] array, int[][] latin1, int[][] latin2) {
		int latinPointer = 0;

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length && latinPointer < latin1.length; j++) {
				if (array[i][j] == -1) {

					int[] put = latin1[latinPointer];

					array[i][j] = put[put.length - 1];

					while (array[i][j] != 0)
						j++;

					for (int k = 0; k < put.length - 1; k++, j++) {
						array[i][j] = put[k];

					}

					latinPointer++;
				}
			}

		}

		latinPointer = latin2.length - 1;
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length && latinPointer >= 0; j++) {
				if (array[i][j] == -1) {

					int[] put = latin2[latinPointer];

					array[i][j] = put[put.length - 1];

					while (array[i][j] != 0)
						j++;

					for (int k = 0; k < put.length - 1; k++, j++) {
						array[i][j] = put[k];

					}

					latinPointer--;
				}
			}

		}

		return array;

	}

	private int[][] mergeVertically(int[][] firstHalf, int[][] secondHalf) {

		int counter1 = countInvalideRows(firstHalf);
		int counter2 = countInvalideRows(secondHalf);

		int length = firstHalf.length + secondHalf.length - (counter1 + counter2);
		int[][] result = new int[length][length];

		int i = 0;
		for (int j = 0; i < result.length && j < firstHalf.length; i++, j++) {

			if (isInvalidRow(firstHalf[j])) {
				i--;
				continue;
			}

			addToRow(result, firstHalf[j], i);
		}

		for (int j = 0; i < result.length && j < secondHalf.length; i++, j++) {

			if (isInvalidRow(secondHalf[j])) {
				i--;
				continue;
			}

			addToRow(result, secondHalf[j], i);
		}

		return result;
	}

	private int countInvalideRows(int[][] array) {

		int counter = 0;

		for (int i = 0; i < array.length; i++) {

			boolean flag = isInvalidRow(array[i]);

			if (flag == true)
				counter++;

		}

		return counter;
	}

	private boolean isInvalidRow(int[] row) {

		for (int i = 0; i < row.length; i++) {
			if (row[i] != -1)
				return false;
		}

		return true;
	}

	private boolean isOdd(int x) {

		if (x % 2 != 0)
			return true;
		return false;

	}

	private boolean isEven(int x) {
		if (x % 2 == 0)
			return true;
		return false;
	}

	private int[][] clearRow(int[][] array, int rowNumber) {

		for (int i = 0; i < array.length; i++)
			array[rowNumber][i] = -1;

		return array;
	}

	private int[][] clearNumber(int[][] array, int number) {

		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array.length; j++)
				if (array[i][j] == number)
					array[i][j] = -1;
		return array;
	}

	private int[][] merge(int[][] array1, int[][] array2, int[][] array3, int[][] array4, int index) {

		int length = array1.length * 2;
		int[][] result = new int[length][length];

		secondaryMerge(result, array1, 0, index, 0, index);
		secondaryMerge(result, array2, 0, index, index, length);

		secondaryMerge(result, array3, index, length, 0, index);
		secondaryMerge(result, array4, index, length, index, length);

		return result;
	}

	private void secondaryMerge(int[][] result, int[][] insert, int startRow, int endRow, int startColumn,
			int endColumn) {

		for (int i = startRow, k = 0; i < endRow && k < insert.length; i++, k++)
			for (int j = startColumn, l = 0; j < endColumn && l < insert[k].length; j++, l++)
				result[i][j] = insert[k][l];

	}

	private int[][] decrease(int[][] array, int number) {
		int[][] copy = copy2DArrays(array);

		for (int i = 0; i < copy.length; i++)
			for (int j = 0; j < copy[i].length; j++)
				copy[i][j] -= number;

		return copy;
	}

	private int[][] copy2DArrays(int[][] array) {

		int[][] copy = new int[array.length][array.length];

		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				copy[i][j] = array[i][j];
			}
		}

		return copy;
	}

	private int[][] increase(int[][] array, int number) {
		int[][] copy = copy2DArrays(array);

		for (int i = 0; i < copy.length; i++)
			for (int j = 0; j < copy[i].length; j++)
				copy[i][j] += number;

		return copy;
	}

	// creating two king of latin arrays in this method
//	because first and second half of array need different king of latins
	private int[][] latin(int start, int end) {
		int[] originalNumbers;
		int length;

//		starting with ascending array 
		if (start > end) {
			length = start - end + 1;
			originalNumbers = new int[length];
			for (int i = 0; i < originalNumbers.length; i++)
				originalNumbers[i] = start--;
		}

//		starting with descending array
		else {
			length = end - start + 1;
			originalNumbers = new int[length];
			for (int i = 0; i < originalNumbers.length; i++)
				originalNumbers[i] = start++;
		}

		int[][] result = new int[length][length];

		addToRow(result, originalNumbers, 0);

		for (int i = 1; i < originalNumbers.length; i++) {
			int[] shifted = shift(originalNumbers, i);

			addToRow(result, shifted, i);
		}
		return result;
	}

	private void addToRow(int[][] result, int[] arrryToInsert, int rowNumber) {

		for (int i = 0; i < arrryToInsert.length; i++) {
			result[rowNumber][i] = arrryToInsert[i];
		}

	}

	private int[] shift(int[] original, int shiftTime) {

		int[] copyOfOriginal = Arrays.copyOf(original, original.length);

		for (int i = 1; i <= shiftTime; i++) {
			int lastElement = copyOfOriginal[copyOfOriginal.length - 1];

			for (int j = copyOfOriginal.length - 1; j > 0; j--)
				copyOfOriginal[j] = copyOfOriginal[j - 1];

			copyOfOriginal[0] = lastElement;
		}

		return copyOfOriginal;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Enter a number: ");
			int number = scanner.nextInt();

			TournomentSchedule schedule = new TournomentSchedule();

			schedule.start(number);

			System.out.println("\n\n");

		 

		}

	}

}
