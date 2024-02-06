package com.KaprekarConstant;

import java.util.Arrays;
import java.util.InputMismatchException;

public class KaprekarConstantService {

	private static int[] arrayOfDigits;
	private static int ascendingNumber;
	private static int descendingNumber;
	private static int numberOfDigits;
	private static boolean flag;
	private static int inputNumber;
	
	public static boolean checkForValidInput(int inputNumber) throws InputMismatchException {

		if (Integer.toString(inputNumber).length() < 4
				|| Integer.toString(inputNumber).length() > 4) {
			throw new InputMismatchException();
		}
		return true;
	}
	
	public static int findKaprekarRoutine(int userInputNumber) {

		inputNumber = userInputNumber;
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

}
