package is.ru.rumdb.mail;

/**
 * Created by joezombie on 1.10.2014.
 */
public interface MailGateway {
    public void sendMessage(String to, String from, String subject, String body);
}
