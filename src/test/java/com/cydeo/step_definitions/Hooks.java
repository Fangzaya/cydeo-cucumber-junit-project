package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
In this class we will be able to create "pre" and "post" condition for ALL fo
the SCENARIOS and STEPS
 */
public class Hooks {

    @Before (order = 1)// import from io.cucumber.java
    public void setupMethod(){
        System.out.println("-->@Before: RUNNING BEFORE EACH SCENARIO");

    }
  //  @Before (value = "@login",order = 2)
    @Before //("@login") add here and on runner(on the top). not neccessaliy
    public void login_scenario_before(){
        System.out.println("-->@Before: RUNNING BEFORE EACH SCENARIO");

    }
    @After// import from io.cucumber.java
    public void teardownMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        System.out.println("-->@After: RUNNING AFTER EACH SCENARIO");
        Driver.closeDriver();
    }
  //  @BeforeStep
  //  public void setupStep(){
    //    System.out.println("****>@BeforeStep : Running before EACH STEP!");

 //   }
  //  @AfterStep
 //   public void teardownStep(){
      //  System.out.println("****>@AfterStep : Running after EACH STEP!");

    }




