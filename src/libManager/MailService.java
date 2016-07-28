package libManager;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import libManager.bean.AddMemberBean;

public class MailService {
	
	public void sendMail(AddMemberBean amb)throws Exception{

	Properties mailServerProperties = System.getProperties();
	mailServerProperties.put("mail.smtp.port", "587");
	mailServerProperties.put("mail.smtp.auth", "true");
	mailServerProperties.put("mail.smtp.starttls.enable", "true");

	// Step2 getting mail
	Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
	MimeMessage generateMailMessage = new MimeMessage(getMailSession);
	generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(amb.emaiId));
	generateMailMessage.setSubject("Library Membership Confirmation..");
	String emailBody = "Hai "+amb.sName+",<br><p>You have successfully registered for the Library Membership.</p><br>--<br><br>Thanks & Regards,<br>ADMIN<br>Library Manager.";
	generateMailMessage.setContent(emailBody, "text/html");

	// Step3
	Transport transport = getMailSession.getTransport("smtp");

	// Enter your correct gmail UserID and Password
	// if you have 2FA enabled then provide App Specific Password
	transport.connect("smtp.gmail.com", "venkey123456@gmail.com", "9291145173");
	transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
	transport.close();
	}
}
