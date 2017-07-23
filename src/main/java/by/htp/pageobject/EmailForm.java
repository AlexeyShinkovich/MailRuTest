package by.htp.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailForm extends BasePage {

	private static final String TO = "//div[@id='b-compose']//textarea[@data-original-name='To']";
	private static final String TOPIC_MAIL = "//div[@id='b-compose']//input[@class='b-input']";
	private static final String ADD_TEXT = "//body";
	private static final String SEND_BUTTON = "//div[@id='b-toolbar__right']//div[@data-name='send']";
	private static final String INBOX = "//div[@id='b-nav_folders']/div/div/a/span[text()='Входящие']";

	public EmailForm(WebDriver driver) {
		super(driver);
	}

	public void sendEmail(String toStr, String topicStr, String textStr) {
		WebElement to = getDriver().findElement(By.xpath(TO));
		to.click();
		to.sendKeys(toStr);
		WebElement topicMail = getDriver().findElement(By.xpath(TOPIC_MAIL));
		topicMail.click();
		topicMail.sendKeys(topicStr);
		WebElement text = driver.findElement(By.xpath(ADD_TEXT));
		text.click();
		text.sendKeys(Keys.CONTROL + "a");
		text.sendKeys(Keys.DELETE);
		text.sendKeys(Keys.ENTER);
		text.sendKeys(textStr);
		getDriver().findElement(By.xpath(SEND_BUTTON)).click();
	}

	public MailBoxPage backInBox() {
		getDriver().findElement(By.xpath(INBOX)).click();
		return new MailBoxPage(driver);
	}
}