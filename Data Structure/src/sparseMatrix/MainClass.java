package sparseMatrix;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// get rows and columns:
		Scanner scanner = new Scanner(System.in);
		System.out.print("enter the number of rows:");
		int rows = scanner.nextInt();

		System.out.print("enter the number of columns:");
		int col = scanner.nextInt();

		int[][] arr = new int[rows][col];
		// scan the array:
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print("Enter a number: ");
				arr[i][j] = scanner.nextInt();
			}
		}
		// print:
		System.out.println("\n\nReal matrix:");
		Matrix.print(arr);

		// change the array to a sparse array:
		Matrix matrix = new Matrix(arr);
		int[][] sparse = matrix.getSparse();
		// print:
		System.out.println("\n\nSparse:");
		Matrix.print(sparse);

		// we mined the real matrix from sparse version:
		int[][] expanded = matrix.expandSparse();
		// print:
		System.out.println("\n\nReal matrix:");
		Matrix.print(expanded);

		// getting another MATRIX for summation:
		System.out.print("\n\nfor summation please enter another matrix:\n\n");
		System.out.print("enter the number of rows:");
		int rows2 = scanner.nextInt();

		System.out.print("enter the number of columns:");
		int col2 = scanner.nextInt();

		int[][] arr2 = new int[rows2][col2];
		// scan the array:
		for (int i = 0; i < rows2; i++) {
			for (int j = 0; j < col2; j++) {
				System.out.print("Enter a number: ");
				arr2[i][j] = scanner.nextInt();
			}
		}

		Matrix matrix2 = new Matrix(arr2);
		matrix.summation(matrix2);
		
		scanner.close();
	}

}
