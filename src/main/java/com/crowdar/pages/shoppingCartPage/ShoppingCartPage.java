package com.crowdar.pages.shoppingCartPage;

import com.crowdar.pages.SaucedemoPage;
import com.crowdar.webDriver.ExtendedWebDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends SaucedemoPage {

    @FindBy(className = "cart_item")
    WebElement itemProduct;
    public ShoppingCartPage(ExtendedWebDriver extendedWebDriver){
        super(extendedWebDriver);
        PageFactory.initElements(extendedWebDriver, this);
    }

    public void verifyProduct(String productName) {
        Assertions.assertEquals(itemProduct.findElement(By.className("inventory_item_name")).toString(), productName);
    }
}
