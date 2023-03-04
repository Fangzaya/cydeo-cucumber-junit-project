package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "com/cydeo/step_definitions"


)
public class FailedTestRunner {
// When Assertion fails then that scenario will be automatically added into the "rerun.txt"
// it will take  note that which test is failed after we run and have failed test
// then we can run FailedTestRunner for failed tests

}
