package org.EmailCarbonFootprint;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Store;

public class GmailAccountDetails {

	private String emailId;
	private String AppPassword;
	private Store emailDataStore;

	public GmailAccountDetails(String emailId, String emailAppPassword, Store emailDataStore) {
		this.emailId = emailId;
		this.AppPassword = emailAppPassword;
		this.emailDataStore = emailDataStore;
	}

	public String getUserEmailId() {
		return emailId;
	}

	public String getUserPassword() {
		return AppPassword;
	}

	public int getCountOfInboxEmails() throws MessagingException {
		Folder inboxFolder = emailDataStore.getFolder("Inbox");
		inboxFolder.open(Folder.READ_ONLY);
		int countOfInboxEmails = inboxFolder.getMessageCount();
		inboxFolder.close(false);
		return countOfInboxEmails;
	}

	public int getCountOfSpamEmails() throws MessagingException {
		Folder spamFolder = emailDataStore.getFolder("[Gmail]/Spam");
		spamFolder.open(Folder.READ_ONLY);
		int countOfSpamEmails = spamFolder.getMessageCount();
		spamFolder.close(false);
		return countOfSpamEmails;
	}

	public int getCountOfSentEmails() throws MessagingException {
		Folder sentFolder = emailDataStore.getFolder("[Gmail]/Sent Mail");
		sentFolder.open(Folder.READ_ONLY);
		int countOfSentEmails = sentFolder.getMessageCount();
		sentFolder.close(false);
		return countOfSentEmails;
	}
}
