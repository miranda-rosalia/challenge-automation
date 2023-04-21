package com.crowdar.pages.sections;

import com.crowdar.pages.SaucedemoPage;
import com.crowdar.pages.common.Page;
import com.crowdar.pages.common.Component;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuSaucedemo extends Component {
    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;
    public MenuSaucedemo(Page page){
        super(page);
    }
    public Page goToSidebar(){
         menuButton.click();
         return page;
    }
}
