package model;

import java.util.Arrays;

public class TournomentSchedule {

	private int[][] table;
//	private static final File outputFile = new File("D:\\Programming\\Files\\outPutOfTournomentAlgorithem.txt");

	public TournomentSchedule() {

	}

	public int[][] start(int number) {
		table = startScheduling(number, 1, number);
//		String result = printTable();

		// printing the output to the console:
//		System.out.println(result);

		// writing to the file:
//		try {
//			FileWriter fileWriter = new FileWriter(outputFile);
//			fileWriter.write(result);
//			fileWriter.flush();
//			fileWriter.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		return table;

	}

	public String printTable() {

		String result = "";

		for (int i = 0; i < table.length; i++) {
			result += "\n";
			if (isInvalidRow(table[i]) == false)
				for (int j = 0; j < table.length; j++) {
					if (j == 0)
						result += String.format("%6s %6s  %6s", "TEAM ", String.valueOf(table[i][j]), ":");
					else {
						if (table[i][j] == -1)
							result += String.format("%8s", "-");
						else
							result += String.format("  %6s  ", String.valueOf(table[i][j]));
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
			int[][] result = findAndFillRestDays(mergedVertically, firstLatin, secondLatin);

//			int[][] result = findAndfillRests(mergedVertically, firstLatin, secondLatin);

			return result;

		}
		return null;

	}

	private int[][] findAndFillRestDays(int[][] array, int[][] latin1, int[][] latin2) {
		int c = 0;

		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length && c < latin1.length; j++) {
				if (array[i][j] == -1) {

					int[] put = latin1[c];

					array[i][j] = put[put.length - 1];

					while (array[i][j] != 0)
						j++;

					for (int k = 0; k < put.length - 1; k++, j++) {
						array[i][j] = put[k];

					}

					c++;
				}
			}

		}

		c = latin2.length - 1;
		for (int i = 0; i < array.length; i++) {

			for (int j = 0; j < array.length && c >= 0; j++) {
				if (array[i][j] == -1) {

					int[] put = latin2[c];

					array[i][j] = put[put.length - 1];

					while (array[i][j] != 0)
						j++;

					for (int k = 0; k < put.length - 1; k++, j++) {
						array[i][j] = put[k];

					}

					c--;
				}
			}

		}

		return array;

	}

	private int[][] mergeVertically(int[][] firstHalf, int[][] secondHalf) {
		// merge them and delete -1 rows
		// invalid row is a row with all elements -1

		// counting invalid rows for both array and calculate the final array length:
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

	// find rows that are all -1 :
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

	private int[][] latin(int start, int end) {
		int[] originalNumbers;
		int length;
		// initializing array and length
		// for like 6 we need to Latin reversely
		// so we call the function and set start greater than end and function
		// understands to do Latin job reversely
		if (start > end) {
			length = start - end + 1;
			originalNumbers = new int[length];
			for (int i = 0; i < originalNumbers.length; i++)
				originalNumbers[i] = start--;
		} else {
			length = end - start + 1;
			originalNumbers = new int[length];
			for (int i = 0; i < originalNumbers.length; i++)
				originalNumbers[i] = start++;
		}

		int[][] result = new int[length][length];

		// add generated numbers as first Latin permutation:
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
//	private int[][] findAndfillRests(int[][] array, int[][] firstLatin, int[][] secondLatin) {
//
//		// find rested teams
//		// fill rest days
//		// delete last row and last column
//
//		int untilDay = array.length / 2;
//		// array index starts at 0 but team numbers stars at 1
//		// finding resed teams:
//		ArrayList<Integer> restedTeams = new ArrayList<>();
//		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
//		for (int dayNumber = 1; dayNumber <= untilDay; dayNumber++) {
//			ArrayList<Integer> restedTeamsInADay = findRestedTeams_InADay(array, dayNumber);
//
//			if (restedTeamsInADay.size() > 0) {
//				restedTeams.addAll(restedTeamsInADay);
//				map.put(dayNumber, restedTeamsInADay);
//			}
//		}
//
//		// filling rested days of a team:
//
//		int[][] finalResult = fillRests(array, map, firstLatin, secondLatin);
//
//		return finalResult;
//
////		boolean[] checkedTeams = new boolean[array.length + 1];
////		for (int dayNumber = 1; dayNumber <= untilDay; dayNumber++) {
////			int restedTeam = findRestedTeamInADay(array, dayNumber, checkedTeams);
////			checkedTeams[restedTeam] = true;
////			restedTeams.add(restedTeam);
////		}
//
////		for (int dayNumber = 1; dayNumber <= untilDay; dayNumber++) {
////			int restedTeam = findRestedTeamInADay(array, dayNumber, checkedTeams);
////			checkedTeams[restedTeam] = true;
////			restedTeams.add(restedTeam);
////		}
//	}

//	private int[][] fillRests(int[][] array, Map<Integer, ArrayList<Integer>> map, int[][] firstLatin,
//			int[][] secondLatin) {
//
//		int[][] result = array;
//
//		for (int i = 0; i < result.length; i++) {
//			for (int j = 0; j < result.length; j++) {
//				if (result[i][j] == -1) {
//					int dayNumber = j;
//
//					ArrayList<Integer> resedTeamsIn_dayNumber = map.get(dayNumber);
//					// fill that day
//					int resedTeam = resedTeamsIn_dayNumber.get(0);
//					result[i][j] = resedTeam;
//					// update the map and arrayList:
//					resedTeamsIn_dayNumber.remove(0);
//					map.put(dayNumber, resedTeamsIn_dayNumber);
//					// finding latin pattern:
//					int[] suitableLatin = findSuitableLatinPatern(firstLatin, secondLatin, resedTeam);
//
//					// filling array with pattern:
//					while (result[i][j] != 0) // finding starting index for adding latin:
//						j++;
//					for (int k = 0; k < suitableLatin.length - 1 && j < result.length; k++, j++) {
//						result[i][j] = suitableLatin[k];
//					}
//
////					System.out.println("here");
//				}
//			}
//		}
//
//		return result;
//	}

//	private int[] findSuitableLatinPatern(int[][] firstLatin, int[][] secondLatin, int resedTeam) {
//		// for debugging purposes return null if no mtched pattern found:
//		int[] result = null;
//		boolean isFound = false;
//		// searching in firstLatin:
//		for (int i = 0; i < firstLatin.length; i++) {
//			// checking last element in each row to find whether it is out suitable pattern
//			// of not:
//			int lastElementOfRow = firstLatin[i][firstLatin[i].length - 1];
//			if (lastElementOfRow == resedTeam) {
//				result = firstLatin[i];
//				isFound = true;
//				break;
//			}
//		}
//
//		// if isFound == false means that we did not found our pattern in firstLatin so
//		// we need to continue searching on seconDLatin:
//
//		for (int i = 0; i < secondLatin.length; i++) {
//			// checking last element in each row to find whether it is out suitable pattern
//			// of not:
//			int lastElementOfRow = secondLatin[i][secondLatin[i].length - 1];
//			if (lastElementOfRow == resedTeam) {
//				result = secondLatin[i];
//				isFound = true;
//				break;
//			}
//		}
//		return result;
//	}

//	// how to find rested teams in a day 3 methods:
//	private ArrayList<Integer> findRestedTeams_InADay(int[][] array, int dayNumber) {
//
//		int floor = array[0][0];
//		int ceil = getMax(array);
//
//		ArrayList<Integer> restedTeams = new ArrayList<>();
//
//		for (int teamNumber = ceil; teamNumber >= floor; teamNumber--) {
//			boolean flag = false;
//			for (int rowPointer = 0; rowPointer < array.length; rowPointer++) {
//
//				if (array[rowPointer][dayNumber] == teamNumber) {
//					flag = true;
//					break;
//				}
//
//			}
//
//			if (flag == false)
//				restedTeams.add(teamNumber);
//		}
//
//		return restedTeams;
//	}
//
//	private int getMax(int[][] array) {
//
//		int max = array[0][0];
//
//		for (int i = 1; i < array.length; i++) {
//			if (array[i][0] > max)
//				max = array[i][0];
//		}
//
//		return max;
//	}

	// this method has a problem
	// O(n) and this method returns all of rested teams in a day:
//	private ArrayList<Integer> findRestedTeamsInADay(int[][] array, int dayNumber) {
//		ArrayList<Integer> restedTeams = new ArrayList<>();
//		// starting for loop form 1 because first column is just representing team
//		// numbers
//		boolean[] playedTeams = new boolean[array.length + 1];
//
//		for (int i = 0; i < array.length; i++) {
//			int team = array[i][dayNumber];
//			// trick:
//			// we also have -1 in table
//			if (team >= 0)
//				playedTeams[team] = true;
//		}
//
//		// 0 is not a team number:
//		for (int i = playedTeams.length - 1; i >= 1; i--) {
//			if (!playedTeams[i])
//				restedTeams.add(i);
//		}
//
//		return restedTeams;
//	}
//
//	// this method has a problem
//	// O(n^2) and this method for every call just return one rested team
//	private int findRestedTeamInADay(int[][] array, int dayNumber, boolean[] checkedTeams) {
//		for (int i = 0; i < array.length; i++) {
//			int check = i + 1;
//			boolean flag = false;
//
//			if (!checkedTeams[check]) {
//				for (int j = 0; j < array.length; j++) {
//					if (array[j][dayNumber] == check) {
//
//						flag = true;
//						break;
//					}
//				}
//
//				if (flag == false)
//					return check;
//			}
//		}
//
//		return -1;
//	}

//	public static void main(String[] args) {
//
//		Scanner scanner = new Scanner(System.in);
//
//		while (true) {
//			System.out.println("Enter a number: ");
//			int number = scanner.nextInt();
//
//			TournomentSchedule schedule = new TournomentSchedule();
//
//			schedule.start(number);
//
////			System.out.println("\n\nTable: \n\n");
////			int[][] result = schedule.startScheduling(number, 1, number);
////			for (int i = 0; i < result.length; i++)
////
////				System.out.println(Arrays.toString(result[i]));
//
////			System.out.println("\n\n");
//		}
//	}

}
