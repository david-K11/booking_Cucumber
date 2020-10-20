package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags="@smoke",
		features = 
				".//Features/",

		glue = "stepDefinitions", 
		dryRun = false, 
		publish = true,
		monochrome = true,
		plugin = { "pretty",
				"html:target/cucumber-html-report",
				"json:target/cucumber.json"}

)

public class TestRun {

}
