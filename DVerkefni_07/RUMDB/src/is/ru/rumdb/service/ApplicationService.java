package is.ru.rumdb.service;

import is.ru.rumdb.mail.MailGateway;

/**
 * Created by joezombie on 1.10.2014.
 */
public class ApplicationService {
    MailGateway mailGateway;

    public MailGateway getMailGateway() {
        return mailGateway;
    }

    public void setMailGateway(MailGateway mailGateway) {
        this.mailGateway = mailGateway;
    }
}
