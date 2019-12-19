package junitTest;

// testing two things:

//1- every team plays only 1 match in a day
//2- every team plays with all teams 

public class TestTable {

	private int[][] table;
	private int numberOfteam;

	public TestTable(int[][] table, int numberOfTeams) {
		this.table = table;
		this.numberOfteam = numberOfTeams;
	}
 
	// check that rule number 1:

//	public boolean checkEveryTeamPlaysOnceDayly() {
//
//		for (int columnPointer = 0; columnPointer < table.length; columnPointer++) {
//			for (int rowPointer = 1; rowPointer < table.length; rowPointer++) {
//				int number = table[rowPointer][columnPointer];
//				if (number != -1)
//					for (int k = rowPointer + 1; k < table.length; k++) {
//						if (table[k][columnPointer] == number)
//							return false;
//					}
//			}
//		}
//
//		return true;
//	}

	public boolean checkEveryTeamPlaysOnceDayly() {

		for (int i = 0; i < table.length; i++)
			for (int j = 1; j < table.length; j++) {
				if (table[i][j] != -1 && i != j) {
					int value = table[i][j];
					if (  table[value - 1][j] != i + 1)
						return false;
				}
			}

		return true;

	}

	public boolean checkEveryTeamPlaysWithAllOthers() {
		int length;
		if (numberOfteam % 2 == 0)
			length = table.length;
		else
			length = table.length - 1;

		for (int i = 0; i < table.length; i++) {

			int[] array = table[i];
			if (isNotInvald(array))
				for (int j = 1; j <= length; j++) {
					boolean flag = search(array, j);
					if (flag == false)
						return false;

				}

		}

//		// trick :
//		for (int i = 0; i < table.length; i++) {
//			boolean[] flag = new boolean[length];
//			for (int j = 0; j < table[i].length; j++) {
//				// means that table[i][j] palyed and we decrement it because team numbers starts
//				// from 1 but flag array indices starts from 0
//				if (table[i][j] != -1)
//					flag[table[i][j] - 1] = true;
//			}
//
//			// checking if all teams got the true:
//			for (int k = 0; k < flag.length; k++) {
//				if (flag[k] == false)
//					// means that team j+1 not played
//					return false;
//			}
//		}

		return true;
	}

	private boolean isNotInvald(int[] array) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] >= 0)
				return true;
		}

		return false;
	}

	private boolean search(int[] array, int number) {

		for (int i = 0; i < array.length; i++) {
			if (array[i] == number)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {

		int[][] array = { { 1, 2, 3, -1 }, { 2, 1, -1, 3 }, { 3, -1, 1, 2 }, { -1, -1, -1, -1 } };

		TestTable table = new TestTable(array, 3);
		boolean ret = table.checkEveryTeamPlaysOnceDayly();
		System.out.println(ret);

	}

}
