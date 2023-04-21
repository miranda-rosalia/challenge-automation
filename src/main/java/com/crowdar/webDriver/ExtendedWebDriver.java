package com.crowdar.webDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;

import java.util.*;

import static java.util.stream.Collectors.toList;


public class ExtendedWebDriver implements WebDriver, JavascriptExecutor {
    private WebDriver webDriver;
    private static ThreadLocal<ExtendedWebDriver> instance;
    private static final int TIMEOUT_FOR_URL_LOADING = 25;
    public ExtendedWebDriver(WebDriver webDriver) {
        super();
        this.webDriver = webDriver;
     //   webDriver.manage().timeouts().implicitlyWait(TIMEOUT_FOR_URL_LOADING, TimeUnit.SECONDS);
       // webDriver.manage().timeouts().setScriptTimeout(TIMEOUT_FOR_URL_LOADING, TimeUnit.SECONDS);
        instance = WebDriverSingleton.getInstance();
        instance.set(this);
    }

    public WebDriver getAugmentedDriver(){
        return new Augmenter().augment(webDriver);
    }

    public void get(String url) {
        webDriver.get(url);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return webDriver.findElements(by).stream().collect(toList());
    }

    public List<Integer> findElementsAsIntegers(By by) {
        return webDriver.findElements(by).stream().map(element->Integer.parseInt(element.getText())).collect(toList());
    }

    public List<String> findElementsAsStrings(By by) {
        return webDriver.findElements(by).stream().map(WebElement::getText).collect(toList());
    }

    public WebElement findElement(By by) {
        return webDriver.findElement(by);
    }

    public String getPageSource() {
        return webDriver.getPageSource();
    }

    public void close() {
        webDriver.close();
    }

    public void quit() {
        webDriver.quit();
    }

    public Set<String> getWindowHandles() {
        return webDriver.getWindowHandles();
    }

    public String getWindowHandle() {
        return webDriver.getWindowHandle();
    }

    public TargetLocator switchTo() {
        return webDriver.switchTo();
    }

    public Navigation navigate() {
        return webDriver.navigate();
    }

    public Options manage() {
        return webDriver.manage();
    }

    public Object executeScript(String s, Object... objects) {
        return ((JavascriptExecutor) webDriver).executeScript(s, objects);
    }

    public Object executeAsyncScript(String s, Object... objects) {
        return ((JavascriptExecutor) webDriver).executeAsyncScript(s, objects);
    }

    public void waitUntil(int timeOutInSeconds, Function<WebDriver, Boolean> isTrue) {
        new WebDriverWait(this, Duration.ofSeconds(timeOutInSeconds)).until(isTrue);
    }

    public void waitUntilWebElementIsReady(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(w-> ExpectedConditions.elementToBeClickable(webElement));
    }

    public void waitUntilElementIsVisible(int timeOutInSeconds, final WebElement... webElements){
        waitUntil(timeOutInSeconds, wd -> Arrays.stream(webElements).anyMatch(this::isElementDisplayed));
    }
    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void maximize(){
        webDriver.manage().window().maximize();
    }
}
