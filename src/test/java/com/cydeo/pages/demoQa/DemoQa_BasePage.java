package com.cydeo.pages.demoQa;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class DemoQa_BasePage {


    public DemoQa_BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

}
