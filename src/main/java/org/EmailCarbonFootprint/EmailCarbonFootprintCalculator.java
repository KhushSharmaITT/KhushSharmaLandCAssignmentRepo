package org.EmailCarbonFootprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	private double inboxEmailsCount;
	private double sentEmailsCount;
	private double spamEmailsCount;
	static Map<String, String> emailCountDetails;

	public EmailCarbonFootprintCalculator(String emailId, double inboxEmails, double sentEmails, double spamEmails) {
		this.emailIds = emailId;
		this.inboxEmailsCount = inboxEmails;
		this.sentEmailsCount = sentEmails;
		this.spamEmailsCount = spamEmails;
		this.source = getSource(emailId);
		getCarbonFootprint(source, emailIds, inboxEmailsCount, sentEmailsCount, spamEmailsCount);
	}

	private static void getCarbonFootprint(String source, String emailId, double inboxEmails, double sentEmails,
			double spamEmails) {
		emailCountDetails = new HashMap<String, String>();
		emailCountDetails.put(EMAIL_ID, emailId);
		emailCountDetails.put(SOURCE, source);
		emailCountDetails.put(INBOX, Double.toString(inboxEmails * CARBON_FOOTPRINT_OF_INBOX_EMAIL));
		emailCountDetails.put(SENT, Double.toString(sentEmails * CARBON_FOOTPRINT_OF_SENT_EMAIL));
		emailCountDetails.put(SPAM, Double.toString(spamEmails * CARBON_FOOTPRINT_OF_SPAM_EMAIL));
	}

	private static String getSource(String emailId) {
		if (emailId.contains("gmail")) {
			return "Gmail";
		} else if (emailId.contains("outlook")) {
			return "Outlook";
		} else if (emailId.contains("yahoo")) {
			return "Yahoo";
		}

		return "";
	}

	protected void printCarbonFootprint() {
		for (Map.Entry<String, String> entry : emailCountDetails.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
