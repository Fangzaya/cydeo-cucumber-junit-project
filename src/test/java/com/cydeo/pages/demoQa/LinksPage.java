package com.cydeo.pages.demoQa;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinksPage extends DemoQa_BasePage{



    @FindBy(id = "linkResponse")
    public WebElement linkResponse;

    // create one method, by providing different link text, I will get different WEB elements
    public WebElement getLink(String linkName){
        return Driver.getDriver().findElement(By.partialLinkText(linkName));
    }
}
