package com.KaprekarConstant;

import java.util.InputMismatchException;

import com.Console.ConsoleService;

public class KaprekarConstantController {

	static boolean checkForInput;
	public static void main(String... args) { 
		int iterations = 0;
        try {
		int inputNumber = ConsoleService.getUserInput("Enter the number:\n");
		checkForInput = KaprekarConstantService.checkForValidInput(inputNumber);
		if (checkForInput) {
			iterations = KaprekarConstantService.findKaprekarRoutine(inputNumber);
		}
		System.out.println(
				"Number of iterations to reach kaprekar routine are:\n" + iterations);
	}
		catch(InputMismatchException exc) {
			System.out.print("Entered number is not a valid number");
		}
	}
}
