package selenium;

import org.testng.annotations.Test;
import play.libs.mailer.MailerClient;

public class MailTest {
    MailerClient mailerClient;
    @Test
    public void testEmail(){
        MailerService test = new MailerService(mailerClient);
        test.sendEmail();
    }
}
