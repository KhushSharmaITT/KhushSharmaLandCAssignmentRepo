import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

class KaprekarConstant {

	private static int findKaprekarRoutine(int number) {

		int iterations = 0;
		int numberOfDigits = (Integer.toString(number)).length();

		int[] arrayOfDigits = new int[numberOfDigits];

		while (number != 6174) {
			for (int i = numberOfDigits - 1; i >= 0; i--) {
				int digit = number % 10;
				arrayOfDigits[i] = digit;
				number /= 10;
			}

			if (arrayOfDigits[0] == arrayOfDigits[1] && arrayOfDigits[1] == arrayOfDigits[2]
					&& arrayOfDigits[2] == arrayOfDigits[3])
				throw new InputMismatchException();

			Arrays.sort(arrayOfDigits);

			int ascendingNumber = 0;
			int descendingNumber = 0;

			for (int i = 0; i < numberOfDigits; i++) {
				ascendingNumber = ascendingNumber * 10 + arrayOfDigits[i];
				descendingNumber = descendingNumber * 10 + arrayOfDigits[(numberOfDigits - 1) - i];
			}

			number = descendingNumber - ascendingNumber;
			iterations++;
		}

		return iterations;
	}

	private static boolean checkKaprekarConstant(int inputChoice) throws InputMismatchException {

		if (Integer.toString(inputChoice).length() < 4
				|| Integer.toString(inputChoice).length() > 4) {
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
				int inputNumber = input.nextInt();
				checkForInput = checkKaprekarConstant(inputNumber);
				if (checkForInput) {
					iterations = findKaprekarRoutine(inputNumber);
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