package sparseMatrix;

public class Matrix {
	// fields and constructors:
	private int[][] array;
	private int valuableNums;

	public Matrix(int[][] array) {
		this.array = array;
		valuableNums = getValuableNumbers();
	}

	// getters & setters:
	public int[][] getArray() {
		return array;
	}

	public void setArray(int[][] array) {
		this.array = array;
	}

	// methods for changing sparse matrix to real and vice versa:
	public int[][] getSparse() {

		int[][] change = new int[valuableNums + 1][3];

		change[0][0] = array.length;
		change[0][1] = array[0].length;
		change[0][2] = valuableNums;

		int counter = 1;

		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[0].length; j++)
				if (array[i][j] != 0) {
					change[counter][0] = i;
					change[counter][1] = j;
					change[counter][2] = array[i][j];
					counter++;
				}

		return change;

	}

	// this function changes a sparse matrix to a real one:
	public int[][] expandSparse() {

		int[][] shrinkedSparse = getSparse();
		int row = shrinkedSparse[0][0];
		int col = shrinkedSparse[0][1];

		int[][] result = new int[row][col];

		// fill all elements with 0:
		// Arrays.fill(result, 0);

		for (int i = 1; i < shrinkedSparse.length; i++) {

			result[shrinkedSparse[i][0]][shrinkedSparse[i][1]] = shrinkedSparse[i][2];
		}

		return result;

	}

	// this function shows numbers of array that are not 0:
	private int getValuableNumbers() {
		int counter = 0;

		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[0].length; j++)
				if (array[i][j] != 0)
					counter++;

		return counter;

	}

	// print function that makes the printing tasks easier for multidimensional
	// arrays:
	public static void print(int[][] x) {
		for (int i = 0; i < x.length; i++) {

			for (int j = 0; j < x[i].length; j++)
				System.out.print(x[i][j] + "\t");
			System.out.println();
		}

		System.out.println("\n\n");
	}

	public void summation(Matrix m) {
		int[][] sparse1 = getSparse();
		int[][] sparse2 = m.getSparse();

//		Matrix.print(sparse2);

		if (sparse1[0][0] != sparse2[0][0] && sparse1[0][1] != sparse2[0][1]) {
			System.out.println("rows and columns are not equal");
		} else {
			int row = sparse1[0][0];
			int col = sparse1[0][1];

			int[][] result = new int[row][col];

			for (int i = 1; i < row; i++) {

				if (sparse1[i][0] == sparse2[i][0] && sparse1[i][1] == sparse2[i][1]) {

					result[sparse1[i][0]][sparse1[i][1]] = sparse1[i][2] + sparse2[i][2];
				} else {
					result[sparse1[i][0]][sparse1[i][1]] += sparse1[i][2];
					result[sparse2[i][0]][sparse2[i][1]] += sparse2[i][2];
				}

			}
			Matrix.print(result);
		}

	}

}
