package com.crowdar.pages.common;

import com.crowdar.utils.PageUrlUtils;
import com.crowdar.webDriver.ExtendedWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public abstract class Page {
    protected ExtendedWebDriver webDriver;
    protected Map<String, Object> pageContext;
    protected Page(ExtendedWebDriver webDriver, Map pageContext) {
        this.webDriver = webDriver;
        this.pageContext = pageContext;
        PageFactory.initElements(webDriver, this);
    }
    protected String targetUrl() {
        return PageUrlUtils.urlFor(this.getClass(), pageContext);
    }
}
