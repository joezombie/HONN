package is.ru.rumdb.mail;

/**
 * Created by joezombie on 1.10.2014.
 */
public class MailServerStub implements MailGateway {
    @Override
    public void sendMessage(String to, String from, String subject, String body) {
        System.out.println(
                "To: " + to + "\n"
              + "From: " + from + "\n"
              + "Subject: " + subject + "\n"
              + "Body: " + body + "\n"
        );
    }
}
