package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.XMLFormatter;

public class WT_LoginPage {

    public WT_LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (css = "input[name='username']")
    public WebElement txt_username;
    @FindBy(css = "input[name='password']")
    public WebElement txt_password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btn_login;

/** this method will log in with this below credential
    //username = Test
    // password = Tester */
public void login(){
    this.txt_username.sendKeys("Test");
    this.txt_password.sendKeys("Tester");
    this.btn_login.click();

}
/** overloading with diff parameters
// this method will log in with data that you provide when you are calling this method
    public void login(String username,String password){
        this.txt_username.sendKeys(username);
        this.txt_password.sendKeys(password);
        this.btn_login.click(); */

    }

