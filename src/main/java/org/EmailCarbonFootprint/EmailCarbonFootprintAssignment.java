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
		int inboxEmailCount;
		int sentEmailCount;
		int spamEmailCount;
		input.close();
		gmailAccountDetails = new GmailAccountDetails(emailId, password);
		try {
			Store emailDataStore = GmailConnection.getGmailConnection(gmailAccountDetails);
			inboxEmailCount = gmailAccountDetails.getCountOfInboxEmails(emailDataStore);
			sentEmailCount = gmailAccountDetails.getCountOfSentEmails(emailDataStore);
			spamEmailCount = gmailAccountDetails.getCountOfSpamEmails(emailDataStore);
			emailCarbonFootprintCalculator = new EmailCarbonFootprintCalculator(emailId, inboxEmailCount,
					sentEmailCount, spamEmailCount);
			emailCarbonFootprintCalculator.printEmailCarbonFootprint();
		} catch (MessagingException exception) {
			System.out.println(exception);
		}
	}
}
