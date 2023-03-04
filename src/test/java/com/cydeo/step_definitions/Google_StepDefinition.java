package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Google_StepDefinition {
    // create obj from Page

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user is on the Google search page")
    public void user_is_on_the_google_search_page() {
     //   // Write code here that turns the phrase above into concrete actions  >> delete
    //    throw new io.cucumber.java.PendingException(); >> delete
        Driver.getDriver().get("https://www.google.com");
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        Driver.closeDriver();

    }

    @When("user searches for {word}")
    public void userSearchesForApple(String word) {
        googleSearchPage.searchBox.sendKeys(word+ Keys.ENTER);

    }

    @Then("user should see {word} in the title")
    public void userShouldSeeAppleInTheTitle(String word) {
        BrowserUtils.verifyTitle(word+" - Google Search");
    }


 //   @And("user sees {int} apples")
 //   public void userSeesApples(int arg0) {
  //  }
}
