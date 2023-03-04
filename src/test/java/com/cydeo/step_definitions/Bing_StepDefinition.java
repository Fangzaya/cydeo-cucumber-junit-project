package com.cydeo.step_definitions;

import com.cydeo.pages.BingSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Bing_StepDefinition {
    // create obj from BingSearchPage CLASS in order to use it web elements , methods
    BingSearchPage bingSearchPage = new BingSearchPage();

    @Given("user is on the Bing search page")
    public void user_is_on_the_bing_search_page() {
        Driver.getDriver().get("https://www.bing.com");

    }

    @When("user enter orange in the Bing search box")
    public void user_enter_orange_in_the_bing_search_box() {
        BrowserUtils.sleep(3);

        bingSearchPage.searchBox.sendKeys("orange"+Keys.ENTER);




    }

    @Then("user should see orange in the title")
    public void userShouldSeeOrangeInTheTitle() {
       BrowserUtils.verifyTitle("orange - Search");

   }

    @When("user enter {string} in the Bing search box")
    public void userEnterInTheBingSearchBox(String searchKey) {
        bingSearchPage.searchBox.sendKeys(searchKey+Keys.ENTER);

    }

    @Then("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String expectedTitle) {
        BrowserUtils.verifyTitle(expectedTitle);
    }

}
