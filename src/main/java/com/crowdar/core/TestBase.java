package com.crowdar.core;

import com.crowdar.config.BaseConf;
import com.crowdar.pages.SiteMap;
import com.crowdar.webDriver.ExtendedWebDriver;
import com.crowdar.webDriver.WebDriverBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.springframework.context.Lifecycle;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(loader= AnnotationConfigContextLoader.class, classes={BaseConf.class})
public class TestBase extends AbstractTestNGSpringContextTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestBase.class);
    public SiteMap siteMap;
    protected ExtendedWebDriver driver;
    protected SoftAssert softAssert;

    @BeforeGroups
    protected void logStartTest(){
        logInfo("TEST-START.");
        softAssert = new SoftAssert();
    }

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        driver = new ExtendedWebDriver(new WebDriverBuilder().build());
        try{ driver.maximize();}catch (WebDriverException e){driver.manage().window().setSize(new Dimension(1600,900));}
        siteMap = new SiteMap(driver);
        logger.info("Setup done.");
    }
    @AfterTest(alwaysRun = true)
    protected void logEndTest() throws InterruptedException {
        logInfo("TEST-END.");
        this.driver.quit();
    }
    private boolean failedTest(ITestContext context){
        return context.getFailedTests().size() > 0;
    }

    protected void logInfo(String message){
        LOGGER.info(message);
    }
}
