package Assignment1;

public class Grade {

	public static void main(String[] args) {
		// defining the assignment, midtermExam, finalExam and textGrade
		// variables.
		int assignment = -1, midtermExam = -1, finalExam = -1;
		char textGrade = 'a';

		// Checking that there are three arguments in the program
		if (args.length != 3) {
			System.out.println("You need to enter three arguments to this program");
			return;
		}

		// Checking that the arguments are right
		assignment = getIntegerNumber(args[0], 1);
		midtermExam = getIntegerNumber(args[1], 2);
		textGrade = getChar(args[2], 3);

		// Printing the arguments
		System.out.println("The score of assignments is: " + assignment);
		System.out.println("The score of the midterm is: " + midtermExam);
		System.out.println("The desired text mark is: " + textGrade);

		// Enter your code below.
		// ========================

		System.out.print("Final: " + finalExam);
		// ========================
		// Enter your code above

	}

	public static int getIntegerNumber(String arg, int position) {
		try {
			int value;
			value = Integer.parseInt(arg);
			// checking if it is a number between 0 and 100
			if (value >= 0 && value <= 100) {
				return value;
			} else {
				System.out.println("ERROR: " + " The argument in the position " + position
						+ " must be an integer between 0 and 100");
			}
		} catch (NumberFormatException e) {
			System.out.println(
					"ERROR: " + e.getMessage() + " The argument in the position " + position + " must be an integer");
		}
		// error, return -1
		return -1;
	}

	public static char getChar(String arg, int position) {
		try {
			char value;
			if (arg.length() == 1) {
				value = arg.charAt(0);
				if (value == 'A' || value == 'B' || value == 'C' || value == 'D' || value == 'F') {
					return value;
				} else {
					System.out.println("ERROR: " + " The argument in the position " + position
							+ " must be a char from the set {'A','B','C','D','F'}");
				}
			} else {
				System.out.println(
						"ERROR: " + " The argument in the position " + position + " contains more than one character");
			}

		} catch (NumberFormatException e) {
			System.out.println(
					"ERROR: " + e.getMessage() + " The argument in the position " + position + " must be a Char");
		}
		// error, return 'z'
		return 'z';
	}
}
