package Assignment3;

import java.util.Random;
import java.util.Scanner;

public class practice {
	public static int kendallDistance(int[] array, int[] arrayTwo) {
		if (array.length != arrayTwo.length) {
			throw new IllegalArgumentException(
					"The dimensions of the arrays do not agree. Please try again, making sure array and arrayTwo have the same length.");

		}

		// Variable n represents length of both arrays
		int n = array.length;

		// Create counter (called distance)
		int distance = 0;

		// Compare values to find distance
		// If array[0] == arrayTwo[0], go to next index
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

	public static void main(String[] args) {

		//
		// -----Kendall Tau Distance -----
		//
		int array[] = {3,2,1,4,5,6};
		int arrayTwo[] = {3,2,5,1,4,6};

		// Initialize kendall tau distance
		int distance;

		// Print array with length n
		System.out.println("Here is array with length n.");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		// Print arrayTwo with length m
		System.out.println("Here is arrayTwo with length m.");
		for (int i = 0; i < arrayTwo.length; i++) {
			System.out.print(arrayTwo[i] + " ");
		}
		System.out.println();

		// Call kendallDistance to find kendall tau distance
		distance = kendallDistance(array, arrayTwo);

		// Print distance
		System.out.println("The kendall tau distance between these two arrays is " + distance);

	}
}
