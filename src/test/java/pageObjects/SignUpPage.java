package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SignUpPage {
	public WebDriver ldriver;
	WaitHelper waithelper;

	public SignUpPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper = new WaitHelper(ldriver);
	}

	@FindBy(id = "login_name_register")
	WebElement txtEmail;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div/div/form/button")
	WebElement btnGetStarted;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(id = "confirmed_password")
	WebElement txtConfPassword;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div/div/form/button/span")
	WebElement btnCreateAcc;

	@FindBy(xpath = "//*[@id=\"b2indexPage\"]/div[14]/button")
	WebElement btnClose;

	@FindBy(xpath = "//*[@id=\"profile-menu-trigger--content\"]/span/span[1]")
	WebElement btnYourAcc;

	@FindBy(linkText = "My Dashboard")
	WebElement btnMyDash;

	public void enterEmail(String mail) {
		waithelper.WaitForElement(txtEmail, 5);
		txtEmail.sendKeys(mail);
	}

	public void clickGetStarted() {
		waithelper.WaitForElement(btnGetStarted, 5);
		btnGetStarted.click();
	}

	public void enterPassword(String pass) {
		waithelper.WaitForElement(txtPassword, 5);
		txtPassword.sendKeys(pass);
	}

	public void confirmPassword(String conf_pass) {
		waithelper.WaitForElement(txtConfPassword, 5);
		txtConfPassword.sendKeys(conf_pass);
	}

	public void clickCreateAccount() {
		waithelper.WaitForElement(btnCreateAcc, 5);
		btnCreateAcc.click();
	}

	public void clickClose() {
		waithelper.WaitForElement(btnClose, 5);
		btnClose.click();
	}

	public void clickYourAcc() {
		waithelper.WaitForElement(btnYourAcc, 5);
		btnYourAcc.click();
	}

	public void clickMyDashboard() {
		waithelper.WaitForElement(btnMyDash, 5);
		btnMyDash.click();
	}

}
