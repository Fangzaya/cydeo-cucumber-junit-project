package com.cydeo.pages.demoQa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends DemoQa_BasePage{
  // locators of Button Page

    @FindBy(id = "doubleClickBtn")
    public WebElement dblClkBtn;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClkBtn;

    @FindBy(xpath = "//button[.='Click Me']")
    public WebElement clkMeBtn;

    @FindBy(id = "doubleClickMessage")
    public WebElement dblClkMsg;

    @FindBy(id = "rightClickMessage")
    public WebElement rightClkMsg;

    @FindBy(id = "dynamicClickMessage")
    public WebElement dynmcClkMsg;
}
