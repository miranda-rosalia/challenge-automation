package com.crowdar.pages;

import com.crowdar.webDriver.ExtendedWebDriver;

import static com.crowdar.utils.PageUrlUtils.urlFor;

public class SiteMap {

    private final ExtendedWebDriver extendedWebDriver;
    public SiteMap(ExtendedWebDriver extendedWebDriver){
        this.extendedWebDriver = extendedWebDriver;
    }
    public LoginPage goToLogin(String username, String password){
        extendedWebDriver.get(urlFor(LoginPage.class));
        return new LoginPage(extendedWebDriver);
    }

}
