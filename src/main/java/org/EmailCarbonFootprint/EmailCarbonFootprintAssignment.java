package org.EmailCarbonFootprint;

import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.Store;

public class EmailCarbonFootprintAssignment {

	public static void main(String[] args) {
		GmailAccountDetails gmailAccountDetails;
		EmailCarbonFootprintCalculator emailCarbonFootprintCalculator;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the emailId:");
		String emailId = input.next();
		System.out.print("Enter your email password: ");
		String password = input.next();
		int inboxEmailsCount;
		int sentEmailsCount;
		int spamEmailsCount;
		input.close();
		gmailAccountDetails = new GmailAccountDetails(emailId, password);
		try {
			Store emailDataStore = GmailConnection.getGmailConnection(gmailAccountDetails);
			inboxEmailsCount = gmailAccountDetails.getCountOfInboxEmails(emailDataStore);
			sentEmailsCount = gmailAccountDetails.getCountOfSentEmails(emailDataStore);
			spamEmailsCount = gmailAccountDetails.getCountOfSpamEmails(emailDataStore);
			emailCarbonFootprintCalculator = new EmailCarbonFootprintCalculator(emailId, inboxEmailsCount,
					sentEmailsCount, spamEmailsCount);
			emailCarbonFootprintCalculator.printEmailCarbonFootprint();
		} catch (MessagingException exception) {
			System.out.println(exception);
		}
	}
}
