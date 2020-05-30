package Assignment1;

public class Encryption {

	public static void main(String[] args) {
		/*
		 * defining the digits. digit1 represents the 'thousand' digit. digit2
		 * represents the 'hundred' digit. digit3 represents the 'tens' digit.
		 * digit4 represents the 'ones' digit.
		 */
		int digit1, digit2, digit3, digit4;
		digit1 = 2;
		digit2 = 3;
		digit3 = 4;
		digit4 = 5;
		

		// Checking that there are four arguments (one for each digit) in the
		// program
		if (args.length != 4) {
			System.out.println("You need to enter four arguments to this program");
			return;
		}

		// Checking that the arguments are integers
		digit1 = getIntegerNumber(args[0], 1);
		digit2 = getIntegerNumber(args[1], 2);
		digit3 = getIntegerNumber(args[2], 3);
		digit4 = getIntegerNumber(args[3], 4);

		// Printing the arguments
		System.out.println("The first digit is: " + digit1);
		System.out.println("The second digit is: " + digit2);
		System.out.println("The third digit is: " + digit3);
		System.out.println("The fourth digit is: " + digit4);

		// ========================
		// Enter your code below for the step 1 of the encryption process
		int reverseDigitThousands = digit4 * 1000;
		int reverseDigitHundreds = digit3 * 100;
		int reverseDigitTens = digit2 * 10;
		int reverseDigitOnes = digit1 * 1;
		int invertedCode = reverseDigitThousands + reverseDigitHundreds + reverseDigitTens + reverseDigitOnes;

		System.out.println("Step 1: " + invertedCode);
		// Enter your code above for the step 1 of the encryption process

		// ========================
		// Enter your code below for the step 2 of the encryption process

		if (invertedCode >= 4987) {
			int sumOfDigits = (digit4 + digit3 + digit2 + digit1);
			int greaterThanCode = invertedCode - sumOfDigits;
			int newGreaterThanDigitThousands, newGreaterThanDigitHundreds, newGreaterThanDigitTens,
					newGreaterThanDigitOnes;
			newGreaterThanDigitThousands = greaterThanCode / 1000;
			newGreaterThanDigitHundreds = (greaterThanCode - (1000 * newGreaterThanDigitThousands)) / 100;
			newGreaterThanDigitTens = (greaterThanCode - (1000 * newGreaterThanDigitThousands)
					- (100 * newGreaterThanDigitHundreds)) / 10;
			newGreaterThanDigitOnes = (greaterThanCode - (1000 * newGreaterThanDigitThousands)
					- (100 * newGreaterThanDigitHundreds) - (10 * newGreaterThanDigitTens));
			greaterThanCode = (1000 * newGreaterThanDigitThousands) + (100 * newGreaterThanDigitHundreds)
					+ (10 * newGreaterThanDigitTens) + (1 * newGreaterThanDigitOnes);
			System.out.println("Step 2:" + greaterThanCode);

		} else {
			int sumOfDigits = (digit4 + digit3 + digit2 + digit1);
			int lessThanCode = invertedCode + sumOfDigits;
			int newLessThanDigitThousands, newLessThanDigitHundreds, newLessThanDigitTens, newLessThanDigitOnes;
			newLessThanDigitThousands = lessThanCode / 1000;
			newLessThanDigitHundreds = (lessThanCode - (1000 * newLessThanDigitThousands)) / 100;
			newLessThanDigitTens = (lessThanCode - (1000 * newLessThanDigitThousands)
					- (100 * newLessThanDigitHundreds)) / 10;
			newLessThanDigitOnes = (lessThanCode - (1000 * newLessThanDigitThousands) - (100 * newLessThanDigitHundreds)
					- (10 * newLessThanDigitTens));
			lessThanCode = (1000 * newLessThanDigitThousands) + (100 * newLessThanDigitHundreds)
					+ (10 * newLessThanDigitTens) + (1 * newLessThanDigitOnes);
			System.out.println("Step 2:" + lessThanCode);

		}

		// Enter your code above for the step 2 of the encryption process

		// ========================
		// Enter your code below for the step 3 of the encryption process

		if (invertedCode >= 4987) {
			int sumOfDigits = (digit4 + digit3 + digit2 + digit1);
			int greaterThanCode = invertedCode - sumOfDigits;
			int newGreaterThanDigitThousands, newGreaterThanDigitHundreds, newGreaterThanDigitTens,
					newGreaterThanDigitOnes;
			newGreaterThanDigitThousands = greaterThanCode / 1000;
			newGreaterThanDigitHundreds = (greaterThanCode - (1000 * newGreaterThanDigitThousands)) / 100;
			newGreaterThanDigitTens = (greaterThanCode - (1000 * newGreaterThanDigitThousands)
					- (100 * newGreaterThanDigitHundreds)) / 10;
			newGreaterThanDigitOnes = (greaterThanCode - (1000 * newGreaterThanDigitThousands)
					- (100 * newGreaterThanDigitHundreds) - (10 * newGreaterThanDigitTens));
			greaterThanCode = (1000 * newGreaterThanDigitThousands) + (100 * newGreaterThanDigitHundreds)
					+ (10 * newGreaterThanDigitTens) + (1 * newGreaterThanDigitOnes);

			int maxDigit = Math.max(newGreaterThanDigitThousands, newGreaterThanDigitOnes);
			int minDigit = Math.min(newGreaterThanDigitThousands, newGreaterThanDigitOnes);

			if (greaterThanCode % 2 == 0) {
				int finalCode = greaterThanCode + maxDigit;
				System.out.println("Step 3:" + finalCode);

			} else {
				int finalCode = greaterThanCode - minDigit;
				System.out.println("Step 3:" + finalCode);

			}
		} else {
			int sumOfDigits = (digit4 + digit3 + digit2 + digit1);
			int lessThanCode = invertedCode + sumOfDigits;
			int newLessThanDigitThousands, newLessThanDigitHundreds, newLessThanDigitTens, newLessThanDigitOnes;
			newLessThanDigitThousands = lessThanCode / 1000;
			newLessThanDigitHundreds = (lessThanCode - (1000 * newLessThanDigitThousands)) / 100;
			newLessThanDigitTens = (lessThanCode - (1000 * newLessThanDigitThousands)
					- (100 * newLessThanDigitHundreds)) / 10;
			newLessThanDigitOnes = (lessThanCode - (1000 * newLessThanDigitThousands) - (100 * newLessThanDigitHundreds)
					- (10 * newLessThanDigitTens));
			lessThanCode = (1000 * newLessThanDigitThousands) + (100 * newLessThanDigitHundreds)
					+ (10 * newLessThanDigitTens) + (1 * newLessThanDigitOnes);

			int maxDigit = Math.max(newLessThanDigitThousands, newLessThanDigitOnes);
			int minDigit = Math.min(newLessThanDigitThousands, newLessThanDigitOnes);

			if (lessThanCode % 2 == 0) {
				int finalCode = lessThanCode + maxDigit;
				System.out.println("Step 3:" + finalCode);

			} else {
				int finalCode = lessThanCode - minDigit;
				System.out.println("Step3:" + finalCode);

			}
		}

	}

	// Enter your code above for the step 3 of the encryption process

	public static int getIntegerNumber(String arg, int position) {
		try {
			int value;
			value = Integer.parseInt(arg);
			// checking if it is a digit
			if (value >= 0 && value <= 9) {
				return value;
			} else {
				System.out.println("ERROR: " + " The argument in the position " + position
						+ " must be an integer between 0 and 9");
			}
		} catch (NumberFormatException e) {
			System.out.println(
					"ERROR: " + e.getMessage() + " The argument in the position " + position + " must be an integer");
		}
		// error, return -1
		return -1;
	}

}