package com.cydeo.step_definitions;

import com.cydeo.pages.demoQa.ButtonsPage;
import com.cydeo.pages.demoQa.LinksPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class DemoQa_StepDefinition {
    String baseUrl = ConfigurationReader.getProperty("baseUrl");

    /**Common approach in testing:
     Test URL : https://demoqa.com/buttons/     = baseUrl+path
     baseUrl : https://demoqa.com/
     path : buttons/
     for this website when you want to go to other link , the beginning of url stay the same
     only change at the end  path : buttons/ or links/ or elements/
     */

    @Given("Navigate to {string} page")
    public void navigate_to_page(String path) {
        String url = baseUrl+path;
        Driver.getDriver().get(url);// it will navigate to path that we provide
        // it could be buttons / links / etc... to go to diff pages
    }

    ButtonsPage buttonPage = new ButtonsPage();

    @When("Click {string} button")
    public void click_button(String buttonName) {
        Actions actions = new Actions(Driver.getDriver());

        switch (buttonName){
            case "Double click":
                actions.doubleClick(buttonPage.dblClkBtn).perform();
                break;
            case "Right click":
                actions.contextClick(buttonPage.rightClkBtn).perform(); // right click action
                break;
            case "Click me":
                buttonPage.clkMeBtn.click(); // no need for Actions class
                break;
            default:
                System.out.println("There are no steps with this input");
        }
    }

    @Then("Verify text :{string} should be visible")
    public void verify_text_should_be_visible(String expectedText) {
        if(expectedText.contains("double")){
            // System.out.println("buttonPage.dblClkMsg.getText() = " + buttonPage.dblClkMsg.getText());
            Assert.assertEquals(expectedText,buttonPage.dblClkMsg.getText());
        }else if(expectedText.contains("right")){
            //   System.out.println("buttonPage.rightClkMsg.getText() = " + buttonPage.rightClkMsg.getText());
            Assert.assertEquals(expectedText,buttonPage.rightClkMsg.getText());
        }else if(expectedText.contains("dynamic")){
            //  System.out.println("buttonPage.dynmcClkMsg.getText() = " + buttonPage.dynmcClkMsg.getText());
            Assert.assertEquals(expectedText,buttonPage.dynmcClkMsg.getText());
        }else{
            System.out.println("Provide wrong text");
        }
    }
    LinksPage linksPage = new LinksPage();
    @When("User clicks on {string} on the links page")
    public void userClicksOnOnTheLinksPage(String link) {
        linksPage.getLink(link).click();
    }

    @Then("Verify the message contains {string}{string}")
    public void verifyTheMessageContains(String statusCode, String expectedText) {
        //  System.out.println("linksPage.linkResponse.getText() = " + linksPage.linkResponse.getText());
        Assert.assertTrue(linksPage.linkResponse.getText().contains(statusCode));
        Assert.assertTrue(linksPage.linkResponse.getText().contains(expectedText));
    }
}
