package com.qa.Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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

public class LoginPageTest extends BaseClass {

	LoginPage loginpage;
	Homepage homepage;

	@Parameters("browserName")
	@BeforeClass
	public void setup(String browserName) throws Exception {

		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
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
	public void Start() {

		loginpage = new LoginPage();
		homepage = new Homepage();

	}

	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String expectedTitle = loginpage.LoginPageTitle();
		Assert.assertEquals(expectedTitle, "Swag Labs");
	}

	@Test(priority = 2)
	public void LoginLogoTest() {
		boolean logo = loginpage.LoginPageLogo();
		Assert.assertEquals(logo, true);
	}

	@Test(priority = 3, dependsOnMethods = "LoginPageTitleTest")
	public void LoginWithValidCradential() throws Exception {
		loginpage.ValidLoginCredential();
		boolean logo = homepage.HomepageLogo();
		Assert.assertEquals(logo, true);
	}

	@Test(priority = 4)
	public void LoginWithInvalidUsername() throws Exception {
		homepage.Logout();
		loginpage.InvalidUsername();
		boolean logo = loginpage.LoginPageLogo();
		Assert.assertEquals(logo, true);
	}

	@Test(priority = 5)
	public void InvalidPassword() throws Exception {
		driver.navigate().refresh();
		loginpage.InvalidPassword();
		boolean logo = loginpage.LoginPageLogo();
		Assert.assertEquals(logo, true);
	}

	@AfterMethod
	public void Screenshots() {

	}

	@AfterClass
	public void Teardown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
