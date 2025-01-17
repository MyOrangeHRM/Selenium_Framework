package com.qa.page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.Base.BaseClass;

public class Homepage extends BaseClass {
	@FindBy(xpath = "//div[@class='app_logo']")
	WebElement homepagelogo;

	@FindBy(xpath = "//div[@class='bm-burger-button']/button")
	WebElement sideTaskBar;

	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	WebElement logout;

	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	public boolean HomepageLogo() {
		boolean homePageLogo = homepagelogo.isDisplayed();
		return homePageLogo;
	}

	public String HomepageTitle() {
		String title = driver.getTitle();
		return title;
	}

	// logout
	public LoginPage Logout() {
		sideTaskBar.click();
		logout.click();
		return new LoginPage();
	}

// Filter Price_LowToHigh
	public void Price_LowToHigh() {
		List<WebElement> allPriceList = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		ArrayList<Double> expectedPriceList = new ArrayList<>();

		for (WebElement ele : allPriceList) {
			expectedPriceList.add(Double.valueOf(ele.getText().replace("$", "")));
		}
		Collections.sort(expectedPriceList);

		Select filter = new Select(dropdown);
		filter.selectByVisibleText("Price (low to high)");

		List<WebElement> filterSortedPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		ArrayList<Double> ActualPriceList = new ArrayList<>();
		for (WebElement ele : filterSortedPrice) {
			ActualPriceList.add(Double.valueOf(ele.getText().replace("$", "")));
		}
	//	System.out.println("ActualPriceList= " + ActualPriceList);
	//	System.out.println("expectedPriceList= " + expectedPriceList);
		Assert.assertEquals(ActualPriceList, expectedPriceList);

	}
// Filter Price_HighToLow

	public void Price_HighToLow() {
		List<WebElement> allPriceList = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
		ArrayList<Double> expectedPriceList = new ArrayList<>();

		for (WebElement ele : allPriceList) {
			expectedPriceList.add(Double.valueOf(ele.getText().replace("$", "")));
		}
		Collections.sort(expectedPriceList);
		Collections.reverse(expectedPriceList);

		Select filter = new Select(dropdown);
		filter.selectByVisibleText("Price (high to low)");

		List<WebElement> filterSortedPrice = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		ArrayList<Double> ActualPriceList = new ArrayList<>();
		for (WebElement ele : filterSortedPrice) {
			ActualPriceList.add(Double.valueOf(ele.getText().replace("$", "")));
		}
		System.out.println("ActualPriceList= " + ActualPriceList);
		System.out.println("expectedPriceList= " + expectedPriceList);
		Assert.assertEquals(ActualPriceList, expectedPriceList);
	}

}
