package org.EmailCarbonFootprint;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Store;

public class GmailAccountDetails {

	private String emailId;
	private String appPassword;
	
	public GmailAccountDetails() {
	}
	
	public GmailAccountDetails(String emailId, String appPassword) {
		this.emailId =  emailId;
		this.appPassword = appPassword;
	}
	public String getUserEmailId() {
		return emailId;
	}
	public String getUserPassword() {
		return appPassword;
	}
	
	public double getNumberOfInboxEmails(Store store) throws MessagingException {
        Folder inbox = store.getFolder("Inbox");
        inbox.open(Folder.READ_ONLY);
        double numberOfInboxEmails = inbox.getMessageCount();
        inbox.close(false);
        return numberOfInboxEmails;
    }

    public double getNumberOfSpamEmails(Store store) throws MessagingException {
        Folder spam = store.getFolder("[Gmail]/Spam");
        spam.open(Folder.READ_ONLY);
        double numberOfSpamEmails = spam.getMessageCount();
        spam.close(false);
        return numberOfSpamEmails;
    }

    public double getNumberOfSentEmails(Store store) throws MessagingException {
        Folder sent = store.getFolder("[Gmail]/Sent Mail");
        sent.open(Folder.READ_ONLY);
        double numberOfSentEmails = sent.getMessageCount();
        sent.close(false);
        return numberOfSentEmails;
    }
}

