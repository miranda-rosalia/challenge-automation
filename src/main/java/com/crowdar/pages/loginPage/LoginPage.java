package com.crowdar.pages.loginPage;

import com.crowdar.pages.InventoryPage;
import com.crowdar.pages.SaucedemoPage;
import com.crowdar.webDriver.ExtendedWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends SaucedemoPage {
    private static final String URL_PAGE = "https://www.saucedemo.com";
    @FindBy(id = "user-name")
    WebElement labelUser;
    @FindBy(id = "password")
    WebElement labelPassword;
    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(className = "error-message-container.error")
    WebElement messageError;

    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    public LoginPage(ExtendedWebDriver extendedWebDriver){
        super(extendedWebDriver);
        this.webDriver.get(URL_PAGE);
        PageFactory.initElements(extendedWebDriver, this);
        logger.info("visit "+ URL_PAGE);
    }
    public void logIn(String user, String pass){
        labelUser.sendKeys(user);
        labelPassword.sendKeys(pass);
        loginButton.click();
    }
    public InventoryPage goToInventory() {
        return new InventoryPage(this.webDriver);
    }
    public InventoryPage goToInventory(ExtendedWebDriver extendedWebDriver) {
        return new InventoryPage(extendedWebDriver);
    }
    public String getMessageError(){
        return messageError.toString();
    }

}
