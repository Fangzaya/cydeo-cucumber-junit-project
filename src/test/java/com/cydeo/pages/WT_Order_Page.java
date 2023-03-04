package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WT_Order_Page extends WT_BasePage{

    public WT_Order_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(name = "product")
    public WebElement productDropDown;
    @FindBy(xpath = "//input[@value='Visa']")
    public WebElement visa_radioButton;
    @FindBy(xpath = "//input[@value='MasterCard']")
    public WebElement Mastercard_radioButton;
    @FindBy(xpath = "//input[@value='American Express']")
    public WebElement American_Express_radioButton;
    @FindBy(name = "card")
    public List<WebElement> cardTypes;
    // all 3 buttons has same locator //name = "card" so we can as them in List

    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement txt_quantity ;

    @FindBy(name = "name")
    public WebElement txt_Name;
    @FindBy(name = "street")
    public WebElement txt_street;
    @FindBy(name = "city")
    public WebElement txt_city;
    @FindBy(name="state")
    public WebElement txt_state;

    @FindBy(name="zip")
    public WebElement txt_zip;
    @FindBy(name = "cardNo")
    public WebElement txt_cardNo;
    @FindBy(name = "cardExp")
    public WebElement txt_expiryDate;

    @FindBy(xpath = "//button[.='Calculate']")
    public WebElement btn_calculate;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement btn_processOder;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement btn_resetFields;





}
