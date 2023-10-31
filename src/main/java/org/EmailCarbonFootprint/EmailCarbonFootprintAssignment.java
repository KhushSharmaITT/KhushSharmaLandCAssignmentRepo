package org.EmailCarbonFootprint;

import java.util.Map;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.Store;

public class EmailCarbonFootprintAssignment {

	public static void main(String[] args) {
		GmailAccountDetails gmailAccountDetails;
		EmailCarbonFootprintCalculator emailCarbonFootprintCalculator;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the emailId:");
		String emailId = scanner.next();
		System.out.print("Enter your email password: ");
		String password = scanner.next();
		double inboxEmailsCount;
		double sentEmailsCount;
		double spamEmailsCount;
		gmailAccountDetails = new GmailAccountDetails(emailId, password);
		try {
			Store store = GmailConnection.getGmailConnection(gmailAccountDetails);
			inboxEmailsCount = gmailAccountDetails.getNumberOfInboxEmails(store);
			sentEmailsCount = gmailAccountDetails.getNumberOfSentEmails(store);
			spamEmailsCount = gmailAccountDetails.getNumberOfSpamEmails(store);
			emailCarbonFootprintCalculator = new EmailCarbonFootprintCalculator(emailId, inboxEmailsCount,
					sentEmailsCount, spamEmailsCount);
			emailCarbonFootprintCalculator.printCarbonFootprint();
		} catch (MessagingException exception) {
			System.out.println(exception);
		}
	}
}
