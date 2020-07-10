package sen300.lewis.notificationservice;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserJpaRepository userRepository;

	@RequestMapping(path = "/notify", method = RequestMethod.GET)
	public void emailAllUsers() {
		for (User user : userRepository.findAll()) {
			if (user.email != null) {
				String from = "subscribernotifmicroservice@gmail.com";

				String to = user.email;

				String host = "smtp.gmail.com";
				final String username = from;
				final String password = "asdfSen300";

				Properties properties = System.getProperties();
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.port", "587");
				properties.put("mail.smtp.starttls.enable", "true");

				Session session = Session.getDefaultInstance(properties, null);

				try {
					Transport transport = session.getTransport("smtp");
					transport.connect(host, username, password);
					MimeMessage message = new MimeMessage(session);

					message.setFrom(new InternetAddress(from));

					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

					message.setSubject("Test");

					message.setContent("<p>Notification of Microservice activity<p>", "text/html");

					transport.sendMessage(message, message.getAllRecipients());
					transport.close();
					System.out.println("Sent message successfully....");
				} catch (MessagingException mex) {
					mex.printStackTrace();
				}
			}
		}
	}
}
