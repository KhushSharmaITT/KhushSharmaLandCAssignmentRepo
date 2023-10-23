import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class EmailCarbonFootprintCalculator {

    private static final double CARBON_FOOTPRINT_OF_INBOX_EMAIL = 4.0;
    private static final double CARBON_FOOTPRINT_OF_SPAM_EMAIL = 0.3;
    private static final double CARBON_FOOTPRINT_OF_SENT_EMAIL = 4.9;
    private static Map<String, String> carbonFootprint;
    private static final String EMAIL_ID = "emailId";
    private static final String SOURCE = "source";
    private static final String INBOX = "inbox";
    private static final String SENT = "sent";
    private static final String SPAM = "spam";


    private static double getInboxEmailsCarbonFootprint(double numberOfInboxEmails) {
        return (numberOfInboxEmails * CARBON_FOOTPRINT_OF_INBOX_EMAIL) / 1000;
    }

    private static double getSpamEmailsCarbonFootprint(double numberOfSpamEmails) {
        return (numberOfSpamEmails * CARBON_FOOTPRINT_OF_SPAM_EMAIL) / 1000;
    }

    private static double getSentEmailsCarbonFootprint(double numberOfSentEmails) {
        return (numberOfSentEmails * CARBON_FOOTPRINT_OF_SENT_EMAIL) / 1000;
    }

    private static Map<String, String> getEmailCarbonFootprint(String emailId, double inboxEmails, double spamEmails, double sentEmails) {
        carbonFootprint = new HashMap<>();

        carbonFootprint.put(EMAIL_ID, emailId);

        String source = getSource(emailId);

        if (source.isEmpty()) {
            carbonFootprint.put( SOURCE , "Unknown");
        } else {
            carbonFootprint.put( SOURCE , source);
        }

        double inboxEmailsCarbonFootprint = getInboxEmailsCarbonFootprint(inboxEmails);
        double spamEmailsCarbonFootprint = getSpamEmailsCarbonFootprint(spamEmails);
        double sentEmailsCarbonFootprint = getSentEmailsCarbonFootprint(sentEmails);

        carbonFootprint.put( INBOX, inboxEmailsCarbonFootprint + " KG");
        carbonFootprint.put( SPAM, spamEmailsCarbonFootprint + " KG");
        carbonFootprint.put( SENT, sentEmailsCarbonFootprint + " KG");

        return carbonFootprint;
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

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the emailId:");
        String emailId = sc.next();

        System.out.println("Enter the number of emails in inbox:");
        double inboxEmails = sc.nextDouble();

        System.out.println("Enter the number of emails in spam:");
        double spamEmails = sc.nextDouble();

        System.out.println("Enter the number of emails sent:");
        double sentEmails = sc.nextDouble();

        Map<String, String> emailCarbonFootprint = getEmailCarbonFootprint(emailId, inboxEmails, spamEmails, sentEmails);

        for (Map.Entry<String, String> entry : emailCarbonFootprint.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}