package com.cydeo.step_definitions;

import com.cydeo.pages.WikiResultPage;
import com.cydeo.pages.WikipediaSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Wikipedia_StepDefinition {

    // create obj from Page POM design
   WikipediaSearchPage wikipediaSearchPage = new WikipediaSearchPage();
   WikiResultPage wikiResultPage = new WikiResultPage();
    @Given("user is on the Wikipedia home page")
    public void user_is_on_the_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org/");

    }
    @Then("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String searchKey) {
        wikipediaSearchPage.searchBox.sendKeys(searchKey);
        System.out.println(searchKey); // just checking optional

    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikipediaSearchPage.searchButton.click();

    }
    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String expectedInTitle) {
        BrowserUtils.verifyTitleContains(expectedInTitle);
    }

    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String expectedInHeader) {
        String actualHeaderText =  wikiResultPage.mainHeader.getText();

        Assert.assertEquals(actualHeaderText,expectedInHeader);



    }



    @Then("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String expectedInImageHeader) {

        Assert.assertEquals(wikiResultPage.imageHeader.getText(),expectedInImageHeader);



    }
}
