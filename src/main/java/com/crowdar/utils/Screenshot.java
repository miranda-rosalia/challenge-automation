package com.crowdar.utils;

import com.crowdar.webDriver.ExtendedWebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Screenshot {

public void newScreenshot(ExtendedWebDriver webDriver) throws IOException {
    String fileWithPath = "./reports/imagen" + System.currentTimeMillis() + ".png";
    TakesScreenshot scrShot = (TakesScreenshot) webDriver.getAugmentedDriver();
    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
    File DestFile=new File(fileWithPath);
    FileHandler.copy(SrcFile, DestFile);

}


    public Screenshot() {
    }

}
