package org.EmailCarbonFootprint;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.Store;

public class EmailCarbonFootprintService{
 
	private static final double CARBON_FOOTPRINT_OF_INBOX_EMAIL = 4.0;
	private static final double CARBON_FOOTPRINT_OF_SPAM_EMAIL = 0.3;
	private static final double CARBON_FOOTPRINT_OF_SENT_EMAIL = 4.9;
	static final int GRAM_TO_KILOGRAM = 1000;
	private static final String EMAIL_ID = "emailId";
	private static final String SOURCE = "source";
	private static final String INBOX = "inbox";
	private static final String SENT = "sent";
	private static final String SPAM = "spam";
	private String emailId;
	private String password;
	private String source;
	private int inboxEmailCount;
	private int sentEmailCount;
	private int spamEmailCount;
	GmailAccountDetails gmailAccountDetails;
	Store emailDataStore;
	static Map<String, String> emailCountDetails;

	public EmailCarbonFootprintService(String emailId, String password) throws MessagingException {
		this.emailId = emailId;
		this.password = password;
        emailDataStore = ConnectionProvider.getGmailConnection(this.emailId, this.password);
        gmailAccountDetails = new GmailAccountDetails(emailId, password,emailDataStore);
		this.inboxEmailCount = gmailAccountDetails.getCountOfInboxEmails();
		this.sentEmailCount = gmailAccountDetails.getCountOfSentEmails();
		this.spamEmailCount = gmailAccountDetails.getCountOfSpamEmails();
		this.source = getEmailSource(emailId);
		calculateEmailCarbonFootprint();
	}

	private void calculateEmailCarbonFootprint() {
		emailCountDetails = new HashMap<String, String>();
		emailCountDetails.put(EMAIL_ID, emailId);
		emailCountDetails.put(SOURCE, source);
		emailCountDetails.put(INBOX, Double.toString(inboxEmailCount * CARBON_FOOTPRINT_OF_INBOX_EMAIL));
		emailCountDetails.put(SENT, Double.toString(sentEmailCount * CARBON_FOOTPRINT_OF_SENT_EMAIL));
		emailCountDetails.put(SPAM, Double.toString(spamEmailCount * CARBON_FOOTPRINT_OF_SPAM_EMAIL));
	}

	private static String getEmailSource(String emailId) {
		if (emailId.contains("gmail")) {
			return "Gmail";
		} else if (emailId.contains("outlook")) {
			return "Outlook";
		} else if (emailId.contains("yahoo")) {
			return "Yahoo";
		}

		return "";
	}

	protected void printEmailCarbonFootprint() {
		for (Map.Entry<String, String> entry : emailCountDetails.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
