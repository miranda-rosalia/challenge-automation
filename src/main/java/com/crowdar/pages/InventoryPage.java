package com.crowdar.pages;

import com.crowdar.core.TestBase;
import com.crowdar.pages.shoppingCartPage.ShoppingCartPage;
import com.crowdar.webDriver.ExtendedWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InventoryPage extends SaucedemoPage {
    @FindBy(className = "btn btn_primary btn_small btn_inventory")
    WebElement addToCartFirstProductButton;

    @FindBy(id = "shopping_cart_container")
    WebElement goToCart;

    @FindBy(className = "inventory_item")
    WebElement firstProduct;
    private static final Logger logger = LoggerFactory.getLogger(InventoryPage.class);
    public InventoryPage(ExtendedWebDriver extendedWebDriver){
        super(extendedWebDriver);
       PageFactory.initElements(this.webDriver,this);
    }

    public String addToCartFirstProduct() {
        try {
            addToCartFirstProductButton.click();
            return firstProduct.findElement(By.className("inventory_item_name")).toString();
        }catch (Exception e){
            System.out.println("EROORRR--------"+e);
        }
        return "";
    }

    public ShoppingCartPage goToCart() {
        goToCart.click();
        return new ShoppingCartPage(webDriver); //webDriver);
    }
}
