package com.crowdar.pages;

import com.crowdar.webDriver.ExtendedWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InventoryPage extends SaucedemoPage{
    private static final Logger logger = LoggerFactory.getLogger(InventoryPage.class);
    public InventoryPage(ExtendedWebDriver webdriver){
        super(webdriver);
        logger.info(targetUrl());
    }
}
