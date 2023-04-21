package com.crowdar.webDriver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static java.lang.System.getProperty;
public class WebDriverBuilder {
    private static final List<String> BROWSER_LIST = Arrays.asList("chrome","firefox","chrome-headless");
    private final String BROWSER = Optional.ofNullable(getProperty("browser")).orElse("chrome");

    public WebDriverBuilder() {
        validateBrowser();
        setBrowserDriverPath();

    }
    private void validateBrowser() {
        if (BROWSER.isEmpty() || !BROWSER_LIST.contains(BROWSER)){
            throw new RuntimeException("Not supported browser value: " + BROWSER);
        }
    }
    private void setBrowserDriverPath(){
        String driverPath = MessageFormat.format("driver.path.{0}", BROWSER);
        String driverPropertyKey = MessageFormat.format("driver.property.{0}", BROWSER);
        System.setProperty(driverPropertyKey, driverPath);
    }
    public WebDriver build(){
        return switch (BROWSER) {
            case "firefox" -> new FirefoxDriver(CapabilitiesFiller.buildFirefox());
            case "chrome-headless" -> new ChromeDriver(CapabilitiesFiller.buildChromeHeadless());
            default -> new ChromeDriver(CapabilitiesFiller.buildChrome());
        };
    }
    public static class CapabilitiesFiller {
        public static ChromeOptions buildChrome(){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--allowed-ips");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--enable-automation");

            //chromeOptions.setCapability("chrome", Platform.ANY);
            return chromeOptions;

        }


        public static ChromeOptions buildChromeHeadless(){
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            chromeOptions.addArguments("--allowed-ips");
            chromeOptions.addArguments("--enable-automation");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--remote-allow-origins=*");
            return chromeOptions;
        }

        public static FirefoxOptions buildFirefox(){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("firefox", Platform.ANY);
            firefoxOptions.setCapability("marionette", true);
            return firefoxOptions;
        }
    }
}
