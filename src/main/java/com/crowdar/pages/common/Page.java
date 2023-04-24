package com.crowdar.pages.common;

import com.crowdar.utils.Screenshot;
import com.crowdar.webDriver.ExtendedWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public abstract class Page {
    protected ExtendedWebDriver webDriver;
    protected Page(ExtendedWebDriver webDriver){
        this.webDriver = webDriver;
      //  PageFactory.initElements(webDriver, this);
    }
    public void newScreenshot() throws IOException {
        Screenshot screenshot = new Screenshot();
        screenshot.newScreenshot(webDriver);
    }
}
