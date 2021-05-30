package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(dryRun=false,features= {"src/test/java/features"},glue={"pages"},monochrome=true
)
public class RunnerCucumberTest extends AbstractTestNGCucumberTests {

}
