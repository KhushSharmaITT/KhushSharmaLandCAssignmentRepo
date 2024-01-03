package org.EmailCarbonFootprint;

import javax.mail.MessagingException;

import com.Console.ConsoleService;

public class EmailCarbonFootprintController {

	public static void main(String[] args) {
	
		String emailId = ConsoleService.getUserInput("Enter the emailId:");
		String password = ConsoleService.getUserInput("Enter your email password: ");
		EmailCarbonFootprintService emailCarbonFootprintService;
		try {
            emailCarbonFootprintService = new EmailCarbonFootprintService(emailId, password);
			emailCarbonFootprintService.printEmailCarbonFootprint();
		} catch (MessagingException exception) {
			System.out.println(exception);
		}
	}
}
