package com.cydeo.step_definitions;

import com.cydeo.pages.DropDownPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataTables_StepDefinitions {


    @Then("user should see below list")
    public void user_should_see_below_list(List<String> fruitAndVeggies) {
        // delete all snippets info
        // delete (arg) and create your own data structure, collection type ex. List , Map, Array , etc...
        // after we created it , data from feature file will automatically add in. no need to do anything
        System.out.println("fruitAndVeggies = " + fruitAndVeggies);
        System.out.println(fruitAndVeggies.get(0));// orange
    }

    @Then("I will share my favorites")
    public void i_will_share_my_favorites(List<String> listOfPets) {
        System.out.println("animalList = " + listOfPets);

    }


    @Then("officer is able to see any data he wants")
    public void officerIsAbleToSeeAnyDataHeWants(Map<String, String> sdetInfo) {
        System.out.println("sdetInfo = " + sdetInfo);
        System.out.println("sdetInfo.get(\"name\") = " + sdetInfo.get("name"));
        System.out.println("sdetInfo.get(\"surname\") = " + sdetInfo.get("surname"));
        System.out.println("sdetInfo.get(\"address\") = " + sdetInfo.get("address"));
        System.out.println("sdetInfo.size() = " + sdetInfo.size());
    }


    @Given("User is on the dropdowns page of practice tool")
    public void userIsOnTheDropdownsPageOfPracticeTool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");


    }

    DropDownPage dropDownPage = new DropDownPage();

    @Then("User should see below info in month dropdown")
    public void userShouldSeeBelowInfoInMonthDropdown(List<String> expectedMonths) {
     /* before create method in util

        Select month = new Select(dropDownPage.monthDropdown);
        List<WebElement> actualMonth_as_WebElement = month.getOptions();// get all months
        // now actualMonth_as_WebElement == WebElement
        // but expectedMonths              == List<String>expectedMonths //List of String
        // so we will create   empty List<String>
        // then use for loop to get each dropdown.getText();

        List<String> actualMonth_as_String = new ArrayList<>();
        for (WebElement eachMonth : actualMonth_as_WebElement) {
            actualMonth_as_String.add(eachMonth.getText());
        }
        Assert.assertEquals(actualMonth_as_String, expectedMonths);

      */
        List<String>actualMonths = BrowserUtils.dropdownOptions_as_STRING(dropDownPage.monthDropdown);

        Assert.assertEquals(actualMonths, expectedMonths);


    }


}


