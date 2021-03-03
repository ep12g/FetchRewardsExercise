package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fetch_Page {

	// Though in this specific example, it may not have made much sense to create
	// page objects for the elements being tested, I made the decision to create
	// this page object class to demonstrate my intention of highly reusable code.
	// If we were to continue testing the gold scale website in the long term,
	// having these page objects may end up being useful.

	@FindBy(id = "left_0")
	WebElement left_0;

	@FindBy(id = "left_1")
	WebElement left_1;

	@FindBy(id = "left_2")
	WebElement left_2;

	@FindBy(id = "left_3")
	WebElement left_3;

	@FindBy(id = "right_0")
	WebElement right_0;

	@FindBy(id = "right_1")
	WebElement right_1;

	@FindBy(id = "right_2")
	WebElement right_2;

	@FindBy(id = "right_3")
	WebElement right_3;

	@FindBy(xpath = "//*[text()='Reset']")
	WebElement reset;

	@FindBy(xpath = "//*[text()='Weigh']")
	WebElement weigh;

	@FindBy(xpath = "//*[text()='Weighings']//following::*[2]")
	WebElement firstweighing;

	@FindBy(xpath = "//*[text()='Weighings']//following::*[3]")
	WebElement secondweighing;

	@FindBy(xpath = "//*[text()='Weighings']//following::*[4]")
	WebElement thirdweighing;

	@FindBy(id = "coin_0")
	WebElement gold_0;

	@FindBy(id = "coin_1")
	WebElement gold_1;

	@FindBy(id = "coin_2")
	WebElement gold_2;

	@FindBy(id = "coin_3")
	WebElement gold_3;

	@FindBy(id = "coin_4")
	WebElement gold_4;

	@FindBy(id = "coin_5")
	WebElement gold_5;

	@FindBy(id = "coin_6")
	WebElement gold_6;

	@FindBy(id = "coin_7")
	WebElement gold_7;

	@FindBy(id = "coin_8")
	WebElement gold_8;

	// constructor needed to initialize elements
	public Fetch_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setBoxL0(String entry) {
		left_0.sendKeys(entry);
	}

	public void setBoxL1(String entry) {
		left_1.sendKeys(entry);
	}

	public void setBoxL2(String entry) {
		left_2.sendKeys(entry);
	}

	public void setBoxL3(String entry) {
		left_3.sendKeys(entry);
	}

	public void setBoxR0(String entry) {
		right_0.sendKeys(entry);
	}

	public void setBoxR1(String entry) {
		right_1.sendKeys(entry);
	}

	public void setBoxR2(String entry) {
		right_2.sendKeys(entry);
	}

	public void setBoxR3(String entry) {
		right_3.sendKeys(entry);
	}

	public void clickReset() {
		reset.click();
	}

	public void clickWeigh() {
		weigh.click();
	}

	public String getFirstWeighing() {
		return firstweighing.getText();
	}

	public String getSecondWeighing() {
		return secondweighing.getText();
	}

	public String getThirdWeighing() {
		return thirdweighing.getText();
	}

	public void clickGoldZero() {
		gold_0.click();
	}

	public void clickGoldOne() {
		gold_1.click();
	}

	public void clickGoldTwo() {
		gold_2.click();
	}

	public void clickGoldThree() {
		gold_3.click();
	}

	public void clickGoldFour() {
		gold_4.click();
	}

	public void clickGoldFive() {
		gold_5.click();
	}

	public void clickGoldSix() {
		gold_6.click();
	}

	public void clickGoldSeven() {
		gold_7.click();
	}

	public void clickGoldEight() {
		gold_8.click();
	}

}
