package cucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src//test//resources//features" }, 
glue = { "stepDefinations","hooks"},
tags= "@login",
dryRun=false
)
public class TestRunner extends AbstractTestNGCucumberTests{

}
