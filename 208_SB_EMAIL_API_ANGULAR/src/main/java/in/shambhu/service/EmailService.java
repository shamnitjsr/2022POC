package in.shambhu.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public boolean sendEmail(String to, String subject, String message) {
		// rest of the code ...

		boolean f = false;

		String from = "shambhuk260@gmail.com";

		// variable for gmail..

		String host = "smtp.gmail.com";

		// get the system properties

		Properties properties = System.getProperties();
		System.out.println("PROPERTIES" + properties);

		// setting important information to properties object

		// host set

		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// step 1 : to get the session object...

		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("shambhuk260@gmail.com", "*****");
			}
		});

		session.setDebug(true);

		// Step 2 : compose the message [text, multi media]
		MimeMessage m = new MimeMessage(session);

		try {
			// from email
			m.setFrom(to);

			// adding recipient to message
			m.setText(message);
			// Step3 : send the message using Transport class
			Transport.send(m);

			f = true;

			System.out.println("Sent Success...........");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
