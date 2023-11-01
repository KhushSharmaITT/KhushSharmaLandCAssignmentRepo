package org.EmailCarbonFootprint;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Store;

public class GmailAccountDetails {

	private String emailId;
	private String gmailAppPassword;

	public GmailAccountDetails() {
	}

	public GmailAccountDetails(String emailId, String appPassword) {
		this.emailId = emailId;
		this.gmailAppPassword = appPassword;
	}

	public String getUserEmailId() {
		return emailId;
	}

	public String getUserPassword() {
		return gmailAppPassword;
	}

	public int getCountOfInboxEmails(Store emailDataStore) throws MessagingException {
		Folder inboxCount = emailDataStore.getFolder("Inbox");
		inboxCount.open(Folder.READ_ONLY);
		int countOfInboxEmails = inboxCount.getMessageCount();
		inboxCount.close(false);
		return countOfInboxEmails;
	}

	public int getCountOfSpamEmails(Store emailDataStore) throws MessagingException {
		Folder spamCount = emailDataStore.getFolder("[Gmail]/Spam");
		spamCount.open(Folder.READ_ONLY);
		int countOfSpamEmails = spamCount.getMessageCount();
		spamCount.close(false);
		return countOfSpamEmails;
	}

	public int getCountOfSentEmails(Store emailDataStore) throws MessagingException {
		Folder sentCount = emailDataStore.getFolder("[Gmail]/Sent Mail");
		sentCount.open(Folder.READ_ONLY);
		int countOfSentEmails = sentCount.getMessageCount();
		sentCount.close(false);
		return countOfSentEmails;
	}
}
