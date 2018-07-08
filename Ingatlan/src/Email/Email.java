package Email;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	public static void sendMail() {
		try {
			String host = "smtp.gmail.com";
			String user = "pin.coding.gmbh@gmail.com";
			String password = "pinCodingAdmin";
			String to = "andraspaksy@yahoo.com";
			String from = "pin.coding.gmbh@gmail.com";
			String subject = "Teszt email";
			String messageText = "Teszt email szövegtörzs";
			boolean sessionDebug = false;
			Properties properties = System.getProperties();
			properties.put("mail.smtp.stattls.enable", "true");
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port", 587);
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.stattls.required", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			Session mailSession = Session.getDefaultInstance(properties, null);
			mailSession.setDebug(sessionDebug);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from));
			InternetAddress[] address = { new InternetAddress(to) };
			msg.setRecipients(Message.RecipientType.TO, address);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(messageText);
			Transport transport = mailSession.getTransport("smtp");
			transport.connect(host, user, password);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("Üzenet küldés sikeres.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
