package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
    // create Page Obj Model POM design Pages
    // 1. create the constructOr and initialize the driver and obj in this class
    //2. Locate web elements by using @FindBy


    public DropDownPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

   @FindBy(id = "month")

    public WebElement monthDropdown;



}
