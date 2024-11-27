package com.qa.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath = "//input[@id='user-name']")
	WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginbtn;

	@FindBy(xpath = "//div[@class='login_logo']")
	WebElement logo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

// LoginPage Title
	public String LoginPageTitle() {
		String title = driver.getTitle();
		return title;
	}

// Login Page Logo
	public boolean LoginPageLogo() {
		boolean loginLogo = logo.isDisplayed();
		return loginLogo;
	}

//Login with valid credential
	public Homepage ValidLoginCredential() throws Exception {

		username.sendKeys(props.getProperty("username"));
		password.sendKeys(props.getProperty("password"));
		loginbtn.click();
		return new Homepage();
	}

	// Login with invalid username and valid password
	public void InvalidUsername() throws Exception {

		username.sendKeys(props.getProperty("invalidUsername"));
		password.sendKeys(props.getProperty("password"));
		loginbtn.click();

	}

	// Login with valid username and invalid password
	public void InvalidPassword() throws Exception {

		username.sendKeys(props.getProperty("username"));
		password.sendKeys(props.getProperty("invalidPassword"));
		loginbtn.click();

	}
}
