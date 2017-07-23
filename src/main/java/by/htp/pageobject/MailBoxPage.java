package by.htp.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailBoxPage extends BasePage {

	private static final String SEND_EMAIL = "//div[@id='b-toolbar__left']//span[text()='Написать письмо']";

	public MailBoxPage(WebDriver driver) {
		super(driver);
	}

	public EmailForm getEmailForm() {
		getDriver().findElement(By.xpath(SEND_EMAIL)).click();
		return new EmailForm(driver);
	}

	public String waitForMyEmail(String emailText) {
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		String xpathExpression = "//div[@id='b-letters']//span[contains(text(),'" + emailText + "')]";
		wait.until(ExpectedConditions.textToBe(By.xpath(xpathExpression), emailText));
		WebElement mail = getDriver().findElement(By.xpath(xpathExpression));
		return mail.getText();
	}
}