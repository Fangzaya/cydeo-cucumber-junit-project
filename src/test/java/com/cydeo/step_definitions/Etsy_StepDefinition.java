package com.cydeo.step_definitions;

import com.cydeo.pages.EtsySearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Etsy_StepDefinition {
    EtsySearchPage searchPage = new EtsySearchPage();

    @Given("user is on the Etsy homepage")
    public void user_is_on_the_etsy_homepage() {
        Driver.getDriver().get("https://www.etsy.com");

    }

    @Then("user should see title is as expected")
    public void user_should_see_title_is_as_expected() {
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";

        BrowserUtils.verifyTitle(expectedTitle);


    }


    @When("User types Wooden Spoon in the search box")
    public void userTypesWoodenSpoonInTheSearchBox() {
        searchPage.searchBox.sendKeys("Wooden Spoon");


    }

    @Then("User clicks search button")
    public void userClicksSearchButton() {

        searchPage.btn_search.click();
    }

    @Then("User sees Wooden Spoon is in the title")
    public void userSeesWoodenSpoonIsInTheTitle() {
        String expectedTitle = "Wooden spoon";
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
        // BrowserUtils.verifyTitleContain(expectedTitle);


    }

    @When("User types {string} in the search box")
    public void userTypesInTheSearchBox(String keyWord) {
        searchPage.searchBox.sendKeys(keyWord);

    }


    @Then("User sees {string} is in the title")
    public void userSeesIsInTheTitle(String expectedTitle) {

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
        System.out.println(expectedTitle);
        System.out.println(Driver.getDriver().getTitle());
    }
}