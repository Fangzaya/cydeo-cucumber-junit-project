package com.cydeo.step_definitions;
import com.cydeo.pages.WT_LoginPage;
import com.cydeo.pages.WT_Order_Page;
import com.cydeo.pages.WT_ViewAllOrderPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.mk_latn.No;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class WebTable_Login_StepDefinition {
    WT_LoginPage wtLoginPage = new WT_LoginPage();
    WT_ViewAllOrderPage viewAllOrderPage = new WT_ViewAllOrderPage();
    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
    }
    @Given("User enter valid username")
    public void user_enter_valid_username() {
        wtLoginPage.txt_username.sendKeys("Test");

    }
    @Given("User enter valid password")
    public void user_enter_valid_password() {
        wtLoginPage.txt_password.sendKeys("Tester");

    }
    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
        wtLoginPage.btn_login.click();
    }


    @Then("User should see URL  as expected")
    public void user_should_see_url_as_expected() {
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedInURL = "orders";
        Assert.assertTrue(actualURL.endsWith(expectedInURL));

    }


    @And("User enter {string} username and {string} password")
    public void userEnterUsernameAndPassword(String username, String password) {
        wtLoginPage.txt_username.sendKeys(username);
        wtLoginPage.txt_password.sendKeys(password);
    }

    @And("User enter below valid credentials")
    public void userEnterBelowValidCredentials(Map<String,String>credentials) {

        wtLoginPage.txt_username.sendKeys(credentials.get("username"));
        wtLoginPage.txt_password.sendKeys(credentials.get("password"));
    }

    @Given("user is already logged in to The Web table app")
    public void user_is_already_logged_in_to_the_web_table_app() {

        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        wtLoginPage.login();


    }
    WT_Order_Page orderPage = new WT_Order_Page();
    @When("user is on the “Order” page")
    public void user_is_on_the_order_page() {
        orderPage.orderLink.click();
        // we call from  WT_Order_Page and the method orderLink() was inherited from WT_BasePage


    }
    @Then("user sees below options under “product” dropdown")
    public void user_sees_below_options_under_product_dropdown(List<String> expectedOptions) {

       List<String> actualOptions = BrowserUtils.dropdownOptions_as_STRING(orderPage.productDropDown);
       Assert.assertEquals(actualOptions,expectedOptions);

    }

    @Then("user sees Visa as enable payment option")
    public void userSeesVisaAsEnablePaymentOption() {
        Assert.assertTrue(orderPage.visa_radioButton.isEnabled());



    }

    @Then("user sees Mastercard as enable payment option")
    public void userSeesMastercardAsEnablePaymentOption() {
        Assert.assertTrue(orderPage.Mastercard_radioButton.isEnabled());
    }

    @Then("user sees American Express as enable payment option")
    public void userSeesAmericanExpressAsEnablePaymentOption() {

        Assert.assertTrue(orderPage.American_Express_radioButton.isEnabled());
    }


    @Then("user enters {string} for Quantity")
    public void userEntersForQuantity(String quantity) {
// IT HAS 1 as a default value so, we need to clear it first
        orderPage.txt_quantity.clear();
 // OR
        //orderPage.txt_quantity.sendKeys(Keys.BACK_SPACE);
        orderPage.txt_quantity.sendKeys(quantity);
    }

    @And("Clicks on Calculate button")
    public void clicksOnCalculateButton() {
        orderPage.btn_calculate.click();
    }

    @Then("user enters {string}  for Customer name")
    public void userEntersForCustomerName(String name) {
        orderPage.txt_Name.sendKeys(name);

    }

    @And("user enters {string}  for Street")
    public void userEntersForStreet(String street) {
        orderPage.txt_street.sendKeys(street);
    }

    @And("user enters {string}  for City")
    public void userEntersForCity(String city) {
        orderPage.txt_city.sendKeys(city);
    }

    @And("user enters {string}  for state")
    public void userEntersForState(String state) {
        orderPage.txt_state.sendKeys(state);
    }

    @And("user enters {string}  for Zip")
    public void userEntersForZip(String Zip) {
        orderPage.txt_zip.sendKeys(Zip);
    }
    @And("user selects payment option {string}")
    public void userSelectsPaymentOption(String expectedCardType) {  // expectedCardType IS card type that you put in feature
        BrowserUtils.clickRadioButton(orderPage.cardTypes,expectedCardType);
    }
    @And("user enters {string}  for Card No")
    public void userEntersForCardNo(String cardNo) {
        orderPage.txt_cardNo.sendKeys(cardNo);

    }

    @And("user enters {string}  for Expire date")
    public void userEntersForExpireDate(String expireDate) {
        orderPage.txt_expiryDate.sendKeys(expireDate);
    }

    @And("user clicks to “Process Order”")
    public void userClicksToProcessOrder() {
        orderPage.btn_processOder.click();

    }

    @Then("user should see {string} in the first row of the web table")
    public void userShouldSeeInTheFirstRowOfTheWebTable(String expectedName) {
        String actualName = viewAllOrderPage.newCustomerCell.getText();
        Assert.assertEquals(actualName,expectedName);





    }


}
