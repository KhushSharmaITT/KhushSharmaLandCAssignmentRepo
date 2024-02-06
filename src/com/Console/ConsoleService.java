package com.Console;

import java.util.Scanner;

public class ConsoleService {
	
	private static Scanner input;
	
	static {
		input = new Scanner(System.in);
	}

	public static int getUserInput(String message) {
		System.out.println(message);
		int userInput = input.nextInt();
		return userInput;
	}
}