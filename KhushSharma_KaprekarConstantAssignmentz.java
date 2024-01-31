import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

class KaprekarConstant {

	private static int[] arrayOfDigits;
	private static int ascendingNumber;
	private static int descendingNumber;
	private static int inputNumber;
	private static int numberOfDigits;
	private static boolean flag;

	private static void prepareData(int index) {

		if (arrayOfDigits == null) {
			arrayOfDigits = new int[numberOfDigits];
		}
		if (flag) {
			int digit = inputNumber % 10;
			arrayOfDigits[index] = digit;
		} else {
			ascendingNumber = ascendingNumber * 10 + arrayOfDigits[index];
			descendingNumber = descendingNumber * 10 + arrayOfDigits[(numberOfDigits - 1) - index];
		}
	}

	private static int findKaprekarRoutine() {

		int iterations = 0;
		numberOfDigits = (Integer.toString(inputNumber)).length();

		while (inputNumber != 6174) {
			ascendingNumber = 0;
			descendingNumber = 0;
			for (int index = numberOfDigits - 1; index >= 0; index--) {
				flag = true;
				prepareData(index);
				inputNumber /= 10;
			}
			flag = false;

			if (arrayOfDigits[0] == arrayOfDigits[1] && arrayOfDigits[1] == arrayOfDigits[2]
					&& arrayOfDigits[2] == arrayOfDigits[3])
				throw new InputMismatchException();

			Arrays.sort(arrayOfDigits);

			for (int index = 0; index < numberOfDigits; index++) {
				prepareData(index);
			}

			inputNumber = descendingNumber - ascendingNumber;
			iterations++;

		}

		return iterations;
	}

	private static boolean checkForValidInput() throws InputMismatchException {

		if (Integer.toString(inputNumber).length() < 4
				|| Integer.toString(inputNumber).length() > 4) {
			throw new InputMismatchException();
		}
		return true;
	}

	public static void main(String... args) {

		System.out.println("Enter the choice: \n");
		System.out.println("1 for finding the Kaprekar Constant : \n");
		System.out.println("2 for exit: \n");
		try {
			Scanner input = new Scanner(System.in);
			int inputChoice = input.nextInt();
			boolean checkForInput;
			int iterations = 0;
			switch (inputChoice) {
			case 1:
				System.out.print("Enter the number:\n");
				inputNumber = input.nextInt();
				checkForInput = checkForValidInput();
				if (checkForInput) {
					iterations = findKaprekarRoutine();
				}
				System.out.println(
						"Number of iterations to reach kaprekar routine are:\n" + iterations);
				break;

			case 2:
				return;
			}
		} catch (InputMismatchException exc) {
			System.out.print("Entered number is not a valid number");
		}
	}
}