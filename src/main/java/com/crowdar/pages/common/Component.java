package com.crowdar.pages.common;

import org.openqa.selenium.support.PageFactory;

public class Component {
    protected final Page page;

    public Component(Page page){
        this.page = page;
        refresh();
    }
    public void refresh(){
        PageFactory.initElements(page.webDriver, this);
    }
}
