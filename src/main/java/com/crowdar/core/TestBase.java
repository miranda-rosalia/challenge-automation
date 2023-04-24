package com.crowdar.core;

import com.crowdar.config.BaseConf;
import com.crowdar.webDriver.ExtendedWebDriver;
import com.crowdar.webDriver.WebDriverBuilder;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(loader= AnnotationConfigContextLoader.class, classes={BaseConf.class})
@Parameters(value={"browser"})
public class TestBase extends AbstractTestNGSpringContextTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);
    protected ExtendedWebDriver driver;


    //@BeforeTest
    public void setUp(String browser) {
        driver = new ExtendedWebDriver(new WebDriverBuilder().build(browser));
        try{ driver.maximize();}catch (WebDriverException e){driver.manage().window().setSize(new Dimension(1600,900));}
        logger.info("Setup done.");
    }

    @AfterMethod
    public void logEndTest() throws InterruptedException {
        logInfo("TEST-END.");
        this.driver.quit();
    }

    protected void logInfo(String message){
        LOGGER.info(message);
    }
}


