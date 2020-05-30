package Assignment3;

import java.util.Random;
import java.util.Scanner;

public class Permutations {
	// ----- RANDOM PERMUTATION-----
	public static int[] randomPermutation(int n) {
		// Initialize array
		int[] array = new int[n];

		// Insert integers from 1 to n into array
		for (int i = 0; i < n; i++) {
			array[i] = i + 1;
		}

		// Swap indexOne and indexTwo n times
		if (n == 1) {
			return array;
		}
		for (int i = 0; i < n; i++) {

			// Select indexes to swap
			Random numberGenerator = new Random();
			int indexOne = numberGenerator.nextInt(((n - 1) + 1) - 0) + 0;
			int indexTwo = numberGenerator.nextInt(((n - 1) + 1) - 0) + 0;
			// Repeat selecting indexes if indexOne = indexTwo
			while (indexOne == indexTwo) {
				indexOne = numberGenerator.nextInt(((n - 1) + 1) - 0) + 0;
				indexTwo = numberGenerator.nextInt(((n - 1) + 1) - 0) + 0;
			}

			// Swaps indexOne and indexTwo
			int temp = array[indexOne];
			array[indexOne] = array[indexTwo];
			array[indexTwo] = temp;

		}
		return array;
	}

	// ------CHECKBOARD ------
	public static String[][] checkBoard(int[] array) {
		System.out.println("Here is your visualized permutation: ");

		// Initialize matrix
		String[][] matrix = new String[array.length][array.length];
		// Print initial array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		// Matrix Visualization
		System.out.println();
		for (int i = 0; i < array.length; i++) { // i represents rows
			for (int j = 0; j < array.length; j++) { // j represents columns in
														// a row
				if (array[j] == i + 1) {
					matrix[i][j] = "Q";
				} else {
					matrix[i][j] = "*";
				}
			}
		}

		// Print matrix
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
		return matrix;
	}

	// ----- QUEENSCHECKER ------
	public static boolean queensChecker(String[][] matrix) {
		// Create flag
		boolean flag = true;

		// Check row by row
		for (int i = 0; i < matrix[0].length; i++)
			// Check for each column
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j].equals("Q")) {
					// Check that no other queen in column
					for (int k = i + 1; k < matrix[0].length; k++) {
						if (matrix[k][j].equals("Q")) {
							flag = false;
							break;
						}
					}

					// Check no other queen in row
					for (int l = j + 1; l < matrix[0].length; l++) {
						if (matrix[i][l].equals("Q")) {
							flag = false;
							break;

						}
					}

					// Check diagonal down and right
					for (int k = i + 1, l = j + 1; k < matrix[0].length && l < matrix[0].length; k++, l++) {
						if (matrix[k][l].equals("Q")) {
							flag = false;
							break;
						}
					}

					// Check diagonal up and left
					for (int k = i - 1, l = j - 1; k > 0 && l > 0; k--, l--) {
						if (matrix[k][l].equals("Q")) {
							flag = false;
							break;
						}
					}

					// Check diagonal down and left
					for (int k = i + 1, l = j - 1; k < matrix[0].length && l > 0; k++, l--) {
						if (matrix[k][l].equals("Q")) {
							flag = false;
							break;
						}
					}

					// Check diagonal up and right
					for (int k = i - 1, l = j + 1; k > 0 && l < matrix[0].length; k--, l++) {
						if (matrix[k][l].equals("Q")) {
							flag = false;
							break;
						}
					}
				}
			}
		// Return to main method
		return flag;
	}

	// ---PERMUTATION ENCRYPTION-----
	public static String permutationEncryption(String phrase, int[] key) {
		// Break phrase and encryptedPhrase into char array
		char[] phraseChar = phrase.toCharArray();

		// Create char array to store encrypted phrase
		char[] encryptedChar = new char[phraseChar.length];

		// Find out how many times to run key
		int rotation = phraseChar.length / key.length;

		// Key length
		int n = key.length;

		// Use newKey to encrypt phrase
		for (int turn = 1; turn <= rotation; turn++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (key[j] == i + 1) {
						encryptedChar[j + ((turn - 1) * n)] = phraseChar[i + ((turn - 1) * n)];
					}
				}
			}
		}
		System.out.println();
		// Return to main method
		return String.valueOf(encryptedChar);
	}

	// ----- KENDALL TAU DISTANCE -----
	public static int kendallDistance(int[] array, int[] arrayTwo) {
		// If arrays not same length, throw exception
		if (array.length != arrayTwo.length) {
			throw new IllegalArgumentException(
					"The dimensions of the arrays do not agree. Please try again, making sure array and arrayTwo have the same length.");

		}

		// Variable n represents length of both arrays
		int n = array.length;

		// Create counter called distance
		int distance = 0;

		// Compare values to find distance
		/*
		 * If array[0] == arrayTwo[0], go to next index (ea. try for index 1,
		 * index 2...)
		 */
		for (int i = 0; i < n; i++) {
			// If array has larger index i than arrayTwo
			if (array[i] < arrayTwo[i]) {
				for (i = 0; i < n; i++) {
					for (int j = n - 1; j >= 0; j--) {
						if (((array[i] < array[j]) && !(arrayTwo[i] < arrayTwo[j]))) {
							distance = distance + 1;
						}
					}
				}
				break;
			}

			// If arrayTwo has larger index i than array
			if (array[i] > arrayTwo[i]) {
				for (i = 0; i < n; i++) {
					for (int j = n - 1; j >= 0; j--) {
						if (((array[i] > array[j]) && !(arrayTwo[i] > arrayTwo[j]))) {
							distance = distance + 1;
						}
					}
				}
				break;
			}

		}
		return distance;
	}

	// -----MAIN METHOD -----
	public static void main(String[] args) {
		// Initialize scanner
		Scanner s = new Scanner(System.in);

		// Initialize variables
		int n; // n represents the length of the permutation

		// User input for n
		System.out.println("> Please input the desired length of the permutation.");
		n = s.nextInt();

		// Create array for permutation
		int[] array = new int[n];

		//
		// ----- Random Permutation -----
		//

		// Call randompermutation to generate random permutation of size n
		array = randomPermutation(n);

		// Print now shuffled array
		System.out.println();
		System.out.println("Here is completely shuffled Array: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		//
		// ----- Visualizing a Permutation -----
		//

		// Create matrix
		String[][] matrix = new String[array.length][array.length];

		// Call method checkBoard to assign Q or * to each position in matrix
		System.out.println();
		matrix = checkBoard(array);

		// -----Queens Checker-----

		// Create boolean called solved (represents if is valid solution or not)
		boolean solved = queensChecker(matrix);

		if (solved == false) {
			System.out.println("No, this is NOT a valid solution for the n queens puzzle.");
		} else {
			System.out.println("Yes, this is a valid solution for the n queens puzzle.");
		}
		System.out.println();

		//
		// ----- Permutation Encryption -----
		//

		// Initialize key -> key is the shuffled random permutation of size n
		int[] key = new int[n];

		// Assign values to elements of key
		for (int k = 0; k < n; k++) {
			key[k] = array[k];
		}

		// Print key
		System.out.println("Your key is ");
		for (int i = 0; i < key.length; i++) {
			System.out.print((key[i]) + " ");
		}
		System.out.println();

		// Initialize new scanner
		Scanner sc = new Scanner(System.in);

		// Initialize variables
		String phrase;

		// Enter phrase
		System.out.println("> Please enter your phrase for encryption.");
		phrase = sc.nextLine();

		// Add extra spaces to phrase so length of string is a multiple of
		// length of key
		int modulo = phrase.length() % key.length;
		if (modulo != 0) {
			for (int i = 0; i <= modulo; i++) {
				phrase = phrase + " ";
			}
		}

		// Call method permutationEncryption
		String encryptedPhrase = permutationEncryption(phrase, key);

		// Print permutation
		System.out.println("The encrypted phrase is: " + "'" + encryptedPhrase + "'");
		System.out.println();

		//
		// -----Kendall Tau Distance -----
		//

		// User input for m
		int m;
		System.out.println("Please input the desired length of the second permutation.");
		m = sc.nextInt();

		// Create new array to store new permutation
		int[] arrayTwo = new int[m];

		// Shuffle arrayTwo
		arrayTwo = randomPermutation(m);

		// Initialize Kendall tau distance
		int distance;

		// Call kendallDistance to find Kendall tau distance
		distance = kendallDistance(array, arrayTwo);
		System.out.println();

		// Print array with length n
		System.out.println("Here is array with length n:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println();

		// Print arrayTwo with length m
		System.out.println("Here is arrayTwo with length m:");
		for (int i = 0; i < arrayTwo.length; i++) {
			System.out.print(arrayTwo[i] + " ");
		}
		System.out.println();
		System.out.println();

		// Print distance
		System.out.println("The kendall tau distance between these two arrays is " + distance + ".");

	}
}
