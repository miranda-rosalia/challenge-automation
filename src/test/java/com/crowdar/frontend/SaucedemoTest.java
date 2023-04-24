package com.crowdar.frontend;

import com.crowdar.core.TestBase;
import com.crowdar.pages.InventoryPage;
import com.crowdar.pages.loginPage.LoginPage;
import com.crowdar.pages.shoppingCartPage.ShoppingCartPage;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class SaucedemoTest extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaucedemoTest.class);

    @Test
    public void dadoUnUsernameYPasswordValidosLoggeo() throws IOException {
        this.setUp("chrome");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn("standard_user","secret_sauce");
        loginPage.newScreenshot();
        InventoryPage inventoryPage = loginPage.goToInventory();
        Assertions.assertEquals(inventoryPage.getWebDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

    }

    @Test
    public void dadoUnProductoDelInventoryAgregarAlCarrito() throws IOException{
       this.setUp("chrome");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn("standard_user","secret_sauce");
        // InventoryPage inventoryPage = loginPage.goToInventory(driver);
        InventoryPage inventoryPage = new InventoryPage(loginPage.getWebDriver());
        String productName = inventoryPage.addToCartFirstProduct();
        ShoppingCartPage shoppingCart = inventoryPage.goToCart();
        shoppingCart.verifyProduct(productName);
    }
}
