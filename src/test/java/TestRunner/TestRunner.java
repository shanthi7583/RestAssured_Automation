package TestRunner;


	import org.junit.runner.RunWith;
	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;
	
	@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/java/Features/AddPlaceAPI.feature",plugin="json:target/jsonreports/cucumer-report.json",tags="@AddPlaceAPI",glue={"stepdefinition"})
	
	public class TestRunner {
		
	
	}
	