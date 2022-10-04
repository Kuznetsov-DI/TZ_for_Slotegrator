package ui;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumber_steps",
        plugin = {"pretty"}
)
public class RunUiTest extends AbstractTestNGCucumberTests {
}
