package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
    // create Page Obj Model POM design Pages
    // 1. create the constructOr and initialize the driver and obj in this class
    //2. Locate web elements by using @FindBy


    public GoogleSearchPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (name="q")
    public WebElement searchBox;
}
