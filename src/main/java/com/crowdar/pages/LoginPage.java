package com.crowdar.pages;

import com.crowdar.utils.PageUrl;
import com.crowdar.webDriver.ExtendedWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PageUrl(url = "login.host")
public class LoginPage extends SaucedemoPage{
    @FindBy(id = "user-name")
    WebElement labelUser;
    @FindBy(id = "password")
    WebElement labelPassword;
    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(className = "error-message-container.error")
    WebElement messageError;

    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    public LoginPage(ExtendedWebDriver webdriver){
        super(webdriver);
        logger.info(targetUrl());
    }
    public void logIn(String user, String pass){
        labelUser.sendKeys(user);
        labelPassword.sendKeys(pass);
        loginButton.click();
    }

    public InventoryPage goToInventory() {
        return new InventoryPage(this.webDriver);
    }
    public String getMessageError(){
        return messageError.toString();
    }
}
