package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "pretty",
                //it will print information about scenario and step in the console
                "html:target/cucumber-report.html",
                // way to get  this report > go to taget folder>cucumber-report.html
                // right click >open in > browser > chrome
                "rerun:target/rerun.txt",
                //  it will get report for FAILED test abd store in File, the name rerun.txt can be any name
                "me.jvt.cucumber.report.PrettyReports:target/cucumber" // for this one we also need to add it's dependency
        },

        features = "src/test/resources/features",  // get from features >copy path from content root
        glue = "com/cydeo/step_definitions",//get from step_definitions folder > copy path form source root

        dryRun = false,// false = off_ execute everything // true =on_it will not execute the code,
        // but it will check for missing snippet, it will generate snippet in console for you to use
        // we turn ON to get the snippet
        // the other way to get snippet is just hover on what you want to get and right click on feature file

        tags = "@wip", // and (both) , and not (one + exclude another) , or (either one)
        publish = true  // generating a report with public link -->report share with team
        // -->View your Cucumber Report at: ..link.. in square after run in StepDefinition class
//,monochrome = true // change color from green to write for pretty plugin in console

)
public class CukesRunner {

}
