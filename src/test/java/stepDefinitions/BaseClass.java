package stepDefinitions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.Checkout;
import pageObjects.Home;
import pageObjects.HotelDetails;
import pageObjects.SignUpPage;
import utilities.ReadConfig;

public class BaseClass {

	public WebDriver driver;
	public SignUpPage signup;
	public HotelDetails hdetails;
	public Home home;
	public Checkout checkpage;
	public Properties configProp;
	public Steps step;

	ReadConfig readconfig = new ReadConfig();

	// Random string generator
	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	public String baseURL = readconfig.getApplicationURL();
	public String email = randomestring() + readconfig.getEmail();
	public String password = readconfig.getPassword();
	public String br = readconfig.getBrowser();
	public String firstname = readconfig.getFirstName();
	public String lastname = readconfig.getLastName();

	
	protected static void selectDate(WebDriver driver, LocalDate date) {
		// Looking at the markup the attribute data-date is formatted as an
		// ISO_LOCAL_DATE
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		// Programmatically generate dateLocator based on date passed in
		By dateLocator = By.xpath(String.format("//td[@data-date='%s']", formatter.format(date)));
		// Wait for date element to be visible, then click on it
		wait.until(ExpectedConditions.visibilityOfElementLocated(dateLocator)).click();
	}

}
