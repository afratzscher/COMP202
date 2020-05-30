package Assignment2;

import java.util.Random;
import java.util.Scanner;

public class MatrixCalculator {

	private static Scanner sc;

	public static void main(String[] args) {
		// Declaring the variables
		int userSelection;
		int[][] firstMatrix = null;
		int[][] secondMatrix = null;
		int size = -1;
		// do_while loop to show the main menu to the user
		do {
			// Printing the menu
			System.out.println("\nPlease type the index of one of the following options...");
			System.out.println("1 Fill two matrices by user-input.");
			System.out.println("2 Fill two matrices by random numbers.");
			System.out.println("3 Print matrices.");
			System.out.println("4 Check if the matrices are magic.");
			System.out.println("5 Transpose the matrices.");
			System.out.println("6 Sum two matrices.");
			System.out.println("7 Multiply two matrices.");
			System.out.println("8 Exit the program.");

			// Using Scanner to get the index Selected by the user
			sc = new Scanner(System.in);
			userSelection = sc.nextInt();

			// Switch block to model the possible execution paths.
			switch (userSelection) {
			case 1:
				System.out.println("Please type one integer representing the size of the matrices.");
				size = sc.nextInt();
				System.out.println("Filling the first Matrix");
				firstMatrix = FillUser(size);
				System.out.println("Filling the second Matrix");
				secondMatrix = FillUser(size);
				break;
			case 2:
				System.out.println("Please type one integer representing the size of the matrices.");
				size = sc.nextInt();
				System.out.println("Filling the first Matrix");
				firstMatrix = FillRandom(size);
				System.out.println("Filling the second Matrix");
				secondMatrix = FillRandom(size);
				break;
			case 3:
				if (size != -1) {
					System.out.println("Printing the first Matrix.");
					PrintMatrix(firstMatrix);
					System.out.println("Printing the second Matrix.");
					PrintMatrix(secondMatrix);
				} else {
					System.out.println("Sorry, but you need to fill in the matrices first.");
				}
				break;
			case 4:
				boolean magic;
				if (size != -1) {
					magic = IsMagic(firstMatrix);
					System.out.println("Is your first matrix magic?: " + magic);
					magic = IsMagic(secondMatrix);
					System.out.println("Is your second matrix magic?: " + magic);
				} else {
					System.out.println("Sorry, but you need to fill in the matrices first.");
				}
				break;
			case 5:
				if (size != -1) {
					System.out.println("Transposing the first Matrix.");
					firstMatrix = Transpose(firstMatrix);
					System.out.println("Transposing the second Matrix.");
					secondMatrix = Transpose(secondMatrix);
				} else {
					System.out.println("Sorry, but you need to fill in the matrices first.");
				}
				break;
			case 6:
				if (size != -1) {
					System.out.println("Printing the addition of the two matrices.");
					PrintMatrix(Addition(firstMatrix, secondMatrix));
				} else {
					System.out.println("Sorry, but you need to fill in the matrices first.");
				}
				break;
			case 7:
				if (size != -1) {
					System.out.println("Printing the multiplication of the two matrices.");
					PrintMatrix(Multiply(firstMatrix, secondMatrix));
				} else {
					System.out.println("Sorry, but you need to fill in the matrices first.");
				}
				break;
			case 8:
				System.out.println("Thanks for using the Matrix Calculator Program.....");
				break;
			default:
				System.out.println("Please insert a number between 1 and 8");
				break;
			}

		} while (userSelection != 8);
		System.out.println();

	}

	public static int[][] FillUser(int size) {
		int[][] matrix = new int[size][size];
		/*
		 * Please insert below your code to fill in the matrix using the
		 * user-input data
		 */

		// USER INPUTED MATRIX
		// Print instructions on how to enter elements
		System.out.print("     > Please enter the elements one by one. ");
		System.out.print("Press enter after entering each element. ");
		System.out.print("NOTE: Matrix fills a row before moving to next row.");
		System.out.println();

		/*
		 * Create loop to fill out matrix (you fill out row, column by column,
		 * before moving to next row)
		 */
		for (int i = 0; i < matrix.length; i++) { // i represents columns
			for (int j = 0; j < matrix[i].length; j++) { // j represents rows
				/*
				 * Inputed integer goes into column i and row j (ea. if i=0,j=1,
				 * integer is second element of first array)
				 */
				matrix[i][j] = sc.nextInt();
			}

			/*
			 * Creates line space between row inputs so can see when you are
			 * moving onto the next row
			 */
			System.out.println();
		}

		System.out.println();

		// Your code must end here.
		return matrix;
	}

	public static int[][] FillRandom(int size) {
		int[][] matrix = new int[size][size];
		/*
		 * Please insert below your code to fill in the matrix using
		 * random-generated data
		 */

		// RANDOMLY GENERATED MATRIX
		// Initialize numberGenerator
		Random numberGenerator = new Random();

		/*
		 * Create loop to fill out matrix randomly (you fill one row, column by
		 * column, before moving to next column)
		 */
		for (int i = 0; i < matrix.length; i++) { // i represents columns
			for (int j = 0; j < matrix[i].length; j++) { // j represents rows
				/*
				 * assigns each element a value between 1 and value of inputed
				 * size (inclusive) -> NOTE: each element is assigned
				 * independently (ea. matrix[0][1] could have diff. value from
				 * matrix [0][2])
				 */
				matrix[i][j] = numberGenerator.nextInt(((size + 1) - 1)) + 1;
			}
		}

		System.out.println();

		// Your code must end here.
		return matrix;
	}

	public static void PrintMatrix(int[][] matrix) {
		// Please insert below your code to print the matrix

		// PRINT MATRIX
		System.out.println("Here is your matrix:");

		// Create loop to print matrix
		for (int i = 0; i < matrix.length; i++) { // i represents columns
			for (int j = 0; j < matrix[i].length; j++) { // j represents rows
				/*
				 * Print an element, followed by space, before moving to next
				 * element in array
				 */
				System.out.print(matrix[i][j] + " ");
			}
			// Prints next row on different line (to achieve square matrix)
			System.out.println();
		}

		System.out.println();

		// Your code must end here.
	}

	public static boolean IsMagic(int[][] matrix) {
		boolean isMagic = true;
		// Please insert below your code to check if the matrix is magic

		// MAGIC MATRIX - TRUE OR FALSE
		int i; // i represents columns
		int j; // j represents rows

		// SUM OF COLUMNS
		// Create sum of column variable
		int sumColumn = 0;
		// Loop to find sum of each column
		for (i = 0; i < matrix.length; i++) {
			sumColumn = 0;
			for (j = 0; j < matrix[i].length; j++) {
				sumColumn = sumColumn + matrix[i][j];
			}
		}

		// SUM OF ROWS
		// Create sum of row variable
		int sumRow = 0;
		// Loop to find sum of each row
		for (j = 0; j < matrix.length; j++) {
			sumRow = 0;
			for (i = 0; i < matrix[j].length; i++) {
				sumRow = sumRow + matrix[i][j];
			}
		}

		// SUM OF DIAGONAL FROM LEFT TO RIGHT
		/*
		 * Create sum of Diagonal from left to right (starts at origin and goes
		 * to last element of last array)
		 */
		int sumDiagonalLR = 0;
		// Loop to find sum of diagonal from left to right
		for (i = 0; i < matrix.length; i++) {
			sumDiagonalLR = sumDiagonalLR + matrix[i][i];
		}

		// SUM OF DIAGONAL FROM RIGHT TO LEFT
		/*
		 * Create sum of Diagonal from right to left (from last element of first
		 * array to first element of last array)
		 */
		int sumDiagonalRL = 0;
		// Loop to find sum of diagonal from right to left
		for (i = 0; i < matrix.length; i++) {
			sumDiagonalRL = sumDiagonalRL + matrix[i][matrix.length - 1 - i];
		}

		// CHECK IF SUMS ARE EQUAL
		// If all sums equal, it is a magic matrix
		if ((sumRow == sumColumn) && (sumRow == sumDiagonalLR) && (sumRow == sumDiagonalRL)) {
			isMagic = true;
		}

		// If all sums are not equal to each other, it is not a magic matrix
		else {
			isMagic = false;
		}

		System.out.println();

		// Your code must end here.
		return isMagic;
	}

	public static int[][] Transpose(int[][] matrix) {
		int size = matrix.length;
		int[][] matrixTransposed = new int[size][size];
		// Please insert below your code to transpose matrix

		// TRANSPOSE MATRICES
		// Create diagonal of transposed matrix (same values as in original)
		for (int i = 0; i < matrixTransposed.length; i++) {
			matrixTransposed[i][i] = matrix[i][i];
		}

		// Transpose non-diagonal values
		for (int i = 0; i < matrixTransposed.length; i++) {
			for (int j = 0; j < matrixTransposed[i].length; j++) {
				matrixTransposed[i][j] = matrix[j][i];
			}
		}

		System.out.print("     > Finished transposing matrix. ");
		System.out.println("Press 3 to print transposed matrix.");

		System.out.println();

		// Your code must end here.
		return matrixTransposed;
	}

	public static int[][] Addition(int[][] firstMatrix, int[][] secondMatrix) {
		int size = firstMatrix.length;
		int[][] matrixAdded = new int[size][size];
		// Please insert below your code to add the two matrices

		// ADDING TWO MATRICES
		/*
		 * Loop to add each element from secondMatrix to element in same
		 * location in firstMatrix
		 */
		for (int i = 0; i < matrixAdded.length; i++) { // i represents columns
			for (int j = 0; j < matrixAdded[i].length; j++) { /*
																 * j represents
																 * rows
																 */
				matrixAdded[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
			}
		}

		System.out.println("     > Finished adding matrices.");

		System.out.println();

		// Your code must end here.
		return matrixAdded;
	}

	public static int[][] Multiply(int[][] firstMatrix, int[][] secondMatrix) {
		int size = firstMatrix.length;
		int[][] matrixMultiplied = new int[size][size];
		// Please insert below your code to multiply the two matrices

		// MULTIPLYING TWO MATRICES
		// For firstMatrix, i represents columns, j represents rows
		// For secondMatrix, k represents columns, j represents rows
		int i, j, k;

		// Declare and Initialize sum variable
		int sum = 0; // sum equals result of adding all products of elements

		// Loop to multiply firstMatrix times secondMatrix
		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				for (k = 0; k < size; k++) {
					sum = sum + firstMatrix[i][k] * secondMatrix[k][j];
					matrixMultiplied[i][j] = sum;
				}
				/*
				 * Reinitialize sum so that sum from previous element in matrix
				 * doesn't carry over
				 */
				sum = 0;
			}
		}

		System.out.println("     > Finished multiplying matrices.");

		System.out.println();

		// Your code must end here.
		return matrixMultiplied;
	}
}