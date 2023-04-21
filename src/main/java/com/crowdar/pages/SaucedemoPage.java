package com.crowdar.pages;

import com.crowdar.pages.common.Page;
import com.crowdar.pages.sections.MenuSaucedemo;
import com.crowdar.webDriver.ExtendedWebDriver;


import java.util.HashMap;
import java.util.Map;

public class SaucedemoPage extends Page {


    private MenuSaucedemo menuSaucedemo;
    public SaucedemoPage(ExtendedWebDriver webDriver, Map mp){
        super(webDriver, mp);
        menuSaucedemo = new MenuSaucedemo(this);
    }
    public SaucedemoPage(ExtendedWebDriver webDriver){
        this(webDriver, new HashMap());
    }
    public Page getMenuSaucedemo() {
        return this.menuSaucedemo.goToSidebar();
    }

    public ExtendedWebDriver getWebDriver(){
        return this.webDriver;
    }
}
