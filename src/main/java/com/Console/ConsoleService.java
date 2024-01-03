package com.Console;

import java.util.Scanner;

public class ConsoleService {
	
	private static Scanner input;
	
	static {
		input = new Scanner(System.in);
	}

	public static String getUserInput(String message) {
		System.out.println(message);
		String userInput = input.next();
		return userInput;
	}
}
