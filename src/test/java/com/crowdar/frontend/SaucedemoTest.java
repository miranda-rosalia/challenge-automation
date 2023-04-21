package com.crowdar.frontend;

import com.crowdar.core.TestBase;
import com.crowdar.pages.InventoryPage;
import com.crowdar.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaucedemoTest extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaucedemoTest.class);

    @org.testng.annotations.Test
    public void dadoUnUsernameYPasswordValidosLoggeo() {

        LoginPage loginPage = siteMap.goToLogin("standard_user","secret_sauce");
        InventoryPage inventoryPage=loginPage.goToInventory();
        softAssert.assertEquals(inventoryPage.getWebDriver().getTitle(),"Swag Labs");
    }

    @Test
    public void dadoUnUsernameValidoYPasswordInvalidoNoLoggearse(){
        LoginPage loginPage = siteMap.goToLogin("standard_user","password_invalidate");
        String messageError= "Epic sadface: Username and password do not match any user in this service";
        softAssert.assertEquals(loginPage.getMessageError(),messageError);
    }
}
