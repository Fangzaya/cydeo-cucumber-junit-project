package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    //1. create a private constructor

    private Driver() {
    }


    //2. create WebDriver driver variable and make it  private static
// we make webdriver private because we want to close access from outside the class
    // static because we will use it in a static method
    //A static method can only access static data members
 //   private static WebDriver driver;  ---> this was for a single run
    private static InheritableThreadLocal<WebDriver>driverPool = new InheritableThreadLocal<>();
    //for multiple run more drivers --> parallel run


   /* 3. Create a re-usable utility method which will return the same driver instance once we call it.
    - If an instance doesn't exist, it will create first, and then it will always return same instance.
     */

    public static WebDriver getDriver() {
        if (driverPool.get()==null){   // --> get() likes we want to get driver from the pool
            //--> it was if(driver == null)
            /*
            We will read our browserType from configuration.properties file.
            This way, we can control which browser is opened from outside our code.
             */


            String browserType  = ConfigurationReader.getProperty("browser");
            browserType = browserType.trim().toLowerCase();
            /*
            Depending on the browserType returned from the configuration.properties
            switch statement will determine the "case", and open the matching browser.
             */

            switch (browserType){  //browserType  store value from configuration.properties
                case "chrome":
                //    WebDriverManager.chromedriver().setup(); before we need to do this
                    driverPool.set( new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    driverPool.set( new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }


        }
        return driverPool.get();
    }

    ///*
    //    Create a new Driver.closeDriver(); it will use .quit() method to quit browsers, and then set the driver value back to null.
    //     */
    public static void closeDriver(){
        if(driverPool.get() != null){
            /*
            This line will terminate the currently existing driver completely. It will not exist going forward.
             */
            driverPool.get().quit();
            /*
            We assign the value back to "null" so that my "singleton" can create a newer one if needed.
             */
            driverPool.remove();
        }
    }
}
