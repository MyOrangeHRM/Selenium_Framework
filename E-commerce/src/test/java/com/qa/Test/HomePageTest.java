package com.qa.Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.Base.BaseClass;
import com.qa.page.Homepage;
import com.qa.page.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest extends BaseClass {

	LoginPage loginpage;
	Homepage homepage;

	@Parameters("browserName")
	@BeforeClass
	public void setup(String browser) throws Exception {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		default:
			break;
		}
		Initlization();
		driver.get(props.getProperty("Url"));
	}

	@BeforeMethod
	public void start() {
		loginpage = new LoginPage();
		homepage = new Homepage();
	}

	@Test
	public void FilterLowToHigh() throws Exception {
		loginpage.ValidLoginCredential();
		homepage.Price_LowToHigh();
	}

	@Test
	public void Price_HighToLow() {
		homepage.Price_HighToLow();
	}

	@AfterMethod
	public void Screenshot() {

	}

	@AfterClass
	public void Teardown() {
		driver.quit();
	}

}
