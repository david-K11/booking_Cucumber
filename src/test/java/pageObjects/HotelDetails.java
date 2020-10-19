package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class HotelDetails {
	public WebDriver ldriver;
	WaitHelper waithelper;

	public HotelDetails(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper = new WaitHelper(ldriver);
	}

	@FindAll({
	@FindBy( className = "hprt-reservation-total-price bui-price-display__value"),
	@FindBy( className =  "hprt-booking-summary-rooms-and-price"),
	@FindBy(css = "div.hprt-reservation-total-price.bui-price-display__value")
	})
	WebElement txtTotalPrice;

	@FindBy(linkText = "Reserve")
	WebElement btnReserve;

	@FindAll({
	@FindBy(xpath="//form[@id='hprt-form']/div[10]/div[2]/div[2]/div[6]/button"),
	@FindBy(xpath="//div[6]/button"),
//	@FindBy(id="b_tt_holder_4")
	})
	WebElement btnIllReserve;

	public void clickReserve() {
		waithelper.WaitForElement(btnReserve, 5);
		btnReserve.click();
	}

	public void clickIllReserve() {
		waithelper.WaitForElement(btnIllReserve, 5);
		btnIllReserve.click();
	}

}
