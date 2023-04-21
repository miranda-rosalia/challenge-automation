package com.crowdar.pages.sections;

import com.crowdar.pages.common.Component;
import com.crowdar.pages.common.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidebarSaucedemo extends Component {
    @FindBy(id = "inventory_sidebar_link")
    WebElement allItemsMenu;
    @FindBy(id = "about_sidebar_link")
    WebElement aboutMenu;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutMenu;
    @FindBy(id = "reset_sidebar_link")
    WebElement resetAppStateMenu;

    public SidebarSaucedemo(Page page){
        super(page);
    }

    public void goToAllItemsMenu(){ allItemsMenu.click();}
    public void goToAboutMenuu(){ aboutMenu.click();}
    public void goToLogoutMenu(){ logoutMenu.click();}
    public void goToResetAppStateMenu(){ resetAppStateMenu.click();}
}
