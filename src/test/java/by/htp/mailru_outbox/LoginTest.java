package by.htp.mailru_outbox;

import static org.testng.Assert.assertTrue;

import java.util.Date;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import by.htp.pageobject.EmailForm;
import by.htp.pageobject.MailBoxPage;
import by.htp.pageobject.MainPage;

public class LoginTest extends BaseTest {

	private static final Logger LOG = Logger.getLogger(LoginTest.class);
	public static final String DATA = new Date().toString();
	private static final String EMAIL_TEXT = "This is A. Shinkovich Test "+ DATA;

	@Test
	public void doLogin() {

		LOG.warn("start: navigate");
		MainPage mainPage = navigate(MainPage.URL);
		LOG.warn("start: login");
		LOG.info("enter: tathtp@mail.ru  Klopik123");
		MailBoxPage mailBox = mainPage.login("tathtp@mail.ru", "Klopik123");

		EmailForm email = mailBox.getEmailForm();
		LOG.info("send Email;");
		email.sendEmail("tathtp@mail.ru", "A. Shiknovich Email", EMAIL_TEXT);

		MailBoxPage mailBoxCheck = email.backInBox();
		LOG.info("check Email;");
		String titleEmail = mailBoxCheck.waitForMyEmail(EMAIL_TEXT);
		assertTrue(titleEmail.contains(EMAIL_TEXT));
		LOG.info("check OK;");
		closeBrowser();
	}
}