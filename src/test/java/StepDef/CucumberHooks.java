package StepDef;


import io.cucumber.java.*;
import static Utility.BaseTest.*;

public class CucumberHooks {

    @Before
    public void beforeTest() {
        startDriver();
    }

    @After
    public void afterTest() {
        quitDriver();
    }
}
