package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class Home {

	public static WebDriver ldriver;
	WaitHelper waithelper;

	public Home(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper = new WaitHelper(ldriver);

	}

	@FindAll({ @FindBy(xpath = "//body[@id='b2indexPage']/header/nav/div[2]/div/button/span/span" /*
																									 * xpath="//img[@alt='English (US)']"
																									 */ ),
			@FindBy(xpath = "/html/body/div[1]/div/div/ul/li[1]/a") })
	WebElement btnCurrency;

	@FindBy(partialLinkText = "U.S. Dollar")
	WebElement btnUSD;

	@FindAll({ @FindBy(xpath = "/html/body/header/nav[1]/div[2]/div[2]/button/span/div/img"),
			@FindBy(xpath = "//img[@alt='English (US)']") })
	WebElement btnLanguage;

	@FindBy(partialLinkText = "US")
	WebElement btnUS;

	@FindBy(linkText = "Register")
	WebElement btnRegister;

	@FindAll({ @FindBy(xpath = "//a[@type='button']"), @FindBy(id = "current_account") })
	WebElement btnMenu;

	@FindBy(partialLinkText = "Manage account")
	WebElement btnManageAcc;

	@FindBy(partialLinkText = "Dashboard")
	WebElement btnDashboard;

	// booking.com
	@FindAll({ @FindBy(id = "logo_no_globe_new_logo"), @FindBy(css = "svg.bk-icon.-logos-booking-logo-inv") })
	WebElement btnBookingHome;

	// Reservation
	@FindBy(id = "ss")
	WebElement txtDestination;

	@FindAll({ @FindBy(css = "span.sb-date-field__icon.sb-date-field__icon-btn.bk-svg-wrapper.calendar-restructure-sb"),
			@FindBy(xpath = "//form[@id='frm']/div/div[2]/div/div[2]/div/div/div/div/span") })
	WebElement btnCalendar;

	@FindBy(id = "xp__guests__toggle")
	WebElement btnGuests;

	@FindAll({ @FindBy(id = "group_adults"),
			@FindBy(xpath = "/html/body/div[4]/div/div/div[2]/form/div[1]/div[3]/div[2]/div/div/div[1]/div/div[2]/input") })
	WebElement nbrAdults;

	@FindBy(id = "group_children")
	WebElement nbrChildren;

	@FindBy(id = "no_rooms")
	WebElement nbrRooms;

	@FindBy(xpath = "//*[@id=\"frm\"]/div[1]/div[4]/div[2]/button")
	WebElement btnSearch;

	@FindBy(linkText = "Select your room")
	WebElement btnSelectRoom;

	@FindBy(className = "modal-mask-closeBtn")
	WebElement closeAlert;

	// Price and raiting
	@FindBy(linkText = "Price (lowest first)")
	WebElement btnlowestprice;

	@FindBy(xpath = "//div[contains(@class, 'b-datepicker')][@data-mode='checkin']")
	WebElement checkInLocator;

	@FindBy(css = ".bui-calendar__content")
	WebElement calendarLocator;

	public void setCurrency() throws InterruptedException {
		waithelper.WaitForElement(btnCurrency, 5);
		btnCurrency.click();
		waithelper.WaitForElement(btnUSD, 5);
		btnUSD.click();
	}

	public void setLanguage() throws InterruptedException {
		waithelper.WaitForElement(btnLanguage, 5);
		btnLanguage.click();
		waithelper.WaitForElement(btnUS, 5);
		btnUS.click();
	}

	public void clickRegister() {
		waithelper.WaitForElement(btnRegister, 5);
		btnRegister.click();
	}

	public void clickMenu() {
		waithelper.WaitForElement(btnMenu, 5);
		btnMenu.click();
	}

	public void clickManageAcc() {
		waithelper.WaitForElement(btnManageAcc, 5);
		btnManageAcc.click();
	}

	public void clickDashboard() {
		waithelper.WaitForElement(btnDashboard, 5);
		btnDashboard.click();
	}

	// booking.com
	public void clickBookingcom() {
		btnBookingHome.click();
	}

	// reservation
	public void EnterDestination(String destination) {
		txtDestination.sendKeys(destination);
	}

	public void clickCalendar() {
		btnCalendar.click();
	}

	public void clickGuests() {
		btnGuests.click();
	}

	public void EnterAdults(String adults) {

		nbrAdults.getText();
		System.out.println(nbrAdults.getText());
		nbrAdults.clear();
		nbrAdults.sendKeys(adults);

	}

	public void EnterChildrens(String kids) {
		waithelper.WaitForElement(nbrChildren, 5);
		nbrChildren.clear();
		nbrChildren.sendKeys(kids);
	}

	public void EnterRooms(String rooms) {
		waithelper.WaitForElement(nbrRooms, 5);
		nbrRooms.clear();
		nbrRooms.sendKeys(rooms);
	}

	public void clickSearch() {
		btnSearch.click();
	}

	public void clickSelectRoom() {
		waithelper.WaitForElement(btnSelectRoom, 5);
		btnSelectRoom.click();
	}

	public void CloseAlert() {
		waithelper.WaitForElement(closeAlert, 5);
		if (closeAlert.isDisplayed()) {
			closeAlert.click();

		}
	}

	public void clickLowestPrice() {
		waithelper.WaitForElement(btnlowestprice, 5);
		btnlowestprice.click();
	}

	public void clickCheckIn() {
		waithelper.WaitForElement(checkInLocator, 5);
		checkInLocator.click();
	}

	public void waitCalendartoDisplay() {
		waithelper.WaitForElement(calendarLocator, 5);
	}

}
