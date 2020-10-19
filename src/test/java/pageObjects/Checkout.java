package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class Checkout {
	public WebDriver ldriver;
	WaitHelper waithelper;
	
	public Checkout(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper = new WaitHelper(ldriver);
	}

	// Are you traveling for work?
	@FindBy(id = "bp_travel_purpose_business")
	WebElement radiobtnYes;

	@FindBy(id = "bp_travel_purpose_leasure")
	WebElement radiobtnNo;

	@FindBy(id = "firstname")
	WebElement txtFirstName;

	@FindBy(id = "lastname")
	WebElement txtLastName;

	// Who are you booking for?
	@FindBy(id = "notstayer_false")
	WebElement radiobtnMainguest;

	@FindBy(id = "notstayer_true")
	WebElement radiobtnSomeoneelse;
	
	@FindBy(partialLinkText = "Final details")
	WebElement btnFinaldetails;

	// Are you traveling for work?
	public void clickYes() {
		radiobtnYes.click();
	}

	public void clickNo() {
		radiobtnNo.click();
	}

	public void EnterName(String name) {
		waithelper.WaitForElement(txtFirstName, 5);
		txtFirstName.sendKeys(name);
	}

	public void EnterLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	// Who are you booking for?
	public void IamMainGuest() {
		radiobtnMainguest.click();
	}

	public void ForSomeoneelse() {
		radiobtnSomeoneelse.click();
	}

}
