package org.EmailCarbonFootprint;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class GmailConnection {

	static Store getGmailConnection(GmailAccountDetails accDetails) throws MessagingException {
        Properties properties = new Properties();
        properties.setProperty("mail.store.protocol", "imaps");
        properties.setProperty("mail.imap.host", "imap.example.com");
        properties.setProperty("mail.imap.port", "993");
        properties.put("mail.imaps.ssl.protocols", "TLSv1.2");
        properties.put("mail.imaps.ssl.ciphersuites", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");

        Session session = Session.getInstance(properties, null);
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com", accDetails.getUserEmailId(),accDetails.getUserPassword());
        return store;
    }
}
