package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:reports/cucumber.html", "json:reports/cucumber.json"},
        glue = {"StepDef"},
        features = {"src/test/resources"}
)
public class CucumberTest {
}
