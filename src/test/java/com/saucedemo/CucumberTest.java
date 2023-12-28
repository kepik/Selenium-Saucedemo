package com.saucedemo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com/saucedemo/StepDef"},
        features = {"src/test/resources"},
        plugin = {"pretty"}
)
public class CucumberTest {
}
