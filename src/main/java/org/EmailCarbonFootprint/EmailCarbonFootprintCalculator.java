package org.EmailCarbonFootprint;

import java.util.HashMap;
import java.util.Map;

public class EmailCarbonFootprintCalculator {

	private static final double CARBON_FOOTPRINT_OF_INBOX_EMAIL = 4.0;
	private static final double CARBON_FOOTPRINT_OF_SPAM_EMAIL = 0.3;
	private static final double CARBON_FOOTPRINT_OF_SENT_EMAIL = 4.9;
	static final int GRAM_TO_KILOGRAM = 1000;
	private static final String EMAIL_ID = "emailId";
	private static final String SOURCE = "source";
	private static final String INBOX = "inbox";
	private static final String SENT = "sent";
	private static final String SPAM = "spam";
	private String emailIds;
	private String source;
	private int inboxEmailsCount;
	private int sentEmailsCount;
	private int spamEmailsCount;
	static Map<String, String> emailCountDetails;

	public EmailCarbonFootprintCalculator(String emailId, int inboxEmails, int sentEmails, int spamEmails) {
		this.emailIds = emailId;
		this.inboxEmailsCount = inboxEmails;
		this.sentEmailsCount = sentEmails;
		this.spamEmailsCount = spamEmails;
		this.source = getEmailSource(emailId);
		calculateEmailCarbonFootprint(source, emailIds, inboxEmailsCount, sentEmailsCount, spamEmailsCount);
	}

	private static void calculateEmailCarbonFootprint(String source, String emailId, int inboxEmailsCount, int sentEmailsCount,
			int spamEmailsCount) {
		emailCountDetails = new HashMap<String, String>();
		emailCountDetails.put(EMAIL_ID, emailId);
		emailCountDetails.put(SOURCE, source);
		emailCountDetails.put(INBOX, Double.toString(inboxEmailsCount * CARBON_FOOTPRINT_OF_INBOX_EMAIL));
		emailCountDetails.put(SENT, Double.toString(sentEmailsCount * CARBON_FOOTPRINT_OF_SENT_EMAIL));
		emailCountDetails.put(SPAM, Double.toString(spamEmailsCount * CARBON_FOOTPRINT_OF_SPAM_EMAIL));
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
