package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			tags="@smoke",
				features = 
				".//Features/",
//				".//Features/BookFirstDisplayedHotel.feature"
//				".//Features/AccountCreation.feature",

		glue = "stepDefinitions", 
		dryRun = false, 
		publish = true,
		monochrome = true,
		plugin = { "pretty",
				"html:target/cucumber-html-report", }

)

public class TestRun {

}
