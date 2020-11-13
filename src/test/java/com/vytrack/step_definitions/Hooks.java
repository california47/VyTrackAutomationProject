package com.vytrack.step_definitions;

import com.vytrack.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

/**
 * Hooks name is not reserved. You may name this class in any way.
 * For example: SuiteSetupAndTearDown
 * Hooks triggered based on tags not class name or their location.
 * These methods can be a part of any step definition class.
 * Common practice is to store them in the separate class.
 */
public class Hooks {

    /**
     * Hooks name is not reserved. You may name this class in any way.
     * For example: SuiteSetupAndTearDown
     * Hooks triggered based on tags not class name or their location.
     * These methods can be a part of any step definition class.
     * Common practice is to store them in the separate class.
     */

//    hook before = @BeforeMethod in TestNG
//    hook after = @AfterMethod in TestNG
//    it's not a good idea to mix implicit and explicit waits. It can lead to unexpectedly long waits.
//    usually, we just use explicit and fluent waits.

    @Before
    public void setup(Scenario scenario) {
        // in this line we specify what scenarios we were running, change the browser on the way as well!
        // [@negative_login]
        System.out.println(scenario.getSourceTagNames());
        System.out.println("::: Starting Automation:::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        //close browser, close DB connection, close tunnel,capture screenshot of the error, etc..
        //this is a hook after
        //runs automatically after every test
        Driver.closeDriver();
        System.out.println(":::(^_^) End of test execution (*_*):::");
    }

    //    this hook will run only before scenarios with a tag @db

    /**
     * @db
     * Scenario: I don't know but here I'm connecting to DB
     * Given user runs following query "SELECT * ...."
     */
    @Before("@db")
    public void dbSetup(){
        System.out.println("::: Connecting to the database:::");
    }

    @After("@db")
    public void dbTearDown(){
        System.out.println("::: Disconnecting from the database:::");
    }
}