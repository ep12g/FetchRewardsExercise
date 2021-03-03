package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.Fetch_Page;

public class FetchChallenge {

	public static void main(String[] args) {

		//Code developed by Eliezer Penias
		
		// instantiate Chrome Driver and Page Object file
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Elie\\Desktop\\Fetch Rewards Coding Exercise\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Fetch_Page fetchpage = new Fetch_Page(driver);

		// Set URL and navigate to URL
		String baseUrl = "http://ec2-54-208-152-154.compute-1.amazonaws.com/";
		driver.get(baseUrl);

		// Enters numbers 0-3 on the left side, and 4-7 on the right side
		runFirstWeighing(fetchpage);

		// If there is inequality, proceed with the second weighing. Otherwise, it is
		// safe to assume the fake gold is 8.
		if (String.valueOf(fetchpage.getFirstWeighing().charAt(10)).equals(">")
				|| String.valueOf(fetchpage.getFirstWeighing().charAt(10)).equals("<")) {
			runSecondWeighing(fetchpage);
		} else {
			System.out.println("The fake gold is number 8");
			System.out.println("\nThe weighings performed include the following: ");
			System.out.println(fetchpage.getFirstWeighing());
			fetchpage.clickGoldEight();
		}

		// Confirmation that my algorithm worked correctly. This reads the pop-up
		// presented after clicking the number box of the fake gold, and verifies it
		// says "Yay, You find it!"
		if (driver.switchTo().alert().getText().equalsIgnoreCase("Yay! You find it!")) {
			System.out.println("\nResult confirmed based on popup");
		} else {
			System.out.println("\nUnexpected error");
		}
	}

	// Extracted method of the first weighing
	private static void runFirstWeighing(Fetch_Page fetchpage) {
		fetchpage.setBoxL0("0");
		fetchpage.setBoxL1("1");
		fetchpage.setBoxL2("2");
		fetchpage.setBoxL3("3");
		fetchpage.setBoxR0("4");
		fetchpage.setBoxR1("5");
		fetchpage.setBoxR2("6");
		fetchpage.setBoxR3("7");

		weighAndReset(fetchpage);
	}

	// Extracted method of the second weighing.
	// This sets 0 and 1 on the left side and 2 and 3 on the right side OR 4 and 5
	// on the left side and 6 and 7 on the right side, depending on if the operator
	// is less than or greater than.
	private static void runSecondWeighing(Fetch_Page fetchpage) {
		if (String.valueOf(fetchpage.getFirstWeighing().charAt(10)).equals("<")) {
			fetchpage.setBoxL0("0");
			fetchpage.setBoxL1("1");
			fetchpage.setBoxR0("2");
			fetchpage.setBoxR1("3");

			weighAndReset(fetchpage);

			runThirdWeighingOptionOne(fetchpage);

		} else {
			fetchpage.setBoxL0("4");
			fetchpage.setBoxL1("5");
			fetchpage.setBoxR0("6");
			fetchpage.setBoxR1("7");

			weighAndReset(fetchpage);

			runThirdWeighingOptionTwo(fetchpage);
		}
	}

	//Extracted method of the third weighing.
	//Based on how the second weighing performed, this places either 0 or 2 on the left side, and 1 or 3 on the right side.
	private static void runThirdWeighingOptionOne(Fetch_Page fetchpage) {
		if (String.valueOf(fetchpage.getSecondWeighing().charAt(6)).equals("<")) {
			fetchpage.setBoxL0("0");
			fetchpage.setBoxR0("1");

			weighAndReset(fetchpage);

			if (String.valueOf(fetchpage.getThirdWeighing().charAt(4)).equals("<")) {
				System.out.println("The fake gold is number 0");
				printAllWeighings(fetchpage);
				fetchpage.clickGoldZero();
			} else {
				System.out.println("The fake gold is number 1");
				printAllWeighings(fetchpage);
				fetchpage.clickGoldOne();
			}

		} else {
			fetchpage.setBoxL0("2");
			fetchpage.setBoxR0("3");

			weighAndReset(fetchpage);

			if (String.valueOf(fetchpage.getThirdWeighing().charAt(4)).equals("<")) {
				System.out.println("The fake gold is number 2");
				printAllWeighings(fetchpage);
				fetchpage.clickGoldTwo();
			} else {
				System.out.println("The fake gold is number 3");
				printAllWeighings(fetchpage);
				fetchpage.clickGoldThree();
			}
		}
	}

	//Extracted method of the third weighing.
	//Based on how the second weighing performed, this places either 4 or 6 on the left side, and 5 or 7 on the right side.
	private static void runThirdWeighingOptionTwo(Fetch_Page fetchpage) {
		if (String.valueOf(fetchpage.getSecondWeighing().charAt(6)).equals("<")) {
			fetchpage.setBoxL0("4");
			fetchpage.setBoxR0("5");

			weighAndReset(fetchpage);

			if (String.valueOf(fetchpage.getThirdWeighing().charAt(4)).equals("<")) {
				System.out.println("The fake gold is number 4");
				printAllWeighings(fetchpage);
				fetchpage.clickGoldFour();
			} else {
				System.out.println("The fake gold is number 5");
				printAllWeighings(fetchpage);
				fetchpage.clickGoldFive();
			}
		} else {
			fetchpage.setBoxL0("6");
			fetchpage.setBoxR0("7");

			weighAndReset(fetchpage);

			if (String.valueOf(fetchpage.getThirdWeighing().charAt(4)).equals("<")) {
				System.out.println("The fake gold is number 6");
				printAllWeighings(fetchpage);
				fetchpage.clickGoldSix();
			} else {
				System.out.println("The fake gold is number 7");
				printAllWeighings(fetchpage);
				fetchpage.clickGoldSeven();
			}
		}
	}

	//Since the weigh button and reset button were clicked multiple times throughout this test, I extracted the two commands here for ease of reusability
	private static void weighAndReset(Fetch_Page fetchpage) {
		fetchpage.clickWeigh();
		fetchpage.clickReset();
	}

	//This method prints out all weighings performed (unless the fake gold was 8, in which case, there was only one weighing performed. 
	private static void printAllWeighings(Fetch_Page fetchpage) {
		System.out.println("\nThe weighings performed include the following: ");
		System.out.println(fetchpage.getFirstWeighing());
		System.out.println(fetchpage.getSecondWeighing());
		System.out.println(fetchpage.getThirdWeighing());
	}
}
