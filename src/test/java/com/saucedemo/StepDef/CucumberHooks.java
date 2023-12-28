package com.saucedemo.StepDef;

import com.saucedemo.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks extends BaseTest {

    @Before
    public void beforeTest() {
        getDriver();
        driver.manage().window().maximize();
    }

    @After
    public void afterTest() {
        driver.close();
    }
}
