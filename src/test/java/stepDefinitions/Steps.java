package stepDefinitions;

import java.io.IOException;
import java.text.ParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.Checkout;
import pageObjects.Home;
import pageObjects.HotelDetails;
import pageObjects.SignUpPage;

public class Steps extends BaseClass {

	@Before
	public void setup() throws IOException {

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}

	}

	@After
	public void afterScenario() {
		driver.quit();
	}

	/* Background */
	@Given("{string} page")
	public void page(String string) throws InterruptedException {

		home = new Home(driver);
		driver.manage().deleteAllCookies();
		driver.get(baseURL);
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@When("set up language to English")
	public void set_up_language_to_english() throws InterruptedException {
		home.setLanguage();
	}

	@When("set up currency to USD")
	public void set_up_currency_to_usd() throws InterruptedException {
		home.setCurrency();

	}

	@Then("Language is English and currency is USD")
	public void language_is_english_and_currency_is_usd() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(driver.getPageSource().contains("selected_currency=USD"));
		Assert.assertTrue(driver.getPageSource().contains("language: 'en-us'"));
	}

	/* Scenario */

	@Given("I am in Sign Up page")
	public void i_am_in_sign_up_page() {
		home.clickRegister();

	}

	@When("I enter valid user email")
	public void i_enter_valid_user_email() {
		signup = new SignUpPage(driver);
		signup.enterEmail(email);
	}

	@When("click on “GET STARTED” button")
	public void click_on_get_started_button() {
		signup.clickGetStarted();

	}

	@When("I enter valid password")
	public void i_enter_valid_password() throws InterruptedException {
		Thread.sleep(2000);
		signup.enterPassword(password);
		signup.confirmPassword(password);

	}

	@When("click on “Create Account” button")
	public void click_on_create_account_button() {
		signup.clickCreateAccount();

	}

	@When("main page is opened")
	public void main_page_is_opened() throws InterruptedException {
		Thread.sleep(2000);

		if (driver.getTitle().contains("Booking.com | Official site | The best hotels & accommodations")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			driver.close();
		}
	}

	@When("I click on “My Dashboard” button under account menu")
	public void i_click_on_my_dashboard_button_under_account_menu() throws InterruptedException {
		home.CloseAlert();
		home.clickMenu();
		if (driver.getPageSource().contains("Manage account")) {
			home.clickManageAcc();
		}
		home.clickDashboard();

	}

	@Then("“My Dashboard” page is opened")
	public void my_dashboard_page_is_opened() throws InterruptedException {
		Thread.sleep(2000);
		if (driver.getTitle().contains("My Dashboard")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			driver.close();
		}

	}

	@Then("correct value is prefilled in email verification placeholder  \\/\\/based on registered email")
	public void correct_value_is_prefilled_in_email_verification_placeholder_based_on_registered_email()
			throws InterruptedException {
		Thread.sleep(2000);
		if (driver.findElement(By.cssSelector("input.email-confirm-banner__email-text")).getAttribute("placeholder")
				.equalsIgnoreCase(email)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			driver.close();
		}

	}

	// Book First Displayed Hotel

	@Given("I have account created")
	public void i_have_account_created() throws InterruptedException {
		home.clickRegister();
		signup = new SignUpPage(driver);
		signup.enterEmail(email);
		signup.clickGetStarted();
		Thread.sleep(2000);
		signup.enterPassword(password);
		signup.confirmPassword(password);
		signup.clickCreateAccount();
		home.CloseAlert();
		home.clickMenu();
		if (driver.getPageSource().contains("Manage account")) {
			home.clickManageAcc();
		}
		home.clickDashboard();
		Thread.sleep(2000);
		if (driver.getTitle().contains("My Dashboard")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			driver.close();
		}

	}

	@Given("I am in {string} page")
	public void i_am_in_page(String string) throws InterruptedException {
		home.clickBookingcom();
		Thread.sleep(2000);
		if (driver.getTitle().contains("Booking.com | Official site | The best hotels & accommodations")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			driver.close();
		}

	}

	@When("I set up destination as {string}")
	public void i_set_up_destination_as(String string) {
		home.EnterDestination(string);

	}

	@When("I set dates {string} - {string}")
	public void i_set_dates(String string, String string2) throws InterruptedException, ParseException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		home.clickCheckIn();
		home.waitCalendartoDisplay();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date = string;
		String date2 = string2;
		LocalDate startdate = LocalDate.parse(date, formatter);
		LocalDate enddate = LocalDate.parse(date2, formatter);

		selectDate(driver, startdate);
		selectDate(driver, enddate);

	}

	@When("I select {string} adults and {string} children")
	public void i_select_adults_and_children(String string, String string2) throws InterruptedException {

		home.clickGuests();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Javascript for selecting adults
		WebElement adults = driver.findElement(By.id("group_adults"));
		String numberadults = string;
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='" + numberadults + "';", adults);

		// Javascript for selecting children
		WebElement children = driver.findElement(By.id("group_children"));
		String numberchildren = string2;
		jse.executeScript("arguments[0].value='" + numberchildren + "';", children);

	}

	@When("I click on {string} button")
	public void i_click_on_Search_button(String string) {
		if (string.equals("Search")) {
			home.clickSearch();
		}
	}

	@When("I click on {string} for fist hotel in the list")
	public void i_click_on_for_fist_hotel_in_the_list(String string) {
		home.clickSelectRoom();

	}

	@When("{string} page is opened for selected hotel")
	public void page_is_opened_for_selected_hotel(String string) {
		hdetails = new HotelDetails(driver);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));

		boolean hotelName = driver.findElement(By.id("hp_hotel_name")).isDisplayed();
		System.out.println(hotelName);
		boolean hotelRaiting = driver.findElement(By.className("hp__hotel_ratings")).isDisplayed();
		System.out.println(hotelRaiting);
		String recomended = driver.findElement(By.className("hp-rt-group_recommendation")).getText();
		System.out.println(recomended);

		if (hotelName == true && hotelRaiting == true /*
														 * && recomended.equals("Recommended for "
														 * +numberadults+" adults,  "+numberchildren+" child")
														 */ ) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			driver.close();
		}
	}

	@When("I click on {string} button for recommended room")
	public void i_click_on_button_for_recommended_room(String string) {
		driver.findElement(By.linkText(string)).click();
	}

	@When("I click on “I'll Reserve” button")
	public void i_click_on_i_ll_reserve_button() {
		hdetails.clickIllReserve();
	}

	@Then("{string} page is displayed")
	public void page_is_displayed(String string) throws InterruptedException {
		if (string.equals("Your Details")) {
			checkpage = new Checkout(driver);
			if (driver.getTitle().contains(string)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
			// Don't know if there is a way to get variables from other methods so i can
			// compare with the dates,adults that are displayed

		} else if (string.equals("Final Details")) {
			Thread.sleep(3000);
			if (driver.getPageSource().contains("Complete booking")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

	}

	@Then("I enter valid booking information")
	public void i_enter_valid_booking_information() {
		checkpage.clickYes();
		checkpage.EnterName(firstname);
		checkpage.EnterLastName(lastname);
		checkpage.IamMainGuest();
	}

	// Book Cheapest Hotel
	@When("I click on {string} for the cheapest hotel in the list with a rating above {string} stars")
	public void i_click_on_for_the_cheapest_hotel_in_the_list_with_a_rating_above_stars(String string, String string2) {
		home.clickLowestPrice();
		int i = Integer.parseInt(string2);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(i);
		driver.findElement(By.partialLinkText(i + " stars")).click();
		home.clickSelectRoom();
	}

	@When("I click on {string} button for the most expensive available room in the hotel")
	public void i_click_on_button_for_the_most_expensive_available_room_in_the_hotel(String string) {
		hdetails = new HotelDetails(driver);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		// Don't know how to select the room from table even if i find the most
		// expensive room

	}

}
