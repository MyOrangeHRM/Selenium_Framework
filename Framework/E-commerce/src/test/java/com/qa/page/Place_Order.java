package com.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.Base.BaseClass;

public class Place_Order extends BaseClass{

	@FindBy(xpath = "(//div[@class='inventory_item']/div/a/img)[1]")
	WebElement product;
	
	@FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
	WebElement add_To_Cart;
	
	@FindBy(xpath = "//div[@id='shopping_cart_container']/a")
	WebElement cart;
	
	@FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
	WebElement numOfCartItem;
	
	@FindBy(xpath = "//a[@class='btn_action checkout_button']")
	WebElement checkoutButton;
}
