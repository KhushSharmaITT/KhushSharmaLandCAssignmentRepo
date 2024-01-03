package org.EmailCarbonFootprint;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class ConnectionProvider {

	static Store getGmailConnection(String emailId, String password) throws MessagingException {
		Properties emailConnectionProperties = new Properties();
		emailConnectionProperties.setProperty("mail.store.protocol", "imaps");
		emailConnectionProperties.setProperty("mail.imap.host", "imap.example.com");
		emailConnectionProperties.setProperty("mail.imap.port", "993");
		emailConnectionProperties.put("mail.imaps.ssl.protocols", "TLSv1.2");
		emailConnectionProperties.put("mail.imaps.ssl.ciphersuites", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");

		Session connectionSession = Session.getInstance(emailConnectionProperties, null);
		Store emailDataStore = connectionSession.getStore("imaps");
		emailDataStore.connect("imap.gmail.com", emailId, password);
		return emailDataStore;
	}
}
